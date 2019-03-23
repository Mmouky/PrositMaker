package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Hypotheses {

	private JPanel panel;
	private ArrayList<Component> components;
	private ArrayList<HypotheseFactory> hypotheses;

	public Hypotheses(JPanel panel) {
		setPanel(panel);
		setComponents(new ArrayList<>());
		setHypotheses(new ArrayList<>());
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

	public ArrayList<HypotheseFactory> getHypotheses() {
		return hypotheses;
	}

	public void setHypotheses(String[] hypotheses) {
		for (int i = 0; i < hypotheses.length; i++) {
			getHypotheses().add(new HypotheseFactory(hypotheses[i], getPanel().getWidth() / 2 * (i % 2) + 10, (i / 2) * 75 + 100, getComponents()));
		}
	}

	public void setHypotheses(ArrayList<HypotheseFactory> hypotheses) {
		this.hypotheses = hypotheses;
	}

}
