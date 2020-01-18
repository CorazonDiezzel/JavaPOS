/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Cashier;

/**
 *
 * @author Dharm
 */
public class MCashier {
    Cashier cashiers[] = {
        new Cashier("Chrisana Dharmawan","Corazon","Diezzel"),
        new Cashier("Wzazky Yil","Wzazky","Yil")
    };
    public Cashier getCashier(String user, String pass){
        for (Cashier cashier : cashiers) {
            if ((cashier.getCashierUserName() == null ? user == null : cashier.getCashierUserName().equals(user)) && cashier.getCashierPassword().equals(pass)) {
                System.out.println("User ditemukan!");
                return cashier;
            }
            System.out.println("User tidak ditemukan!");
        }
        return null;
    }
}
