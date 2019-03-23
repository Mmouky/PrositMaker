package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.cer.GenerationCER;
import fr.mmouky.prosit.utils.Button;
import fr.mmouky.prosit.utils.TypeContenu;

public class ContenuCER {

	private JPanel panel;
	private TypeContenu typeContenu;
	private String[] contraintes;
	private String contexte, generalisation, problematique;
	private XWPFDocument doc;
	private JLabel nom;
	private Button generer;
	private InformationsCER informations;
	private MotsCles MC;
	private Hypotheses Hypotheses;
	private Plan_action PA;

	public ContenuCER(XWPFDocument doc, TypeContenu typeContenu) {
		setTypeContenu(typeContenu);
		setDoc(doc);
		setPanel(new JPanel());
		getPanel().setLayout(null);
		getPanel().setBounds(0, Panel.HEIGHT_MENU, (int) Main.PANEL_SIZE.getWidth() - Panel.WIDTH_MENU, (int) Main.PANEL_SIZE.getHeight() - Panel.HEIGHT_MENU);

		setNom(new JLabel());
		getNom().setFont(new Font("Arial", Font.BOLD, 30));
		getNom().setBounds(10, 10, 300, 50);

		if (doc != null) {
			updateDoc();
		}

		setGenerer(new Button(getPanel().getWidth() - 110, 10, 100, 50, "Générer", Panel.BACKGROUND_COLOR, Color.WHITE, Color.WHITE));
		getGenerer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GenerationCER(ContenuCER.this);
			}
		});

		setInformations(new InformationsCER(getPanel()));
		setMC(new MotsCles(getPanel()));
		setHypotheses(new Hypotheses(getPanel()));
		setPA(new Plan_action(getPanel()));

		getPanel().add(getNom());
		update();
	}

	public void update() {
		if (typeContenu == TypeContenu.INFORMATIONS) {
			getNom().setText("Informations");
			getInformations().addComponents();
		} else {
			getInformations().removeComponents();
		}
		if (typeContenu == TypeContenu.MOTS_CLES) {
			getNom().setText("Mots clés");
			getMC().addComponents();
		} else {
			getMC().removeComponents();
		}
		if (typeContenu == TypeContenu.HYPOTHESES) {
			getNom().setText("Hypothèses");
			getHypotheses().addComponents();
		} else {
			getHypotheses().removeComponents();
		}
		if (typeContenu == TypeContenu.PLAN_DACTION) {
			getNom().setText("Plan d'action");
			getPA().addComponents();
		} else {
			getPA().removeComponents();
		}
	}

	public void updateDoc() {
		@SuppressWarnings("resource")
		XWPFWordExtractor we = new XWPFWordExtractor(doc);
		String[] txt = we.getText().split("\n\n");
		for (String s : txt) {
			if (s.contains("Prosit")) {
				getInformations().setInfos(s);
			} else if (s.contains("Mots clés :")) {
				String[] str = s.split("\n");
				String[] newStr = new String[str.length - 1];
				for (int i = 1; i < str.length; i++) {
					newStr[i - 1] = str[i].substring(3);
				}
				getMC().setMotscles(newStr);
			} else if (s.contains("Contexte :")) {
				String[] str = s.split("\n");
				setContexte(str[1].substring(1));
			} else if (s.contains("Contraintes :")) {
				String[] str = s.split("\n");
				String[] newStr = new String[str.length - 1];
				for (int i = 1; i < str.length; i++) {
					newStr[i - 1] = str[i].substring(3);
				}
				setContraintes(newStr);
			} else if (s.contains("Généralisation :")) {
				String[] str = s.split("\n");
				setGeneralisation(str[1].substring(1));
			} else if (s.contains("Problématique :")) {
				String[] str = s.split("\n");
				setProblematique(str[1].substring(1));
			} else if (s.contains("Hypothèses :")) {
				String[] str = s.split("\n");
				String[] newStr = new String[str.length - 1];
				for (int i = 1; i < str.length; i++) {
					newStr[i - 1] = str[i].substring(3);
				}
				getHypotheses().setHypotheses(newStr);
			} else if (s.contains("Plan d'action :")) {
				String[] str = s.split("\n");
				String[] newStr = new String[str.length - 1];
				for (int i = 1; i < str.length; i++) {
					newStr[i - 1] = str[i].substring(3);
				}
				getPA().setPa(newStr);
			}
		}
		getPanel().add(getGenerer());
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getGeneralisation() {
		return generalisation;
	}

	public void setGeneralisation(String generalisation) {
		this.generalisation = generalisation;
	}

	public String getProblematique() {
		return problematique;
	}

	public void setProblematique(String problematique) {
		this.problematique = problematique;
	}

	public TypeContenu getTypeContenu() {
		return typeContenu;
	}

	public void setTypeContenu(TypeContenu typeContenu) {
		this.typeContenu = typeContenu;
	}

	public XWPFDocument getDoc() {
		return doc;
	}

	public void setDoc(XWPFDocument doc) {
		this.doc = doc;
		if (doc != null) {
			updateDoc();
		}
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	public InformationsCER getInformations() {
		return informations;
	}

	public void setInformations(InformationsCER Pinformations) {
		this.informations = Pinformations;
	}

	public Button getGenerer() {
		return generer;
	}

	public void setGenerer(Button generer) {
		this.generer = generer;
	}

	public MotsCles getMC() {
		return MC;
	}

	public void setMC(MotsCles pMC) {
		MC = pMC;
	}

	public Hypotheses getHypotheses() {
		return Hypotheses;
	}

	public void setHypotheses(Hypotheses pHypotheses) {
		Hypotheses = pHypotheses;
	}

	public Plan_action getPA() {
		return PA;
	}

	public void setPA(Plan_action pPA) {
		PA = pPA;
	}

	public String[] getContraintes() {
		return contraintes;
	}

	public void setContraintes(String[] contraintes) {
		this.contraintes = contraintes;
	}

}
