/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Transaction;
import entities.TransactionItem;
import java.util.Stack;

/**
 *
 * @author Dharm
 */
public class MTransaction {
    Stack<Transaction> transactions;
    public MTransaction() {
        transactions = new Stack<>();
        transactions.add(new Transaction("TA00001", "10 Januari 2020", 120000, 120000, "Lunas",new Stack<>()));
        transactions.get(0).addItem(new TransactionItem("ITM000001", 4));
        transactions.get(0).addItem(new TransactionItem("ITM000003", 6));
        transactions.get(0).addItem(new TransactionItem("ITM000002", 2));
    }
    public Transaction getExample(){
        System.out.println(this.transactions.firstElement().getTransactionStatus());
        return transactions.firstElement();
    }
}
