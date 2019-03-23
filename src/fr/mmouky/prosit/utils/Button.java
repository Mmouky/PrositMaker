package fr.mmouky.prosit.utils;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Button extends JButton {

	private static final long serialVersionUID = -8791124560475994015L;

	public Button(int x, int y, int width, int height, ImageIcon img, Color colorBG, Color colorTxt, Color colorContour) {
		super(img);
		defButton(x, y, width, height, colorBG, colorTxt, colorContour);
	}

	public Button(int x, int y, int width, int height, String title, Color colorBG, Color colorTxt, Color colorContour) {
		super(title);
		defButton(x, y, width, height, colorBG, colorTxt, colorContour);
	}

	private void defButton(int x, int y, int width, int height, Color colorBG, Color colorTxt, Color colorContour) {
		this.setBackground(colorBG);
		this.setForeground(colorTxt);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setFocusable(false);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorderPainted(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(new LineBorder(colorContour));
				setBorderPainted(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		this.setBounds(x, y, width, height);
	}

}
