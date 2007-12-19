package com.ifips.walletOptimiser;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Variable extends Operande {
	private static HashSet<String> toutesLesVariables = new HashSet<String>();
	private LinkedList<String> mesNomVariables = new LinkedList<String>();
	
	public int getDimension(){
		return mesNomVariables.size();
	}
	
	public void addVariableProbleme(String s){
		toutesLesVariables.add(s);
	}

	public void add(String variable) throws Exception {
		if(contains(variable))
				throw new Exception("Variable : Tentative d'ajout d'une variable deja connue.");
		if(!existeVariable(variable))
			throw new Exception("Variable : Variable inexistante.");
		mesNomVariables.add(variable);
	}
	
	private boolean existeVariable(String variable) {
		return toutesLesVariables.contains(variable);
	}

	public boolean contains(String s){
		for (Iterator it = mesNomVariables.iterator(); it.hasNext();) {
			String el = (String) it.next();
			if(el.equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}

	public List<String> getMesNomVariables() {
		return mesNomVariables;
	}
	
	public int getPosition(String s){
		int i=0;
		for (Iterator it = mesNomVariables.iterator(); it.hasNext();) {
			String element = (String) it.next();
			if(element.compareTo(s)==0){
				return i;
			}
			i++;
		}
		return -1;
	}

	public void addLast(String nomVariable) throws Exception {
		if(!contains(nomVariable)){
			mesNomVariables.addLast(nomVariable);
		}else 
			throw new Exception("Variable : Tentative d'ajout d'une variable deja connue");
	}
}
