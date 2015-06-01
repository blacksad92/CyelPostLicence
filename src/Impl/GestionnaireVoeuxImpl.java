/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.EtatCandidature;
import CyelPostLicence.Etudiant;
import CyelPostLicence.GestionnaireAcces;
import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.Reponse;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            periode = periode + 1;
            if (periode == 2) {
                listeVoeuxParAcademie = bdd.bdd_listeVoeuxParAcademie(academie.numAcademie);
                for (int i = 0; i < listeVoeuxParAcademie.size(); i++) {
                    int numUniversite = listeVoeuxParAcademie.get(i).universite.numUniv;
                    System.out.println("cloturerPeriode academie " + academie.nomAcademie);
                    System.out.println("cloturerPeriode universite " + listeVoeuxParAcademie.get(i).universite.nomUniv);
                    int numVoeux = listeVoeuxParAcademie.get(i).numVoeu;
                    GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(numUniversite);
                    if (gestCand != null) {
                        EtatCandidature etat = gestCand.validerCandidature(listeVoeuxParAcademie.get(i).master.numMaster, listeVoeuxParAcademie.get(i).numLicence);
                        System.out.println("cloturerPeriode etat " + etat.toString());
                        boolean modifier = bdd.bdd_modifieEtat(numVoeux, etat.value());
                        System.out.println("cloturerPeriode modifier " + modifier);
                    }
            }
        }

        }

        
        System.out.println("Periode nouvelle " + periode);
    }

    @Override
    public void RAZPeriode() {
        System.out.println("Periode actuelle " + periode);
        System.out.println("Remise à zéro de la période");
        // Remise à 1 de la période, pourquoi periode est en static ? 
        //periode = 1;
        maListeUnivs();
        for(int i=0; i<mesIDUnivs.size();i++){
            //GestionnaireCandidatures gestCand = gestAcces.obtenirGestionnaireCandidatures(tableauUniv[i].numUniv);
            //gestCand.RAZPeriode();
            System.out.println(mesIDUnivs.get(i));
            System.out.println(mesIDUnivs.size());
        }/*
        try {
            bdd.RAZ(academie.numAcademie);
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireVoeuxImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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

//TODO Implémenter cette méthode
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
        /*
        //Permet de récupérer l'état valide ou non-valide d'un voeu, supprimer l'appel de la méthode dans cloturerPeriode
        GestionnaireCandidatures gestCandidature = gestAcces.obtenirGestionnaireCandidatures(listeVoeux[0].universite.numUniv);
        EtatCandidature etatVoeu = gestCandidature.validerCandidature(listeVoeux[0].master.numMaster, etudiant.licence.numLicence);
        //On affecte le nouvel état
        listeVoeux[0].etatCandidature = etatVoeu;
        */
        //Si le voeux est dans cette meme academie
        if (this.academie.numAcademie == listeVoeux[0].universite.academie.numAcademie) {
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
        ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
        System.out.println("RecupererCandidature VoeuxImpl"+ academie.nomAcademie);
        ArrayList<Integer> listeINE = bdd.bdd_listeVoeuxParUniversiteParMaster(numMaster, numUniversite);
        System.out.println("RecupererCandidature TailleListe"+ listeINE.size());
        for(int i=0; i < listeINE.size(); i++)
        {
            int INE = listeINE.get(i);
            System.out.println("RecupererCandidature VoeuxImpl INE"+ INE);
            Etudiant etu = gestAcces.obtenirEtudiant(INE);
            listeEtudiants.add(etu);
        }
         Etudiant[] tabEtudiants = listeEtudiants.toArray(new Etudiant[listeEtudiants.size()]);
         System.out.println("SORS VoeuxImps RecupererCandidature");
        return tabEtudiants;
    }

    @Override
    public void enregistrerDecisions(int numMaster, int numAcademie, Reponse[] listeAccepte, Reponse[] listeAttente, Reponse[] listeRefuse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void maListeUnivs(){
        this.mesIDUnivs = bdd.bdd_recupNumUnivs(academie.numAcademie);
    }
}
