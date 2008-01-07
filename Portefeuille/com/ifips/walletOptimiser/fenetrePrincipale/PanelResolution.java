package com.ifips.walletOptimiser.fenetrePrincipale;

import java.awt.FlowLayout;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class PanelResolution extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel_journal = null;
	private JScrollPane jScrollPane_journal = null;
	private JTextArea jTextArea_journal = null;
	private JLabel jLabel_solutions = null;
	private JScrollPane jScrollPane_solutions = null;
	private JTextArea jTextArea_solutions = null;
	private JButton jButton_save1 = null;
	private JButton jButton_save2 = null;

	/**
	 * This is the default constructor
	 */
	public PanelResolution() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel_solutions = new JLabel();
		jLabel_solutions.setText("Solutions : ");
		jLabel_journal = new JLabel();
		jLabel_journal.setText("Journal : ");
		this.setSize(700, 555);
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		this.setLayout(fl);
		this.add(jLabel_journal, null);
		this.add(getJScrollPane_journal(), null);
		EmptyLabel empty1 = new EmptyLabel(700,20);
		this.add(getJButton_save1(), null);
		this.add(empty1, null);
		this.add(jLabel_solutions, null);
		this.add(getJScrollPane_solutions(), null);
		this.add(getJButton_save2(), null);
	}

	/**
	 * This method initializes jScrollPane_journal	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_journal() {
		if (jScrollPane_journal == null) {
			jScrollPane_journal = new JScrollPane();
			jScrollPane_journal.setPreferredSize(new Dimension(500, 250));
			jScrollPane_journal.setViewportView(getJTextArea_journal());
		}
		return jScrollPane_journal;
	}

	/**
	 * This method initializes jTextArea_journal	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_journal() {
		if (jTextArea_journal == null) {
			jTextArea_journal = new JTextArea();
			jTextArea_journal.setText("");
			jTextArea_journal.setBackground(Color.WHITE);
			jTextArea_journal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			jTextArea_journal.setEditable(false);
			jTextArea_journal.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return jTextArea_journal;
	}

	/**
	 * This method initializes jScrollPane_solutions	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_solutions() {
		if (jScrollPane_solutions == null) {
			jScrollPane_solutions = new JScrollPane();
			jScrollPane_solutions.setViewportView(getJTextArea_solutions());
			jScrollPane_solutions.setPreferredSize(new Dimension(500, 250));
		}
		return jScrollPane_solutions;
	}

	/**
	 * This method initializes jTextArea_solutions	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_solutions() {
		if (jTextArea_solutions == null) {
			jTextArea_solutions = new JTextArea();
			jTextArea_solutions.setText("");
			jTextArea_solutions.setBackground(Color.WHITE);
			jTextArea_solutions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			jTextArea_solutions.setEditable(false);
			jTextArea_solutions.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return jTextArea_solutions;
	}

	/**
	 * This method initializes jButton_save1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_save1() {
		if (jButton_save1 == null) {
			jButton_save1 = new JButton();
			jButton_save1.setText("Enregistrer...");
			jButton_save1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FiltreFichiers filtre = new FiltreFichiers("Fichiers texte (*.txt)",".txt");
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/"));
					chooser.changeToParentDirectory();
					chooser.removeChoosableFileFilter(chooser.getFileFilter());
					chooser.addChoosableFileFilter(filtre);
					int retour = chooser.showSaveDialog(null);
					if (retour == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile() != null && !chooser.getSelectedFile().getName().equals("")) {
						if (chooser.getSelectedFile().exists()) {
							int reponse = JOptionPane.showConfirmDialog(new Frame(),
								       "Voulez-vous écraser le fichier existant \"" + chooser.getSelectedFile().getName() + "\" ?",
								       "Ecraser le fichier ?", 
								        JOptionPane.YES_NO_OPTION);
						  	if (reponse == JOptionPane.YES_OPTION) {
								System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
						  		File fichier = chooser.getSelectedFile().getAbsoluteFile();
								try {
									FileWriter fw = new FileWriter(fichier, false);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter fichierSortie = new PrintWriter(bw); 
									fichierSortie.println(jTextArea_journal.getText());
									fichierSortie.close();
								}
								catch (Exception ex){
									ex.printStackTrace();
								}
							}
						}
						else {
							System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
					  		File fichier = chooser.getSelectedFile().getAbsoluteFile();
							try {
								FileWriter fw = new FileWriter(fichier, false);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter fichierSortie = new PrintWriter(bw); 
								fichierSortie.println(jTextArea_journal.getText());
								fichierSortie.close();
							}
							catch (Exception ex){
								ex.printStackTrace();
							}
						}
					}
				}
			});
		}
		return jButton_save1;
	}

	/**
	 * This method initializes jButton_save2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_save2() {
		if (jButton_save2 == null) {
			jButton_save2 = new JButton();
			jButton_save2.setText("Enregistrer...");
			jButton_save2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FiltreFichiers filtre = new FiltreFichiers("Fichiers texte (*.txt)",".txt");
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/"));
					chooser.changeToParentDirectory();
					chooser.removeChoosableFileFilter(chooser.getFileFilter());
					chooser.addChoosableFileFilter(filtre);
					int retour = chooser.showSaveDialog(null);
					if (retour == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile() != null && !chooser.getSelectedFile().getName().equals("")) {
						if (chooser.getSelectedFile().exists()) {
							int reponse = JOptionPane.showConfirmDialog(new Frame(),
								       "Voulez-vous écraser le fichier existant \"" + chooser.getSelectedFile().getName() + "\" ?",
								       "Ecraser le fichier ?", 
								        JOptionPane.YES_NO_OPTION);
						  	if (reponse == JOptionPane.YES_OPTION) {
						  		System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
						  		File fichier = chooser.getSelectedFile().getAbsoluteFile();
								try {
									FileWriter fw = new FileWriter(fichier, false);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter fichierSortie = new PrintWriter(bw); 
									fichierSortie.println(jTextArea_solutions.getText());
									fichierSortie.close();
								}
								catch (Exception ex){
									ex.printStackTrace();
								}
							}
						}
						else {
							System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
					  		File fichier = chooser.getSelectedFile().getAbsoluteFile();
							try {
								FileWriter fw = new FileWriter(fichier, false);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter fichierSortie = new PrintWriter(bw); 
								fichierSortie.println(jTextArea_solutions.getText());
								fichierSortie.close();
							}
							catch (Exception ex){
								ex.printStackTrace();
							}
						}
					}
				}
			});
		}
		return jButton_save2;
	}

	
	public void appendTextJournal(String text) {
		jTextArea_journal.append(text + "\n");
	}
	
	public void appendTextSolution(String text) {
		jTextArea_solutions.append(text + "\n");
	}
	
	public void clearTextJournal() {
		jTextArea_journal.setText("");
	}
	
	public void clearTextSolution() {
		jTextArea_solutions.setText("");
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
