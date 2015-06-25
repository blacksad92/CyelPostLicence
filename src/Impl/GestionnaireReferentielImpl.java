/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import CyelPostLicence.Academie;
import CyelPostLicence.Licence;
import CyelPostLicence.Master;

/**
 *
 * @author Linkro
 */
public class GestionnaireReferentielImpl extends CyelPostLicence.GestionnaireReferentielPOA {

    
    private Academie[] tableauAcademie;
    private Master[] tableauMaster;
    private Licence[] tableauLicence;
    
    public BDD_GestionnaireReferentiel bdd = new BDD_GestionnaireReferentiel();

     public GestionnaireReferentielImpl() {
        InitList();
    }
    
    public void InitList(){
        //Recherche dans la base de données les académies
        tableauAcademie = bdd.bdd_listeAcademies();
        //Recherche dans la base de données la liste des Masters
        tableauMaster = bdd.bdd_listeMasters();
        // Recherche dans la base de données la liste des Licences
        tableauLicence = bdd.bdd_listeLicences();
    }
    
    //Getter de la liste complète des académies
    @Override
    public Academie[] listeAcademies() {
       
        return tableauAcademie;
    }

    //Getter de la liste complète des masters
    @Override
    public Master[] listeMasters() {
        
        return tableauMaster;
    }

    //Getter de la liste complète des licences
    @Override
    public Licence[] listeLicences() {
        
        return tableauLicence;
    }
}
