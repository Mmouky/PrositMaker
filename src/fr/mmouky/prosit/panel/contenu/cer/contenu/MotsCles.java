package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class MotsCles {

	private JPanel panel, panel2;
	private ArrayList<Component> components;
	private String[][] motscles;
	private int scrollValue = 0, maxY = 0;

	public MotsCles(JPanel panel) {
		setPanel(panel);
		setPanel2(new JPanel());
		getPanel2().setLayout(null);
		getPanel2().setBounds(0, 75, getPanel().getWidth(), getPanel().getHeight() - 75);
		getPanel2().setBackground(Color.WHITE);
		setComponents(new ArrayList<>());
		JScrollBar scroll = new JScrollBar(JScrollBar.VERTICAL);
		scroll.setBounds(getPanel().getWidth() - 20, 0, 20, getPanel2().getHeight());
		scroll.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				scroll(e.getAdjustable().getValue() - scrollValue);
				scrollValue = e.getAdjustable().getValue();
			}
		});

		getPanel2().add(scroll);
		getComponents().add(getPanel2());
	}

	private void scroll(int delta) {
		double r = (double) getMaxY() / (double) 90;
		int rapport = (int) r;
		if ((r - rapport) != 0)
			rapport++;
		for (Component c : getPanel2().getComponents()) {
			if (!(c instanceof JScrollBar)) {
				c.setLocation(c.getX(), (int) (c.getY() - delta * rapport));
			}
		}
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

	public String[][] getMotscles() {
		return motscles;
	}

	public void setMotscles(String[] motscles) {
		RechercheGoogle google = new RechercheGoogle();
		int maxY = 0;
		this.motscles = new String[motscles.length][2];
		for (int i = 0; i < motscles.length; i++) {
			this.motscles[i][0] = motscles[i];
			this.motscles[i][1] = google.recherche(motscles[i], 0);

			JLabel j = new JLabel(this.motscles[i][0]);
			j.setBounds(10, i * 75 + 10, 100, 25);
			JTextField recherche = new JTextField(this.motscles[i][1]);
			recherche.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			recherche.setBounds(10, i * 75 + 35, getPanel().getWidth() - 40, 25);
			maxY = recherche.getY() + recherche.getHeight();
			getPanel2().add(j);
			getPanel2().add(recherche);
		}
		this.maxY = maxY - getPanel2().getHeight();
		google.stop();
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

}
