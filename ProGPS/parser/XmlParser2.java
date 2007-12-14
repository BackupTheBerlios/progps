package parser;

import java.io.FileInputStream;
import java.util.*;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;

import noyau.*;

/**
 * Pour lancer le chargement du xml :exemple :

		SingletonProgps pr = SingletonProgps.getInstance();
		XmlParser xMLStats = new XmlParser(pr,"C:\\Documents and Settings\\Test\\Bureau\\network.xml");
		xMLStats.start();
 *
 */
public class XmlParser2 extends Thread{
	private SingletonProgps myProgps;
	private String filename = null;
	private XMLStreamReader position;

	private int nbrNoeudsVisites=0;
	private int nbrNoeuds=0;
	private boolean exceptionLevee=false;
	private boolean parsingtermine=false;
	// Permet de quitter le thread proprement
	private boolean stop=false;

	public int getNbrNoeuds(){
		return nbrNoeuds;
	}

	public XmlParser2(SingletonProgps myProgps, String filename) {
		this.myProgps = myProgps;
		this.filename = filename;
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		try {
			position=xmlif.createXMLStreamReader(
					filename, 
					new FileInputStream(filename));
		} catch (Exception e) {
			System.out.println(e.toString());
			exceptionLevee=true;
		}
	}

	public void run() {
		while(!isInterrupted() && !stop){
			if(!exceptionLevee && !parsingtermine){
				//check if there are  more events  in  the input stream
				try {
					// Determine le nombre de balises fermantes dans le fichier
					while(position.hasNext() && !exceptionLevee){
						position.next();
						if(position.getEventType()==XMLEvent.START_ELEMENT)
							nbrNoeuds++;
					}
					// On se remet en position de début
					position=XMLInputFactory.newInstance().createXMLStreamReader(
										filename, 
										new FileInputStream(filename));
					
					// On liste toutes les balises du XML
					while(position.hasNext() && !exceptionLevee){
						position.next();
						int eventType = position.getEventType();
						switch  (eventType)
						{
						case XMLEvent.START_ELEMENT:
							nbrNoeudsVisites++;
							if(position.getLocalName().equalsIgnoreCase("reseau")){
								position.next();
								break;
							}
							if(position.getLocalName().equalsIgnoreCase("ville")){
								nodeVille();
								break;
							}
							if(position.getLocalName().equalsIgnoreCase("route")){
								nodeRoute();
								break;
							}
							System.out.println("XML non valide");
							exceptionLevee=true;
							break;
						case XMLEvent.END_ELEMENT:
							if(position.getLocalName().equalsIgnoreCase("reseau"))
								break;
							System.out.println("XML non valide");
							exceptionLevee=true;
							break;
						}
					}
				} catch (Exception e) {
					System.out.println(e.toString());
					exceptionLevee=true;
				}
				// Si aucune exception n'a été levée, on indique que le parsing est fini
				if (!exceptionLevee)
					parsingtermine=true;
			}
		}
	}

	private void nodeVille(){
		String nomVille=null;
		boolean touristique=false;
		int type=0;

		try {
			while(position.hasNext())
			{
				position.next();
				int eventType = position.getEventType();
				switch  (eventType)
				{
				case XMLEvent.START_ELEMENT:
					nbrNoeudsVisites++;
					if(position.getLocalName().equalsIgnoreCase("nom")){
						nomVille=position.getElementText();
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("type")){
						String typeTexte=position.getElementText();
						if(typeTexte.equalsIgnoreCase("petite"))
							type=0;
						if(typeTexte.equalsIgnoreCase("moyenne"))
							type=1;
						if(typeTexte.equalsIgnoreCase("grande"))
							type=2;
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("touristique")){
						//position.next();
						String typeTouristique=position.getElementText();
						if(typeTouristique.equalsIgnoreCase("oui"))
							touristique=true;
						break;
					}
					System.out.println("XML non valide : Noeud trouvé="+position.getLocalName());
					exceptionLevee=true;
					break;
				case XMLEvent.END_ELEMENT:
					if(position.getLocalName().equalsIgnoreCase("ville")){
						// On essaie d'ajouter la ville
						if(nomVille==null){
							exceptionLevee=true;
							System.out.println("Fin de noeud Ville et le nom n'est pas lu.");
						}else{
							myProgps.ajouterVille(nomVille, true, type, touristique);
							return;
						}
						//position.next();
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("nom")
							|| position.getLocalName().equalsIgnoreCase("type")
							|| position.getLocalName().equalsIgnoreCase("touristique")){
						//position.next();
						break;
					}
					System.out.println("XML non valide : Noeud trouvé="+position.toString());
					exceptionLevee=true;
					break;
				}
			}
		} catch (XMLStreamException e) {
			System.out.println(e.toString());
			exceptionLevee=true;
		}
	}

