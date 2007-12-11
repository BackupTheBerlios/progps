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

public class XmlParser {
	private SingletonProgps progpsAImplenter;

	private String filename = null;

	public XmlParser(SingletonProgps progpsAImplenter, String filename) {
		this.progpsAImplenter = progpsAImplenter;
		this.filename = filename;
	}

	public void doMain() throws Exception {
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
			System.out.println("Loading classes, parsing " + filename);
			InputSource in = new InputSource(new FileInputStream(filename));
			DocumentBuilderFactory dfactory = DocumentBuilderFactory
					.newInstance();
			dfactory.setNamespaceAware(true);
			Document doc = dfactory.newDocumentBuilder().parse(in);

			nl = XPathAPI.selectNodeIterator(doc, "/reseau/ville");

			progpsAImplenter = SingletonProgps.getInstance();
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
					throw new Exception(
							"XML Error : Unknow city tourism state for "
									+ nomVille);

				if (type.equalsIgnoreCase("petite")) {
					intT = 1;
				} else if (type.equalsIgnoreCase("moyenne")) {
					intT = 2;
				} else if (type.equalsIgnoreCase("grande")) {
					intT = 3;
				} else
					throw new Exception("XML Error : Unknow city type for "
							+ nomVille);

				progpsAImplenter.ajouterVille(new Ville(progpsAImplenter
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
					throw new Exception("Unknow road type for " + nomRoute);

				r = new Route(progpsAImplenter.getNewIdRoute(), nomRoute, intT);
				progpsAImplenter.ajouterRoute(r);

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

					if (progpsAImplenter.existeVille(nomVille)) {
						if (progpsAImplenter.existeVille(nomVille2)) {
							try {
								intVitesse = Integer.parseInt(vitesse);
								try {
									intLongueur = Integer.parseInt(longueur);
									etats = new LinkedList<Etat>();
									if (touristique.equalsIgnoreCase("oui")) {
										etats.add(Touristique.getInstance());
									} else if (touristique
											.equalsIgnoreCase("non")) {

									} else
										throw new Exception(
												"XML Error : Unknow city tourism state for "
														+ nomVille);
									if (radar.equalsIgnoreCase("oui")) {
										etats.add(Radar.getInstance());
									} else if (radar.equalsIgnoreCase("non")) {
									} else
										throw new Exception(
												"XML Error : Unknow city radar state for "
														+ nomVille);
									if (payant.equalsIgnoreCase("oui")) {
										etats.add(Payant.getInstance());
									} else if (payant.equalsIgnoreCase("non")) {
									} else
										throw new Exception(
												"XML Error : Unknow city tourism state for "
														+ nomVille);
									r.ajouterTroncon(nomVille, nomVille2,
											intVitesse, intLongueur, etats);
								} catch (NumberFormatException e) {
									throw new Exception(
											"Non integer value enter as distance between"
													+ nomVille2 + " : "
													+ nomVille);
								}
							} catch (NumberFormatException e) {
								throw new Exception(
										"Non integer value enter as speed limit "
												+ nomVille2 + " : " + nomVille);
							}

						} else
							throw new Exception(
									"Try to create a section with a non existant city "
											+ nomVille2 + " : " + nomVille);
					} else
						throw new Exception(
								"Try to create a section with a non existant city "
										+ nomVille + " : " + nomVille2);
				}
			}
		} else
			throw new Exception("XML unvalable");
	}
}
