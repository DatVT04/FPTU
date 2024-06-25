/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.ManagerTask;
import bo.TaskInputer;
import entity.Task;
import utils.Validator;

/**
 *
 * @author VuxD4t
 */
public class Controller {
     private ManagerTask managerTask;
    private TaskInputer inputer;

    public Controller() {
        managerTask = new ManagerTask();
    }

    public ManagerTask getManagerTask() {
        return managerTask;
    }

    public void setManagerTask(ManagerTask managerTask) {
        this.managerTask = managerTask;
    }

    public int add() throws Exception {
        inputer = new TaskInputer();
        Task task = inputer.input();
        return managerTask.add(task.getTaskTypeID(), task.getRequirementName(),
                task.getDate(), task.getPlanFrom(), task.getPlanTo(),
                task.getAssign(), task.getReviewer());
    }
    
    public Task delete() throws Exception{
        int ID = Validator.getInt("Task ID: ", "Error range!", "Invalid!",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        return managerTask.deleteTaskByID(ID);
    }
    
    public void show() throws Exception{
        String str= managerTask.toString();
        if(str==null){
            throw new Exception("This list is empty!");
        }
        System.out.println(str);
    }
}