	private void nodeRoute(){
		String nomRoute=null;
		int type=0;
		Route me=null;

		try {
			while(position.hasNext() && !exceptionLevee)
			{
				position.next();
				int eventType = position.getEventType();
				switch  (eventType)
				{
				case XMLEvent.START_ELEMENT:
					nbrNoeudsVisites++;
					if(position.getLocalName().equalsIgnoreCase("nom")){
						nomRoute=position.getElementText();
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("type")){
						String typeTexte=position.getElementText();
						if(typeTexte.equalsIgnoreCase("autoroute"))
							type=0;
						if(typeTexte.equalsIgnoreCase("nationale"))
							type=1;
						if(typeTexte.equalsIgnoreCase("departementale"))
							type=2;
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("troncon")){
						if(me==null)
							me=myProgps.ajouterRoute(nomRoute, type);
						nodeTroncon(me);
						break;
					}
					System.out.println("1 XML non valide : Noeud trouvé="+position.getLocalName());
					exceptionLevee=true;
					break;
				case XMLEvent.END_ELEMENT:
					if(position.getLocalName().equalsIgnoreCase("route")){
						return;
					}
					if(position.getLocalName().equalsIgnoreCase("nom")
							|| position.getLocalName().equalsIgnoreCase("type"))
						break;
					System.out.println("2 XML non valide : Noeud trouvé="+position.toString());
					exceptionLevee=true;
					break;
				}
			}
		} catch (XMLStreamException e) {
			System.out.println(e.toString());
			exceptionLevee=true;
		}
	}

	private void nodeTroncon(Route r){
		String ville1=null;
		String ville2=null;
		int vitesse=0;
		int longueur=0;
		List<Etat> etats=new ArrayList<Etat>();

		try {
			while(position.hasNext() && !exceptionLevee)
			{
				position.next();
				int eventType = position.getEventType();
				switch  (eventType)
				{
				case XMLEvent.START_ELEMENT:
					nbrNoeudsVisites++;
					if(position.getLocalName().equalsIgnoreCase("ville1")){
						ville1=position.getElementText();
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("ville2")){
						ville2=position.getElementText();
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("vitesse")){
						vitesse=(Integer.parseInt(position.getElementText()));
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("longueur")){
						longueur=(Integer.parseInt(position.getElementText()));
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("radar")){
						String typeTexte=position.getElementText();
						if(typeTexte.equalsIgnoreCase("oui"))
							etats.add(Etat.Radar);
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("touristique")){
						String typeTexte=position.getElementText();
						if(typeTexte.equalsIgnoreCase("oui"))
							etats.add(Etat.Touristique);
						break;
					}
					if(position.getLocalName().equalsIgnoreCase("payant")){
						String typeTexte=position.getElementText();
						if(typeTexte.equalsIgnoreCase("oui"))
							etats.add(Etat.Payant);
						break;
					}
					System.out.println("3 XML non valide : Noeud trouvé="+position.getLocalName());
					exceptionLevee=true;
					break;
				case XMLEvent.END_ELEMENT:
					if(position.getLocalName().equalsIgnoreCase("troncon")){
						// On essaie d'ajouter le troncon
						if(!myProgps.ajouterTroncon(ville1, ville2, r, vitesse, longueur, etats)){
							exceptionLevee=true;
							System.out.println("Impossible d'ajoute un troncon.");
						}
						return;
					}
					if(position.getLocalName().equalsIgnoreCase("ville1")
							|| position.getLocalName().equalsIgnoreCase("ville2")
							|| position.getLocalName().equalsIgnoreCase("vitesse")
							|| position.getLocalName().equalsIgnoreCase("touristique")
							|| position.getLocalName().equalsIgnoreCase("radar")
							|| position.getLocalName().equalsIgnoreCase("payant")
							|| position.getLocalName().equalsIgnoreCase("longueur"))
						break;
					System.out.println("4 XML non valide : Noeud trouvé="+position.toString());
					exceptionLevee=true;
					break;
				}
			}
		} catch (XMLStreamException e) {
			System.out.println(e.toString());
			exceptionLevee=true;
		}
	}
	/**
	 * Retourne l'avancement en % [de 0 à 100]
	 * @return l'avancement en % [de 0 à 100]
	 */
	public int getAvancement() {
		if (this.nbrNoeuds==0) return 0;
		return (100*this.nbrNoeudsVisites/this.nbrNoeuds);
	}

	public boolean isExceptionLevee() {
		return exceptionLevee;
	}

	public boolean isParsingtermine() {
		return parsingtermine;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
