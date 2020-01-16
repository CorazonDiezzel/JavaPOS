/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.PaymentMethod;
import java.util.Stack;

/**
 *
 * @author Dharm
 */
public class MPaymentMethod {
    Stack<PaymentMethod> pm;

    public MPaymentMethod() {
        pm = new Stack<>();
        pm.push(new PaymentMethod("PM000", "Cash", "Langsung bayar"));
        pm.push(new PaymentMethod("PM001", "GoPay", "Bayar lewat gopay"));
        pm.push(new PaymentMethod("PM002", "", ""));
    }
    
}
