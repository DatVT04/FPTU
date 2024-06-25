
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VuxD4t
 */
public class Validator {
    public String inputString(String str){
        Scanner scanner = new Scanner(System.in);
        while (true) {            
            try {
                System.out.println(str);
                String input = scanner.nextLine();
                if(input == null || input.trim().isEmpty()){
                    throw new Exception("String can't be empty");
                }
                return input;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
