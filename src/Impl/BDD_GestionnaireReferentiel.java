/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Licence;
import CyelPostLicence.Master;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cy
 */
public class BDD_GestionnaireReferentiel {
    
    Connection conn;
    
    public BDD_GestionnaireReferentiel() {
        try {
            System.out.println("Connexion BDD");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cyelpost","root","");
            System.out.println("Connexion BDD effectuée");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //Retourne la liste complète des licences
    public Licence[] bdd_listeLicences() {
        ArrayList<Licence> listeLicences = new ArrayList<Licence>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT l.NumLicence, l.NomLicence"
                    + "      FROM gr_Licences l";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                              
                Licence licence = new Licence(rs.getInt("l.NumLicence"), rs.getString("l.NomLicence"));                
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
    
     //Retourne la liste complète des masters
    public Master[] bdd_listeMasters() {
        ArrayList<Master> listeMasters = new ArrayList<Master>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT m.NumMaster, m.NomMaster"
                    + "      FROM gr_Masters m";
            //System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                              
                Master master = new Master(rs.getInt("m.NumMaster"), rs.getString("m.NomMaster"));                
               listeMasters.add(master);
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Master[] tabMasters = listeMasters.toArray(new Master[listeMasters.size()]);
        
        return tabMasters;
    }
    
     //Retourne la liste complète des académies
    public Academie[] bdd_listeAcademies() {
        ArrayList<Academie> listeAcademies = new ArrayList<Academie>();
        
        try {
            // On crée un objet Statement qui va permettre l'execution des requètes
            Statement s = conn.createStatement();
            
            String req = "SELECT a.NumAcademie,a.NomAcademie"
                    + "      FROM gr_Academies a";
            System.out.println(req);
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()) {
                              
                Academie academie = new Academie(rs.getInt("a.NumAcademie"), rs.getString("a.NomAcademie"));                
               listeAcademies.add(academie);
            }
                        
        } catch(Exception e) {
            // Il y a une erreur
            e.printStackTrace();
            return null;
        }
        Academie[] tabAcademies = listeAcademies.toArray(new Academie[listeAcademies.size()]);
        
        return tabAcademies;
    }
}
