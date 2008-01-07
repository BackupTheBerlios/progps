package com.ifips.walletOptimiser.fenetrePrincipale;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author  Fish
 */
public class FiltreFichiers extends FileFilter {

	//Description et extension acceptée par le filtre
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	private String extension;

	//Constructeur à partir de la description et de l'extension acceptée
	public FiltreFichiers(String description, String extension){
		if(description == null || extension == null){
			throw new NullPointerException("La description (ou extension) ne peut être null.");
		}
		this.description = description;
		this.extension = extension;
	}

	//Implémentation de FileFilter
	public boolean accept(File file){
		if(file.isDirectory()) { 
			return true;
		}
		String nomFichier = file.getName().toLowerCase();
		return nomFichier.endsWith(extension);
	}

	/**
	 * @return
	 * @uml.property  name="description"
	 */
	public String getDescription(){
		return description;
	}
}
