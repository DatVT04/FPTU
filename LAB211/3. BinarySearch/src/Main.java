/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VuxD4t
 */
public class Main {
    public static void main(String[] args) {
        int number=Validate.getInt("Enter number of array:","Enter number >0:",
            "Enter Integer number:", 1, Integer.MAX_VALUE);
        
    BinarySearch array= new BinarySearch();
    int []randomArray = null;
        try {
            randomArray=array.generateRandomArray(number);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        array.sort(randomArray);
        System.out.println("Sorted array: "+array.toString());
        
        BinarySearch bs=new BinarySearch(randomArray);
        
        int key=Validate.getInt("Enter search value:","Error" ,
            "Enter Integer number",Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index=bs.binarySearch(key);
        
        if(index==-1){
            System.out.println("Can not found the key");
        }else{
            System.out.println("Found "+key+" at index: "+index);
        }
    }
}
