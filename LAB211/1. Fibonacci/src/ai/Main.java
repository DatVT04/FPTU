/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ai;

import ao.Fibonacci;

/**
 *
 * @author VuxD4t
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long maxN = 50;
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.generateFibonacci(maxN);
        fibonacci.displayFibonacci(maxN, "The "+maxN+" sequence fibonacci: ");
        // TODO code application logic here
    }
    
}
