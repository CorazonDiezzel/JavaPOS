/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Dharm
 */
public class Transaction {
    String transactionId;
    Date transactionDate;
    int transactionTotalPrice;
    int transactionTotalPaid;
    String transactionStatus;
    Stack<TransactionItem> items;
    
    final static String[] ATTR = {
            "ID",
            "Date",
            "Total Price",
            "Total Paid",
            "Status",
            "Items"
    };
    public static String ID = ATTR[0];
    public static String DATE = ATTR[1];
    public static String TOTAL_PRICE = ATTR[2];
    public static String TOTAL_PAID = ATTR[3];
    public static String STATUS = ATTR[4];
    public static String ITEMS = ATTR[5];
    
    public Object getVal(String attr){
        if(attr.equals(ATTR[0])){
            return this.transactionId;
        }else if(attr.equals(ATTR[1])){
            return this.transactionDate;
        }else if(attr.equals(ATTR[2])){
            return this.transactionTotalPrice;
        }else if(attr.equals(ATTR[3])){
            return this.transactionTotalPaid;
        }else if(attr.equals(ATTR[4])){
            return this.transactionStatus;
        }else if(attr.equals(ATTR[5])){ //Aesthetically not correct.
            return this.items;
        }
        return null;
    }

    public Stack<TransactionItem> getItems() {
        return items;
    }

    public void setItems(Stack<TransactionItem> items) {
        this.items = items;
    }

    public void setTransactionDate(Date transactionDate) {
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

    public Transaction(String transactionId, Date transactionDate, int transactionTotalPrice, int transactionTotalPaid, String transactionStatus) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionTotalPrice = transactionTotalPrice;
        this.transactionTotalPaid = transactionTotalPaid;
        this.transactionStatus = transactionStatus;
        this.items = new Stack<>();
        
    }
    
    public Transaction(String transactionId, Date transactionDate, int transactionTotalPrice, int transactionTotalPaid, String transactionStatus, Stack<TransactionItem> items) {
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
        final boolean newItem;
        this.items.forEach((t_itm) -> {
            if(t_itm.productId == itm.productId){
                t_itm.qty += itm.qty;
                itm.qty = t_itm.qty;
            }
        });
        if(this.items.search(itm)<0){
            this.items.push(itm);
        }
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