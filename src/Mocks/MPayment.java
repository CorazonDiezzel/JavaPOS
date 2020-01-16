/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Payment;
import java.util.Stack;

/**
 *
 * @author Dharm
 */
public class MPayment {
    Stack<Payment> payment;

    public MPayment() {
        payment = new Stack<>();
        payment.push(new Payment("PY001", "PM00", "TA00001", 150000));
    }
    
}
