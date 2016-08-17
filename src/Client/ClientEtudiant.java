/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/* test */

import CyelPostLicence.Academie;
import CyelPostLicence.AcademieIncorrecte;
import CyelPostLicence.Etudiant;
import CyelPostLicence.EtudiantInconnu;
import CyelPostLicence.Master;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import Outils.CorbaName;
import org.omg.CosNaming.NamingContext;fd

public class Etudiant {

    public CyelPostLicence.GestionnaireAcces gestAcces;
    public CyelPostLicence.GestionnaireVoeux gestVoeux;
    public CyelPostLicence.GestionnaireReferentiel gestReferentiel;
    public Etudiant test;

    public ClientEtudian(String args[]) {
        try {
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Recuperation du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + CorbaName.NOM_NAMINGSERV + ":2001/NameService"));

            // Construction du nom a rechercher
            String idObj = CorbaName.GEST_ACCES;
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));
	    System.out.println("Wouallez");
            //Creation de l'objet distant gestAcces
            gestAcces = CyelPostLicence.GestionnaireAccesHelper.narrow(distantAcces);

            // Construction du nom a rechercher
            idObj = CorbaName.GEST_RERENTIEL;
            nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantReferentiel = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            //Creation de l'objet distant gestReferentiel
            gestReferentiel = CyelPostLicence.GestionnaireReferentielHelper.narrow(distantReferentiel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Obtient la liste des académies auprès du gestionnaire de référentiel
    public Academie[] listeAcademie() {
        return gestReferentiel.listeAcademies();
    }

    //Obtient la liste des masters auprès du gestionnaire de référentiel
    public Master[] listeMaster() {
        return gestReferentiel.listeMasters();
    }

    public void connexion(String ine, Academie academie) throws EtudiantInconnu, AcademieIncorrecte {
        try {
            monEtudiant = gestAcces.identification(Integer.parseInt(ine), academie);

        } catch (EtudiantInconnu e) {
            throw e;
        }
        gestVoeux = gestAcces.obtenirGestionnaireVoeux(academie.numAcademie);
    }

    //Obtient la liste des accréditation d'un diplome auprès du gestionnaire de voeux
    public Universite[] getAccreditations(int numDiplome) {
        Universite[] u;
        u = gestVoeux.consulterAcreditations(numDiplome);
        return u;
    }

     //Enregistrement d'un voeux auprès du gestionnaire de voeux associés à l'étudiant
    public boolean enregistrerVoeux(Voeu[] listeVoeux) {
        gestVoeux.enregistrerVoeux(monEtudiant, listeVoeux);
        return true;
    }

    //Obtient la liste des voeux de l'étudiant
    public Voeu[] mesVoeux() {
        Voeu[] v;
        v = gestVoeux.consulterVoeux(monEtudiant.INE, false);
        return v;
    }
    
    //Obtient la période auprès du gestionnaire de voeux
    public int periode() {
        return gestVoeux.periode();
    }

    //Suppresion d'un voeux auprès du gestionnaire de voeux associés à l'étudiant
    public void supprimerVoeux(int numVoeu, int numUniv) {
        gestVoeux.supprimerVoeux(numVoeu, numUniv);
    }

}
