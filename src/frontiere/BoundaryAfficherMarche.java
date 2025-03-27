package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		StringBuilder chaine = new StringBuilder();
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		int tailleMarche = infosMarche.length;
		if(tailleMarche==0)
			System.out.println("Le marché est vide, revenez plus tard. \n");
		else {
			System.out.println(nomAcheteur+" vous trouverez au marché : \n");
			for(int i=0;i<tailleMarche;i++) {
				if(i%3==0) {
					chaine.append(infosMarche[i]);
					chaine.append(" qui vend ");
					
				}
				else if(i%3==1) {
					chaine.append(infosMarche[i]);
					chaine.append(" ");
					
				}
				else if(i%3==2) {
					chaine.append(infosMarche[i]);
					
					System.out.println(chaine);
					chaine.append("/n");
					chaine.setLength(0);
				}
			}
		}
	}
}