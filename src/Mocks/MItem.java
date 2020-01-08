/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Item;
import java.lang.reflect.Array;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Dharm
 */
public class MItem {
    Item[] items = {
        new Item(1,4000,40,"LePen Pensil 2B","89129818273","LePen"  ,"Pensil"),
        new Item(2,4500,20,"LePen Pensil 3B","38910205860","LePen"  ,"Pensil"),
        new Item(3,5000,10,"LePen Pensil 4B","93748393759","LePen"  ,"Pensil"),
        new Item(4,5500,30,"LePen Pensil 5B","19818302840","LePen"  ,"Pensil"),
        new Item(5,5500,30,"Buku Gambar"    ,"18492837478","VinLand","Buku"),
        new Item(6,5500,30,"Buku Tulis Noob","19818302840","VinLand","Buku"),
        new Item(7,5500,30,"Buku Tulis Pro" ,"19818346240","VinLand","Buku"),
        new Item(8,5500,30,"Buku Gambar Pro"    ,"19475302840","VinLand","Buku"),
        new Item(9,5500,30,"Penghapus"      ,"19818302916","VinLand","Penghapus"),
        new Item(10,5500,30,"TipEx"         ,"19818302001","Ytd"    ,"TipEx")
    };
    
    public Vector<Item> getItem(String attrName, String attrValue){
        Vector<Item> results = new Vector<Item>();
        Stack<Item> s_results = new Stack<Item>();
//            Search Value
        Stack<String> srcVal = new Stack<>();
        String[] swords = attrValue.split(" ");
        for(String sword : swords){
            System.out.println(sword);
            srcVal.push(sword);
        }
        for (Item item : items) {
//            Item
            Stack<String> itemVal = new Stack<>();
            String[] iwords = String.valueOf(item.getVal(attrName)).split(" ");
            for(String iword : iwords){
                itemVal.push(iword);
            }
            
            srcVal.forEach((word) -> {
                if(itemVal.search(word)>0){
                    System.out.println("Item ditemukan!");
                    System.out.println(s_results.search(item));
                    if(!(s_results.search(item)>0)){
                        s_results.add(item);
                    }
                }else{
                    s_results.remove(item);
                }
            });
        }
        s_results.forEach((r) -> {
            results.add(r);
        });
        if(results.isEmpty()){
            System.out.println("Item tidak ditemukan!");
            return null;
        }
        return results;
    }
}
