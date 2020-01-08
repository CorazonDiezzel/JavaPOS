/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

/**
 *
 * @author Dharm
 */
public class OutputHandler {
    int displayWidth = 80; //Default

    public OutputHandler() {
    }
    public OutputHandler(int width) {
        this.displayWidth = width;
    }
    public Table table = new Table(displayWidth);
}
class Table{
    int width,row,colSpaces[];
    Table(int w){
        this.width = w;
    }
    
    public Table setColumnSpace(int[] cs){
        this.colSpaces = cs;
        return this;
    }
    public Table header(String head[]){
        for(int i=0;i<=width;i++){
            System.out.print("=");
        }
        row(head);
        for(int i=0;i<=width;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        return this;
    }
    
    public Table row(String col[]){
        System.out.print("\n");
        for (int i=0;i<col.length;i++) {
            System.out.printf("|%"+(colSpaces[i]-1)+"s",col[i]);
        }
        System.out.print("\n");
        return this;
    }
    
}