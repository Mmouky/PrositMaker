package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import fr.mmouky.prosit.utils.Button;

public class HypotheseFactory {

	private int x, y;
	private String txt;
	private Color color;

	public HypotheseFactory(String txt, int x, int y, ArrayList<Component> components) {
		setX(x);
		setY(y);
		setTxt(txt);
		setColor(Color.BLACK);
		JLabel j = new JLabel(txt);
		j.setBounds(getX(), getY(), 240, 25);
		Button btrue = new Button(x, y + 30, 75, 25, "V", new Color(50, 205, 50), Color.BLACK, null);
		btrue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(new Color(50, 205, 50));
				j.setForeground(getColor());
			}
		});

		Button bdk = new Button(x + 80, y + 30, 75, 25, "-", new Color(237, 127, 16), Color.BLACK, null);
		bdk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(new Color(237, 127, 16));
				j.setForeground(getColor());
			}
		});

		Button bfalse = new Button(x + 160, y + 30, 75, 25, "X", new Color(219, 23, 2), Color.BLACK, null);
		bfalse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(new Color(219, 23, 2));
				j.setForeground(getColor());
			}
		});

		components.add(j);
		components.add(btrue);
		components.add(bdk);
		components.add(bfalse);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
