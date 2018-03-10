package fr.mouvement.reso2rav.core.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.mouvement.reso2rav.core.domain.Adresse;
import fr.mouvement.reso2rav.core.domain.FrequenceProduit;
import fr.mouvement.reso2rav.core.domain.Identite;
import fr.mouvement.reso2rav.core.domain.Producteur;
import fr.mouvement.reso2rav.core.domain.Produit;
import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;
import fr.mouvement.reso2rav.core.domain.TypeProduit;
import fr.mouvement.reso2rav.core.domain.TypeRetrait;
import fr.mouvement.reso2rav.core.repository.ProducteurRepository;
import fr.mouvement.reso2rav.core.repository.ReseauRavitaillementRepository;

@Component
public class JeuEssaiUtils {

	@Autowired
	ReseauRavitaillementRepository reseauRavitaillementRepository;

	@Autowired
	ProducteurRepository producteurRepository;

	public void creerJeuEssai() {

		Set<Producteur> producteurs = new HashSet<Producteur>();

		Producteur producteur1 = new Producteur();

		producteur1.setNomExploitation("La ferme à blé de Jean-Mi");

		Identite identite = new Identite();

		identite.setNom("Gougou");
		identite.setPrenom("Jean-Michel");
		identite.setMail("jean-mi@mail.fr");
		identite.setTelephone("0123456789");

		Adresse adresse = new Adresse();

		producteur1.setIdentite(identite);
		adresse.setLieuDit("La Conillais");
		adresse.setCodePostal("44130");
		adresse.setCommune("Blain");

		producteur1.setAdresse(adresse);

		Produit produit11 = new Produit();

		produit11.setTypeProduit(TypeProduit.PAIN);
		produit11.setQuantiteDisponible(10);
		produit11.setFrequence(FrequenceProduit.JEUDI);
		produit11.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur1.addProduit(produit11);

		Produit produit12 = new Produit();

		produit12.setTypeProduit(TypeProduit.BLE);
		produit12.setQuantiteDisponible(1000);
		produit12.setFrequence(FrequenceProduit.DIMANCHE);
		produit12.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur1.addProduit(produit12);

		producteurs.add(producteur1);

		Producteur producteur2 = new Producteur();

		producteur2.setNomExploitation("Poulaillier marxiste");

		Identite identite2 = new Identite();

		identite2.setNom("Michou");
		identite2.setPrenom("Maurice");
		identite2.setMail("momo@mail.fr");
		identite2.setTelephone("0987654321");

		Adresse adresse2 = new Adresse();

		producteur2.setIdentite(identite2);
		adresse2.setLieuDit("La Mer de l'Isle");
		adresse2.setCodePostal("44160");
		adresse2.setCommune("Sainte-Anne-sur-Brivet");

		producteur2.setAdresse(adresse2);

		Produit produit21 = new Produit();

		produit21.setTypeProduit(TypeProduit.POULE);
		produit21.setQuantiteDisponible(5);
		produit21.setFrequence(FrequenceProduit.MARDI);
		produit21.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur2.addProduit(produit21);

		Produit produit22 = new Produit();

		produit22.setTypeProduit(TypeProduit.OEUF);
		produit22.setQuantiteDisponible(30);
		produit22.setFrequence(FrequenceProduit.MARDI);
		produit22.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur2.addProduit(produit22);

		producteurs.add(producteur2);

		Producteur producteur3 = new Producteur();

		producteur3.setNomExploitation("L'appel de la laiterie");

		Identite identite3 = new Identite();

		identite3.setNom("Cloclo");
		identite3.setPrenom("Roger");
		identite3.setMail("roro@mail.fr");
		identite3.setTelephone("0666666666");

		Adresse adresse3 = new Adresse();

		producteur3.setIdentite(identite3);
		adresse3.setLieuDit("Tresse");
		adresse3.setCodePostal("44630");
		adresse3.setCommune("Plesse");

		producteur3.setAdresse(adresse3);

		Produit produit31 = new Produit();

		produit31.setTypeProduit(TypeProduit.LAIT);
		produit31.setQuantiteDisponible(10);
		produit31.setFrequence(FrequenceProduit.MERCREDI);
		produit31.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur3.addProduit(produit31);

		Produit produit32 = new Produit();

		produit32.setTypeProduit(TypeProduit.FROMAGE);
		produit32.setQuantiteDisponible(30);
		produit32.setFrequence(FrequenceProduit.MERCREDI);
		produit32.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur3.addProduit(produit32);

		Produit produit33 = new Produit();

		produit33.setTypeProduit(TypeProduit.VIANDE);
		produit33.setQuantiteDisponible(5);
		produit33.setFrequence(FrequenceProduit.A_CONTACTER);
		produit33.setTypeRetrait(TypeRetrait.A_RETIRER);

		producteur3.addProduit(produit33);

		producteurs.add(producteur3);

		ReseauRavitaillement laCagette = new ReseauRavitaillement();

		laCagette.setNom("La cagette");

		laCagette.setProducteurs(producteurs);

		producteurRepository.save(producteurs);

		reseauRavitaillementRepository.save(laCagette);

	}

}
