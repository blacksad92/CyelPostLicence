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
import CyelPostLicence.Master;
import CyelPostLicence.Note;
import CyelPostLicence.Universite;
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
    ArrayList<Note> arrayNotes = new ArrayList<Note>();
    Note[] notes;
    
    public GestionnaireCandidaturesImpl() {

        bdd = new BDD_GestionnaireCandidature();
        listeMaster = new ArrayList<Master>();
        
        Academie academie = new Academie(1, "Toulouse");
        //universite = new Universite(1, "Universite Paul Sabatier", academie);
        //universite = new Universite(2, "Universite Jean Jaures", academie);
        universite = new Universite(5, "Universite Capitole", academie);
        
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

        //listeUniv = new ArrayList<Universite>();
        System.out.println(universite.nomUniv);
    }
    //TODO Implémenter cette méthode
    @Override
    public EtatCandidature validerCandidature(int numMaster, int numLicence) {
        System.out.println("validerCandidature"+universite.nomUniv);
        EtatCandidature etat;
        boolean prerequis = bdd.bdd_verifieLicencePrerequis(universite.numUniv, numMaster, numLicence);
        if(prerequis == false)
        {
            etat = new EtatCandidature(1);
        }
        else
        {
             etat = new EtatCandidature(0);
        }
        return etat;
    }

    //TODO Implémenter cette méthode
    @Override
    public Note[] recupererListeNotes(int INE, boolean externe) {
        System.out.println("[GestionnaireCandidaturesImpl]");
        int numUniv = universite.numUniv;
        
        arrayNotes = new ArrayList();
        arrayNotes.add(new Note());
        
        notes = arrayNotes.toArray(new Note[arrayNotes.size()]);
        
        //Note[] notes = null;
        
        System.out.println("A FAIRE : TRAITEMENT EN FONCTION DE externe");
        
        /**/
        // A FAIRE :
        // TRAITEMENT EN FONCTION DE externe
        /**/
        
        return notes;
    }
    
    //TODO Implémenter cette méthode
    @Override
    public Universite universite() {
        return universite;
    }
    
    //TODO Implémenter cette méthode
    @Override
    public void universite(Universite value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //TODO Implémenter cette méthode
    @Override
    public Master[] listeMaster() {
        listeMaster=bdd.bdd_listeMasters(universite.numUniv);
        tabeauMaster = listeMaster.toArray(new Master[listeMaster.size()]);
        return tabeauMaster;
    }

    @Override
    public Etudiant[] consulterCandidatures(int numMaster, int numUniversite) {
        System.out.println("CandImpl consulterCandid");    
        Etudiant[] etudiants = bdd.bdd_listeCandidature(numUniversite, numMaster);
        return etudiants;
    }

    @Override
    public void enregistrerCandidatures(Etudiant[] listeCandidatures, int numMaster) {
        System.out.println("CandImpl EnregistrerCandid");
        int numUniv = this.universite.numUniv;
        for(int i = 0; i < listeCandidatures.length; i++)
        {
            bdd.bdd_insertCandidature(listeCandidatures[i], numMaster,numUniv);
        }
    }

    @Override
    public void RAZPeriode() {
        try {
            bdd.RAZ(universite.numUniv);
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCandidaturesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
