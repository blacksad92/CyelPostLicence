/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Decision;
import CyelPostLicence.EnumDecision;
import CyelPostLicence.Etudiant;
import CyelPostLicence.GestionnaireAcces;
import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;

/**
 *
 * @author Linkro
 */
public class GestionnaireVoeuxImpl extends CyelPostLicence.GestionnaireVoeuxPOA {

    public ArrayList<Universite> listeUniv;
    public Universite[] tableauUniv;
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
        academie = new Academie(1, "Toulouse");
        //academie = new Academie(2, "Montpellier");
        //academie = new Academie(3, "Nice");
        //academie = new Academie(4, "Aix-Marseille");
        //academie = new Academie(5, "Bordeaux");
        //academie = new Academie(6, "Corse");

        listeUniv = new ArrayList<Universite>();
        listeUniv2 = new ArrayList<Universite>();
        listeVoeu = new ArrayList<Voeu>();
        listeTempo = new ArrayList<Voeu>();
        listeVoeuxParAcademie = new ArrayList<Voeu>();
        System.out.println(academie.nomAcademie);
    }

    @Override
    public void cloturerPeriode() {
        System.out.println("Periode ancienne " + periode);
        
        if (periode < 4) {
            periode++;
            
            if(periode == 2) {// SI la periode passe a 2, on envoie automatiquement les candidatures
                //Recuperer les voeux pour l'academie.
                ArrayList<Voeu> listeVoeux = bdd.bdd_listeVoeuxParAcademie(this.academie.numAcademie);
                for(int i=0; i< listeVoeux.size(); i++)
                {
                    int numMaster = listeVoeux.get(i).master.numMaster;
                    int numUniversite = listeVoeux.get(i).universite.numUniv;
                    int numVoeux = listeVoeux.get(i).numVoeu;
                    int INE = bdd.bdd_INEduVoeu(numVoeux);
                    Etudiant etu = gestAcces.obtenirEtudiant(INE);
                    // Recuperer le bon gestionnaire de candidature
                    GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(numUniversite); 
                   
                    // Appeller la méthode enregistrer voeux
                    if(gestCand != null)
                    {
                        gestCand.enregistrerCandidatures(etu, numMaster);
                    }
                }
            }
            
            if(periode == 3) { // SI lon passe à la période 3 -> Envoi des décisions des universités vers les académies (on va donc notifier les universités)
                System.out.println("[GestionnaireVoeuxImpl] cloturerPeriode - PASSAGE PERIODE 3");
                // Récupérer la liste des universités de l'académie
                ArrayList<Universite> listeUniv = bdd.bdd_consultUniversitePourUneAcademie(academie.numAcademie);
                // Pour chaque université
                Iterator it = listeUniv.iterator();
                while(it.hasNext()) {
                    Universite univ = (Universite) it.next();
                    // Recuperer le bon gestionnaire de candidature
                    GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(univ.numUniv);
                    
                    // Appeller la méthode finPeriodeDecision
                    if(gestCand != null)
                    {
                        gestCand.finPeriodeDecision();
                    }
                }
            }
        }
        System.out.println("NOUVELLE PERIODE : " + periode);
    }

    @Override
    public void RAZPeriode() {
        System.out.println("Periode actuelle " + periode);
        System.out.println("Remise à zéro de la période");
        periode = 1;
        ArrayList<Universite> liste = bdd.bdd_consultUniversitePourUneAcademie(academie.numAcademie);
        System.out.println(liste.get(0).numUniv);
        System.out.println(liste.get(1).numUniv);
        System.out.println(liste.get(2).numUniv);
        System.out.println(liste.size());
        for (int i = 0; i < liste.size(); i++) {
            GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(liste.get(i).numUniv);
            if (gestCand != null){
            gestCand.RAZPeriode();}
        }
        
         try {
         bdd.bdd_RAZ(academie.numAcademie);
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
    public Universite[] consulterAcreditations(int numMaster, boolean externe) {

        if (!externe) {
            listeUniv = new ArrayList<Universite>();
            Universite[] univExterne;
            //Liste de toutes les académies
            GestionnaireVoeux[] listeGestVoeux = gestAcces.listeGestionnairesVoeux();

            for (int i = 0; i < listeGestVoeux.length; i++) {
                univExterne = listeGestVoeux[i].consulterAcreditations(numMaster, true);
                if (univExterne.length > 0) {
                    if (listeUniv.contains(univExterne[0]) == false) {
                        listeUniv.add(univExterne[0]); /**/ /*ELEA : Pourquoi juste univEcterne[0] et pas tous ?*/
                        /* ROMAIN : Parceque bdd_consultAccreditations ne retourne qu'une université 
                         par conséquent la recursive consulterAcreditations retourne un tableau avec un seul élément*/


                    }
                }
            }
        }

        if (externe) {
            Universite u = bdd.bdd_consultAccreditations(academie.numAcademie, numMaster);
            if (u != null) {
                if (listeUniv.contains(u) == false) {
                    listeUniv.add(u);
                }
            }
        }

        tableauUniv = listeUniv.toArray(new Universite[listeUniv.size()]);
        return tableauUniv;
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
        boolean ok = bdd.bdd_repondreVoeu(INE,voeu);
        if (!ok) {
            System.out.println("ERREUR REPONDRE VOEU");
        }
    }
}
