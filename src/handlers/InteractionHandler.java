/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import Mocks.MTransaction;
import entities.Item;
import entities.Transaction;
import entities.TransactionItem;
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
    Scanner s = new Scanner(System.in);
    
    Table menuTable = new Table();

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
            menuTable.printLine('-');
            System.out.print("Masukkan Pilihan :");
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
        ItemHandler itemHandler = new ItemHandler();
        MTransaction mt = new MTransaction();
        
        Table salesTable = new Table();
        Transaction transaction = mt.getExample();
        
        int totalPrice = 0;
        int input;
        
        salesTable.printLine('=');
        salesTable.printLine('=');
        salesTable.setColumnSpace(new int[]{5,30,20,25})
                .header(new String[]{"No","Item Name","Qty","Price"});
        salesTable.printLine('-');
//        Item goes here
//        Enumeration res = ih.items.getItem(Item.AttrName(3), "Buku") != null ? ih.items.getItem(Item.AttrName(3), "Buku").elements():null;
        Enumeration res;
        res = transaction.fetchTransactionItem().elements();
        
        int inum = 1;
        while(res.hasMoreElements()){
            TransactionItem ti = (TransactionItem) res.nextElement();
            Item sitm = itemHandler.items.getItem(Item.AttrName(0), ti.getProductId()).firstElement();
            salesTable.row(new String[]{
                String.valueOf(inum),
                String.valueOf((sitm.getVal(Item.AttrName(3)))),
                String.valueOf(ti.getQty()),
                salesTable.priceFormat(Integer.valueOf(String.valueOf(sitm.getVal(Item.AttrName(1)))))
            });
            inum+=1;
        }
        
        salesTable.printLine('-');
        salesTable.setColumnSpace(new int[]{10,70})
                .row(new String[]{"Total",salesTable.priceFormat(totalPrice)});
        salesTable.printLine('-');
        salesTable.row(new String[]{"1","Search Item"});
        salesTable.row(new String[]{"2","Input Item ID / Barcode"});
        salesTable.printLine('-');
        System.out.print("Masukan pilihan : ");
        int p = s.nextInt(1);
        boolean v = false;
        do{
            switch(p){
                case 1:
                    TransactionItem ti = new TransactionItem();
                    ti.setProductId(itemHandler.showSearchItemMenu().getVal(Item.AttrName(0)).toString());
                    System.out.println("Masukan jumlah beli: ");
                    ti.setQty(s.nextInt());
                    transaction.addItem(ti);
                    v = true;
                    break;
                case 2:
                    break;
                default:
                    System.out.print("Input salah!");
                    break;
            }
        }while(!v);
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
