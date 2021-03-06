/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Item;
import entities.Transaction;
import entities.TransactionItem;
import handlers.ItemHandler;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 *
 * @author Dharm
 */
public class MTransaction {
    Stack<Transaction> transactions;
    public MTransaction() {
        transactions = new Stack<>();
        transactions.add(new Transaction("TA00001", new Date(2020, 1, 10, 10, 2), 120000, 120000, "Lunas",new Stack<>()));
        transactions.get(0).addItem(new TransactionItem("ITM000001", 4));
        transactions.get(0).addItem(new TransactionItem("ITM000002", 6));
        transactions.get(0).addItem(new TransactionItem("ITM000003", 2));
    }
    public Transaction getExample(){
        return transactions.firstElement();
    }
    public String getNewID(){
        String gid = "TA00000";
        int last = Integer.valueOf(new Scanner(this.transactions.lastElement().getVal(Transaction.ID).toString()).skip(Pattern.compile("[a-zA-Z]+")).next())+1;
        String subgid = gid.substring(0, gid.length()-String.valueOf(last).length()).concat(String.valueOf(last));
        return subgid;
    }
    
    public void pushTransaction(Transaction t, ItemHandler ih){
        Transaction nt = t;
        nt.setTransactionId(getNewID());
        if(this.transactions.push(t)!=null){
            for(TransactionItem ti:t.getItems()){
                ih.updateStockItem(ti.getProductId(), ti.getQty());
            }
        }
    }
            
    public Vector<Transaction> getTransaction(String attrName, String attrValue){
        Vector<Transaction> results = new Vector<Transaction>();
        Stack<Transaction> s_results = new Stack<Transaction>();
//            Search Value
        Stack<String> srcVal = new Stack<>();
        String[] swords = attrValue.split(" ");
        for(String sword : swords){
            srcVal.push(sword);
        }
        transactions.forEach((transaction) -> { //Start Search Iteration;
            Stack<String> itemVal = new Stack<>();
            String[] iwords = String.valueOf(transaction.getVal(attrName)).split(" ");
            for(String iword : iwords){
                itemVal.push(iword);
            }
            
            srcVal.forEach((word) -> {
                if(itemVal.search(word)>0){
                    if(!(s_results.search(transaction)>0)){
                        s_results.add(transaction);
                    }
                }else{
                    s_results.remove(transaction);
                }
            });
        }); //End Search Iteration;
        s_results.forEach((r) -> {
            results.add(r);
        });
        if(results.isEmpty()){
//            System.out.println("Item tidak ditemukan!");
            return null;
        }
        return results;
    }
}
