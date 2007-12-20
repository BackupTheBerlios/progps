/**
 * 
 */
package com.ifips.walletOptimiser.algo;


import java.util.ArrayList;
import java.util.List;

import ilog.concert.*;
import ilog.cplex.*;
import com.ifips.walletOptimiser.*;
/**
 * @author Test
 *
 */
public class MonCPLEX extends Algorithme{
	
	private Fonction fonctionObj;
	private List<Contrainte> contraintes;
	private IloCplex modele;
	private List<IloNumVar> varsCplex = new ArrayList<IloNumVar>();
	private List<IloLinearNumExpr> contraintesCplex = new ArrayList<IloLinearNumExpr>();
	
	public MonCPLEX(Probleme p) {
		super(p);
		fonctionObj=p.getFonctionObjective();
		contraintes=p.getMesContraintes();
		try {
			modele=new IloCplex();
			IloLinearNumExpr obj = modele.linearNumExpr();
			//définition de la fonction objectif
			for (int i = 0; i < fonctionObj.getLaVariable().getDimension(); i++) {
				varsCplex.add(modele.numVar(((DomaineBorne)fonctionObj.getLaVariable().getMonDomaine()).getBorneInf(), ((DomaineBorne)fonctionObj.getLaVariable().getMonDomaine()).getBorneInf(), IloNumVarType.Float));
				obj.addTerm(fonctionObj.getMesPoids().get(i), varsCplex.get(i));
			}
			//définition des contraintes
			for (int i = 0; i < contraintes.size(); i++) {
				contraintesCplex.add(modele.linearNumExpr());
				for (int j=0; i< contraintes.get(i).getPartieGauche().getLaVariable().getDimension();j++) {
					contraintesCplex.get(i).addTerm(contraintes.get(i).getPartieGauche().getMesPoids().get(j), varsCplex.get(j));
				}
				modele.addLe(contraintesCplex.get(i), contraintes.get(i).calculerPartieDroite(null));
			}
			
		} catch (IloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Solution resoudre() {
		try {
			if (modele.solve()) {
				System.out.println();
				System.out.println(" Valeur optimale = " + modele.getObjValue());
				for (int i = 0; i < 3; i++) {
					System.out.println(" x" + i + " = " + modele.getValue(varsCplex.get(i)));
				}
				System.out.println();
			}
			modele.end();
		} catch (IloException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	

}
