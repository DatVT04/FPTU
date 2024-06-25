/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author VuxD4t
 */
public class BinarySearch {
    private int[] array;

    public BinarySearch() {
    }
    
    public BinarySearch(int[] array) {
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
    
    void sort(int[]array){
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }    
        }
    }

    @Override
    public String toString() {
        
        return ""+Arrays.toString(array);
    }
    
    public int binarySearch(int key){
        int l = 0;
        int r = array.length-1;
        while(l<=r) {
            int m = (l + r)/2;
            if(array[m]==key){
                return m;
            }else if(array[m]<key){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
}
