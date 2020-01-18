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
 *
 * @author Dharm
 */
public class TransactionHandler {
    Transaction currentTransaction;
    MTransaction mtrans = new MTransaction();
    ItemHandler itemHandler;
    Scanner s;

    public TransactionHandler(Transaction currentTransaction,ItemHandler itemHandler) {
        this.currentTransaction = currentTransaction;
        this.itemHandler = itemHandler;
        s = new Scanner(System.in);
    }
    
    void createNewTransaction(){
        currentTransaction = new Transaction();
    }
    
    void getTransaction(String transactionID){
        this.currentTransaction = mtrans.getTransaction(Transaction.ID, transactionID).firstElement();
    }
    
    Transaction getCurrentTransaction(){
        return this.currentTransaction;
    }
    
    boolean Checkout(){
        return true;
    }
    
    boolean addTransactionItem(String p){
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
            System.out.println("Masukan jumlah beli: ");
            nti.setQty(s.nextInt());
            currentTransaction.addItem(nti);
            return true;
        }
        return false;
    }
}
