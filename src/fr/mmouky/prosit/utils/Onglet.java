package fr.mmouky.prosit.utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.cer.contenu.ContenuCER;
import fr.mmouky.prosit.panel.contenu.pa.contenu.ContenuPA;

public class Onglet extends Button {

	private static final long serialVersionUID = 6424177749672935491L;

	public Onglet(int x, int y, int width, int height, String title, ContenuPA contenu, TypeContenu typeContenu) {
		super(x, y, width, height, title, Panel.BACKGROUND_COLOR, Color.WHITE, Color.WHITE);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (contenu.getTypeContenu() != typeContenu) {
					contenu.setTypeContenu(typeContenu);
					contenu.update();
					Main.getFrame().repaint();
				}
			}
		});
		setBounds(x, y, width, height);
	}
	
	public Onglet(int x, int y, int width, int height, String title, ContenuCER contenu, TypeContenu typeContenu) {
		super(x, y, width, height, title, Panel.BACKGROUND_COLOR, Color.WHITE, Color.WHITE);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (contenu.getTypeContenu() != typeContenu) {
					contenu.setTypeContenu(typeContenu);
					contenu.update();
					Main.getFrame().repaint();
				}
			}
		});
		setBounds(x, y, width, height);
	}
}
