/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.Scanner;
import uas.Session;
import uas.Toko;


/**
 *
 * @author Dharm
 */
public class InteractionHandler {
    Boolean exitCode = false;
    
    Session session;
    Toko toko;
    ItemHandler ih = new ItemHandler();
    Table table = new Table();
    Scanner s = new Scanner(System.in);

    public InteractionHandler(Toko toko,Session session) {
        this.toko = toko;
        this.session = session;
        this.showTokoMenu();
    }
    
    public void showTokoMenu(){
        String p;
        table.printLine('=');
        table.center(toko.getTokoName());
        table.center(toko.getTokoAddress());
        table.center(toko.getTokoPhoneNo());
        table.printLine('=');
        do{
            table.setColumnSpace(new int[]{5,40})
                    .row(new String[]{"1","New Sales"})
                    .row(new String[]{"2","Report"})
                    .row(new String[]{"3","Add Item"})
                    .row(new String[]{"4","Log Out"});
            System.out.println("\nMasukkan Pilihan :");
            p = s.next();
            switch(p){
                case "1":
                    showSalesMenu();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
            }
        }while(p != "4");
    }
    public void showSalesMenu(){
        /*
        ---------------------------------------
        No | Item Name          | Qty | Price |
        ---------------------------------------
        
        
        
        
        ---------------------------------------
        Total
        ---------------------------------------
        1.Search Item
        Input Item Id / Barcode :
        */
    }
    public void doExit(){
        exitCode = true;
    }
    public boolean exit(){
        session.logOut();
        return exitCode;
    }
}
