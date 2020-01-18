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
    
    public Item(){
    }
    
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

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    final static String[] ATTR = {
            "ID",
            "Price",
            "Stock",
            "Item Name",
            "Barcode",
            "Brand",
            "Item Type"
    };
    public static final String ID = ATTR[0];
    public static final String PRICE = ATTR[1];
    public static final String STOCK = ATTR[2];
    public static final String ITEM_NAME = ATTR[3];
    public static final String BARCODE = ATTR[4];
    public static final String BRAND = ATTR[5];
    public static final String ITEM_TYPE = ATTR[6];
    
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
