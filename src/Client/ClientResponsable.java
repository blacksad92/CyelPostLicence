/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import CyelPostLicence.Academie;
import CyelPostLicence.Candidature;
import CyelPostLicence.Etudiant;
import CyelPostLicence.Master;
import CyelPostLicence.Note;
import CyelPostLicence.ResponsableInconnu;
import CyelPostLicence.Universite;
import Impl.BDD_GestionnaireCandidature;
import Outils.CorbaName;
import org.omg.CosNaming.NamingContext;

/**
 *
 * @author Linkro
 */
public class ClientResponsable {

    public CyelPostLicence.GestionnaireAcces gestAcces;
    public CyelPostLicence.GestionnaireVoeux gestVoeux;
    public CyelPostLicence.GestionnaireReferentiel gestReferentiel;
    public CyelPostLicence.GestionnaireCandidatures gestCandidature;
    private int NumMaster;

    public ClientResponsable(String args[]) {
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

    public int getNumMaster() {
        return NumMaster;
    }

    public void setNumMaster(int NumMaster) {
        this.NumMaster = NumMaster;
    }

    public int getPeriode() {
        return gestVoeux.periode();
    }

    public Academie[] listeAcademie() {
        return gestReferentiel.listeAcademies();
    }

    public Master[] listeMaster() {
        return gestCandidature.listeMaster();
    }

    public Universite[] listeUniversite() {
        return gestVoeux.listeUniversite();
    }

    public void connexion(String login, String mdp, int academie) throws ResponsableInconnu {
        try {
            gestVoeux = gestAcces.identificationUniv(login, mdp, academie);
        } catch (ResponsableInconnu e) {
            throw e;
        }
    }

    public Universite[] getAccreditations(int numDiplome) {
        Universite[] u = new Universite[5];
      //  u = gestVoeux.consulterAcreditations(numDiplome);

        return u;
    }

    public void obtenirGestionnaireCandidatures(int numUniversite) {
        System.out.println("cR obtenirGestionnaire Candidatures");
        gestCandidature = gestAcces.obtenirGestionnaireCandidatures(numUniversite);
    }

    public void recupererLesCandidatures() {
        int NumUniv = gestCandidature.universite().numUniv;
        System.out.println("CR recupererLesCandidatures");
        Etudiant[] etudiants = gestVoeux.recupererListeCandidatures(NumMaster, NumUniv);
        System.out.println("CR etudiants" + etudiants.length);
        gestCandidature.enregistrerCandidatures(etudiants, NumMaster);
    }

    public Candidature[] mesCandidatures() {
        System.out.println("CR mesCandidatures");
        int NumUniversite = gestCandidature.universite().numUniv;
        System.out.println("CR mesCandidatures numUniversite" + NumUniversite);
        Candidature[] candidatures;
        candidatures = gestCandidature.consulterCandidatures(NumMaster, NumUniversite);
        System.out.println("CR mesCandidatures etudiants" + candidatures.length);
        return candidatures;
    }

    public Note[] recupererNotesCandidat(int INE) {
        System.out.println("[ClientResponsable] Recupereration des notes de " + INE);
        Note[] notes = gestCandidature.recupererListeNotes(INE, false);

        return notes;
    }
    
    public void enregistrerClassement(int INE, int classement) {
        gestCandidature.enregistrerClassement(INE, classement);
    }
}
