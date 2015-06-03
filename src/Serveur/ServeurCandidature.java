/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import CyelPostLicence.GestionnaireAcces;
import CyelPostLicence.GestionnaireCandidatures;
import Impl.GestionnaireCandidaturesImpl;
import Outils.CorbaName;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author David
 */
public class ServeurCandidature {
    
    public static String[] arg;

    public static void main(String[] args) {
        try {
            arg = args;
            // Intialisation de l'ORB
            //************************
            org.omg.CORBA.ORB orbGestCandidature = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Gestion du POA
            //****************
            // Recuperation du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Creation du servant
            //*********************
            GestionnaireCandidaturesImpl gestCandidature = new GestionnaireCandidaturesImpl();

            // Activer le servant au sein du POA et recuperer son ID
            byte[] gestAccesId = rootPOA.activate_object(gestCandidature);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();

            // Recuperation du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+CorbaName.NOM_NAMINGSERV+":2001/NameService"));

            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(gestCandidature));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);

            //Inscription du gestionnaireVoeux auprès du Gestionnaire d'acces
            // Construction du nom a rechercher
            String idObj = CorbaName.GEST_ACCES;
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

            // Recherche du gestionnaireAcces aupres du naming service
            org.omg.CORBA.Object distantAcces = nameRoot.resolve(nameToFind);

            // Casting de l'objet CORBA au type convertisseur GestionnaireAcces
            GestionnaireAcces gestAcces = CyelPostLicence.GestionnaireAccesHelper.narrow(distantAcces);
            gestCandidature.gestAcces = gestAcces;

            //Construction de l'objet GestionnaireVoeux
            GestionnaireCandidatures thisgestCandidature = CyelPostLicence.GestionnaireCandidaturesHelper.narrow(orbGestCandidature.string_to_object(IORServant));

            //Appel de la méthode du gestAcces pour s'inscrire
            gestAcces.inscriptionGestionnaireCandidatures(thisgestCandidature);

            // Lancement de l'ORB et mise en attente de requete
            System.out.println("Prêt à travailler");
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}