/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Candidature;
import CyelPostLicence.Decision;
import CyelPostLicence.EnumDecision;
import CyelPostLicence.EtatCandidature;
import CyelPostLicence.Etudiant;
import CyelPostLicence.GestionnaireAcces;
import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.Master;
import CyelPostLicence.Note;
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
public class GestionnaireCandidaturesImpl extends CyelPostLicence.GestionnaireCandidaturesPOA {

    public GestionnaireAcces gestAcces;
    public Universite universite;
    public BDD_GestionnaireCandidature bdd;
    public ArrayList<Master> listeMaster;
    public Master[] tabeauMaster;
    ArrayList<Note> listeNotes = new ArrayList<Note>();
    Note[] tableauNotes;
    
    public GestionnaireCandidaturesImpl() {

        bdd = new BDD_GestionnaireCandidature();
        listeMaster = new ArrayList<Master>();
        
        ////// NOUVEAUX : Pour scénario
        Academie academie;
        
        academie = new Academie(1, "Toulouse");
        universite = new Universite(1, "Universite Paul Sabatier", academie);
        //universite = new Universite(2, "Universite Capitole", academie);
        //universite = new Universite(3, "Universite Jean Jaures", academie);
        
        //academie = new Academie(2, "Nice");      
        //universite = new Universite(4, "Polytech Nice", academie);
        //universite = new Universite(5, "Universite Nice Sophia Antipolis", academie);  
        
        ///////////////////////////////////////////////////////////////////////////
        ////// ANCIENS
        //Academie academie = new Academie(1, "Toulouse");
        //universite = new Universite(1, "Universite Paul Sabatier", academie);
        //universite = new Universite(2, "Universite Jean Jaures", academie);
        //universite = new Universite(5, "Universite Capitole", academie);
        
        //Academie academie = new Academie(5, "Bordeaux");
        //universite = new Universite(3, "Universite Montaigne", academie);
        //universite = new Universite(4, "Universite Bordeaux 1", academie);
        
        //Academie academie = new Academie(2, "Montpellier");
        //universite = new Universite(6, "Universite Paul Valery", academie);
        //universite = new Universite(7, "Universite Montpellier 3", academie);
        
        //Academie academie = new Academie(4, "Aix-Marseille");
        //niversite = new Universite(8, "Universite de provence", academie);
        //universite = new Universite(9, "Universite Aix Marseille", academie);
        
        //Academie academie = new Academie(3, "Nice");
        //universite = new Universite(10, "Universite Nice Sophia Antipolis", academie);        
        //universite = new Universite(12, "Polytech Nice", academie);
        
        //Academie academie = new Academie(6, "Corse");
        //universite = new Universite(11, "Universite Pasquale Paoli", academie);
        ///////////////////////////////////////////////////////////////////////////

        //listeUniv = new ArrayList<Universite>();
        System.out.println(universite.nomUniv);
    }

    //Verifie si le master demandé est valide avec la licence de l'etudiant. 
    // Retourne un etat valide ou non valide
    @Override
    public EnumDecision validerCandidature(int numMaster, int numLicence) {
        EnumDecision etat;
        boolean prerequis = bdd.bdd_verifieLicencePrerequis(universite.numUniv, numMaster, numLicence);
        if(prerequis == false)
        {
            etat = new EnumDecision(1);
        }
        else
        {
             etat = new EnumDecision(0);
        }
        return etat;
    }

    //Recupere les notes d'un etudiant grace a son numéro INE
    @Override
    public Note[] recupererListeNotes(int INE, boolean externe) {        
        if (!externe) {
            listeNotes = new ArrayList<Note>();
            Note[] notesExternes;
            //Liste de toustes les universités
            GestionnaireCandidatures[] listeGestCandidatures = gestAcces.ListeGestionnairesCandidatures();
            for (int i = 0; i < listeGestCandidatures.length; i++) {
                notesExternes = listeGestCandidatures[i].recupererListeNotes(INE, true);
                
                for (int k = 0; k < notesExternes.length; k++) {
                    if (listeNotes.contains(notesExternes[k]) == false) {
                        listeNotes.add(notesExternes[k]);
                    }
                }
            }
        }

        if (externe) {
            Note[] notes = bdd.bdd_listeNotes(INE);
            
            for (int i = 0; i < notes.length; i++) {
                if (listeNotes.contains(notes[i]) == false) {
                    listeNotes.add(notes[i]);
                }
            }
            
        }

        tableauNotes = listeNotes.toArray(new Note[listeNotes.size()]);
        
        return tableauNotes;
    }
    
