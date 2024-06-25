/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.*;

/**
 *
 * @author tphon
 */
public class Function {

//    public void displayMenu(){
//        System.out.printf("=========Task Program========\n"
//                        +"1. Add task\n"
//                        +"2. Delete task\n"
//                        +"3. Display task\n"
//                        +"4. exit\n");
//    }
    public void displayMenu(){
        System.out.println("========Task Program=======\n"+
                "1. add\n"+
                "2. del\n"+
                "3. dispay\n"+
                "4. exit\n");
    }
    
    public void addTask(List<Task> task){
        Validation Valid = new Validation();
        
        int id = 1;
        if(!task.isEmpty()){
            id = task.get(task.size()-1).getId()+1;
        }
        
        String name = Valid.inputString("Requirement name: ");
        int idTask = Valid.inputInt("Task Type", "From 1 to 4", 1, 4);
        String date = Valid.inputDate("Date: ");
        double from = Valid.inputFrom();
        double to = Valid.inputTo(from);
        String assign = Valid.inputString("Assign: ");
        String review = Valid.inputString("Reviewer: ");
        
        while (Valid.duplicate(name, date, from, to, task)) {            
            System.err.println("Have duplicate task!! Enter time again");
            date = Valid.inputDate("Date: ");
            from = Valid.inputFrom();
            to = Valid.inputTo(from);
            
        }
        Task temp = new Task(id, name, idTask, date, from, to, assign, review);
        task.add(temp);
    }


    
    public void delTask(List<Task> task){
        Validation Valid = new Validation();
        
        System.out.println("-----------Delete Task----------");
        int id = Valid.inputInt("ID: ", "ID not exist ", 1, task.size());
        
        for (int i = task.size(); i >=id; i--) {
            Task temp = task.get(i);
            temp.setId(task.get(i).getId()-1);
            task.set(i, temp);
        }
        task.remove(id - 1);
    }
    
    public void displayTask(List<Task> task){
        System.out.println("-------------------------------------------Task-------------------------------------------------------\n"+
                "ID      Name                   Task Type         Date          Time               Assigne                 Reviewer");
        for (Task temp : task) {
            System.out.println(temp.toString());
        }
    }
    
}

