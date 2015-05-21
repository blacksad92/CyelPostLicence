/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import Client.ClientEtudiant;
import IHM.ConnexionEtudiant;

/**
 *
 * @author Eléa
 */
public class Launcher_AppliEtudiant {
    public static void main(String args[]) {
        System.out.println("--- APPLICATION ETUDIANT ---");
        
        ClientEtudiant client = new ClientEtudiant(args);
        new ConnexionEtudiant(client);
    }
}
