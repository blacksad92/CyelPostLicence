/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Decision;
import CyelPostLicence.EnumDecision;
import CyelPostLicence.EnumReponse;
import CyelPostLicence.Etudiant;
import CyelPostLicence.GestionnaireAcces;
import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;

/**
 *
 * @author Linkro
 */
public class GestionnaireVoeuxImpl extends CyelPostLicence.GestionnaireVoeuxPOA {

    public ArrayList<Universite> listeAccredUniv;
    public Universite[] tableauAccredUniv;
    public ArrayList<Universite> listeAccredUnivExt;
    public Universite[] tableauAccredUnivExt;
    public ArrayList<Universite> listeUniv2;
    public Universite[] tableauUniv2;
    public ArrayList<Voeu> listeVoeu;
    public ArrayList<Voeu> listeTempo;
    public Voeu[] tabtemp;
    public Voeu[] tableauTempo;
    public Voeu[] tableauConsulterVoeu;

    public Academie academie;
    public ArrayList<Integer> mesIDUnivs = new ArrayList();
    public BDD_GestionnaireVoeux bdd = new BDD_GestionnaireVoeux();
    public GestionnaireAcces gestAcces;
    public static int nbGest = 0;
    public static int periode = 1;
    public ArrayList<Voeu> listeVoeuxParAcademie;

    public GestionnaireVoeuxImpl() {
        ////// NOUVEAUX : Pour scénario
        academie = new Academie(1, "Toulouse");
        //academie = new Academie(2, "Nice");
        
        ///////////////////////////////////////////////////////////////////////////
        ////// ANCIENS
        //academie = new Academie(1, "Toulouse");
        //academie = new Academie(2, "Montpellier");
        //academie = new Academie(3, "Nice");
        //academie = new Academie(4, "Aix-Marseille");
        //academie = new Academie(5, "Bordeaux");
        //academie = new Academie(6, "Corse");
        ///////////////////////////////////////////////////////////////////////////

        listeAccredUniv = new ArrayList<Universite>();
        listeAccredUnivExt = new ArrayList<Universite>();
        listeUniv2 = new ArrayList<Universite>();
        listeVoeu = new ArrayList<Voeu>();
        listeTempo = new ArrayList<Voeu>();
        listeVoeuxParAcademie = new ArrayList<Voeu>();
        System.out.println(academie.nomAcademie);
        maListeUnivs();
    }

