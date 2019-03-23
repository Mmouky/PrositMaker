package fr.mmouky.prosit.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.ContenuPanel;

public class Menu extends Button {

	private static final long serialVersionUID = 6424177749672935491L;

	public Menu(int x, int y, int width, int height, ImageIcon img, ContenuPanel contenu, TypeContenu typeContenu, Panel panel) {
		super(x, y, width, height, img, Panel.BACKGROUND_COLOR.darker(), Color.WHITE, Color.WHITE);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (contenu.getTypeContenu() != typeContenu) {
					for (Component c : panel.getMenu().getComponents()) {
						if (c instanceof Menu) {
							c.setBackground(Panel.BACKGROUND_COLOR.darker());
						}
					}
					setBackground(Panel.BACKGROUND_COLOR.darker().darker());
					contenu.setTypeContenu(typeContenu);
					contenu.update();
					Main.getFrame().repaint();
				}
			}
		});
	}
	
	public Menu(int x, int y, int width, int height, ImageIcon img, ContenuPanel contenu, TypeContenu typeContenu, Panel panel, boolean inFocus) {
		this(x, y, width, height, img, contenu, typeContenu, panel);
		if(inFocus) {
			setBackground(Panel.BACKGROUND_COLOR.darker().darker());
		}
	}

}
