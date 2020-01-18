/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import Mocks.MItem;
import java.util.Scanner;
import entities.Item;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.regex.Pattern;
/**
 *
 * @author Dharm
 * Class for handling Items
 */
public class ItemHandler {
    Table table = new Table();
    Scanner sc;
    MItem items = new MItem();
    int tableWidth[] = {5,10,45,20};
    String searchKey;
    String searchValue = "";

    /**
     *  Declared once, Class to handle Items.
     */
    public ItemHandler() {
    }
    
    
    
    /**@param searchkey parameter to specify the Field.
     * 
     * @return Item
     */
    public Item showSearchItemMenu(String searchkey){
        searchKey = searchkey == null ? Item.ITEM_NAME:searchkey;
        System.out.println("Masukkan "+searchKey);
        sc = new Scanner(System.in);
        searchValue = sc.nextLine();
        Vector<Item> res = items.getItem(searchKey, searchValue) != null ? items.getItem(searchKey, searchValue):null;
        Enumeration result_enum = res != null ? res.elements():null;
        Boolean found = result_enum != null ? result_enum.hasMoreElements():false;
        Integer select = 0;
        int result_enum_index = 1;
        table.setColumnSpace(tableWidth).header(new String[]{
            "No",
            Item.ID,
            Item.ITEM_NAME,
            Item.STOCK
        });
        
        if(result_enum != null){
            while (result_enum.hasMoreElements()) {
                Item nextItem = (Item) result_enum.nextElement();
                table.row(new String[]{
                    String.valueOf(result_enum_index),
                    nextItem.getVal(Item.ID).toString(),
                    nextItem.getVal(Item.ITEM_NAME).toString(),
                    nextItem.getVal(Item.STOCK).toString()
                });
                result_enum_index+=1;
            }
            do{
                System.out.println("Masukkan No Barang Yang Dipilih :");
                try{
                    select = sc.nextInt()-1;
                }catch(InputMismatchException ime){
                    System.out.println("Input salah!");
                }
            }while(select != -1 && select > result_enum_index-1);
            return res.elementAt(select);
        }else{
            System.out.println("Item tidak ditemukan!");
        }
        return null;
    }
    
    public void updateStockItem(String itemId, int new_value){
        Item itm = this.items.getItem(Item.ID, itemId).firstElement();
        this.items.getItem(Item.ID, itemId).firstElement().setStock(((int)itm.getVal(Item.STOCK))-new_value);
    }

    /**
     * function to add Item to Mock data.
     */
    public void addItem(){
        Item new_item = new Item();
        System.out.println("Masukkan "+Item.BARCODE+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[0-9]+")));
        System.out.println("Masukkan "+Item.ITEM_NAME+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[a-zA-Z0-9]+")));
        System.out.println("Masukkan "+Item.ITEM_TYPE+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[a-zA-Z0-9]+")));
        System.out.println("Masukkan "+Item.PRICE+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[0-9]+")));
        System.out.println("Masukkan "+Item.STOCK+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[0-9]+")));
        System.out.println("Masukkan "+Item.BRAND+" : ");
        sc = new Scanner(System.in);
        new_item.setBarcode(sc.next(Pattern.compile("[a-zA-Z0-9]+")));
        this.items.pushItem(new_item);
    }
}