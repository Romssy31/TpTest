package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) 
			//Vendeur non reconnu
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui ! \n");
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0]=="true") {
				int quantiteVendu = Integer.parseInt(donneesEtal[4]);
				int quantiteInitial = Integer.parseInt(donneesEtal[3]);
				System.out.println("Vous avez vendu "+quantiteVendu+" sur "+quantiteInitial+" "+donneesEtal[2]+".\n");
				System.out.println("Au revoir "+nomVendeur+", passez une bonne journée ! \n");
			}
		}
	}
}