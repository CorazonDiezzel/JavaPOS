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
public class PaymentMethod {
    String paymentMethodId;
    String paymentMethodName;
    String paymentMethodDesc;

    public PaymentMethod() {
    }

    public PaymentMethod(String paymentMethodId, String paymentMethodName, String paymentMethodDesc) {
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodName = paymentMethodName;
        this.paymentMethodDesc = paymentMethodDesc;
    }
    
    
}
