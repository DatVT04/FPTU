/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.*;

/**
 *
 * @author tphon
 */
public class Main {

    public static void main(String[] args) {
        Validation Valid = new Validation();
        Function Funct = new Function();
        List<Task> task = new ArrayList<>();
        
        do {            
            Funct.displayMenu();
            int choose = Valid.inputInt("Choose option: ", "Error! Choose again: ", 1, 4);
            switch(choose){
                case 1:
                    Funct.addTask(task);
                    break;
                case 2:
                    Funct.delTask(task);
                    break;
                case 3: 
                    Funct.displayTask(task);
                    break;
                case 4:
                    System.exit(0);                    
            }
        } while (true);
    }
}
