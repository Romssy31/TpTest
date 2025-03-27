package controleur;
import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	public boolean isVendeur(String nomVendeur) {
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		/*String[] donneesEtal = null;
		return donneesEtal;*/
		if(!isVendeur(nomVendeur))
			return null;
		else {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			String[] donneesEtal = new String[5];
			boolean etalOccup = etal.isEtalOccupe();
			String strEtalOccup;
			if(etalOccup)
				strEtalOccup = "true";
			else
				strEtalOccup = "false";
			int quantiteActuelle = etal.getQuantite();
			int quantiteDebMarche = etal.getquantiteDebutMarche();
			int quantiteVendu = quantiteDebMarche-quantiteActuelle;
			String strQteVendu = Integer.toString(quantiteVendu);
			String strquantiteDebMarch = Integer.toString(quantiteDebMarche);
			donneesEtal[0] = strEtalOccup;
			donneesEtal[1] = nomVendeur;
			donneesEtal[2] = etal.getProduit();
			donneesEtal[3] = strquantiteDebMarch;
			donneesEtal[4] = strQteVendu;
			return donneesEtal;
		}
	}

}
