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
import java.util.regex.Pattern;
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
    Scanner s;
    
    ItemHandler itemHandler;
    
    Table menuTable = new Table();

    public InteractionHandler(Toko toko,Session session) {
        this.toko = toko;
        this.session = session;
        this.itemHandler = new ItemHandler();
        s = new Scanner(System.in);
        this.showTokoMenu();
    }
    
    public void showTokoMenu(){
        String p;
        do{
            menuTable.printLine('=');
            menuTable.center(toko.getTokoName());
            menuTable.center(toko.getTokoAddress());
            menuTable.center(toko.getTokoPhoneNo());
            menuTable.printLine('=');
            
            menuTable.setColumnSpace(new int[]{10,70})
                    .row(new String[]{"User",this.session.getName()});
            menuTable.printLine('=');
            
            menuTable.setColumnSpace(new int[]{5,40})
                    .row(new String[]{"1","New Sales"})
                    .row(new String[]{"2","Report"})
                    .row(new String[]{"3","Add Item"})
                    .row(new String[]{"4","Log Out"});
            menuTable.printLine('-');
            
            System.out.print("Masukkan Pilihan :");
            s = new Scanner(System.in);
            p = s.next();
            switch(p){
                case "1":
                    showSalesMenu();
                    break;
                case "2":
                    menuTable.center("NOT IMPLEMENTED YET");
                    break;
                case "3":
                    itemHandler.addItem();
                    break;
                case "4":
                    session.logOut();
                    break;
            }
        }while(!"4".equals(p));
    }
    public void showSalesMenu(){
        MTransaction mt = new MTransaction();
        TransactionHandler transactionHandler = new TransactionHandler(mt.getExample(), this.itemHandler);
        Transaction transaction;
        Table salesTable = new Table();
        
        Enumeration res;
        int p = 0;
        boolean again;
        do{
            again = false;
            transaction = transactionHandler.getCurrentTransaction();
            
            salesTable.printLine('=');
            salesTable.printLine('=');
            salesTable.setColumnSpace(new int[]{5,30,15,10,20})
                    .header(new String[]{"No","Item Name","Price","Qty","Sum Price"});
            salesTable.printLine('-');

    //      Fetch TransactionItem
            res = transactionHandler.getCurrentTransaction().fetchTransactionItem().elements();
            if(res!=null){
                int inum = 1;
                while(res.hasMoreElements()){
                    TransactionItem ti = (TransactionItem) res.nextElement();
                    Item sitm = itemHandler.items.getItem(Item.ID, ti.getProductId()).firstElement();
                    salesTable.row(new String[]{
                        String.valueOf(inum),
                        String.valueOf((sitm.getVal(Item.ITEM_NAME))),
                        salesTable.priceFormat(Integer.valueOf(String.valueOf(sitm.getVal(Item.PRICE)))),
                        String.valueOf(ti.getQty()),
                        salesTable.priceFormat(Integer.valueOf(String.valueOf(sitm.getVal(Item.PRICE)))*ti.getQty())
                    });
                    inum+=1;
                }
            }
            salesTable.printLine('-');
            salesTable.setColumnSpace(new int[]{10,70})
                    .row(new String[]{"Total",salesTable.priceFormat(Integer.valueOf(transaction.getVal(Transaction.TOTAL_PRICE).toString()))});
            salesTable.printLine('-');
            salesTable.row(new String[]{"1","Search Item"})
                    .row(new String[]{"2","Input Item ID / Barcode"})
                    .row(new String[]{"3","Checkout"})
                    .row(new String[]{"4","Keluar"});
            salesTable.printLine('-');
            System.out.print("Masukan pilihan : ");
            s = new Scanner(System.in);
            p = s.nextInt();
            if(Pattern.matches("[1234]",String.valueOf(p))){
                switch (p) {
                    case 1:
                        again = transactionHandler.addTransactionItem(Item.ITEM_NAME);
                        break;
                    case 2:
                        again = transactionHandler.addTransactionItem(p == 1 ? Item.ID:Item.BARCODE);
                        break;
                    case 3:
                        again = transactionHandler.Checkout();
                        break;
                    case 4:
                        again = false;
                        break;
                    default:
                        again = true;
                        break;
                }
            }else{
                System.out.println("Input mismatch!");
                again = true;
            }
        }while(again);
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
