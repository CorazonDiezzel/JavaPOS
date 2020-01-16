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
public class Payment {
    String paymentId;
    String paymentMethod;
    String transactionId;
    int amount;

    public Payment() {
    }

    public Payment(String paymentId, String paymentMethod, String transactionId, int amount) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.amount = amount;
    }
    
    
}
