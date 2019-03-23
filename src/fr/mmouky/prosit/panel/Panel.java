package fr.mmouky.prosit.panel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.contenu.ContenuPanel;
import fr.mmouky.prosit.utils.Button;
import fr.mmouky.prosit.utils.Menu;
import fr.mmouky.prosit.utils.TypeContenu;

public class Panel extends JPanel {

	private static final long serialVersionUID = 6375665736594599233L;

	private JPanel menu;
	private ContenuPanel contenu;
	public static final int WIDTH_MENU = 250;
	public static final int HEIGHT_MENU = 100;
	private static final String version = "1.2";
	private Button close;
	private JLabel LVersion, Logo;

	public static Color BACKGROUND_COLOR = new Color(92, 136, 218);

	public Panel() {
		super();
		this.setBounds(0, 0, (int) Main.PANEL_SIZE.getWidth(), (int) Main.PANEL_SIZE.getHeight());
		this.setLayout(null);
		setMenu(new JPanel());
		getMenu().setLayout(null);
		setContenu(new ContenuPanel(TypeContenu.PA));
		getMenu().setBounds(0, 0, WIDTH_MENU, (int) Main.PANEL_SIZE.getHeight());
		ImageIcon imgPA = new ImageIcon(new ImageIcon(Main.class.getResource("img/PA.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon imgCER = new ImageIcon(new ImageIcon(Main.class.getResource("img/CER.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon imgMeme = new ImageIcon(new ImageIcon(Main.class.getResource("img/MEME.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		ImageIcon imgGroupe = new ImageIcon(new ImageIcon(Main.class.getResource("img/group.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		getMenu().add(new Menu(0, HEIGHT_MENU, WIDTH_MENU, HEIGHT_MENU, imgPA, getContenu(), TypeContenu.PA, this, true));
		getMenu().add(new Menu(0, 2 * HEIGHT_MENU, WIDTH_MENU, HEIGHT_MENU, imgCER, getContenu(), TypeContenu.CER, this));
		getMenu().add(new Menu(0, 3 * HEIGHT_MENU, WIDTH_MENU, HEIGHT_MENU, imgMeme, getContenu(), TypeContenu.MEME, this));
		getMenu().add(new Menu(0, 4 * HEIGHT_MENU, WIDTH_MENU, HEIGHT_MENU, imgGroupe, getContenu(), TypeContenu.GROUPE, this));
		getMenu().setBackground(Panel.BACKGROUND_COLOR.darker());
		ImageIcon imgClose = new ImageIcon(new ImageIcon(Main.class.getResource("img/close.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		setClose(new Button(0, (int) Main.PANEL_SIZE.getHeight() - 50, 50, 50, imgClose, Panel.BACKGROUND_COLOR.darker(), null, Panel.BACKGROUND_COLOR.darker()));
		getClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setLVersion(new JLabel("v" + version, SwingConstants.RIGHT));
		getLVersion().setForeground(Color.BLACK);
		getLVersion().setBounds(getClose().getX() + getClose().getWidth(), getClose().getY(), WIDTH_MENU - getClose().getWidth() - 20, getClose().getHeight());

		Image imgLogo = new ImageIcon(Main.class.getResource("img/logo.png")).getImage();
		float rapport = (float) (HEIGHT_MENU - 30) / imgLogo.getHeight(null);
		ImageIcon logoIcon = new ImageIcon(imgLogo.getScaledInstance((int) (imgLogo.getWidth(null) * rapport), HEIGHT_MENU - 30, Image.SCALE_SMOOTH));

		setLogo(new JLabel(logoIcon));
		getLogo().setBounds(0, 0, WIDTH_MENU, HEIGHT_MENU);
		this.add(getLogo());
		this.add(getLVersion());
		this.add(getClose());
		this.add(getMenu());
		this.add(getContenu().getPanel());
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public ContenuPanel getContenu() {
		return contenu;
	}

	public void setContenu(ContenuPanel contenu) {
		this.contenu = contenu;
	}

	public Button getClose() {
		return close;
	}

	public void setClose(Button close) {
		this.close = close;
	}

	public JLabel getLogo() {
		return Logo;
	}

	public void setLogo(JLabel logo) {
		Logo = logo;
	}

	public JLabel getLVersion() {
		return LVersion;
	}

	public void setLVersion(JLabel lVersion) {
		LVersion = lVersion;
	}

}
