package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationsCER {

	private JPanel panel;
	private JTextField nbProsit, nomProsit, nomPersonne;
	private JLabel LNbProsit, LNomProsit, LNomPersonne;
	private ArrayList<Component> components;
	private String infos;

	public InformationsCER(JPanel panel) {
		setPanel(panel);
		setNbProsit(new JTextField());
		getNbProsit().setBounds(10, 100, 200, 25);
		getNbProsit().setText("0");
		getNbProsit().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		setLNbProsit(new JLabel("Numéro du prosit :"));
		getLNbProsit().setBounds(10, 75, 300, 25);
		setNomProsit(new JTextField());
		getNomProsit().setText("Nom_Prosit");
		getNomProsit().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		getNomProsit().setBounds(10, 200, 200, 25);
		setLNomProsit(new JLabel("Nom du prosit :"));
		getLNomProsit().setBounds(10, 175, 300, 25);
		setNomPersonne(new JTextField());
		getNomPersonne().setBounds(10, 300, 200, 25);
		getNomPersonne().setText("Nom Prénom");
		getNomPersonne().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		setLNomPersonne(new JLabel("Nom et prénom :"));
		getLNomPersonne().setBounds(10, 275, 300, 25);
		setComponents(new ArrayList<>());
		
		getComponents().add(getNbProsit());
		getComponents().add(getLNbProsit());
		getComponents().add(getNomProsit());
		getComponents().add(getLNomProsit());
		getComponents().add(getLNomPersonne());
		getComponents().add(getNomPersonne());
	}

	public void addComponents() {
		for (Component c : getComponents()) {
			getPanel().add(c);
		}
		getPanel().setBackground(Color.WHITE);
	}

	public void removeComponents() {
		for (Component c : getComponents()) {
			getPanel().remove(c);
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getContexte() {
		return getNbProsit().getText();
	}

	public JTextField getNbProsit() {
		return nbProsit;
	}

	public void setNbProsit(JTextField nbProsit) {
		this.nbProsit = nbProsit;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public JTextField getNomProsit() {
		return nomProsit;
	}

	public void setNomProsit(JTextField nomProsit) {
		this.nomProsit = nomProsit;
	}

	public JLabel getLNbProsit() {
		return LNbProsit;
	}

	public void setLNbProsit(JLabel lNbProsit) {
		LNbProsit = lNbProsit;
	}

	public JLabel getLNomProsit() {
		return LNomProsit;
	}

	public void setLNomProsit(JLabel lNomProsit) {
		LNomProsit = lNomProsit;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
		if (infos != null) {
			String[] strs = infos.split(" : ");
			getNomProsit().setText(strs[1]);
			String[] strs2 = strs[0].split(" ");
			getNbProsit().setText(strs2[1]);
		}
	}

	public JTextField getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(JTextField nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public JLabel getLNomPersonne() {
		return LNomPersonne;
	}

	public void setLNomPersonne(JLabel lNomPersonne) {
		LNomPersonne = lNomPersonne;
	}

}
