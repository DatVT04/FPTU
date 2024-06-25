/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.math.BigInteger;

/**
 *
 * @author VuxD4t
 */
public class BaseNumber {

    private Base base;
    private String number;

    public BaseNumber() {
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BaseNumber(Base base, String number) throws Exception {
        if (isValidNumber(base, number)) {
            this.base = base;
            this.number = number;
        } else {
            throw new Exception("Invalid number of base");
        }
    }

    private boolean isValidNumber(Base base, String number) {
        switch (base) {
            case BIN:
                return number.matches("[01]+");
            case DEC:
                return number.matches("[0-9]+");
            case HEX:
                return number.matches("[0-9A-F]+");

            default:
                throw new AssertionError();
        }
    }

    //Base
    public enum Base {
        DEC(10), BIN(2), HEX(16);
        private int base;

        private Base(int base) {
            this.base = base;
        }

        public static Base getBase(int type) {
            switch (type) {
                case 10:
                    return DEC;
                case 2:
                    return BIN;
                case 16:
                    return HEX;
                default:
                    throw new AssertionError();
            }
        }

        public int value() {
            return base;
        }
    }

    //BaseInputer
    public BaseNumber input() throws Exception {
        int choice = Validator.getInt("Enter 1 for binary,2 for decimal,3 for hexadecimal: ",
                "Just 1-> 3", "Invalid!", 1, 3);
        switch (choice) {
            case 1:
                base = Base.BIN;
                number = Validator.getString("Enter a number: ", "Not a valid number", "[01]+");
                break;
            case 2:
                base = Base.DEC;
                number = Validator.getString("Enter a number: ", "Not a valid number", "[0-9]+");
                break;
            case 3:
                base = Base.HEX;
                number = Validator.getString("Enter a number: ", "Not a valid number", "[0-9A-F]+");
                break;
        }
        return new BaseNumber(base, number);
    }

    //BaseNumber
//    private BaseNumber convertToDec() throws Exception {
//        int decNum = 0;
//        int base = this.base.value();
//        int power = 1; //Bien tich luy bat dau tu base ^ 0
//        for (int i = number.length() - 1; i >= 0; i--) {
//            char digit = number.charAt(i);
//            int digitValue = Character.getNumericValue(digit);
//            decNum += digitValue * power;
//            power *= base;
//        }
//        return new BaseNumber(Base.DEC, Integer.toString(decNum));
//    }
    private BaseNumber convertToDec() throws Exception{
        int decNum = 0;
        int base = this.base.value();
        int power = 1;
        for (int i = number.length()-1; i >= 0; i--) {
            char digit = number.charAt(i);
            int digitValue = Character.getNumericValue(digit);
            decNum += digitValue * power;
            power *= base;
            
        }
        return new BaseNumber(Base.DEC, Integer.toString(decNum));
    }

//    private BaseNumber convertDecToOut(Base outBase) throws Exception {
//        int decNum = Integer.parseInt(convertToDec().number);
//        StringBuilder reverseResult = new StringBuilder();
//        // Mảng ánh xạ các giá trị số dư sang ký tự tương ứng trong hệ cơ số
//        char[] baseDigits = "0123456789ABCDEF".toCharArray();
//        while (decNum != 0) {
//            int remainNum = decNum % outBase.value();
//            decNum /= outBase.value();
//            // Thêm ký tự tương ứng vào đầu chuỗi kết quả
//            reverseResult.insert(0, baseDigits[remainNum]);
//        }
//        // Kiểm tra nếu chuỗi kết quả rỗng thì thêm "0" vào đầu chuỗi
//        if (reverseResult.toString().trim().isEmpty()) {
//            reverseResult.insert(0, "0");
//        }
//
//        BaseNumber result = new BaseNumber(outBase, reverseResult.toString());
//        return result;
//    }
//
//    public BaseNumber getOutputByBase(Base outBase) throws Exception {
//        return new BaseNumber(outBase, convertDecToOut(outBase).number);
//    }
    private BaseNumber convertDecToOut(Base outBase) throws Exception{
        int decNum = Integer.parseInt(convertToDec().number);
        StringBuilder reverseResult = new StringBuilder();
        char[] baseDigits = "0123456789ABCDEF".toCharArray();
        while (decNum != 0){
            int remainNum = decNum % outBase.value();
            decNum /= outBase.value();
            reverseResult.insert(0, baseDigits[remainNum]);
        }
        if (reverseResult.toString().trim().isEmpty()) {
            reverseResult.insert(0, "0");
        }
        
        BaseNumber result = new BaseNumber(outBase, reverseResult.toString());
        return result;
        
    }
    
    public BaseNumber getOutputByBase(Base outBase) throws Exception{
        return new BaseNumber(outBase, convertDecToOut(outBase).number);
    }
}
