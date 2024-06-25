/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import entity.Matrix;

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
        Matrix matrix = new Matrix();

        while (true) {

            int choice = Validator.getInt("==============Caculator program=============\n"
                    + "1. Addition matrix\n"
                    + "2. Subtraction matrix\n"
                    + "3. multyply matrix\n"
                    + "4. exit\n"
                    + "Enter choice: ",
                     "Out of range", "Enter integer number", 1, 4);
            switch (choice) {
                case 1:
                    try {
                    matrix.add();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 2:
                    try {
                    matrix.subtract();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 3:
                    matrix.multiply();
                    try {
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }
}
