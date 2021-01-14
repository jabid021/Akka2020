package app;

import demoFactory.AutreClassQuiImplementBidon;
import demoFactory.Bidon;
import demoFactory.BindonFactory;
import demoFactory.ClassQuiImplementInterfaceBidon;
import services.Ville;
import services.VilleServiceService;
import services.Villeservice;

public class App {

	public static void main(String[] args) {
//
//		Bidon instance = BindonFactory.getInstance();
//		instance.methodeBidon();

		VilleServiceService villeServiceFactory = new VilleServiceService();
		Villeservice villeService = villeServiceFactory.getVilleservicePort();
		Ville ville = villeService.getInfo("paris");
		if (ville != null)
			System.out.println(ville.getNom() + " ,population:" + ville.getPopulation() + " ,pays:" + ville.getPays());
		else
			System.out.println("cette ville est inconnu");
	}

}
