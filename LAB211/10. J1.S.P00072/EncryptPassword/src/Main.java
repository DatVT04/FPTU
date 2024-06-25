
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VuxD4t
 */
public class Main {
    public static void main(String[] args) {
        Validation Valid = new Validation();
        Function Funct = new Function();
        List<Account> account = new ArrayList<>();
        
        do {            
            Funct.displayMenu();
            int choose = Valid.inputInt("Please choice one option: ", "Error! Choose again: ", 1, 3);
            switch(choose){
                case 1:
                    Funct.addAccount(account);
                    break;
                case 2:
                    Funct.login(account);
                    break;
                case 3: 
                    System.exit(0);
                    break;                                                      
            }
        } while (true);
    }
}
