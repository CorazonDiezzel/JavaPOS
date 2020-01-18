/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import Mocks.MCashier;
import handlers.InteractionHandler;
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
        InteractionHandler mainInteraction;
        Toko tokoku = new Toko();
        Session currentSession = new Session();
        
        tokoku.tokoName = "Toko ATK";
        tokoku.tokoAddress = "Jl.Kebanjiran, Gang.Tak Berujung, No.13";
        tokoku.tokoPhoneNo = "08123456719";
        do{
            /**
            * Login tidak berjalan dalam console IDE.
            * jika ingin menjalankan login, maka bukalah dengan Terminal lain (seperti Command Prompt).
            * Ini hanya untuk testing.
            */
//            LoginHandler lh = new LoginHandler();
//            lh.doLogin(currentSession);
            currentSession.setSession(new MCashier().getCashier("Corazon", "Diezzel"));
            mainInteraction = new InteractionHandler(tokoku,currentSession);
        }while(mainInteraction.exit());
    }
}
    