    @Override
    public void cloturerPeriode() {
        System.out.println("Periode ancienne " + periode);

        if (periode < 4) {
            periode++;

            if (periode == 2) {// SI la periode passe a 2, on envoie automatiquement les candidatures
                //Recuperer les voeux pour l'academie.
                ArrayList<Voeu> listeVoeux = bdd.bdd_listeVoeuxParAcademie(this.academie.numAcademie);
                for (int i = 0; i < listeVoeux.size(); i++) {
                    /**/System.out.println("[cloturerPeriode] NumVoeu="+listeVoeux.get(i).numVoeu+" | Etat="+listeVoeux.get(i).etatCandidature.value()+" | nonValide="+EnumDecision.nonValide.value());
                    if (listeVoeux.get(i).etatCandidature.value()!=EnumDecision.nonValide.value()) { // On ne passe aux universités que les candidatures valides
                        /**/System.out.println("ok : "+listeVoeux.get(i).etatCandidature.value()+"!="+EnumDecision.nonValide.value());
                        int numMaster = listeVoeux.get(i).master.numMaster;
                        int numUniversite = listeVoeux.get(i).universite.numUniv;
                        int numVoeux = listeVoeux.get(i).numVoeu;
                        int INE = bdd.bdd_INEduVoeu(numVoeux);
                        Etudiant etu = gestAcces.obtenirEtudiant(INE);
                        // Recuperer le bon gestionnaire de candidature
                        GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(numUniversite);

                        // Appeller la méthode enregistrer candidatures
                        if (gestCand != null) {
                            gestCand.enregistrerCandidatures(etu, numMaster);
                        }
                    }
                }
            }

            if (periode == 3) { // SI lon passe à la période 3 -> Envoi des décisions des universités vers les académies (on va donc notifier les universités)
                System.out.println("[GestionnaireVoeuxImpl] cloturerPeriode - PASSAGE PERIODE 3");
                // Récupérer la liste des universités de l'académie
                ArrayList<Universite> listeUniv = bdd.bdd_consultUniversitePourUneAcademie(academie.numAcademie);
                // Pour chaque université
                Iterator it = listeUniv.iterator();
                while (it.hasNext()) {
                    Universite univ = (Universite) it.next();
                    // Recuperer le bon gestionnaire de candidature
                    GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(univ.numUniv);

                    // Appeller la méthode finPeriodeDecision
                    if (gestCand != null) {
                        gestCand.finPeriodeDecision();
                    }
                }
            }
            /* Lorsque la periode passe à 4, il faut mettre à jour le classement des candidatures
                en fonction de la réponse adressée par l'étudiant 
            */ 
            if (periode == 4) {
                ArrayList<Voeu> listeVoeuxAvecReponse = bdd.bdd_listeVoeuxParAcademie(this.academie.numAcademie);
                for (int i = 0; i < listeVoeuxAvecReponse.size(); i++) {
                    int numUniversite = listeVoeuxAvecReponse.get(i).universite.numUniv;
                    int numVoeu = listeVoeuxAvecReponse.get(i).numVoeu;
                    int INE = bdd.bdd_INEduVoeu(numVoeu);
                    GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(numUniversite);
                    // On appelle la méthode majListe sur tous les gestionnaires de candidatures en activité
                    if (gestCand != null) {
                        gestCand.majListe(INE, listeVoeuxAvecReponse.get(i));
                    }
                }
            }
        }
        System.out.println("NOUVELLE PERIODE : " + periode);
    }
    
// Permet de remettre la période à 1 et de supprimer en BD les voeux et les candidatures
    @Override    
    public void RAZPeriode() {
        try {
        System.out.println("Periode actuelle " + periode);
        System.out.println("Remise à zéro de la période");
        periode = 1;
        ArrayList<Universite> liste = bdd.bdd_consultUniversitePourUneAcademie(academie.numAcademie);
        for (int i = 0; i < liste.size(); i++) {
            GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(liste.get(i).numUniv);

            if (gestCand != null){
                // on appelle le RAZ pour chaque gestionnaire de candidatures en activité
                gestCand.RAZPeriode();
                bdd.bdd_RAZ(academie.numAcademie);
            }
        }
        
         System.out.println("La période a été remis à : "+periode);
         } catch (SQLException ex) {
         Logger.getLogger(GestionnaireVoeuxImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public Academie academie() {
        return academie;
    }

    @Override
    public void academie(Academie value) {
        this.academie = value;
    }

    @Override
    public int periode() {
        return periode;
    }

//TODO Implémenter cette méthode
    @Override
    public void periode(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Universite[] listeUniversite() {
        listeUniv2 = bdd.bdd_consultUniversitePourUneAcademie(academie.numAcademie);
        tableauUniv2 = listeUniv2.toArray(new Universite[listeUniv2.size()]);
        return tableauUniv2;
    }

    @Override
    public Voeu[] consulterVoeux(int INE, boolean externe) {

        if (!externe) {
            listeVoeu = new ArrayList<Voeu>();

            //Liste de toutes les académies
            GestionnaireVoeux[] listeGestVoeux = gestAcces.listeGestionnairesVoeux();

            for (int i = 0; i < listeGestVoeux.length; i++) {
                tableauTempo = listeGestVoeux[i].consulterVoeux(INE, true);
                if (tableauTempo.length > 0) {
                    for (Voeu v : tableauTempo) {
                        listeVoeu.add(v);
                    }
                }
            }
            
            // Tri du tableau résultat
            Comparator comparator = new Comparator<Voeu>() {
                @Override
                public int compare(Voeu  voeu1, Voeu  voeu2)
                {
                    int res = 0;
                    if (voeu1.ordre.value() < voeu2.ordre.value()) {
                        res = -1;
                    }
                    if (voeu1.ordre.value() > voeu2.ordre.value()) {
                        res = 1;
                    }
                    return res;
                }
            };
            listeVoeu.sort(comparator);
            
            tableauConsulterVoeu = listeVoeu.toArray(new Voeu[listeVoeu.size()]);            
            return tableauConsulterVoeu;
        }

        if (externe) {
            listeTempo = bdd.bdd_listeVoeux(INE, this.academie.numAcademie);
            tabtemp = new Voeu[listeTempo.size()];
            if (listeTempo.size() > 0) {
                tabtemp = listeTempo.toArray(new Voeu[listeTempo.size()]);
            }
            return tabtemp;
        }
        return tableauConsulterVoeu;
    }
    /*
    private Voeu[] ordonnerListeVoeux(Voeu[] tabVoeux) {
        int n=0;
        
        ArrayList<Voeu> listeRetour = new ArrayList<Voeu>();
        for (int i=0;i<tabVoeux.length;i++) {
            if ()
        }
    }
    */

    @Override
    public void enregistrerVoeux(Etudiant etudiant, Voeu[] listeVoeux) {

        //Si le voeux est dans cette meme academie
        if (this.academie.numAcademie == listeVoeux[0].universite.academie.numAcademie) {
            if (listeVoeux[0].numVoeu == 0) {

                //Permet de récupérer l'état valide ou non-valide d'un voeu, supprimer l'appel de la méthode dans cloturerPeriode
                GestionnaireCandidatures gestCandidature = gestAcces.obtenirGestionnaireCandidatures(listeVoeux[0].universite.numUniv);
                EnumDecision etatVoeu = gestCandidature.validerCandidature(listeVoeux[0].master.numMaster, etudiant.licence.numLicence);

                listeVoeux[0].etatCandidature = etatVoeu;
            }

            //On enregistre voeu
            bdd.bdd_insertVoeu(etudiant, listeVoeux);

            //Sinon le voeu concerne une autre académie
        } else {
            GestionnaireVoeux gestVoeu = gestAcces.obtenirGestionnaireVoeux(listeVoeux[0].universite.academie.numAcademie);
            gestVoeu.enregistrerVoeux(etudiant, listeVoeux);
        }
    }

    @Override
    public Etudiant[] recupererListeCandidatures(int numMaster, int numUniversite) {
        //Plus necessaire a supprimer
        return null;
    }

    @Override
    public void enregistrerDecision(Decision decision) {
        System.out.println("[GestionnaireVoeuxImpl] enregistrerDecision");

        boolean res = bdd.bdd_enregistrerDecision(decision.etudiant.INE, decision.numMaster, decision.numUniversite, decision.decision);

        if (!res) {
            System.out.println("/!\\ ERREUR ENREGISTREMENT DECISION /!\\");
        }
    }

    public void maListeUnivs() {
        this.mesIDUnivs = bdd.bdd_recupNumUnivs(academie.numAcademie);
    }

    @Override
    public void repondreVoeu(int INE, Voeu voeu) {
        // On récupère la liste des voeux de l'étudiant
        ArrayList<Voeu> listeVoeux = new ArrayList<Voeu>();
        Voeu[] tabVoeux = consulterVoeux(INE,false);
        if (tabVoeux.length > 0) {
            for (Voeu v : tabVoeux) {
                listeVoeux.add(v);
            }
        }
        
        boolean passe = false;
        Iterator it = listeVoeux.iterator();
        while (it.hasNext()) {
            Voeu v = (Voeu) it.next();

            if (v.numVoeu == voeu.numVoeu) { // Voeu répondu
                passe = true;
                bdd.bdd_repondreVoeu(voeu.numVoeu, voeu.reponse);
            } else if (passe) { // Voeux en dessous
                bdd.bdd_repondreVoeu(v.numVoeu, EnumReponse.non);
            } else { // Voeux au dessus
                EnumReponse rep = EnumReponse.oui;
                // Si il a répondu non : abandon de tous les voeux, oui : abandon des voeux supérieurs
                if (voeu.reponse == EnumReponse.non || voeu.reponse == EnumReponse.oui) {
                    rep = EnumReponse.non;
                }
                bdd.bdd_repondreVoeu(v.numVoeu, rep);
            }
        }
    }

    @Override
    public void supprimerVoeux(int numVoeu, int numUniv) {

        if (mesIDUnivs.contains(numUniv)) {
            try {
                bdd.bdd_SupprimerVoeux(numVoeu);
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        } else {
            GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(numUniv);
            Universite univ = gestCand.universite();
            GestionnaireVoeux gestVoeux = gestAcces.obtenirGestionnaireVoeux(univ.academie.numAcademie);
            gestVoeux.supprimerVoeux(numVoeu, numUniv);
        }
    }

    public Universite[] consulterAcreditations(int numMaster) {

        listeAccredUniv = new ArrayList<Universite>();
        Universite[] univExterne;
        //Liste de toutes les académies
        GestionnaireVoeux[] listeGestVoeux = gestAcces.listeGestionnairesVoeux();

        for (int i = 0; i < listeGestVoeux.length; i++) {
            univExterne = listeGestVoeux[i].consulterAcreditationsExternes(numMaster);
            for (int j=0;j<univExterne.length;j++) {
                listeAccredUniv.add(univExterne[j]);
            }
        }
        
        tableauAccredUniv = listeAccredUniv.toArray(new Universite[listeAccredUniv.size()]);
        return tableauAccredUniv;
    }

    public Universite[] consulterAcreditationsExternes(int numMaster) {
        listeAccredUnivExt = bdd.bdd_consultAccreditations(academie.numAcademie, numMaster);
        tableauAccredUnivExt = listeAccredUnivExt.toArray(new Universite[listeAccredUnivExt.size()]);
        return tableauAccredUnivExt;
    }
}
