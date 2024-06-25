
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VuxD4t
 */
public class Validation {
    public int inputInt(String msg, String wrongMsg, int MIN, int MAX) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(msg);
            try {
                int temp = Integer.parseInt(scan.nextLine().trim());
                if (temp < MIN || temp > MAX) {
                    throw new NumberFormatException();
                }
                return temp;
            } catch (NumberFormatException e) {
                System.err.println(wrongMsg);
            }
        }

    }
    public String inputString(String str) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(str);
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new Exception("String can't be empty!!!");
                }
                return input;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public String inputDate(String str){
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {            
            System.out.print(str);
            try {
                Date date = dateFormat.parse(scan.next());
                return dateFormat.format(date);
            } catch (ParseException e) {
                System.err.println("Enter with date format dd-MM-yyyy");
            }
        }
    }
//    public String checkInputPhone(String str) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print(str);
//        while (true) {
//            String result = scan.nextLine().trim();
//            if (result.length() != 0 && result.matches("^\\d{10,11}$")) {
//                return result;
//            } else {
//                System.err.println("Re-input");
//            }
//        }
//    }
    public String checkInputPhone(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() != 0 && result.matches("^\\d{10,11}$")) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }
    
//    public String checkInputEmail(String str) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print(str);
//        while (true) {
//            String result = scan.nextLine().trim();
//            if (result.length() != 0 && result.matches("^^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$")) {
//                return result;
//            } else {
//                System.err.println("Re-input");
//            }
//        }
//    }
    public String checkInputEmail(String str){
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.length()!=0&&result.matches("^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$")){
                return result;
            }else{
                System.err.println("Re-input");
            }
        }
    }
    
//    public String checkInputUsername(List<Account> account, String str) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print(str);
//        while (true) {
//            String result = scan.nextLine().trim();
//            if (result.isEmpty()) {
//                System.err.println("Not empty");
//            } else {
//                boolean usernameExists = false;
//                for (Account acc : account) {
//                    if (result.equals(acc.getUsername())) {
//                        System.err.println("Username exist!!!");
//                        usernameExists = true;
//                        break;
//                    }
//                }
//                if (!usernameExists) {
//                    return result;
//                }
//            }
//        }
//    }
    public String checkInputUsername(List<Account>account, String str){
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Not empty");
            }else{
                boolean usernameExists = false;
                for (Account acc : account) {
                    if(result.equals(acc.getUsername())){
                        System.err.println("Username exist");
                        usernameExists = true;
                        break;
                    }
                }
                if(!usernameExists){
                    return result;
                }
            }
        }
    }
//    public boolean duplicate(List<Account> account, String email, String phone) {
//        for (Account temp : account) {
//            if (temp.getEmail().equals(email) || temp.getPhone().equals(phone)) {
//                System.err.println("Email or phone number already exists.");
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean duplicate(List<Account> account, String email, String phone){
        
        for (Account temp : account) {
            if (temp.getEmail().equals(email)||temp.getPhone().equals(phone)) {
                System.err.println("Email or phone already exists!!");
                return false;
            }
        }
        return true;
    }
}
