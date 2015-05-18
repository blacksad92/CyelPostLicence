/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outils;

/**
 *
 * @author Linkro
 */
public class Item
    {
        private int id;
        private String valeur;
 
        public Item(int id, String valeur)
        {
            this.id = id;
            this.valeur = valeur;
        }
 
        public int getId()
        {
            return id;
        }
 
        public String getValeur()
        {
            return valeur;
        }
 
        public String toString()
        {
            return valeur;
        }
    }
