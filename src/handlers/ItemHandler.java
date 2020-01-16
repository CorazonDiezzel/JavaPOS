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
    Table table = new Table();
    Scanner sc = new Scanner(System.in);
    MItem items = new MItem();
    int tableWidth[] = {10,50,20};
    String searchKey;
    String searchValue = "";
    
    public Item showSearchItemMenu(){
        searchKey = Item.AttrName(3);
        System.out.println("Masukkan "+searchKey);
        searchValue = sc.nextLine();
        Enumeration res = items.getItem(searchKey, searchValue) != null ? items.getItem(searchKey, searchValue).elements():null;
        Boolean found = res.hasMoreElements();
        table.setColumnSpace(tableWidth).header(new String[]{
            Item.AttrNames()[0],
            Item.AttrNames()[3],
            Item.AttrNames()[4]
        });
        if(res !=null){
            while (res.hasMoreElements()) {
                Item nextItem = (Item) res.nextElement();
                table.row(new String[]{
                    nextItem.getVal(Item.AttrName(0)).toString(),
                    nextItem.getVal(Item.AttrName(3)).toString(),
                    nextItem.getVal(Item.AttrName(4)).toString()
                });
            }
        }else{
            
        }
        System.out.println("Masukkan No Barang Yang Dipilih :");
        return items.getItem(searchKey, sc.next()).elementAt(0);
    }
    public void addItem(){
        System.out.println("Masukkan "+Item.AttrNames()[0]+" : ");
        sc.next();
        
    }
}