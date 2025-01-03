/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author VuxD4t
 */
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    //input
    public Matrix input(String messInfor, int row, int col) {
        Matrix matrix = new Matrix(); //Khởi tạo đối tượng
        matrix.setRows(row);//Đặt số hàng và cột cho ma trận
        matrix.setCols(col);
        int data[][] = new int[row][col];//Tạo mảng hai chiều để lưu dữ liệu của ma trận
        for (int i = 0; i < row; i++) {//Sử dụng hai vòng lặp lồng nhau để nhập dữ liệu cho từng phần tử của ma trận
            for (int j = 0; j < col; j++) {
                data[i][j] = Validator.getInt(messInfor + String.format("[%d][%d]: ", i + 1, j + 1),
                        "Error range!", "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        matrix.setData(data);//Đặt dữ liệu cho đối tượng
        return matrix;
    }

    //String
    public String toString() {
        String str = "";//Khởi tạo chuỗi rỗng
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += String.format("[%d]", data[i][j]);
                /*
                tạo một chuỗi đại diện cho giá trị của phần tử tại vị trí [i][j] trong ma trận và nối vào biến str.
                */
            }
            str += "\n";
        }
        return str;
    }

    
    //Add
    public void add() {
        Matrix matrix1, matrix2; //Khai báo các biến ma trận
        Matrix result = new Matrix();
        
        System.out.println("---------------Addition---------------------");
        
        //Nhập số hàng và cột cho matrix1:
        int rows = Validator.getInt("Enter rows matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        int cols = Validator.getInt("Enter cols matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        matrix1 = input("Enter matrix1 ", rows, cols);//Gọi phương thức input để nhập dữ liệu cho matrix1 từ người dùng
        
        
        while (true) {
            rows = Validator.getInt("Enter rows matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);
            cols = Validator.getInt("Enter cols matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);
            //điều kiện khi 2 ma trận cộng
            if (matrix1.getRows() != rows || matrix1.getCols() != cols) {
                System.out.println("rows anh cols in two matrix must be the same");
            } else {
                matrix2 = input("Enter matrix2 ", rows, cols);
                break;
            }
        }
        
        //Tạo một mảng hai chiều dataResult để lưu kết quả phép cộng.
        int[][] dataResult = new int[matrix1.getRows()][matrix2.getCols()];
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                dataResult[i][j] = matrix1.getData()[i][j] + matrix2.getData()[i][j];
            }
        }
        System.out.println(matrix1.toString() + "+");
        System.out.println(matrix2.toString() + "=");
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        System.out.println(result);
    }

    
    //Subtract: giống như hàm + khác mỗi dấu - 
    public void subtract() {
        Matrix matrix1, matrix2;
        Matrix result = new Matrix();
        System.out.println("---------------Addition---------------------");
        int rows = Validator.getInt("Enter rows matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        int cols = Validator.getInt("Enter cols matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        matrix1 = input("Enter matrix1 ", rows, cols);
        while (true) {

            rows = Validator.getInt("Enter rows matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);
            cols = Validator.getInt("Enter cols matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);

            if (matrix1.getRows() != rows || matrix1.getCols() != cols) {
                System.out.println("rows anh cols in two matrix must be the same");
            } else {
                matrix2 = input("Enter matrix2 ", rows, cols);
                break;
            }
        }
        int[][] dataResult = new int[matrix1.getRows()][matrix2.getCols()];
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                dataResult[i][j] = matrix1.getData()[i][j] - matrix2.getData()[i][j];
            }
        }
        System.out.println(matrix1.toString() + "-");
        System.out.println(matrix2.toString() + "=");
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        System.out.println(result.toString());
    }

    
    //Multiply: nhân
    public void multiply() {
        Matrix matrix1, matrix2;
        Matrix result = new Matrix();
        System.out.println("---------------Addition---------------------");
        int rows = Validator.getInt("Enter rows matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        int cols = Validator.getInt("Enter cols matrix1: ", "Out of range",
                "Enter integer number", 1, Integer.MAX_VALUE);
        matrix1 = input("Enter matrix1 ", rows, cols);
        while (true) {

            rows = Validator.getInt("Enter rows matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);
            cols = Validator.getInt("Enter cols matrix2: ", "Out of range",
                    "Enter integer number", 1, Integer.MAX_VALUE);
            
            //Điều kiện để nhân: cột matrix1 = hàng matrix2
            if (matrix1.getCols() != rows) {
                System.out.println("rows matrix1 must be the same with cols matrix2");
            } else {
                matrix2 = input("Enter matrix2 ", rows, cols);
                break;
            }
        }
        int[][] dataResult = new int[matrix1.getRows()][matrix2.getCols()];
        
        //3 vòng lặp
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix2.getCols(); j++) {
                for (int k = 0; k < matrix1.getCols(); k++) {
                    dataResult[i][j] += matrix1.getData()[i][k] * matrix2.getData()[k][j];

                }

            }
        }
        System.out.println(matrix1.toString() + "*");
        System.out.println(matrix2.toString() + "=");
        result.setRows(matrix1.getRows());
        result.setCols(matrix2.getCols());
        result.setData(dataResult);
        System.out.println(result);
    }
}
