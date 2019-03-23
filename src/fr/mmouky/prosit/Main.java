package fr.mmouky.prosit;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import fr.mmouky.prosit.panel.Panel;

public class Main {

	public static final Dimension PANEL_SIZE = new Dimension(1280, 720);

	private static JFrame frame;

	public static void main(String[] args) {
		Point mouse = new Point();
		setFrame(new JFrame());
		getFrame().setIconImage(new ImageIcon(Main.class.getResource("img/logo.png")).getImage());
		getFrame().setTitle("Prosit Maker");
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setContentPane(new Panel());
		getFrame().setFocusable(true);
		getFrame().requestFocus();
		getFrame().getContentPane().setPreferredSize(PANEL_SIZE);
		getFrame().setResizable(false);
		getFrame().setUndecorated(true);
		getFrame().pack();
		getFrame().setLocationRelativeTo(null);
		getFrame().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouse.setLocation(e.getPoint());
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		getFrame().addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				double rapX = e.getPoint().getX() - mouse.getX();
				double rapY = e.getPoint().getY() - mouse.getY();
				getFrame().setLocation(getFrame().getX() + (int) rapX, getFrame().getY() + (int) rapY);
			}
		});
		getFrame().setVisible(true);
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		Main.frame = frame;
	}

}
