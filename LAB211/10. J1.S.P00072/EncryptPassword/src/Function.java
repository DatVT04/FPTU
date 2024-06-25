
import com.sun.beans.finder.MethodFinder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.xml.bind.DatatypeConverter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VuxD4t
 */
public class Function {
    public void displayMenu(){
        System.out.println("========Login Program=======\n"+
                "1. Add User\n"+
                "2. Login\n"+
                "3. Exit\n");
    }
//    public String MD5Encryption(String password) {
//        try {
//            //Tạo một đối tượng MessageDigest cho thuật toán MD5.
//            //đối số MD5 (Message Digest 5) chỉ định thuật toán băm (hash) sẽ được sử dụng để tính toán giá trị băm cho dữ liệu đầu vào. 
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            //Cập nhật đối tượng MessageDigest với chuỗi mật khẩu đã được chuyển đổi thành mảng byte.
//            md.update(password.getBytes());
//            // Chuyển đổi mảng byte kết quả thành chuỗi hexa và đưa về dạng chữ thường.
//            String myHash = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
//            return myHash;
//        } catch (NoSuchAlgorithmException ex) {
////            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
////        return null;
//    }
    public String MD5Encryption(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            String myHash = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
            return myHash;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void addAccount(List<Account> account) {
        Validation Valid = new Validation();
        
        String username = Valid.checkInputUsername(account, "Enter Username: ");
        String password = Valid.inputString("Password: ");
        
//        System.out.println("My Hash: " + MD5Encryption(password));
        
        String name = Valid.inputString("Enter name: ");
        
        String phone = Valid.checkInputPhone("Enter phone: ");
        
        String email = Valid.checkInputEmail("Enter email: ");
        
        String address = Valid.inputString("Enter address: ");
        
        String dateOfBirth = Valid.inputDate("Enter Date Of Birth: ");

        if (Valid.duplicate(account, email, phone)) {
            account.add(new Account(username, MD5Encryption(password), name, phone, email, address, dateOfBirth));
            System.err.println("Add success!!!");
        }
    }
    
//    public void login(List<Account> account) {
//        Validation Valid = new Validation();
//        if (account.isEmpty()) {
//            System.err.println("Account empty.");
//            return;
//        }
//        String username = Valid.inputString("Enter Username: ");
//        String password = Valid.inputString("Enter Password: ");
////        Account accountLogin = findAccount(list, username, password);
//
//        Account accountLogin = null;
//        for (Account acc : account) {
//            if (username.equals(acc.getUsername())) {
//                if (MD5Encryption(password).equals(acc.getPassword())) {
//                    accountLogin = acc;
//                    break;
//                }
//            }
//        }
//        if (accountLogin != null) {
//            changePassword(accountLogin);
//        } else {
//            System.err.println("Invalid username or password.");
//        }
//    }
    public void login(List<Account> account){
        Validation Valid = new Validation();
        if(account.isEmpty()){
            System.err.println("Account empty");
            return;
        }
        String username = Valid.inputString("Enter username: ");
        String password = Valid.inputString("Enter password: ");
        Account accountLogin = null;
        for (Account acc : account) {
            if(username.equals(acc.getUsername())){
                if(password.equals(acc.getPassword())){
                    accountLogin = acc;
                    break;
                }
            }
        }
        if(accountLogin!=null){
            changePassword(accountLogin);
        }else{
            System.err.println("Invalid username or password");
        }
    }
//    public void changePassword(Account acc) {
//        Validation Valid = new Validation();
//        String choice = Valid.inputString("Hello "+ acc.getName()+", Do you want to change password now? Y/N: ");
//
//        if (choice.trim().equalsIgnoreCase("Y")) {
//            String newPassword = getNewPassword(acc);
//            if (newPassword != null) {
//                acc.setPassword(newPassword);
//                System.out.println("Change password success!!");
//            }
//        }
//    }
    public void changePassword(Account acc){
        Validation Valid = new Validation();
        String choice = Valid.inputString("Hello "+acc.getName()+"Do you want to change password now?");
        if(choice.trim().equalsIgnoreCase("Y")){
            String newPassword = getNewPassword(acc);
            if(newPassword!=null){
                acc.setPassword(newPassword);
                System.out.println("Chagne password success");
            }
        }
    }
    
//    public String getNewPassword(Account acc) {
//        Validation Valid = new Validation();
//        while (true) {
//            try {
//                String oldPassword = Valid.inputString("Enter old password: ");
//                if (!MD5Encryption(oldPassword).equalsIgnoreCase(acc.getPassword())) {
//                    throw new Exception("Old password incorrect.");
//                }
//                String newPassword;
//                while (true) {
//                    newPassword = Valid.inputString("Enter new password: ");
//                    if (!MD5Encryption(newPassword).equalsIgnoreCase(acc.getPassword())) {
//                        break;
//                    }
//                    System.err.println("New password must be different from old password.");
//                }
//
//                String renewPassword;
//                while (true) {
//                    renewPassword = Valid.inputString("Re-enter new password: ");
//                    if (newPassword.trim().equalsIgnoreCase(renewPassword.trim())) {
//                        break;
//                    }
//                    System.err.println("New password and Renew password not the same.");
//                }
//
//                return MD5Encryption(newPassword);
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
    public String getNewPassword(Account acc){
        Validation Valid = new Validation();
        while (true) {            
            try {
                String oldPassword = Valid.inputString("Enter old password: ");
                if(!MD5Encryption(oldPassword).equalsIgnoreCase(acc.getPassword())){
                    throw new Exception("Oldpassword incorrect");
                }
                String newPassword;
                while (true) {                    
                    newPassword = Valid.inputString("Enter newpassword: ");
                    if(!MD5Encryption(newPassword).equalsIgnoreCase(acc.getPassword())){
                        break;
                    }else{
                        System.err.println("Old password and new password must be different");
                    }
                }
                String renewPassword;
                while (true) {                    
                    renewPassword = Valid.inputString("Re-enter new password: ");
                    if(newPassword.trim().equalsIgnoreCase(renewPassword.trim())){
                        break;
                    }
                    System.err.println("Not the same");
                }
                return MD5Encryption(newPassword);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
