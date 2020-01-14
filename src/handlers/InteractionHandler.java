/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import entities.Item;
import java.util.Enumeration;
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
    Scanner s = new Scanner(System.in);
    
    Table menuTable = new Table();
    Table salesTable = new Table();

    public InteractionHandler(Toko toko,Session session) {
        this.toko = toko;
        this.session = session;
        this.showTokoMenu();
    }
    
    public void showTokoMenu(){
        String p;
        menuTable.printLine('=');
        menuTable.center(toko.getTokoName());
        menuTable.center(toko.getTokoAddress());
        menuTable.center(toko.getTokoPhoneNo());
        menuTable.printLine('=');
        do{
            menuTable.setColumnSpace(new int[]{5,40})
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
        int totalPrice = 0;
        salesTable.printLine('=');
        salesTable.printLine('=');
        salesTable.printLine('-');
        salesTable.setColumnSpace(new int[]{5,30,20,20})
                .header(new String[]{"No","Item Name","Qty","Price"});
        salesTable.printLine('-');
//        Item goes here
        Enumeration res = ih.items.getItem(Item.AttrName(3), "Buku") != null ? ih.items.getItem(Item.AttrName(3), "Buku").elements():null;
        int[] qty = {4,6,2,6,8,3,7,4,6};
        int inum = 0;
        while(res.hasMoreElements()){
            Item sitm = (Item) res.nextElement();
            salesTable.row(new String[]{
                String.valueOf(inum),
                String.valueOf((sitm.getVal(Item.AttrName(3)))),
                String.valueOf(qty),
                Integer.valueOf(String.valueOf(sitm.getVal(Item.AttrName(1)))).toString()
            });
        }
        
        salesTable.printLine('-');
        salesTable.setColumnSpace(new int[]{10,40})
                .row(new String[]{"Total",String.valueOf(totalPrice)});
        salesTable.printLine('-');
        salesTable.row(new String[]{"1","Search Item"});
        salesTable.row(new String[]{"2","Input Item ID / Barcode"});
        salesTable.printLine('=');
    }
    public void doExit(){
        exitCode = true;
    }
    public boolean exit(){
        session.logOut();
        return exitCode;
    }
}
