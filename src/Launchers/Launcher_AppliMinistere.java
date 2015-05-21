/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import Client.ClientMinistere;
import IHM.InterfaceMinistere;

/**
 *
 * @author Eléa
 */
public class Launcher_AppliMinistere {
    public static void main(String args[]) {
        System.out.println("--- APPLICATION MINISTERE ---");
        
        ClientMinistere client = new ClientMinistere(args);
        new InterfaceMinistere(client);
    }
}
