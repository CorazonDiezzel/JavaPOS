/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import entities.Cashier;

/**
 *
 * @author Dharm
 */
public class Session {
    Cashier cashier;
    public boolean sessionCheck() {
        if(this.cashier != null){
            return true;
        }
        return false;
    }
    public void setSession(Cashier c){
        cashier = c;
    }
}