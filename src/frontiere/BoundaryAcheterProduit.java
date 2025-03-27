package frontiere;

import controleur.ControlAcheterProduit;
import java.util.Objects;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		boolean controlIdAcheteur = controlAcheterProduit.verifIdentVendeur(nomAcheteur);

		if (!controlIdAcheteur)
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici. \n");
		else {
			String nomProduit = Clavier.entrerChaine("Quel produit voulez-vous acheter ? \n");
			System.out.println("Chez quel commerçant voulez-vous acheter des " + nomProduit + " ? \n");
			String[] tabVendeurs = controlAcheterProduit.donnerListeVendeurs();
			int longTabVendeurs = tabVendeurs.length;
			int indiceTabVendeursProduit = 0;
			int testProduitVenduOuNon = 0;
			String[] tabVendeursProduit = new String[longTabVendeurs / 3]; // Car on ne veut que les noms de Vendeurs
			for (int i = 2; i < longTabVendeurs;) {
				// Car on veut accéder au produits donc aux indices 2,5,8...
				if (Objects.equals(tabVendeurs[i], nomProduit)) {
					// Cas ou le produit est vendu par le vendeur
					tabVendeursProduit[indiceTabVendeursProduit] = tabVendeurs[i - 2]; // On ajoute le nom du Vendeur au
																						// tab de vendeurs qui vendent
																						// le produit
					indiceTabVendeursProduit += 1;
					String indiceTabEnString = Integer.toString(indiceTabVendeursProduit);
					System.out.println(indiceTabEnString + " - " + tabVendeurs[i - 2]);
					testProduitVenduOuNon += 1;
				}
				i += 3;
			}
			if (testProduitVenduOuNon == 0)
				System.out.println("Désolé, personne ne vend ce produit au marché. \n");
			else {
				int numMarchand = 0; // INIT PAR DEFAUT
				String nomMarchandChoisi;
				int indiceMarchandChoisi;// INIT PAR DEFAUT

				do {
					indiceMarchandChoisi = numMarchand; // Pas de -1 ?
					nomMarchandChoisi = tabVendeursProduit[indiceMarchandChoisi];
					numMarchand = Clavier.entrerEntier("");
					if ((numMarchand < 0) || ((numMarchand - 1) > indiceTabVendeursProduit)) {
						System.out.println("Erreur indice marchand ! Veuillez taper le bon numéro !\n");
					} else if (!controlAcheterProduit.verifIdentVendeur(nomMarchandChoisi))
						System.out.println("Je suis désolée " + nomMarchandChoisi
								+ " mais il faut être un habitant de notre village pour commercer ici. \n");

				} while ((numMarchand < 0) || ((numMarchand - 1) > indiceTabVendeursProduit)
						|| !controlAcheterProduit.verifIdentVendeur(nomMarchandChoisi));

				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomMarchandChoisi + "\n");
				int nbAAcheter = Clavier.entrerEntier(
						"Bonjour " + nomAcheteur + ".\n" + "Combien de " + nomProduit + " voulez vous acheter ? \n");
				int indiceQuantite = indiceMarchandChoisi + 1 + 3 * indiceMarchandChoisi;
				String quantiteRestanteString = tabVendeurs[indiceQuantite];
				int quantiteRestante = Integer.parseInt(quantiteRestanteString);
				if (quantiteRestante == 0)
					System.out.println(nomAcheteur + " veut acheter " + nbAAcheter + " " + nomProduit
							+ ", malheureusement il n'y en a plus. \n");
				else if (quantiteRestante < nbAAcheter) {
					System.out.println(nomAcheteur + " veut acheter " + nbAAcheter + " " + nomProduit
							+ ", malheureusement " + nomMarchandChoisi + " n'en a plus que " + quantiteRestante + "."
							+ nomAcheteur + " achète tous le stock de " + nomProduit + ". \n");
					// Diminuer le stock de quantiteRestante
					controlAcheterProduit.diminuerQuantiteProduit(quantiteRestante, nomMarchandChoisi);
				} else {
					System.out.println(nomAcheteur + " achète " + nbAAcheter + " " + nomProduit + " à "
							+ nomMarchandChoisi + ".\n");
					// Diminuer le stock de quantiteAcheter
					controlAcheterProduit.diminuerQuantiteProduit(nbAAcheter, nomMarchandChoisi);
				}

			}

		}
	}
}
