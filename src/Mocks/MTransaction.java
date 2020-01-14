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
        transactions.add(new Transaction("1", "10 Januari 2020", 120000, 120000, "Lunas", new TransactionItem("1")));
    }
    
}
