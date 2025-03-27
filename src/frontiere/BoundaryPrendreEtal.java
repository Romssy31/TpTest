package frontiere;


import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean verifVendeur = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!verifVendeur)
			System.out.println("Je suis désolé "+nomVendeur +" mais il faut être un habitant de notre village pour commercer ici. \n");
		else {
			installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal. \n");
		boolean etalsRestants = controlPrendreEtal.resteEtals();
		if(!etalsRestants) {
			System.out.println("Désolé "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé. \n");
		} else {
			System.out.println("C'est parfait, il me reste un étal pour vous !\n");
			System.out.println("Il me faudrait quelques renseignements :\n");
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ? \n");
			int quantiteAvendre = Clavier.entrerEntier("Combien souhaitez-vous en vendre ? \n");
			int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantiteAvendre);
			
			if(numeroEtal!=-1) { 
				int numEtalAffichage = numeroEtal+1;
				System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numEtalAffichage+"\n");
			}
		}
	}
}
