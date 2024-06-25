/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author VuxD4t
 */
public class Task {

    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    public Task(int id, int taskTypeID, String requirementName, Date date,
            double planFrom, double planTo, String assign,
            String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n", getId(), getRequirementName(),
                TaskType.getTaskTypeByID(taskTypeID).getName(),
                dateFormat.format(date), getPlanTo() - getPlanFrom(), getAssign(), getReviewer());
    }

    public enum TaskType {
        CODE(1, "Code"),
        TEST(2, "Test"),
        DESIGN(3, "Design"),
        REVIEW(4, "Review");
        private int id;
        private String name;

        private TaskType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static TaskType getTaskTypeByID(int ID) {
            switch (ID) {
                case 1:
                    return CODE;
                case 2:
                    return TEST;
                case 3:
                    return DESIGN;
                case 4:
                    return REVIEW;
                default:
                    throw new AssertionError();
            }
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }
}
