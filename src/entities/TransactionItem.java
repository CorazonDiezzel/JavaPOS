/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Dharm
 */

public class TransactionItem{
    String transactionId;
    String productId;
    int qty;

    public TransactionItem() {
        
    }

    public TransactionItem(String transactionId) {
        this.transactionId = transactionId;
    }
    
}