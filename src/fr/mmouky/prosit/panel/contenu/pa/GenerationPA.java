package fr.mmouky.prosit.panel.contenu.pa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import fr.mmouky.prosit.Main;
import fr.mmouky.prosit.panel.contenu.pa.contenu.ContenuPA;

public class GenerationPA {

	private final String contexte, generalisation, problematique;
	private final ArrayList<String> motscles, contraintes, hypotheses, plan_action;

	public GenerationPA(ContenuPA pa) {
		motscles = pa.getMotscles().getDatas();
		contexte = pa.getContexte().getData();
		contraintes = pa.getContraintes().getDatas();
		generalisation = pa.getGeneralisation().getData();
		problematique = pa.getProblematique().getData();
		hypotheses = pa.getHypotheses().getDatas();
		plan_action = pa.getPlan_action().getDatas();

		try {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("Sélectionner dossier");
			jfc.setApproveButtonText("Enregistrer");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(jfc);
			int ret = jfc.showOpenDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
				try {
					@SuppressWarnings("resource")
					XWPFDocument document = new XWPFDocument();

					XWPFParagraph Ptitre = document.createParagraph();
					Ptitre.setAlignment(ParagraphAlignment.CENTER);
					XWPFRun titre = Ptitre.createRun();
					titre.setText("Prosit " + pa.getInformations().getNbProsit().getText() + " : " + pa.getInformations().getNomProsit().getText());
					titre.setBold(true);
					titre.addBreak();

					XWPFParagraph PMC = document.createParagraph();
					XWPFRun MCtitre = PMC.createRun();
					MCtitre.setText("Mots clés : ");
					MCtitre.setBold(true);
					MCtitre.addBreak();
					for (String str : getMotscles()) {
						XWPFRun MC = PMC.createRun();
						MC.addTab();
						MC.setText("- " + str);
						MC.addBreak();
					}

					XWPFParagraph PContexte = document.createParagraph();
					XWPFRun Contextetitre = PContexte.createRun();
					Contextetitre.setText("Contexte : ");
					Contextetitre.setBold(true);
					Contextetitre.addBreak();
					if (!getContexte().equalsIgnoreCase("")) {
						XWPFRun Contexte = PContexte.createRun();
						Contexte.addTab();
						Contexte.setText(getContexte());
						Contexte.addBreak();
					}

					XWPFParagraph PContraintes = document.createParagraph();
					XWPFRun ContraintesTitre = PContraintes.createRun();
					ContraintesTitre.setText("Contraintes : ");
					ContraintesTitre.setBold(true);
					ContraintesTitre.addBreak();
					for (String str : getContraintes()) {
						XWPFRun Contrainte = PContraintes.createRun();
						Contrainte.addTab();
						Contrainte.setText("- " + str);
						Contrainte.addBreak();
					}

					XWPFParagraph PG = document.createParagraph();
					XWPFRun GeneTitre = PG.createRun();
					GeneTitre.setText("Généralisation : ");
					GeneTitre.setBold(true);
					GeneTitre.addBreak();
					if (!getGeneralisation().equalsIgnoreCase("")) {
						XWPFRun Gene = PG.createRun();
						Gene.addTab();
						Gene.setText(getGeneralisation());
						Gene.addBreak();
					}

					XWPFParagraph PP = document.createParagraph();
					XWPFRun ProbTitre = PP.createRun();
					ProbTitre.setText("Problématique : ");
					ProbTitre.setBold(true);
					ProbTitre.addBreak();
					if (!getProblematique().equalsIgnoreCase("")) {
						XWPFRun Prob = PP.createRun();
						Prob.addTab();
						Prob.setText(getProblematique());
						Prob.addBreak();
					}

					XWPFParagraph PH = document.createParagraph();
					XWPFRun HTitre = PH.createRun();
					HTitre.setText("Hypothèses : ");
					HTitre.setBold(true);
					HTitre.addBreak();
					for (String str : getHypotheses()) {
						XWPFRun H = PH.createRun();
						H.addTab();
						H.setText("- " + str);
						H.addBreak();
					}

					XWPFParagraph PPA = document.createParagraph();
					XWPFRun PATitre = PPA.createRun();
					PATitre.setText("Plan d'action : ");
					PATitre.setBold(true);
					PATitre.addBreak();
					for (String str : getPlan_action()) {
						XWPFRun PA = PPA.createRun();
						PA.addTab();
						PA.setText("- " + str);
						PA.addBreak();
					}

					File nv_fichier = new File(jfc.getSelectedFile() + "\\Prosit " + pa.getInformations().getNbProsit().getText() + ".docx");
					FileOutputStream out = new FileOutputStream(nv_fichier);
					document.write(out);
					out.close();

				} catch (IOException e) {
					JOptionPane.showMessageDialog(Main.getFrame(), "Une erreur est survenue : " + e.getMessage(), "PrositMaker Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}

	public String getContexte() {
		return contexte;
	}

	public String getGeneralisation() {
		return generalisation;
	}

	public String getProblematique() {
		return problematique;
	}

	public ArrayList<String> getMotscles() {
		return motscles;
	}

	public ArrayList<String> getContraintes() {
		return contraintes;
	}

	public ArrayList<String> getHypotheses() {
		return hypotheses;
	}

	public ArrayList<String> getPlan_action() {
		return plan_action;
	}

}
