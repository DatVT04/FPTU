
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    public String inputDate(String str) {
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

    public double inputDouble(String msg, String wrongMsg, double MIN, double MAX) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(msg);
            try {
                double temp = Double.parseDouble(scan.nextLine().trim());
                if (temp < MIN || temp > MAX) {
                    throw new NumberFormatException();
                }
                return temp;
            } catch (NumberFormatException e) {
                System.err.println(wrongMsg);
            }
        }

    }
    
}
