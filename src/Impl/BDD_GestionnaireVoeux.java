/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.EnumOrdre;
import CyelPostLicence.EnumReponse;
import CyelPostLicence.EtatCandidature;
import CyelPostLicence.Etudiant;
import CyelPostLicence.Master;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Cy
 */
public class BDD_GestionnaireVoeux {

    Connection conn;

    public BDD_GestionnaireVoeux() {
        try {
            System.out.println("Connexion BDD");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cyelpost", "root", "");
            System.out.println("Connexion BDD effectuée");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bdd_insertVoeu(Etudiant etudiant, Voeu[] listeVoeux) {
        boolean res = false;
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            String query = "INSERT INTO gv_Voeux (Etat,Ordre,NumINE,Reponse,NumMaster,NomMaster,NumUniversite,NomUniversite,NumAcademie,NomAcademie, NumLicence)" + "VALUES ("
                    + listeVoeux[0].etatCandidature.value() + ","
                    + listeVoeux[0].ordre.value() + "," + etudiant.INE + ","
                    + listeVoeux[0].reponse.value() + ","
                    + listeVoeux[0].master.numMaster + ",'"
                    + listeVoeux[0].master.nomMaster + "',"
                    + listeVoeux[0].universite.numUniv + ",'"
                    + listeVoeux[0].universite.nomUniv + "',"
                    + listeVoeux[0].universite.academie.numAcademie + ",'"
                    + listeVoeux[0].universite.academie.nomAcademie + "',"
                    + etudiant.licence.numLicence + ")";
            System.out.println(query);
            int result = s.executeUpdate(query);

            if (result == 1) {
                res = true;
            }
        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
        return res;
    }

    public ArrayList<Voeu> bdd_listeVoeux(int INE, int numAcademie) {
        ArrayList<Voeu> listeVoeux = new ArrayList<Voeu>();

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT v.NumVoeux, v.NumAcademie, v.NomAcademie, v.NumUniversite, v.NomUniversite, v.Etat, v.Ordre, v.Reponse, v.NumMaster, v.NomMaster, v.NumLicence"
                    + "      FROM gv_Voeux v"
                    + "      WHERE (v.NumINE = " + INE + ")"
                    + "      AND v.numAcademie = " + numAcademie;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                int numero = rs.getInt("v.NumVoeux");
                Academie academie = new Academie(rs.getInt("v.NumAcademie"), rs.getString("v.NomAcademie"));
                Universite univ = new Universite(rs.getInt("v.NumUniversite"), rs.getString("v.NomUniversite"), academie);
                Master master = new Master(rs.getInt("v.NumMaster"), rs.getString("v.NomMaster"));
                EnumOrdre enumOrdre = new EnumOrdre(rs.getInt("v.Ordre"));
                EtatCandidature etatCandid = new EtatCandidature(rs.getInt("v.Etat"));
                EnumReponse enumReponse = new EnumReponse(rs.getInt("v.Reponse"));
                int numLicence = rs.getInt("v.NumLicence");

                listeVoeux.add(new Voeu(numero, univ, master, enumOrdre, etatCandid, enumReponse, numLicence));
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        return listeVoeux;
    }
    
    
     public ArrayList<Voeu> bdd_listeVoeuxParAcademie(int numAcademie) {
        ArrayList<Voeu> listeVoeux = new ArrayList<Voeu>();

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT v.NumVoeux, v.NumAcademie, v.NomAcademie, v.NumUniversite, v.NomUniversite, v.Etat, v.Ordre, v.Reponse, v.NumMaster, v.NomMaster, v.NumLicence"
                    + "      FROM gv_Voeux v"
                    + "      WHERE v.numAcademie = " + numAcademie;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                int numero = rs.getInt("v.NumVoeux");
                Academie academie = new Academie(rs.getInt("v.NumAcademie"), rs.getString("v.NomAcademie"));
                Universite univ = new Universite(rs.getInt("v.NumUniversite"), rs.getString("v.NomUniversite"), academie);
                Master master = new Master(rs.getInt("v.NumMaster"), rs.getString("v.NomMaster"));
                EnumOrdre enumOrdre = new EnumOrdre(rs.getInt("v.Ordre"));
                EtatCandidature etatCandid = new EtatCandidature(rs.getInt("v.Etat"));
                EnumReponse enumReponse = new EnumReponse(rs.getInt("v.Reponse"));
                int numLicence = rs.getInt("v.NumLicence");

                listeVoeux.add(new Voeu(numero, univ, master, enumOrdre, etatCandid, enumReponse, numLicence));
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        return listeVoeux;
    }

    public ArrayList<Universite> bdd_consultUniversitePourUneAcademie(int numAcademie) {
        ArrayList<Universite> listeUniversites = new ArrayList<Universite>();
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT u.NumUniversite, u.NomUniversite, a.NumAcademie, a.NomAcademie"
                    + "      FROM gv_universites u, gv_academies a"
                    + "      WHERE a.NumAcademie =" + numAcademie
                    + "     AND a.NumAcademie = u.NumAcademie";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                Academie academie = new Academie(rs.getInt("a.NumAcademie"), rs.getString("a.NomAcademie"));
                Universite univ = new Universite(rs.getInt("u.NumUniversite"), rs.getString("u.NomUniversite"), academie);
                listeUniversites.add(univ);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        //Universite[] tabUniversites = listeUniversites.toArray(new Universite[listeUniversites.size()]);
        return listeUniversites;
    }

    public Master[] bdd_consultMastersPourUneUniversite(int numUniversite) {
        ArrayList<Master> listeMasters = new ArrayList<Master>();
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT m.NumMaster, m.NomMaster"
                    + "      FROM gv_masters m, gv_accreditations a"
                    + "      WHERE a.NumUniversite =" + numUniversite
                    + "     AND a.NumMaster = m.NumMaster";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {

                Master master = new Master(rs.getInt("m.NumMaster"), rs.getString("m.NomMaster"));
                listeMasters.add(master);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        Master[] tabMasters = listeMasters.toArray(new Master[listeMasters.size()]);
        return tabMasters;
    }

    public boolean bdd_modifieClassement(int numVoeux, int ordre) {

        boolean res = false;

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            int result = s.executeUpdate("UPDATE gv_voeux"
                    + "                   SET ordre = " + ordre
                    + "                   WHERE NumVoeux = " + numVoeux);

            System.out.println("[bdd_modifieClassement] result : " + result);
            if (result == 1) {
                res = true;
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }

        return res;
    }
    
     public boolean bdd_modifieEtat(int numVoeux, int etat) {

        boolean res = false;

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            int result = s.executeUpdate("UPDATE gv_voeux"
                    + "                   SET Etat = " + etat
                    + "                   WHERE NumVoeux = " + numVoeux);

            System.out.println("[bdd_modifieClassement] result : " + result);
            if (result == 1) {
                res = true;
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }

        return res;
    }

    public Universite bdd_consultAccreditations(int numAcademie, int numMaster) {
        Universite univ = null;
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT u.NomUniversite, u.NumUniversite, ac.NumAcademie, ac.NomAcademie"
                    + "      FROM gv_academies ac,gv_universites u, gv_masters m, gv_accreditations a"
                    + "      WHERE u.NumAcademie =" + numAcademie
                    + "      AND a.NumMaster =" + numMaster
                    + "     AND a.NumUniversite = u.NumUniversite"
                    + "     AND a.NumMaster = m.NumMaster"
                    + "     AND ac.NumAcademie = u.NumAcademie";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {

                Academie academie = new Academie(rs.getInt("ac.NumAcademie"), rs.getString("ac.NomAcademie"));
                univ = new Universite(rs.getInt("u.NumUniversite"), rs.getString("u.NomUniversite"), academie);

            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        return univ;
    }
    
     public ArrayList<Integer> bdd_listeVoeuxParUniversiteParMaster(int numMaster,int numUniv) {
        ArrayList<Integer> listeINE = new ArrayList<Integer>();

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT v.NumINE"
                    + "      FROM gv_Voeux v"
                    + "      WHERE v.numMaster = " + numMaster
                    + "      AND v.NumUniversite = " + numUniv;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                int ine = rs.getInt("v.NumINE");

                listeINE.add(ine);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        return listeINE;
    }

}
