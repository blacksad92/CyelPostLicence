/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

/* */

import CyelPostLicence.GestionnaireCandidatures;
import CyelPostLicence.GestionnaireVoeux;
import CyelPostLicence.Universite;
import Outils.CorbaName;
import java.util.ArrayList;
import org.omg.CosNaming.NamingContext;

/**
 *
 * @author Cy
 */
public class ClientMinistere {
    
    public static CyelPostLicence.GestionnaireAcces gestAcces;
    public static CyelPostLicence.GestionnaireVoeux gestVoeux;
    public static CyelPostLicence.GestionnaireReferentiel gestReferentiel;
    public GestionnaireVoeux[] tabGestVoeux;
    
    public ClientMinistere(String args[]) {

        try {
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Recuperation du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+CorbaName.NOM_NAMINGSERV+":2001/NameService"));

            // Construction du nom a rechercher
            String idObj = CorbaName.GEST_ACCES;
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche aupres du naming service
            org.omg.CORBA.Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            //Creation de l'objet distant gestAcces
            gestAcces = CyelPostLicence.GestionnaireAccesHelper.narrow(distantAcces);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cloturerPeriode() {
        tabGestVoeux = gestAcces.listeGestionnairesVoeux();
        for(int i=0; i < tabGestVoeux.length ; i++)
        {
            tabGestVoeux[i].cloturerPeriode();
        }
    }
    
    public void RAZPeriode() {
        tabGestVoeux = gestAcces.listeGestionnairesVoeux();
        
        for(int i=0; i < tabGestVoeux.length ; i++)
        {
            //System.out.println(tabGestVoeux[i].academie().numAcademie);
            tabGestVoeux[i].RAZPeriode();
        }
    }
    
    public void actualiserListes() {
        System.out.println("[ClientMinistere] actualiserListes");
        // Récupérer la liste des universités
        GestionnaireCandidatures[] listeGestCand = gestAcces.ListeGestionnairesCandidatures();
        // Pour chaque université
        for (int i=0; i<listeGestCand.length; i++) {
            // Appeller la méthode finPeriodeDecision
            listeGestCand[i].finPeriodeDecision();
        }
    }
    
    public int periode() {
        int periode =  0;
        tabGestVoeux = gestAcces.listeGestionnairesVoeux();
        if (tabGestVoeux.length>0){
            periode = tabGestVoeux[0].periode();
        }
        return periode;
    }
}