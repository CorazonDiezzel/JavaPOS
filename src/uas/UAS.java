/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import handlers.ItemHandler;
import handlers.LoginHandler;

/**
 *
 * @author Dharm
 */

public class UAS {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Toko tokoku = new Toko();
        tokoku.tokoName = "Toko ATK";
        tokoku.tokoAddress = "Jl.Kebanjiran, Gang.Tak Berujung, No.13";
        tokoku.tokoPhoneNo = "08123456719";
//        Session currentSession = new Session();
//        LoginHandler lh = new LoginHandler();
//        lh.doLogin(currentSession);
        ItemHandler itemHandler = new ItemHandler();
        itemHandler.showSearchItemMenu();
    }
}


class Toko{
    String tokoName;
    String tokoAddress;
    String tokoPhoneNo;
}
    