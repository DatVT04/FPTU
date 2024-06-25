/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;

/**
 *
 * @author VuxD4t
 */
public class Main {

    public static void main(String[] args) {
        Function Funct = new Function();
        Validator Valid = new Validator();
        List<Expense> exp = new ArrayList<>();

        while (true) {
            Funct.displayMenu();
            int choice = Valid.inputInt("Your choice: ", "Just 1 to 4", 1, 4);
            switch (choice) {
                case 1:
                    Funct.addExp(exp);
                    break;
                case 2:
                    Funct.displayExp(exp);
                    break;
                case 3:
                    Funct.delExp(exp);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
