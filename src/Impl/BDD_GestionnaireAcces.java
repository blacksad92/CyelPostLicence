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
import CyelPostLicence.Licence;
import CyelPostLicence.Universite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Cy
 */
public class BDD_GestionnaireAcces {

    Connection conn;

    public BDD_GestionnaireAcces() {
        try {
            System.out.println("Connexion BDD");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cyelpost", "root", "");
            System.out.println("Connexion BDD effectuée");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public Etudiant bdd_identification(int login, Academie academie) throws EtudiantInconnu, AcademieIncorrecte {
        Etudiant etudiant = null;
        Licence licence = null;
        Universite univ = null;

        try {
            /*Protège des injections SQL
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ga_etudiants e WHERE INE=?");
            stmt.setInt(1, login);
            ResultSet rs = stmt.executeQuery();
            */
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ga_etudiants e WHERE INE = " + login);

            while (rs.next()) {
                licence = new Licence(rs.getInt("e.numLicence"), rs.getString("e.Licence"));
                univ = new Universite(rs.getInt("e.numUniversite"), rs.getString("e.UniversiteAppartenance"), academie);
                etudiant = new Etudiant(rs.getInt("e.INE"), rs.getString("e.Nom"), rs.getString("e.Prenom"), licence, univ);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return etudiant;
        }

        if (etudiant == null) {
            EtudiantInconnu EI = new EtudiantInconnu(1, "L'INE " + " n'existe pas");
            throw EI;
        }

        try {
            etudiant = null;
            /*Protège des injections SQL
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ga_etudiants e WHERE INE=? AND e.numAcademie=?");
            stmt.setInt(1, login);
            stmt.setInt(2, academie.numAcademie);
            ResultSet rs = stmt.executeQuery();
            */
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ga_etudiants e WHERE INE = " + login + " AND e.numAcademie = " + academie.numAcademie);

            while (rs.next()) {
                licence = new Licence(rs.getInt("e.numLicence"), rs.getString("e.Licence"));
                univ = new Universite(rs.getInt("e.numUniversite"), rs.getString("e.UniversiteAppartenance"), academie);
                etudiant = new Etudiant(rs.getInt("e.INE"), rs.getString("e.Nom"), rs.getString("e.Prenom"), licence, univ);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return etudiant;
        }

        if (etudiant == null) {
            AcademieIncorrecte AI = new AcademieIncorrecte(1, "L'académie choisie ne correspond pas à votre académie d'appartennance");
            throw AI;
        }

        return etudiant;
    }

    public boolean bdd_identificationUniv(String login, String mdp) {
        try {
            /*Protège des injections SQL
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ga_responsables WHERE Login=? AND Mdp=?");
            stmt.setString(1, login);
            stmt.setString(2, mdp);
            ResultSet rs = stmt.executeQuery();
            */
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ga_responsables WHERE Login = '" + login + "' AND Mdp = '" + mdp + "'");

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
    }

    public Etudiant bdd_consultEtudiant(int INE) {
        Etudiant etudiant = null;
        Licence licence = null;
        Universite univ = null;
        Academie academie = null;
        try {
            /*Protège des injections SQL
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ga_etudiants e WHERE INE=?");
            stmt.setInt(1, INE);
            ResultSet rs = stmt.executeQuery();
            */
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ga_etudiants e WHERE INE = " + INE);

            while (rs.next()) {
                academie = new Academie(rs.getInt("e.NumAcademie"), rs.getString("e.NomAcademie"));
                licence = new Licence(rs.getInt("e.numLicence"), rs.getString("e.Licence"));
                univ = new Universite(rs.getInt("e.numUniversite"), rs.getString("e.UniversiteAppartenance"), academie);
                etudiant = new Etudiant(rs.getInt("e.INE"), rs.getString("e.Nom"), rs.getString("e.Prenom"), licence, univ);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return etudiant;
        }

        return etudiant;
    }
}
