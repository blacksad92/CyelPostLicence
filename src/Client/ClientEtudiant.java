/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import CyelPostLicence.Academie;
import CyelPostLicence.AcademieIncorrecte;
import CyelPostLicence.Etudiant;
import CyelPostLicence.EtudiantInconnu;
import CyelPostLicence.Master;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import Outils.CorbaName;
import org.omg.CosNaming.NamingContext;

/**
 *
 * @author Linkro
 */
public class ClientEtudiant {

    public static CyelPostLicence.GestionnaireAcces gestAcces;
    public static CyelPostLicence.GestionnaireVoeux gestVoeux;
    public static CyelPostLicence.GestionnaireReferentiel gestReferentiel;
    public Etudiant monEtudiant;

    public ClientEtudiant(String arg[]) {
        this.main(arg);
    }

    public static void main(String args[]) {

        try {
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Recuperation du naming service
            //org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + CorbaName.NOM_NAMINGSERV + ":2001/NameService"));

            // Construction du nom a rechercher
            String idObj = CorbaName.GEST_ACCES;
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            //org.omg.CORBA.Object distantAcces = orb.string_to_object("IOR:000000000000002A49444C3A4379656C506F73744C6963656E63652F47657374696F6E6E6169726541636365733A312E30000000000000010000000000000058000102000000000D3139322E3136382E312E32300000F40C00000014004F4F0103B916394D010000504F41FE73F9F4A200000001000000010000001C00000000050100010000000100010020000101090000000100010100");
            // Casting de l'objet CORBA au type convertisseur GestionnaireAcces
            gestAcces = CyelPostLicence.GestionnaireAccesHelper.narrow(distantAcces);

            // Construction du nom a rechercher
            idObj = CorbaName.GEST_RERENTIEL;
            nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantReferentiel = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            gestReferentiel = CyelPostLicence.GestionnaireReferentielHelper.narrow(distantReferentiel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Academie[] listeAcademie() {
        return gestReferentiel.listeAcademies();
    }

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
        gestVoeux.cloturerPeriode();
    }

    public Universite[] getAccreditations(int numDiplome) {
        Universite[] u;
        u = gestVoeux.consulterAcreditations(numDiplome, false);

        return u;
    }

    public boolean enregistrerVoeux(Voeu[] listeVoeux) {
        gestVoeux.enregistrerVoeux(monEtudiant, listeVoeux);
        return true;
    }

    public Voeu[] mesVoeux() {
        Voeu[] v;
        v = gestVoeux.consulterVoeux(monEtudiant.INE, false);
        return v;
    }
}
