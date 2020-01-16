/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Dharm
 */
public class Transaction {
    String transactionId;
    String transactionDate;
    int transactionTotalPrice;
    int transactionTotalPaid;
    String transactionStatus;
    Stack<TransactionItem> items;

    public String getTransactionDate() {
        return transactionDate;
    }

    public Stack<TransactionItem> getItems() {
        return items;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public int getTransactionTotalPaid() {
        return transactionTotalPaid;
    }

    public int getTransactionTotalPrice() {
        return transactionTotalPrice;
    }

    public void setItems(Stack<TransactionItem> items) {
        this.items = items;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public void setTransactionTotalPaid(int transactionTotalPaid) {
        this.transactionTotalPaid = transactionTotalPaid;
    }

    public void setTransactionTotalPrice(int transactionTotalPrice) {
        this.transactionTotalPrice = transactionTotalPrice;
    }
    
    
    
    public Transaction() {
    }

    public Transaction(String transactionId, String transactionDate, int transactionTotalPrice, int transactionTotalPaid, String transactionStatus) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionTotalPrice = transactionTotalPrice;
        this.transactionTotalPaid = transactionTotalPaid;
        this.transactionStatus = transactionStatus;
        this.items = new Stack<>();
        
    }
    
    public Transaction(String transactionId, String transactionDate, int transactionTotalPrice, int transactionTotalPaid, String transactionStatus, Stack<TransactionItem> items) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionTotalPrice = transactionTotalPrice;
        this.transactionTotalPaid = transactionTotalPaid;
        this.transactionStatus = transactionStatus;
        this.items = items;
        
    }
    
    public void setTransactionItem(Stack<TransactionItem> items){
        this.items = items;
    }
    
    public void addItem(TransactionItem itm){
        itm.transactionId = this.transactionId;
        this.items.push(itm);
    }
    
    /**
     *
     * @return
     */
    public Vector<TransactionItem> fetchTransactionItem(){
        Vector<TransactionItem> f = new Vector<>();
        if(items != null){
            this.items.forEach((i) -> {
                f.add(i);
            });
        }else{
//            What about the exeption ? nope :)
        }
        return f;
    }
}