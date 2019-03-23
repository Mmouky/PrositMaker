package fr.mmouky.prosit.panel.contenu.pa;

import java.util.ArrayList;

import javax.swing.JPanel;

import fr.mmouky.prosit.panel.Panel;
import fr.mmouky.prosit.panel.contenu.pa.contenu.ContenuPA;
import fr.mmouky.prosit.utils.Button;
import fr.mmouky.prosit.utils.Onglet;
import fr.mmouky.prosit.utils.TypeContenu;

public class PA {

	private JPanel panel;
	private ContenuPA contenu;
	private Onglet INFORMATIONS, MC, CONTEXTE, CONTRAINTES, GENERALISATION, PROBLEMATIQUE, HYPOTHESES, PA;
	private ArrayList<Onglet> buttons;

	public PA(JPanel panel) {
		setPanel(panel);
		setContenu(new ContenuPA(TypeContenu.INFORMATIONS));
		setButtons(new ArrayList<>());

		int width = getPanel().getWidth() / 8;

		setINFORMATIONS(new Onglet(0, 0, width, Panel.HEIGHT_MENU, "Informations", getContenu(), TypeContenu.INFORMATIONS));
		setMC(new Onglet(width, 0, width, Panel.HEIGHT_MENU, "Mots Clés", getContenu(), TypeContenu.MOTS_CLES));
		setCONTEXTE(new Onglet(2 * width, 0, width, Panel.HEIGHT_MENU, "Contexte", getContenu(), TypeContenu.CONTEXTE));
		setCONTRAINTES(new Onglet(3 * width, 0, width, Panel.HEIGHT_MENU, "Contraintes", getContenu(), TypeContenu.CONTRAINTES));
		setGENERALISATION(new Onglet(4 * width, 0, width, Panel.HEIGHT_MENU, "Généralisation", getContenu(), TypeContenu.GENERALISATION));
		setPROBLEMATIQUE(new Onglet(5 * width, 0, width, Panel.HEIGHT_MENU, "Problématique", getContenu(), TypeContenu.PROBLEMATIQUE));
		setHYPOTHESES(new Onglet(6 * width, 0, width, Panel.HEIGHT_MENU, "Hypothèses", getContenu(), TypeContenu.HYPOTHESES));
		setPA(new Onglet(7 * width, 0, width, Panel.HEIGHT_MENU, "Plan d'action", getContenu(), TypeContenu.PLAN_DACTION));

		getButtons().add(getINFORMATIONS());
		getButtons().add(getMC());
		getButtons().add(getCONTEXTE());
		getButtons().add(getCONTRAINTES());
		getButtons().add(getGENERALISATION());
		getButtons().add(getPROBLEMATIQUE());
		getButtons().add(getHYPOTHESES());
		getButtons().add(getPA());

	}

	public void addComponents() {
		for (Button b : getButtons()) {
			getPanel().add(b);
		}
		getPanel().add(getContenu().getPanel());
		getPanel().setBackground(Panel.BACKGROUND_COLOR);
	}

	public void removeComponents() {
		for (Button b : getButtons()) {
			getPanel().remove(b);
		}
		getPanel().remove(getContenu().getPanel());
	}

	public Onglet getMC() {
		return MC;
	}

	public void setMC(Onglet mC) {
		MC = mC;
	}

	public Onglet getCONTEXTE() {
		return CONTEXTE;
	}

	public void setCONTEXTE(Onglet cONTEXTE) {
		CONTEXTE = cONTEXTE;
	}

	public Onglet getCONTRAINTES() {
		return CONTRAINTES;
	}

	public void setCONTRAINTES(Onglet cONTRAINTES) {
		CONTRAINTES = cONTRAINTES;
	}

	public Onglet getGENERALISATION() {
		return GENERALISATION;
	}

	public void setGENERALISATION(Onglet gENERALISATION) {
		GENERALISATION = gENERALISATION;
	}

	public Onglet getPROBLEMATIQUE() {
		return PROBLEMATIQUE;
	}

	public void setPROBLEMATIQUE(Onglet pROBLEMATIQUE) {
		PROBLEMATIQUE = pROBLEMATIQUE;
	}

	public Onglet getHYPOTHESES() {
		return HYPOTHESES;
	}

	public void setHYPOTHESES(Onglet hYPOTHESES) {
		HYPOTHESES = hYPOTHESES;
	}

	public Onglet getPA() {
		return PA;
	}

	public void setPA(Onglet pA) {
		PA = pA;
	}

	public ArrayList<Onglet> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<Onglet> buttons) {
		this.buttons = buttons;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public ContenuPA getContenu() {
		return contenu;
	}

	public void setContenu(ContenuPA contenu) {
		this.contenu = contenu;
	}

	public Onglet getINFORMATIONS() {
		return INFORMATIONS;
	}

	public void setINFORMATIONS(Onglet iNFORMATIONS) {
		INFORMATIONS = iNFORMATIONS;
	}

}
