/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;


import entity.BaseNumber;
import entity.BaseNumber.Base;
import entity.Validator;

/**
 *
 * @author VuxD4t
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaseNumber number = null;
        
        BaseNumber inputer = new BaseNumber();
        try {
            number = inputer.input();
            int choice = Validator.getInt("Enter 1 for binary,2 for decimal,3 for hexadecimal: ",
                    "Just 1-> 3", "Invalid!", 1, 3);
            BaseNumber result = null;
            switch (choice) {
                case 1:
                    result = number.getOutputByBase(Base.BIN);
                    break;
                case 2:
                    result = number.getOutputByBase(Base.DEC);
                    break;
                case 3:
                    result = number.getOutputByBase(Base.HEX);
                    break;
            }
            System.out.println("Number after convert: " + result.getNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