    @Override
    public Universite universite() {
        return universite;
    }
    
    //TODO Implémenter cette méthode
    @Override
    public void universite(Universite value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Master[] listeMaster() {
        listeMaster=bdd.bdd_listeMasters(universite.numUniv);
        tabeauMaster = listeMaster.toArray(new Master[listeMaster.size()]);
        return tabeauMaster;
    }

    //Recupere en BDD toutes les candidatures d'une universite pour un master
    @Override
    public Candidature[] consulterCandidatures(int numMaster, int numUniversite) {
        Candidature[] listeCandidatures = bdd.bdd_listeCandidature(numUniversite, numMaster);
        return listeCandidatures;
    }

    // Enregistre en BDD un etudiant pour un master (une candidature)
    @Override
    public void enregistrerCandidatures(Etudiant etudiant, int numMaster) {
        int numUniv = this.universite.numUniv;
        bdd.bdd_insertCandidature(etudiant, numMaster,numUniv);
    }

    //Vide la base de données de ses données afin de simuler un retour en période 1 (au debut)
    @Override
    public void RAZPeriode() {
        try {
            bdd.bdd_RAZ(universite.numUniv);
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCandidaturesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void enregistrerClassement(int INE, int NumMaster, int classement) {
        bdd.bdd_enregistrerClassement(INE,NumMaster,universite.numUniv, classement);
    }

    @Override
    public void finPeriodeDecision() {
        // Début de la période 3
        // On va récupérer toutes les candidatures de l'université puis les renvoyer vers leur gestionnaire de voeux respectives
        Candidature[] listeCandidatures = bdd.bdd_listeCandidature(universite.numUniv);
        
        for (int i=0; i<listeCandidatures.length; i++) {
            Candidature candidature = listeCandidatures[i];
            // On récupère le gestionnaire de voeux associé à l'académie de l'étudiant concerné par la candidature
            GestionnaireVoeux gestVoeux = gestAcces.obtenirGestionnaireVoeux(candidature.etudiant.universite.academie.numAcademie);
            
            // Ecriture de la décision finale
            int classement = candidature.classement;
            int quota = bdd.bdd_quotaFormation(candidature.numUniversite, candidature.numMaster);
            
            EnumDecision libDecision;
            if (classement<=0) { // REFUSE
                libDecision = new EnumDecision(2);
            }
            else {
                if (classement<=quota) { // ACCEPTE
                    libDecision = new EnumDecision(3);
                }
                else { // LISTE D'ATTENTE
                    libDecision = new EnumDecision(4);
                }
            }
            
            Decision decision = new Decision(candidature.etudiant,candidature.numUniversite,candidature.numMaster,libDecision);
            
            System.out.println("[GestionnaireCandidaturesImpl] finPeriodeDecision - Etudiant : "+candidature.etudiant.INE+" | Universite : "+candidature.numUniversite+" | Master : "+candidature.numMaster+" | Décision : "+libDecision+" ("+classement+"/"+quota+")");

            // On enregistre la décision
            gestVoeux.enregistrerDecision(decision);
        }
    }
    
    /*cette méthode va faire la mise à jour des candidatures si la réponse d'un étudiant
        à un voeu est un "non" ou un "non mais"
    */
    @Override
    public void majListe(int INE, Voeu voeu){
        if ((voeu.reponse.value() == 2) || (voeu.reponse.value() == 3)){
            bdd.bdd_modifierClassement(INE, voeu);
        }
    
    }
}
