/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Candidature;
import CyelPostLicence.Etudiant;
import CyelPostLicence.Licence;
import CyelPostLicence.Master;
import CyelPostLicence.Note;
import CyelPostLicence.Universite;
import CyelPostLicence.Voeu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Cy
 */
public class BDD_GestionnaireCandidature {

    Connection conn;

    public BDD_GestionnaireCandidature() {
        try {
            System.out.println("Connexion BDD");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cyelpost", "root", "");
            System.out.println("Connexion BDD effectuée");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retourne la liste des note pour un étudiant
    public Note[] bdd_listeNotes(int INE, int numUniv) {
        ArrayList<Note> listeNotes = new ArrayList<Note>();

        try {
            /*Protège des injections SQL
             PreparedStatement stmt = conn.prepareStatement("SELECT r.Semestre, r.NumSemestre, r.Moyenne, r.CodeObtention, r.Position, r.NumUniversite, r.NumLicence, r.NomLicence FROM gc_resultats r WHERE NumINE=?");
             stmt.setInt(1, INE);
             ResultSet rs = stmt.executeQuery();
             */
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT r.Semestre, r.NumSemestre, r.Moyenne, r.CodeObtention, r.Position, r.NumUniversite, r.NumLicence, r.NomLicence"
                    + "      FROM gc_resultats r"
                    + "      WHERE NumINE = " + INE
                    + "         AND NumUniversite = " + numUniv;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                int ine = INE;
                int semestre = rs.getInt("r.Semestre");
                int numSemestre = rs.getInt("r.NumSemestre");
                int moyenne = rs.getInt("r.Moyenne");
                String codeObtention = rs.getString("r.CodeObtention");
                String position = rs.getString("r.Position");
                int numUniversite = rs.getInt("r.NumUniversite");
                Licence licence = new Licence(rs.getInt("r.NumLicence"), rs.getString("r.NomLicence"));

                Note note = new Note(ine, semestre, numSemestre, moyenne, codeObtention, position, licence, numUniversite);
                listeNotes.add(note);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Note[] tabNotes = listeNotes.toArray(new Note[listeNotes.size()]);

        return tabNotes;
    }

    //Retourne la liste des master présent dans une université
    public ArrayList<Master> bdd_listeMasters(int NumUniversite) {
        ArrayList<Master> listeMasters = new ArrayList<Master>();

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT m.NumMaster, m.NomMaster"
                    + "      FROM gc_formations f, gc_masters m"
                    + "      WHERE f.NumUniversite = " + NumUniversite + ""
                    + "      AND f.NumMaster = m.NumMaster";
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
        //Master[] tabMasters = listeMasters.toArray(new Master[listeMasters.size()]);

        return listeMasters;
    }

    //Retourne la liste des licences nécessaire pour un master dans une université spécifique
    public Licence[] bdd_listePrerequis(int NumUniversite, int NumMaster) {
        ArrayList<Licence> listeLicences = new ArrayList<Licence>();

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT l.NumLicence, l.NomLicence"
                    + "      FROM gc_formations f, gc_masters m, gc_prerequis p, gc_licences l"
                    + "      WHERE f.NumUniversite = " + NumUniversite + ""
                    + "      AND f.NumMaster = m.NumMaster"
                    + "     AND m.NumMaster = " + NumMaster + ""
                    + "     AND m.NumMaster = p.NumMaster"
                    + "     AND p.NumLicence = l.NumLicence";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {

                Licence licence = new Licence(rs.getInt("l.NumLicence"), rs.getString("l.NomLicence"));
                listeLicences.add(licence);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Licence[] tabLicences = listeLicences.toArray(new Licence[listeLicences.size()]);

        return tabLicences;
    }

    //Retourne la liste des candidatures pour un master d'une université
    public Candidature[] bdd_listeCandidature(int NumUniversite, int NumMaster) {
        ArrayList<Candidature> listeCandidatures = new ArrayList<Candidature>();
        Licence licence;
        Universite univ;
        Academie academie;
        Etudiant etudiant;

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT c.Classement, c.NumINE,c.NomEtudiant, c.PrenomEtudiant, c.NumMaster, c.NumLicenceProv, c.NomLicenceProv, c.NumUniversiteProv, c.NomUniversiteProv, c.NumAcademieProv, c.NomAcademieProv, c.etat, c.NumUniversite, c.NumMaster"
                    + "      FROM gc_candidatures c, gc_masters m"
                    + "      WHERE c.NumUniversite = " + NumUniversite + ""
                    + "      AND c.NumMaster = m.NumMaster"
                    + "     AND m.NumMaster = " + NumMaster
                    + "     ORDER BY c.Classement";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                academie = new Academie(rs.getInt("c.NumAcademieProv"), rs.getString("c.NomAcademieProv"));
                licence = new Licence(rs.getInt("c.NumLicenceProv"), rs.getString("c.NomLicenceProv"));
                univ = new Universite(rs.getInt("c.NumUniversiteProv"), rs.getString("c.NomUniversiteProv"), academie);
                etudiant = new Etudiant(rs.getInt("c.NumINE"), rs.getString("c.NomEtudiant"), rs.getString("c.PrenomEtudiant"), licence, univ);
                Candidature candidature = new Candidature(etudiant, rs.getInt("c.NumUniversite"), rs.getInt("c.NumMaster"), rs.getInt("c.Classement"));
                listeCandidatures.add(candidature);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }

        // Tri du tableau résultat
        Comparator comparator = new Comparator<Candidature>() {
            @Override
            public int compare(Candidature cand1, Candidature cand2) {
                int res = 0;
                if (cand1.classement == -1) {
                    res = 1;
                } else if (cand2.classement == -1) {
                    res = -1;
                } else {
                    if (cand1.classement < cand2.classement) {
                        res = -1;
                    } else if (cand1.classement > cand2.classement) {
                        res = 1;
                    }
                }
                return res;
            }
        };
        listeCandidatures.sort(comparator);

        Candidature[] tabCandidatures = listeCandidatures.toArray(new Candidature[listeCandidatures.size()]);

        return tabCandidatures;
    }

    //Retourne la liste des candidatures pour une université
    public Candidature[] bdd_listeCandidature(int NumUniversite) {
        System.out.println("[BDD_GestionnaireCandidature] bdd_listeCandidature");

        ArrayList<Candidature> listeCandidatures = new ArrayList<Candidature>();
        Licence licence;
        Universite univ;
        Academie academie;
        Etudiant etudiant;

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT c.Classement, c.NumINE,c.NomEtudiant, c.PrenomEtudiant, c.NumMaster, c.NumLicenceProv, c.NomLicenceProv, c.NumUniversiteProv, c.NomUniversiteProv, c.NumAcademieProv, c.NomAcademieProv, c.etat, c.NumUniversite, c.NumMaster"
                    + "      FROM gc_candidatures c, gc_masters m"
                    + "      WHERE c.NumUniversite = " + NumUniversite + ""
                    + "      AND c.NumMaster = m.NumMaster"
                    + "     ORDER BY c.Classement";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                academie = new Academie(rs.getInt("c.NumAcademieProv"), rs.getString("c.NomAcademieProv"));
                licence = new Licence(rs.getInt("c.NumLicenceProv"), rs.getString("c.NomLicenceProv"));
                univ = new Universite(rs.getInt("c.NumUniversiteProv"), rs.getString("c.NomUniversiteProv"), academie);
                etudiant = new Etudiant(rs.getInt("c.NumINE"), rs.getString("c.NomEtudiant"), rs.getString("c.PrenomEtudiant"), licence, univ);
                Candidature candidature = new Candidature(etudiant, rs.getInt("c.NumUniversite"), rs.getInt("c.NumMaster"), rs.getInt("c.Classement"));
                listeCandidatures.add(candidature);
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Candidature[] tabCandidatures = listeCandidatures.toArray(new Candidature[listeCandidatures.size()]);

        return tabCandidatures;
    }

    //Retourne le quota de place pour un master dans une université
    public int bdd_quotaFormation(int numUniversite, int numMaster) {
        System.out.println("[BDD_GestionnaireCandidature] quotaFormation");

        int quota = -1;

        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT Quota"
                    + "      FROM gc_formations"
                    + "      WHERE NumUniversite = " + numUniversite + ""
                    + "      AND NumMaster = " + numMaster;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                quota = rs.getInt("Quota");
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return -1;
        }

        return quota;
    }

    public boolean bdd_verifieLicencePrerequis(int NumUniversite, int NumMaster, int NumLicence) {
        int nbr = 0;
        boolean ok = false;
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();

            String req = "SELECT count(*)"
                    + "      FROM gc_formations f, gc_masters m, gc_prerequis p"
                    + "      WHERE f.NumUniversite = " + NumUniversite + ""
                    + "      AND f.NumMaster = m.NumMaster"
                    + "     AND m.NumMaster = " + NumMaster + ""
                    + "     AND m.NumMaster = p.NumMaster"
                    + "     AND p.NumLicence = " + NumLicence;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);

            while (rs.next()) {
                nbr = rs.getInt("count(*)");
            }

        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
        if (nbr == 0) {
            ok = false;
        } else {
            ok = true;
        }
        // Renvoie TRUE alors la licence pour ce master dans cette universite est un prerequis
        // Renvoie FAlSE alors etat "Non valide"
        return ok;
    }

    //Enregistre une candidature
    public boolean bdd_insertCandidature(Etudiant etudiant, int numMaster, int numUniv) {
        boolean res = false;
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            String query = "INSERT INTO gc_candidatures (NumINE,NomEtudiant, PrenomEtudiant,NumMaster,NumLicenceProv,NomLicenceProv, NumUniversiteProv,NomUniversiteProv,NumAcademieProv, NomAcademieProv, etat, NumUniversite )" + "VALUES ("
                    + etudiant.INE + ",'"
                    + etudiant.nom + "','"
                    + etudiant.prenom + "',"
                    + numMaster + "," + etudiant.licence.numLicence + ",'"
                    + etudiant.licence.nomLicence + "',"
                    + etudiant.universite.numUniv + ",'"
                    + etudiant.universite.nomUniv + "',"
                    + etudiant.universite.academie.numAcademie + ",'"
                    + etudiant.universite.academie.nomAcademie + "',"
                    + "0,"
                    + numUniv + ")";
            //System.out.println(query);
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

    // Fais un delete en BD pour supprimer toutes les candidatures appartenant à une numéro d'universite passé en entrée 
    public void bdd_RAZ(int numUniv) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM gc_candidatures WHERE NumUniversite=?;");
        stmt.setInt(1, numUniv);
        int rs = stmt.executeUpdate();
    }

    public boolean bdd_enregistrerClassement(int INE, int NumMaster, int NumUniv, int classement) {
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            String query = "UPDATE gc_candidatures SET Classement=" + classement + " WHERE NumINE=" + INE + " AND NumMaster=" + NumMaster + " AND NumUniversite=" + NumUniv;
            //System.out.println(query);
            s.executeUpdate(query);

            return true;
        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
    }

    public boolean bdd_modifierClassement(int INE, Voeu voeu) {
        try {
            int classement = 0;
            int numMaster = voeu.master.numMaster;
            int numUniversite = voeu.universite.numUniv;

            //Recupere le classement du voeu à supprimer
            PreparedStatement stmt = conn.prepareStatement("SELECT Classement FROM gc_candidatures WHERE NumINE=? AND NumMaster=? AND NumUniversite=?;");
            stmt.setInt(1, INE);
            stmt.setInt(2, numMaster);
            stmt.setInt(3, numUniversite);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                classement = rs.getInt("Classement");
            }

            /*Modifie le classement de toutes les candidatures, c'est à dire applique -1 au classement
             permet par la suite à étudiant de passer de la liste d'attente à la liste des acceptés
             */
            stmt = conn.prepareStatement("UPDATE gc_candidatures SET Classement=Classement-1 WHERE Classement > ? AND NumMaster=? AND NumUniversite=?;");
            stmt.setInt(1, classement);
            stmt.setInt(2, numMaster);
            stmt.setInt(3, numUniversite);
            stmt.executeUpdate();

            //Supprime l'enregistrement dans les candidatures qui correspond au voeu "non" et "non mais"
            stmt = conn.prepareStatement("DELETE FROM gc_candidatures WHERE NumINE=? AND NumMaster=? AND NumUniversite=?;");
            stmt.setInt(1, INE);
            stmt.setInt(2, numMaster);
            stmt.setInt(3, numUniversite);
            stmt.executeUpdate();

            return true;
        } catch (Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
    }
}
