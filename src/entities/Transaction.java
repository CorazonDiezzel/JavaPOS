/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Stack;

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

    public Transaction() {
    }

    public Transaction(String transactionId, String transactionDate, int transactionTotalPrice, int transactionTotalPaid, String transactionStatus, TransactionItem items) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionTotalPrice = transactionTotalPrice;
        this.transactionTotalPaid = transactionTotalPaid;
        this.transactionStatus = transactionStatus;
        this.items = new Stack<>();
        
    }
    
    public void addItem(TransactionItem itm){
        this.items.push(itm);
    }
}