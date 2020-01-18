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
public final class Cashier {
    private String cashierFullName;
    private String cashierUserName;
    private String cashierPassword;
    
    public Cashier(){}
    
    public Cashier(String fullname,String user, String pass){
        this.setCashierFullName(fullname);
        this.setCashierUserName(user);
        this.setCashierPassword(pass);
    }

    public void setCashierFullName(String cashierFullName) {
        this.cashierFullName = cashierFullName;
    }
    
    public void setCashierUserName(String cashierUserName) {
        this.cashierUserName = cashierUserName;
    }

    public void setCashierPassword(String cashierPassword) {
        this.cashierPassword = cashierPassword;
    }

    public String getCashierFullName() {
        return cashierFullName;
    }

    public String getCashierUserName() {
        return cashierUserName;
    }

    public String getCashierPassword() {
        return cashierPassword;
    }
}
