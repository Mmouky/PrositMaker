package fr.mmouky.prosit.panel.contenu.cer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.cer.contenu.ContenuCER;
import fr.mmouky.prosit.utils.Button;
import fr.mmouky.prosit.utils.Onglet;
import fr.mmouky.prosit.utils.TypeContenu;

public class CER {

	private XWPFDocument doc;
	private Button selectPA;
	private JPanel panel;
	private ContenuCER contenu;
	private Onglet INFORMATIONS, MC, HYPOTHESES, PA;

	public CER(JPanel panel) {
		setPanel(panel);
		setSelectPA(new Button((int) getPanel().getWidth() / 2 - 50, (int) getPanel().getHeight() / 2 - 25, 100, 50, "Ouvrir", Panel.BACKGROUND_COLOR, Color.WHITE,
				Color.WHITE));
		setContenu(new ContenuCER(getDoc(), TypeContenu.INFORMATIONS));
		getSelectPA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					jfc.setDialogTitle("Sélectionner prosit");
					jfc.setApproveButtonText("Ouvrir");
					jfc.setFileFilter(new FileNameExtensionFilter("Document Microsoft Word .docx", "docx"));
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(jfc);
					int ret = jfc.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION) {
						if (jfc.getSelectedFile().getName().contains("Prosit")) {
							try {
								removeComponents();
								setDoc(new XWPFDocument(new FileInputStream(jfc.getSelectedFile().getPath())));
								getContenu().setDoc(getDoc());
								addComponents();
								getPanel().repaint();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
			}
		});

		int width = getPanel().getWidth() / 4;
		setINFORMATIONS(new Onglet(0, 0, width, Panel.HEIGHT_MENU, "Informations", getContenu(), TypeContenu.INFORMATIONS));
		setMC(new Onglet(width, 0, width, Panel.HEIGHT_MENU, "Mots Clés", getContenu(), TypeContenu.MOTS_CLES));
		setHYPOTHESES(new Onglet(2 * width, 0, width, Panel.HEIGHT_MENU, "Hypothèses", getContenu(), TypeContenu.HYPOTHESES));
		setPA(new Onglet(3 * width, 0, width, Panel.HEIGHT_MENU, "Plan d'action", getContenu(), TypeContenu.PLAN_DACTION));
	}

	public void addComponents() {
		if (doc == null) {
			getPanel().add(getSelectPA());
			getPanel().setBackground(Color.WHITE);
		} else {
			getPanel().add(getINFORMATIONS());
			getPanel().add(getMC());
			getPanel().add(getHYPOTHESES());
			getPanel().add(getPA());
			getPanel().add(getContenu().getPanel());
			getPanel().setBackground(Panel.BACKGROUND_COLOR);
		}
	}

	public void removeComponents() {
		if (doc == null) {
			getPanel().remove(getSelectPA());
		} else {
			getPanel().remove(getINFORMATIONS());
			getPanel().remove(getMC());
			getPanel().remove(getHYPOTHESES());
			getPanel().remove(getPA());
			getPanel().remove(getContenu().getPanel());
		}
	}

	public XWPFDocument getDoc() {
		return doc;
	}

	public void setDoc(XWPFDocument doc) {
		this.doc = doc;
	}

	public Button getSelectPA() {
		return selectPA;
	}

	public void setSelectPA(Button selectPA) {
		this.selectPA = selectPA;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public ContenuCER getContenu() {
		return contenu;
	}

	public void setContenu(ContenuCER contenu) {
		this.contenu = contenu;
	}

	public Onglet getINFORMATIONS() {
		return INFORMATIONS;
	}

	public void setINFORMATIONS(Onglet iNFORMATIONS) {
		INFORMATIONS = iNFORMATIONS;
	}

	public Onglet getMC() {
		return MC;
	}

	public void setMC(Onglet mC) {
		MC = mC;
	}

	public Onglet getHYPOTHESES() {
		return HYPOTHESES;
	}

	public void setHYPOTHESES(Onglet hYPOTHESES) {
		HYPOTHESES = hYPOTHESES;
	}

	public Onglet getPA() {
		return PA;
	}

	public void setPA(Onglet pA) {
		PA = pA;
	}

}
