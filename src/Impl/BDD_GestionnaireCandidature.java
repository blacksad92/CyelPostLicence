/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Impl;

import CyelPostLicence.Licence;
import CyelPostLicence.Master;
import CyelPostLicence.Note;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cyelpost","root","");
            System.out.println("Connexion BDD effectuée");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
     public Note[] bdd_listeNotes(int INE) {
        ArrayList<Note> listeNotes = new ArrayList<Note>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT r.Semestre, r.NumSemestre, r.Moyenne, r.CodeObtention, r.Position, r.NumUniversite, r.NumLicence, r.NomLicence"
                    + "      FROM gc_resultats r"
                    + "      WHERE NumINE = "+INE;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                int ine = INE;
                int semestre = rs.getInt("r.Semestre");
                int numSemestre = rs.getInt("r.NumSemestre");
                int moyenne = rs.getInt("r.Moyenne");
                String codeObtention = rs.getString("r.CodeObtention");
                String position = rs.getString("r.Position");
                int numUniversite =  rs.getInt("r.NumUniversite");
                Licence licence = new Licence (rs.getInt("r.NumLicence"),rs.getString("r.NomLicence"));
                              
                Note note = new Note(ine,semestre ,numSemestre,moyenne,codeObtention ,position ,licence,numUniversite);                
                listeNotes.add(note);
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Note[] tabNotes = listeNotes.toArray(new Note[listeNotes.size()]);
        
        return tabNotes;
    }
     
     public ArrayList<Master> bdd_listeMasters(int NumUniversite) {
        ArrayList<Master> listeMasters = new ArrayList<Master>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT m.NumMaster, m.NomMaster"
                    + "      FROM gc_formations f, gc_masters m"
                    + "      WHERE f.NumUniversite = "+NumUniversite+""
                    + "      AND f.NumMaster = m.NumMaster";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                                                          
                Master master = new Master(rs.getInt("m.NumMaster"),rs.getString("m.NomMaster"));                
                listeMasters.add(master);
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        //Master[] tabMasters = listeMasters.toArray(new Master[listeMasters.size()]);
        
        return listeMasters;
    }
    
     
     public Licence[] bdd_listePrerequis(int NumUniversite,int NumMaster) {
        ArrayList<Licence> listeLicences = new ArrayList<Licence>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT l.NumLicence, l.NomLicence"
                    + "      FROM gc_formations f, gc_masters m, gc_prerequis p, gc_licences l"
                    + "      WHERE f.NumUniversite = "+NumUniversite+""
                    + "      AND f.NumMaster = m.NumMaster"
                    + "     AND m.NumMaster = "+NumMaster+""
                    + "     AND m.NumMaster = p.NumMaster"
                    + "     AND p.NumLicence = l.NumLicence";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                                                          
                Licence licence = new Licence(rs.getInt("l.NumLicence"),rs.getString("l.NomLicence"));                
                listeLicences.add(licence);
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Licence[] tabLicences = listeLicences.toArray(new Licence[listeLicences.size()]);
        
        return tabLicences;
    } 
     
     
     public boolean bdd_verifieLicencePrerequis(int NumUniversite,int NumMaster,int NumLicence) {
              int nbr = 0;
              boolean ok =  false;
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT count(*)"
                    + "      FROM gc_formations f, gc_masters m, gc_prerequis p"
                    + "      WHERE f.NumUniversite = "+NumUniversite+""
                    + "      AND f.NumMaster = m.NumMaster"
                    + "     AND m.NumMaster = "+NumMaster+""
                    + "     AND m.NumMaster = p.NumMaster"
                    + "     AND p.NumLicence = "+NumLicence;
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {                                                          
                nbr = rs.getInt("count(*)");
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return false;
        }
        if(nbr == 0)
        {
            ok = false;
        }
        else
        {
            ok = true;
        }
        // Renvoie TRUE alors la licence pour ce master dans cette universite est un prerequis
        // Renvoie FAlSE alors etat "Non valide"
        return ok;
    } 
}
