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

public class TransactionItem { //supposed to extend Stack, but nah...
    String transactionId;
    String productId;
    int qty;

    public TransactionItem() {
        
    }
    
    public TransactionItem(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public TransactionItem(String productId, int qty) {
        this.productId = productId;
        this.qty = qty;
    }
    
    public TransactionItem(String transactionId, String productId, int qty) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.qty = qty;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductId() {
        return productId;
    }

    public int getQty() {
        return qty;
    }
    
}