/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;

/**
 *
 * @author VuxD4t
 */
public class Validate {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static int getInt(String messageInfo, String messageOutOfRange,
            String messageErrorNumber, int min, int max){
        do {            
            try {
                System.out.println(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }else{
                    System.out.println(messageOutOfRange);
                }
            } catch (Exception e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
}
