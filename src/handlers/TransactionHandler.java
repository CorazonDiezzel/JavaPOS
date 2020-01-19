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
import java.util.Scanner;

/**
 * Declare once.
 * @author Dharm
 */
public class TransactionHandler {
    Transaction currentTransaction;
    MTransaction mtrans = new MTransaction();
    ItemHandler itemHandler;
    Table transactionTable;
    Scanner s;
    
    public TransactionHandler(Transaction currentTransaction,ItemHandler itemHandler) {
        this.currentTransaction = currentTransaction;
        this.itemHandler = itemHandler;
        this.transactionTable = new Table();
        s = new Scanner(System.in);
    }
    
    void setTransaction(String transactionID){
        this.currentTransaction = mtrans.getTransaction(Transaction.ID, transactionID).firstElement();
    }
    
    Transaction getCurrentTransaction(){
        return this.currentTransaction;
    }
    
    public boolean Checkout(){
        Integer totalPaid = 0;
        Integer totalPrice = (int)this.currentTransaction.getVal(Transaction.TOTAL_PRICE);
        
        this.transactionTable.printLine('=');
        this.transactionTable.center("CHECKOUT");
        this.transactionTable.printLine('=');
        this.transactionTable.setColumnSpace(new int[]{22,58})
                .row(new String[]{"Total Harga",OutputHandler.priceFormat(totalPrice)});
        this.transactionTable.printLine('-');
        System.out.print("Masukan Nominal Bayar : ");
        this.s = new Scanner(System.in);
        totalPaid = s.nextInt();
        this.transactionTable.printLine('-');
        this.transactionTable.setColumnSpace(new int[]{22,58})
                .row(new String[]{"Total Harga",OutputHandler.priceFormat((int)this.currentTransaction.getVal(Transaction.TOTAL_PRICE))})
                .row(new String[]{"Total Bayar",OutputHandler.priceFormat(totalPaid)})
                .row(new String[]{"Kembalian",OutputHandler.priceFormat(totalPaid-totalPrice)});
        this.mtrans.pushTransaction(currentTransaction,this.itemHandler);
        this.currentTransaction = new Transaction();
        this.transactionTable.printLine('=');
        this.transactionTable.center("TERIMA KASIH");
        this.transactionTable.printLine('=');
        this.s = new Scanner(System.in);
        s.nextLine(); //Intercept for Nothing
        return false;
    }
    
    /**
     * Interaction for adding new TransactionItem into Current Transaction.
     * @see ItemHandler
     * @param p Field to search
     * @return true if Item can be added successfully
     */
    public boolean addTransactionItem(String p){
    TransactionItem nti = new TransactionItem();
        String productId = "";
        try{
            productId = itemHandler.showSearchItemMenu(p).getVal(Item.ID).toString();
        }catch(NullPointerException npe){
            System.out.println("Item tidak ditemukan!");
            productId = "";
            return true;
        }
        if(!productId.equals("")){
            nti.setProductId(productId);
            int qty;
            boolean valid = false;
            do{
            System.out.println("Masukan jumlah beli: ");
            s = new Scanner(System.in);
            qty = s.nextInt();
            valid = ((int)this.itemHandler.items.getItem(Item.ID, productId).firstElement().getVal(Item.STOCK)) - qty > 0;
            if(!valid){
                System.out.println("Stock kurang!");
            }
            }while(!valid);
            nti.setQty(qty);
            currentTransaction.addItem(nti);
            return true;
        }
        return false;
    }
}
