package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Plan_action {

	private JPanel panel;
	private ArrayList<Component> components;
	private String[][] pa;

	public Plan_action(JPanel panel) {
		setPanel(panel);
		setComponents(new ArrayList<>());
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

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public String[][] getPa() {
		return pa;
	}

	public void setPa(String[] motscles) {
		
	}

}
