/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author VuxD4t
 */
public class Validator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Validator(){
        
    }
    public static int getInt(String messageInfo,String messsageErrorOutOfRange,
            String messageErrorNumber,int min,int max){
        do {            
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }else{
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
    
    public static double getDouble(String messageInfo,String messsageErrorOutOfRange,
            String messageErrorNumber,double min,double max){
        do {            
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }else{
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
    
    public static String getString(String messageInfo, String messageError, final String REGEX){
        do {            
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if(str.matches(REGEX)){
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
    
    public static Date getDate(String messageInfo,String messageErrorDate,final String REGEX){
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);
        do {            
            System.out.print(messageInfo);
            try {
                Date date = dateFormat.parse(SCANNER.nextLine());
                return date;
            } catch (ParseException e) {
                System.out.println(messageErrorDate);
            }
        } while (true);
    }
}
