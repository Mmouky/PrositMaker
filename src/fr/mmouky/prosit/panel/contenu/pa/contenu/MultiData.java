package fr.mmouky.prosit.panel.contenu.pa.contenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.utils.Button;

public class MultiData {

	private JPanel panel;
	private JLabel LMC;
	private ArrayList<String> motscles;
	private ArrayList<Component> components;
	private JTextField field;
	private Button button;
	private final int totCol = 4;

	public MultiData(JPanel panel, String title) {
		setPanel(panel);
		setButton(new Button(220, 100, 50, 25, "+", Panel.BACKGROUND_COLOR, Color.WHITE, Color.WHITE));
		getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel();
				checkLabel();
				getPanel().repaint();
			}
		});
		setLMC(new JLabel(title));
		getLMC().setBounds(10, 160, 300, 25);
		setField(new JTextField());
		getField().setBounds(10, 100, 200, 25);
		getField().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		getField().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addLabel();
					checkLabel();
					getPanel().repaint();
				}
			}
		});

		setDatas(new ArrayList<>());
		setComponents(new ArrayList<>());

		getComponents().add(getButton());
		getComponents().add(getField());
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

	public void addLabel() {
		if (!getDatas().contains(getField().getText()) && !getField().getText().equalsIgnoreCase("")) {
			getDatas().add(getField().getText());
			getField().setText("");
			int index = getDatas().size() - 1;
			defLabel(index, true);
		}
	}

	public void defLabel(int index, boolean add) {
		int nbCol = index / totCol;
		int nbLigne = index % totCol;
		String txt = getDatas().get(index);
		JLabel label = new JLabel(getDatas().get(index));
		label.setBounds(nbLigne * (getPanel().getWidth() / totCol) + 60, nbCol * 50 + 200, (getPanel().getWidth() / totCol) - 50, 25);
		Button moins = new Button(nbLigne * (getPanel().getWidth() / totCol) + 10, nbCol * 50 + 200, 40, 25, "-", Color.WHITE, Color.black, Panel.BACKGROUND_COLOR);
		moins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getDatas().remove(txt);
				getComponents().remove(label);
				getComponents().remove(moins);
				getPanel().remove(label);
				getPanel().remove(moins);
				checkLabel();
				int i = 0;
				for (Component c : getComponents()) {
					int nbCol = i / totCol;
					int nbLigne = i % totCol;
					if (c instanceof JLabel) {
						if (getDatas().contains(((JLabel) c).getText())) {
							c.setLocation(nbLigne * (getPanel().getWidth() / totCol) + 50, nbCol * 50 + 200);
							i++;
						}
					} else if (c instanceof Button) {
						if (((Button) c).getText().equalsIgnoreCase("-")) {
							c.setLocation(nbLigne * (getPanel().getWidth() / totCol) + 5, nbCol * 50 + 200);
						}
					}
				}
				getPanel().repaint();
			}
		});
		if (add) {
			getComponents().add(moins);
			getComponents().add(label);
		}
		getPanel().add(moins);
		getPanel().add(label);
		getPanel().repaint();
	}

	public void checkLabel() {
		if (getDatas().size() == 0 && getComponents().contains(getLMC())) {
			getComponents().remove(getLMC());
			getPanel().remove(getLMC());
		} else {
			if (getDatas().size() > 0 && !getComponents().contains(getLMC())) {
				getComponents().add(getLMC());
				getPanel().add(getLMC());
			}
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public ArrayList<String> getDatas() {
		return motscles;
	}

	public void setDatas(ArrayList<String> motscles) {
		this.motscles = motscles;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public JLabel getLMC() {
		return LMC;
	}

	public void setLMC(JLabel lMC) {
		LMC = lMC;
	}

}
