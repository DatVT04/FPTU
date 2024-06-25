/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VuxD4t
 */
public class Fibonacci {
    private List<BigInteger> fibonacci;

    public Fibonacci() {
        fibonacci = new ArrayList<>();
    }
    
    public void generateFibonacci(long number){
        
        for(long i = 0; i < number; i++){
            if(i==0){
            fibonacci.add(BigInteger.ZERO);
            }else if(i==1){
            fibonacci.add(BigInteger.ONE);
            }else{
            BigInteger next = fibonacci.get((int)i - 1).add(fibonacci.get((int)i - 2));
            fibonacci.add(next);
            }
        }
    }
    
    public void displayFibonacci(long number, String message){
        
        System.out.println(message);
        for (int i = 0; i < fibonacci.size(); i++) {
            System.out.print(fibonacci.get(i));
            if(i==fibonacci.size()-1){
                System.out.print(".");
            }else{
                System.out.print(", ");
            }
        }
        
    }
    
    
}
