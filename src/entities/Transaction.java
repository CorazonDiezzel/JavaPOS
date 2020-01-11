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
public class Transaction {
    String transactionId;
    String transactionDate;
    String transactionTotalPrice;
    String transactionTotalPaid;
    String transactionStatus;
    TransactionItems items;
}
class TransactionItems{
    String transactionId;
    Item tItems[];
}