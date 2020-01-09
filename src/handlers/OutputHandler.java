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
    
    public void printLine(char c){
        System.out.print("|");
        for(int i=0;i<=(displayWidth-2);i++){
            System.out.print(c);
        }
        System.out.print("|\n");
    }
    
    public void center(String s){
        int c = (displayWidth - s.length())/2;
        System.out.printf("%"+c+"s"+s+"%"+c+"s\n"," "," ");
    }
}
class Table extends OutputHandler{
    int colSpaces[];
    
    Table(){
        
    }
    
    public Table setColumnSpace(int[] cs){
        this.colSpaces = cs;
        return this;
    }
    public Table header(String head[]){
        printLine('-');
        row(head);
        printLine('-');
        return this;
    }
    
    public Table row(String col[]){
        for (int i=0;i<col.length;i++) {
            System.out.printf("|%"+(colSpaces[i]-1)+"s",col[i]);
        }
        System.out.print("|");
        System.out.print("\n");
        return this;
    }
    
}