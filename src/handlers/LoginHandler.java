/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import Mocks.MCashier;
import java.io.Console;
import java.util.Scanner;
import uas.Session;

/**
 *
 * @author Dharm
 */
public class LoginHandler {
    public void doLogin(Session s){
        String name, pass;
        
        Scanner sc = new Scanner(System.in);
        Console cs = System.console();
        if(cs==null){
            System.out.println("Console instance failed!");
            System.exit(0);
        }
        int attempt = 0;
        do{
            attempt +=1;
            if(attempt>1){
                System.out.println("Login Gagal, cek Username dan Password!");
            }
            System.out.println("Masukkan Username : ");
            name = sc.nextLine();
            System.out.println("Masukkan Password : ");
            pass = String.valueOf(cs.readPassword());
            System.out.println(name);
            System.out.println(pass);
            s.setSession(new MCashier().getCashier(name, pass));
        }while(!s.sessionCheck());
    }
}
