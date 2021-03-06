/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocks;

import entities.Item;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 *
 * @author Dharm
 */
public class MItem {
    Stack<Item> items = new Stack<>();

    public MItem() {
        items.addElement(new Item("ITM000001",4000,40,"LePen Pensil 2B","89129818273","LePen"  ,"Pensil"));
        items.addElement(new Item("ITM000002",4500,20,"LePen Pensil 3B","38910205860","LePen"  ,"Pensil"));
        items.addElement(new Item("ITM000003",5000,10,"LePen Pensil 4B","93748393759","LePen"  ,"Pensil"));
        items.addElement(new Item("ITM000004",5500,30,"LePen Pensil 5B","19818302840","LePen"  ,"Pensil"));
        items.addElement(new Item("ITM000005",5500,30,"Buku Gambar"    ,"18492837478","VinLand","Buku"));
        items.addElement(new Item("ITM000006",5500,30,"Buku Tulis Noob","19818302840","VinLand","Buku"));
        items.addElement(new Item("ITM000007",5500,30,"Buku Tulis Pro" ,"19818346240","VinLand","Buku"));
        items.addElement(new Item("ITM000008",5500,30,"Buku Gambar Pro","19475302840","VinLand","Buku"));
        items.addElement(new Item("ITM000009",5500,30,"Penghapus"      ,"19818302916","VinLand","Penghapus"));
        items.addElement(new Item("ITM000010",5500,30,"TipEx"          ,"19818302001","Ytd"    ,"TipEx"));
    }
    
    public String getNewID(){
        String gid = "ITM000000";
        int last = Integer.valueOf(new Scanner(this.items.lastElement().getVal(Item.ID).toString()).skip(Pattern.compile("[a-zA-Z]+")).next())+1;
        String subgid = gid.substring(0, gid.length()-String.valueOf(last).length()).concat(String.valueOf(last));
        return subgid;
    }
    
    public int pushItem(Item newItem){
        Item nitem = newItem;
        nitem.setItemId(getNewID());
        this.items.push(newItem);
        return 0;
    }
    
    public Vector<Item> getItem(String attrName, String attrValue){
        Vector<Item> results = new Vector<Item>();
        Stack<Item> s_results = new Stack<Item>();
//            Search Value
        Stack<String> srcVal = new Stack<>();
        String[] swords = attrValue.split(" ");
        for(String sword : swords){
            srcVal.push(sword);
        }
        items.forEach((item) -> { //Start Search Iteration;
            Stack<String> itemVal = new Stack<>();
            String[] iwords = String.valueOf(item.getVal(attrName)).split(" ");
            for(String iword : iwords){
                itemVal.push(iword);
            }
            
            srcVal.forEach((word) -> {
                if(itemVal.search(word)>0){
//                    System.out.println("Item ditemukan!");
//                    System.out.println(s_results.search(item));
                    if(!(s_results.search(item)>0)){
                        s_results.add(item);
                    }
                }else{
                    s_results.remove(item);
                }
            });
        }); //End Search Iteration;
        s_results.forEach((r) -> {
            results.add(r);
        });
        if(results.isEmpty()){
//            System.out.println("Item tidak ditemukan!");
            return null;
        }
        return results;
    }
    
}
