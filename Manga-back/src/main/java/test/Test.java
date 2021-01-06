package test;

import config.Context;
import model.Oeuvre;

public class Test {

	public static void main(String[] args) {
		
		
		Oeuvre e = new Oeuvre("One Piece","Kana","One Piece est une série de mangas shōnen créée par Eiichirō Oda. Elle est prépubliée depuis le 22 juillet 1997 dans le magazine hebdomadaire Weekly Shōnen Jump, puis regroupée en volumes reliés aux éditions Shūeisha depuis le 24 décembre 1997. 97 tomes sont commercialisés au Japon en septembre 2020. La version française est publiée directement en volumes reliés depuis le 1er septembre 2000 par Glénat. 96 volumes sont commercialisés en octobre 2020 en France.");
		Oeuvre e2 = new Oeuvre("DBZ","Glenat","Dragon Ball Z, abréviation commune DBZ) est une série télévisée d'animation japonaise adaptée de la franchise Dragon Ball d'Akira Toriyama et produite par Toei Animation. Cette série fait suite à l’anime Dragon Ball et adapte les vingt-six derniers volumes du manga.");
		Oeuvre e3=new Oeuvre("SNK","Pika Édition","L’Attaque des Titans. Le Titan assaillant, souvent abrégé SnK) est un shōnen manga écrit et dessiné par Hajime Isayama. Il est prépublié depuis septembre 2009 dans le magazine Bessatsu Shōnen Magazine de l’éditeur Kōdansha, et trente-deux tomes sont sortis en septembre 2020. La version française est publiée par Pika Édition dans la collection seinen depuis juin 2013.");
		Oeuvre e4=new Oeuvre("Naruto","Kana","Naruto manga écrit et dessiné par Masashi Kishimoto. Naruto a été prépublié dans l'hebdomadaire Weekly Shōnen Jump de l'éditeur Shūeisha entre septembre 1999 et novembre 2014. La série a été compilée en 72 tomes.");
		
		
		/*Context.getInstance().getDaoOeuvre().save(e);
		Context.getInstance().getDaoOeuvre().save(e2);
		Context.getInstance().getDaoOeuvre().save(e3);
		Context.getInstance().getDaoOeuvre().save(e4);
		*/
		
		/*System.out.println(Context.getInstance().getDaoOeuvre().findAll());
		
		
		System.out.println(Context.getInstance().getDaoOeuvre().findById(3));
		*/
		
		Context.getInstance().closeEmf();
	}

}
