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
    final static String[] ATTR = {
            "ID",
            "Price",
            "Stock",
            "Item Name",
            "Barcode",
            "Brand",
            "Item Type"
    };
    public static String ID = ATTR[0];
    public static String PRICE = ATTR[1];
    public static String STOCK = ATTR[2];
    public static String ITEM_NAME = ATTR[3];
    public static String BARCODE = ATTR[4];
    public static String BRAND = ATTR[5];
    public static String ITEM_TYPE = ATTR[6];
    
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
    
    public Object getVal(String attr){
        if(attr.equals(ATTR[0])){
            return this.itemId;
        }else if(attr.equals(ATTR[1])){
            return this.price;
        }else if(attr.equals(ATTR[2])){
            return this.stock;
        }else if(attr.equals(ATTR[3])){
            return this.itemName;
        }else if(attr.equals(ATTR[4])){
            return this.Barcode;
        }else if(attr.equals(ATTR[5])){
            return this.Brand;
        }else if(attr.equals(ATTR[6])){
            return this.itemType;
        }
        return null;
    }
}
