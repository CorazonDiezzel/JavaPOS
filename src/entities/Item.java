/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Dharm
 */
public class Item{
    String itemId;    
    int price;
    int stock;
    String itemName;
    String Barcode;
    String Brand;
    String itemType;
    static String[] Attributes = {
            "ID",
            "Price",
            "Stock",
            "Item Name",
            "Barcode",
            "Brand",
            "Item Type"
    };
    
    public Item(){}
    
    public Item(String itemId,    
    int price,
    int stock,
    String itemName,
    String Barcode,
    String Brand,
    String itemType){
        this.itemId = itemId;
        this.price = price;
        this.stock = stock;
        this.itemName = itemName;
        this.Barcode = Barcode;
        this.Brand = Brand;
        this.itemType = itemType;
    }
    
    public static String[] AttrNames(){
        return Attributes;
    }
    
    public static String AttrName(int index){
        return Attributes[index];
    }
    
    public Object getVal(String attr){
        if(attr == Attributes[0]){
            return this.itemId;
        }else if(attr == Attributes[1]){
            return this.price;
        }else if(attr == Attributes[2]){
            return this.stock;
        }else if(attr == Attributes[3]){
            return this.itemName;
        }else if(attr == Attributes[4]){
            return this.Barcode;
        }else if(attr == Attributes[5]){
            return this.Brand;
        }else if(attr == Attributes[6]){
            return this.itemType;
        }
        return null;
    }
}
