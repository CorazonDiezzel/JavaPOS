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
/**
 *
 * @author Dharm
 */
public class ItemHandler {
    OutputHandler oh = new OutputHandler();
    Scanner sc = new Scanner(System.in);
    MItem items = new MItem();
    int tableWidth[] = {10,50,20};
    
    String searchKey = Item.AttrName(3);
    String searchValue = "";
    
    public void showSearchItemMenu(){
        System.out.println("Masukkan "+searchKey);
        searchValue = sc.nextLine();
        Enumeration res = items.getItem(searchKey, searchValue).elements() != null ? items.getItem(searchKey, searchValue).elements():null;
//        -----------------------------------------
//        NO | Nama Barang
//        -----------------------------------------
//        
        oh.table.setColumnSpace(tableWidth).header(new String[]{
            Item.AttrNames()[0],
            Item.AttrNames()[3],
            Item.AttrNames()[4]
        });
        if(!res.equals(null)){
            while (res.hasMoreElements()) {
                Item nextItem = (Item) res.nextElement();
                oh.table.row(new String[]{
                    nextItem.getVal(Item.AttrName(0)).toString(),
                    nextItem.getVal(Item.AttrName(3)).toString(),
                    nextItem.getVal(Item.AttrName(4)).toString()
                });
            }
        }else{
            
        }
        
        System.out.println("Masukkan No Barang Yang Dipilih :");
    }
}