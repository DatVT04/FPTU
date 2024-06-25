
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author VuxD4t
 */
public class Function {

    Validator Valid = new Validator();

    public void displayMenu() {
        System.out.println("==============Handy Expense Program=============\n"
                + "1. Add an Expense\n"
                + "2. Display all expense\n"
                + "3. Delete an Expense\n"
                + "4. Quit\n");

    }

    public void addExp(List<Expense> exp) {
        int id = 1;
        if (!exp.isEmpty()) {
            id = exp.get(exp.size() - 1).getId() + 1;

        }
        String date = Valid.inputDate("Enter date: ");
        double amount = Valid.inputDouble("Enter amount: ", "Error", 1, Double.MAX_VALUE);
        String content = Valid.inputString("Enter content: ");
        Expense temp = new Expense(id, date, content.toLowerCase(), amount);
        exp.add(temp);
    }

    public void displayExp(List<Expense> exp) {
        System.out.println("------------Display all expenses------------------\n"
                         + "ID      Date            Amount  Content");
        double sum = 0;
        for (Expense temp : exp) {
            System.out.println(temp.toString());
            sum+=temp.getNumber();
        }
        System.out.println("                 Total: " + (int) sum);
        
    }

    public void delExp(List<Expense> exp) {
        int id = Valid.inputInt("ID: ", "ID not exist! ", 1, exp.size());
        if (id != -1) {
            for (int i = exp.size() - 1; i >= id; i--) {
                Expense temp = exp.get(i);
                temp.setId(exp.get(i).getId() - 1);
                exp.set(i, temp);
            }
            exp.remove(id - 1);
            System.out.println("Delete an expense successful!");
        }

    }
}
