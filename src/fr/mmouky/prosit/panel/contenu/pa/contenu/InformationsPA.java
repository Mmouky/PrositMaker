package fr.mmouky.prosit.panel.contenu.pa.contenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationsPA {

	private JPanel panel;
	private JTextField nbProsit, nomProsit;
	private JLabel LNbProsit, LNomProsit;
	private ArrayList<Component> components;

	public InformationsPA(JPanel panel) {
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
		setComponents(new ArrayList<>());
		getComponents().add(getNbProsit());
		getComponents().add(getLNbProsit());
		getComponents().add(getNomProsit());
		getComponents().add(getLNomProsit());
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

}
