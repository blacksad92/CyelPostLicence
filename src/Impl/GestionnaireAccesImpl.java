/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.AcademieIncorrecte;
import CyelPostLicence.Etudiant;
import CyelPostLicence.EtudiantInconnu;
import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.ResponsableInconnu;
import CyelPostLicence.Universite;
import CyelPostLicence.UniversiteInconnu;
import java.util.ArrayList;

/**
 *
 * @author Linkro
 */
public class GestionnaireAccesImpl extends CyelPostLicence.GestionnaireAccesPOA {

    private ArrayList<GestionnaireVoeux> listeGestionnairesVoeux;
    private GestionnaireVoeux[] tableauGestionnairesVoeux;
    
    private ArrayList<GestionnaireCandidatures> listeGestionnairesCandidatures;
    private GestionnaireCandidatures[] tableauGestionnairesCandidatures;
    
    public BDD_GestionnaireAcces bdd = new BDD_GestionnaireAcces();

    public GestionnaireAccesImpl(ArrayList<GestionnaireVoeux> listeGestionnairesVoeux, ArrayList<GestionnaireCandidatures> listeGestionnairesCandidatures) {
        this.listeGestionnairesVoeux = listeGestionnairesVoeux;
        this.listeGestionnairesCandidatures = listeGestionnairesCandidatures;
    }

    public GestionnaireAccesImpl() {
        this.listeGestionnairesVoeux = new ArrayList<GestionnaireVoeux>();
        this.listeGestionnairesCandidatures = new ArrayList<GestionnaireCandidatures>();
    }
    
    @Override
    public GestionnaireVoeux[] listeGestionnairesVoeux() {
        tableauGestionnairesVoeux = listeGestionnairesVoeux.toArray(new GestionnaireVoeux[listeGestionnairesVoeux.size()]);
        return tableauGestionnairesVoeux;
    }

    @Override
    public void inscriptionGestionnaireVoeux(GestionnaireVoeux gestVoeux) {
        listeGestionnairesVoeux.add(gestVoeux);
    }

    @Override
    public GestionnaireVoeux obtenirGestionnaireVoeux(int numAcademie) {
        GestionnaireVoeux gestVoeux = null;
        int indice;
        boolean trouve = false;
        indice = 0;
        while (indice < listeGestionnairesVoeux.size() && !false){
            if (numAcademie == listeGestionnairesVoeux.get(indice).academie().numAcademie)
            {
                  gestVoeux = listeGestionnairesVoeux.get(indice);
                  trouve = true;
                 
            }
            indice++;
        }
        return (gestVoeux);
    
    }

    @Override
    public GestionnaireVoeux identificationUniv(String login, String password, int numAcademie) throws ResponsableInconnu {
        if (bdd.bdd_identificationUniv(login, password)){
            GestionnaireVoeux gestVoeux = null;
            int indice;
            boolean trouve = false;
            indice = 0;
            while (indice < listeGestionnairesVoeux.size() && !false){
                if (numAcademie == listeGestionnairesVoeux.get(indice).academie().numAcademie)
                {
                    gestVoeux = listeGestionnairesVoeux.get(indice);
                    trouve = true;
                 }
                indice++;
            }
            return (gestVoeux);
        }
        else{
            System.out.println("Erreur");
            ResponsableInconnu RI = new ResponsableInconnu(1, "Le login " + login + " n'existe pas batard !");
            throw RI;
        }
    }

    @Override
    public Etudiant identification(int INE, Academie academie) throws EtudiantInconnu, AcademieIncorrecte {

        //Modifier cette methode pour retourner un etudiant
        Etudiant etu = bdd.bdd_identification(INE, academie);

        
        return etu;
    
    }

    @Override
    public GestionnaireCandidatures obtenirGestionnaireCandidatures(int numUniversite) {
      GestionnaireCandidatures gestCandidature = null;
        int indice;
        boolean trouve = false;
        indice = 0;
         System.out.println("Acces Impl, avant WHILE "+trouve);
         System.out.println("Acces Impl, num Universite"+numUniversite);
         System.out.println("Acces Impl, size liste"+listeGestionnairesCandidatures.size());
         System.out.println("Acces Impl, indice"+indice);
        while(indice < listeGestionnairesCandidatures.size() && trouve == false)
        {
            System.out.println("Acces Impl, liste gestionnaires candidatures"+listeGestionnairesCandidatures.get(indice).universite().numUniv);
            if (numUniversite == listeGestionnairesCandidatures.get(indice).universite().numUniv)
            {
                  gestCandidature = listeGestionnairesCandidatures.get(indice);
                  trouve = true;
                  System.out.println("Acces Impl, trouve"+trouve);
                 
            }
            indice++;
        }
        System.out.println("Acces Impl, avant RETURN trouve"+trouve);
        return (gestCandidature);
    
    }

    @Override
    public void inscriptionGestionnaireCandidatures(GestionnaireCandidatures gestCandidatures) {
        System.out.println("Taille avant enregistrement"+listeGestionnairesCandidatures.size());
        listeGestionnairesCandidatures.add(gestCandidatures);
         System.out.println("Taille apres enregistrement"+listeGestionnairesCandidatures.size());
    }

    @Override
    public Etudiant obtenirEtudiant(int INE) {
        return bdd.bdd_consultEtudiant(INE);
    }

}
