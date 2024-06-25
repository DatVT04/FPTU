/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author VuxD4t
 */
public class LinearSearch {
    private int[] array;

    public LinearSearch() {
    }
    
    public LinearSearch(int[] array) {
        this.array = array;
    }
    
    public int[] generateRandomArray(int number) throws Exception{
        if(number<=0){
            throw new Exception("Number parameter must be > 0");
        }
        array = new int[number];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]= random.nextInt(array.length);
        }
        return array;
    }

    @Override
    public String toString() {
        
        return "The array: "+Arrays.toString(array);
    }
    
    public int linearSearch(int key){
        for (int i = 0; i < array.length; i++) {
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
