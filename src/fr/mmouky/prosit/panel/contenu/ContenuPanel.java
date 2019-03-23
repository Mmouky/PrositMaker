package fr.mmouky.prosit.panel.contenu;

import javax.swing.JPanel;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.cer.CER;
import fr.mmouky.prosit.panel.contenu.pa.PA;
import fr.mmouky.prosit.utils.TypeContenu;

public class ContenuPanel {

	private TypeContenu typeContenu;
	private PA pa;
	private CER cer;
	private JPanel panel;

	public ContenuPanel(TypeContenu typeContenu) {
		setPanel(new JPanel());
		getPanel().setLayout(null);
		setTypeContenu(typeContenu);
		getPanel().setBounds(Panel.WIDTH_MENU, 0, (int) Main.PANEL_SIZE.getWidth() - Panel.WIDTH_MENU, (int) Main.PANEL_SIZE.getHeight());
		getPanel().setBackground(Panel.BACKGROUND_COLOR);
		setPa(new PA(getPanel()));
		setCer(new CER(getPanel()));
		update();
	}

	public void update() {
		getPanel().setBackground(Panel.BACKGROUND_COLOR);
		if (typeContenu == TypeContenu.PA) {
			getPa().addComponents();
		} else {
			getPa().removeComponents();
		}

		if (typeContenu == TypeContenu.CER) {
			getCer().addComponents();
		} else {
			getCer().removeComponents();
		}
	}

	public TypeContenu getTypeContenu() {
		return typeContenu;
	}

	public void setTypeContenu(TypeContenu typeContenu) {
		this.typeContenu = typeContenu;
	}

	public PA getPa() {
		return pa;
	}

	public void setPa(PA pa) {
		this.pa = pa;
	}

	public CER getCer() {
		return cer;
	}

	public void setCer(CER cer) {
		this.cer = cer;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
