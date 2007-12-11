package parser;

import java.io.FileInputStream;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilderFactory;

import noyau.*;

//import org.apache.xpath.XPathAPI;
import org.w3c.dom.*;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;

import com.sun.org.apache.xpath.internal.XPathAPI;
import exceptions.ExceptionParser;

public class XmlParser extends Thread{
	private SingletonProgps myProgps;

	private String filename = null;

	public XmlParser(SingletonProgps myProgps, String filename) {
		this.myProgps = myProgps;
		this.filename = filename;
	}

	public void run() {
		while( !isInterrupted()) {
			try {
			String nomVille;
			String nomVille2;
			String vitesse;
			String touristique;
			String radar;
			String payant;
			String longueur;
			String type;
			String nomRoute;
			Node n;
			NodeIterator nl;
			NodeIterator nl2;
			boolean boolT;
			int intT;
			int intVitesse;
			int intLongueur;
			LinkedList<Etat> etats;
			Route r;
	
			if ((filename != null) && (filename.length() > 0)) {
				System.out.println("Chargement des classes, lecture du fichier " + filename+"...");
				InputSource in = new InputSource(new FileInputStream(filename));
				DocumentBuilderFactory dfactory = DocumentBuilderFactory
						.newInstance();
				dfactory.setNamespaceAware(true);
				Document doc = dfactory.newDocumentBuilder().parse(in);
	
				nl = XPathAPI.selectNodeIterator(doc, "/reseau/ville");
	
				myProgps = SingletonProgps.getInstance();
				while ((n = nl.nextNode()) != null) {
					nomVille = XPathAPI.selectNodeIterator(n, "nom").nextNode()
							.getTextContent();
					type = XPathAPI.selectNodeIterator(n, "type").nextNode()
							.getTextContent();
					touristique = XPathAPI.selectNodeIterator(n, "touristique")
							.nextNode().getTextContent();
	
					if (touristique.equalsIgnoreCase("oui")) {
						boolT = true;
					} else if (touristique.equalsIgnoreCase("non")) {
						boolT = false;
					} else
						throw new ExceptionParser(
								"Etat inconnu pour "
										+ nomVille);
	
					if (type.equalsIgnoreCase("petite")) {
						intT = 1;
					} else if (type.equalsIgnoreCase("moyenne")) {
						intT = 2;
					} else if (type.equalsIgnoreCase("grande")) {
						intT = 3;
					} else
						throw new ExceptionParser("Type de ville inconnu pour "
								+ nomVille+".");
	
					myProgps.ajouterVille(new Ville(myProgps
							.getNewIdVille(), nomVille, true, intT, boolT));
				}
	
				nl = XPathAPI.selectNodeIterator(doc, "/reseau/route");
	
				while ((n = nl.nextNode()) != null) {
					nomRoute = XPathAPI.selectNodeIterator(n, "nom").nextNode()
							.getTextContent();
					type = XPathAPI.selectNodeIterator(n, "type").nextNode()
							.getTextContent();
	
					if (type.equalsIgnoreCase("autoroute")) {
						intT = Route.AUTOROUTE;
					} else if (type.equalsIgnoreCase("nationale")) {
						intT = Route.NATIONALE;
					} else if (type.equalsIgnoreCase("departementale")) {
						intT = Route.DEPARTEMENTALE;
					} else
						throw new ExceptionParser("Type de route inconnu pour " + nomRoute+".");
	
					r = new Route(myProgps.getNewIdRoute(), nomRoute, intT);
					myProgps.ajouterRoute(r);
	
					nl2 = XPathAPI.selectNodeIterator(n, "troncon");
	
					while ((n = nl2.nextNode()) != null) {
						nomVille = XPathAPI.selectNodeIterator(n, "ville1")
								.nextNode().getTextContent();
						nomVille2 = XPathAPI.selectNodeIterator(n, "ville2")
								.nextNode().getTextContent();
						vitesse = XPathAPI.selectNodeIterator(n, "vitesse")
								.nextNode().getTextContent();
						touristique = XPathAPI.selectNodeIterator(n, "touristique")
								.nextNode().getTextContent();
						radar = XPathAPI.selectNodeIterator(n, "radar").nextNode()
								.getTextContent();
						payant = XPathAPI.selectNodeIterator(n, "payant")
								.nextNode().getTextContent();
						longueur = XPathAPI.selectNodeIterator(n, "longueur")
								.nextNode().getTextContent();
	
						if (myProgps.existeVille(nomVille)) {
							if (myProgps.existeVille(nomVille2)) {
								try {
									intVitesse = Integer.parseInt(vitesse);
									try {
										intLongueur = Integer.parseInt(longueur);
										etats = new LinkedList<Etat>();
										if (touristique.equalsIgnoreCase("oui")) {
											etats.add(Etat.Touristique);
										} else if (touristique
												.equalsIgnoreCase("non")) {
	
										} else
											throw new ExceptionParser(
													"Touristique : type inconnu pour "
															+ nomVille+".");
										if (radar.equalsIgnoreCase("oui")) {
											etats.add(Etat.Radar);
										} else if (radar.equalsIgnoreCase("non")) {
										} else
											throw new ExceptionParser(
													"Radar : type inconnu pour "
															+ nomVille+".");
										if (payant.equalsIgnoreCase("oui")) {
											etats.add(Etat.Payant);
										} else if (payant.equalsIgnoreCase("non")) {
										} else
											throw new ExceptionParser(
													"Etat de ville inconnu pour "
															+ nomVille+".");
										r.ajouterTroncon(nomVille, nomVille2,
												intVitesse, intLongueur, etats);
									} catch (NumberFormatException e) {
										throw new ExceptionParser(
												"La distance entre "+ nomVille2 + " et "+nomVille+" n'est pas un nombre entier.");
	
									}
								} catch (NumberFormatException e) {
									throw new ExceptionParser(
											"La vitesse limite entre "+ nomVille2 + " et "+nomVille+" n'est pas un nombre entier.");
								}
	
							} else
								throw new ExceptionParser(
										"Impossible de créer un tronçon entre "+ nomVille2 + " et "+nomVille+" : une des deux villes n'existe pas.");
						} else
							throw new ExceptionParser(
									"Impossible de créer un tronçon entre "+ nomVille2 + " et "+nomVille+" : une des deux villes n'existe pas.");
					}
				}
			} else
				throw new ExceptionParser("Fichier XML indisponible");
			}
			catch (Exception e) {
				return;
			}
		}
	}
}
