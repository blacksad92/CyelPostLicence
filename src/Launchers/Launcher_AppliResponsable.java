/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import Client.ClientResponsable;
import IHM.ConnexionResponsable;

/**
 *
 * @author Eléa
 */
public class Launcher_AppliResponsable {
    public static void main(String args[]) {
        System.out.println("--- APPLICATION RESPONSABLE DE FORMATION ---");
        System.out.println("--- TEST MODIFICATION");
        
        ClientResponsable client = new ClientResponsable(args);
        new ConnexionResponsable(client);
    }
}
