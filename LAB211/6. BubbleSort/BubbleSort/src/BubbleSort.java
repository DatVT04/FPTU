
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VuxD4t
 */
public class BubbleSort {
    private int[] array;
    
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
//    public String toString() {
//        String str=" [";
//        for (int i = 0; i < array.length; i++) {
//            str+=array[i];
//            if (i < array.length - 1) {
//                str+=", ";
//            } else {
//                str+="]";
//            }
//        }
//        return str;
//    }

    public String toString() {
        
        return "Sorted array: "+Arrays.toString(array);
    }
    
    public void bubbleSort(int[]array){
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
    
    public static void main(String[] args) {
        int number=Validator.getInt("Enter number of array:","Enter number >0:",
            "Enter Integer number:", 1, Integer.MAX_VALUE);
        BubbleSort array= new BubbleSort();
        int []randomArray = null;
        try {
            randomArray=array.generateRandomArray(number);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("UnSorted array: "+array.toString());
        
        array.bubbleSort(randomArray);
        System.out.println("Sorted array: "+array.toString());
    }
}
