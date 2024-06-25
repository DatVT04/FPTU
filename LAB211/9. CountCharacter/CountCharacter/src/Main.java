/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author VuxD4t
 */
public class Main {
    public static void main(String[] args) {
        Validator valid = new Validator();
        String input = valid.inputString("Enter your content: ");
        
        String[] words = input.trim().split(" ");
        
        Map<String, Integer> wordCount = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (char ch : input.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }
        
        System.out.println(wordCount);
        System.out.println(charCount);
    }
    
}
