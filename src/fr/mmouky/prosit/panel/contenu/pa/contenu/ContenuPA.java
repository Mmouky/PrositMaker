package fr.mmouky.prosit.panel.contenu.pa.contenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.pa.GenerationPA;
import fr.mmouky.prosit.utils.Button;
import fr.mmouky.prosit.utils.TypeContenu;

public class ContenuPA {

	private TypeContenu typeContenu;
	private JPanel panel;
	private JLabel nom;
	private Button generer;
	private InformationsPA informations;
	private MultiData motscles, contraintes, hypotheses, plan_action;
	private SoloData contexte, generalisation, problematique;

	public ContenuPA(TypeContenu typeContenu) {
		setTypeContenu(typeContenu);
		setPanel(new JPanel());
		getPanel().setLayout(null);
		getPanel().setBounds(0, Panel.HEIGHT_MENU, (int) Main.PANEL_SIZE.getWidth() - Panel.WIDTH_MENU, (int) Main.PANEL_SIZE.getHeight() - Panel.HEIGHT_MENU);
		getPanel().setFocusable(true);
		getPanel().requestFocus();
		setGenerer(new Button(getPanel().getWidth() - 110, 10, 100, 50, "Générer", Panel.BACKGROUND_COLOR, Color.WHITE, Color.WHITE));
		setNom(new JLabel());
		getNom().setFont(new Font("Arial", Font.BOLD, 30));
		getNom().setBounds(10, 10, 300, 50);
		getGenerer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GenerationPA(ContenuPA.this);
			}
		});

		setInformations(new InformationsPA(getPanel()));
		setMotscles(new MultiData(getPanel(), "Mots clés : "));
		setContexte(new SoloData(getPanel()));
		setContraintes(new MultiData(getPanel(), "Contraintes : "));
		setGeneralisation(new SoloData(getPanel()));
		setProblematique(new SoloData(getPanel()));
		setHypotheses(new MultiData(getPanel(), "Hypothèses : "));
		setPlan_action(new MultiData(getPanel(), "Plan d'action : "));

		getPanel().add(getNom());
		getPanel().add(getGenerer());
		update();
	}

	public void update() {
		if (typeContenu == TypeContenu.INFORMATIONS) {
			getInformations().addComponents();
			getNom().setText("Informations");
		} else {
			getInformations().removeComponents();
		}
		if (typeContenu == TypeContenu.MOTS_CLES) {
			getMotscles().addComponents();
			getNom().setText("Mots clés");
		} else {
			getMotscles().removeComponents();
		}

		if (typeContenu == TypeContenu.CONTEXTE) {
			getContexte().addComponents();
			getNom().setText("Contexte");
		} else {
			getContexte().removeComponents();
		}
		if (typeContenu == TypeContenu.CONTRAINTES) {
			getContraintes().addComponents();
			getNom().setText("Contraintes");
		} else {
			getContraintes().removeComponents();
		}
		if (typeContenu == TypeContenu.GENERALISATION) {
			getGeneralisation().addComponents();
			getNom().setText("Généralisation");
		} else {
			getGeneralisation().removeComponents();
		}
		if (typeContenu == TypeContenu.PROBLEMATIQUE) {
			getProblematique().addComponents();
			getNom().setText("Problématique");
		} else {
			getProblematique().removeComponents();
		}
		if (typeContenu == TypeContenu.HYPOTHESES) {
			getHypotheses().addComponents();
			getNom().setText("Hypothèses");
		} else {
			getHypotheses().removeComponents();
		}
		if (typeContenu == TypeContenu.PLAN_DACTION) {
			getPlan_action().addComponents();
			getNom().setText("Plan d'action");
		} else {
			getPlan_action().removeComponents();
		}
	}

	public TypeContenu getTypeContenu() {
		return typeContenu;
	}

	public void setTypeContenu(TypeContenu typeContenu) {
		this.typeContenu = typeContenu;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public MultiData getMotscles() {
		return motscles;
	}

	public void setMotscles(MultiData motscles) {
		this.motscles = motscles;
	}

	public SoloData getContexte() {
		return contexte;
	}

	public void setContexte(SoloData contexte) {
		this.contexte = contexte;
	}

	public MultiData getContraintes() {
		return contraintes;
	}

	public void setContraintes(MultiData contraintes) {
		this.contraintes = contraintes;
	}

	public SoloData getGeneralisation() {
		return generalisation;
	}

	public void setGeneralisation(SoloData generalisation) {
		this.generalisation = generalisation;
	}

	public SoloData getProblematique() {
		return problematique;
	}

	public void setProblematique(SoloData problematique) {
		this.problematique = problematique;
	}

	public MultiData getHypotheses() {
		return hypotheses;
	}

	public void setHypotheses(MultiData hypotheses) {
		this.hypotheses = hypotheses;
	}

	public MultiData getPlan_action() {
		return plan_action;
	}

	public void setPlan_action(MultiData plan_action) {
		this.plan_action = plan_action;
	}

	public Button getGenerer() {
		return generer;
	}

	public void setGenerer(Button generer) {
		this.generer = generer;
	}

	public InformationsPA getInformations() {
		return informations;
	}

	public void setInformations(InformationsPA informations) {
		this.informations = informations;
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

}
