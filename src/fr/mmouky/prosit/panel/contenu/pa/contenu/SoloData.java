package fr.mmouky.prosit.panel.contenu.pa.contenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoloData {

	private JPanel panel;
	private JTextField area;
	private ArrayList<Component> components;

	public SoloData(JPanel panel) {
		setPanel(panel);
		setArea(new JTextField());
		getArea().setBounds(10, 100, 500, 25);
		getArea().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		setComponents(new ArrayList<>());
		getComponents().add(getArea());
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

	public String getData() {
		return getArea().getText();
	}

	public JTextField getArea() {
		return area;
	}

	public void setArea(JTextField area) {
		this.area = area;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

}
