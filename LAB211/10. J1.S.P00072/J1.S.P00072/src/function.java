
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

public class function {

    public String MD5Encryption(String password) {
        try {
            //Tạo một đối tượng MessageDigest cho thuật toán MD5.
            //đối số MD5 (Message Digest 5) chỉ định thuật toán băm (hash) sẽ được sử dụng để tính toán giá trị băm cho dữ liệu đầu vào. 
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Cập nhật đối tượng MessageDigest với chuỗi mật khẩu đã được chuyển đổi thành mảng byte.
            md.update(password.getBytes());
            // Chuyển đổi mảng byte kết quả thành chuỗi hexa và đưa về dạng chữ thường.
            String myHash = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
            return myHash;
        } catch (NoSuchAlgorithmException ex) {
//            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
//        return null;
    }

    public void addAccount(ArrayList<Account> list) {
        String username = Validation.checkInputUsername(list, "Enter Username: ");
        String password = Validation.checkInputString("Enter Password: ");
        System.out.println("My Hash: " + MD5Encryption(password));
        String name = Validation.checkInputString("Enter Name: ");
        String phone = Validation.checkInputPhone("Enter Phone: ");
        String email = Validation.checkInputEmail("Enter email: ");
        String address = Validation.checkInputString("Enter address: ");
        String dateOfBirth = Validation.checkInputDate("Enter Date Of Birth: ");

        if (Validation.checkUniqueEmailAndPhone(list, email, phone)) {
            list.add(new Account(username, MD5Encryption(password), name, phone, email, address, dateOfBirth));
            System.err.println("Add success!!!");
        }
    }

    public void login(ArrayList<Account> list) {
        if (list.isEmpty()) {
            System.err.println("Account empty.");
            return;
        }
        String username = Validation.checkInputString("Enter username: ");
        String password = Validation.checkInputString("Enter Password: ");
//        Account accountLogin = findAccount(list, username, password);

        Account accountLogin = null;
        for (Account acc : list) {
            if (username.equals(acc.getUsername())) {
                if (MD5Encryption(password).equals(acc.getPassword())) {
                    accountLogin = acc;
                    break;
                }
            }
        }
        if (accountLogin != null) {
            changePassword(accountLogin);
        } else {
            System.err.println("Invalid username or password.");
        }
    }

//    public Account findAccount(ArrayList<Account> list, String username, String password) {
//        for (int i = 0; i < list.size(); i++) {
//            if (username.equals(list.get(i).getUsername())) {
//                if (MD5Encryption(password).equals(list.get(i).getPassword())) {
//                    return list.get(i);
//                } else {
//                    return null;
//                }
//            }
//        }
//        return null;
//    }
    public void changePassword(Account accountLogin) {
        String choice = Validation.checkInputString("Hello "+ accountLogin.getName()+" Do you want to change password now? Y/N: ");

        if (choice.trim().equalsIgnoreCase("Y")) {
            String newPassword = getNewPassword(accountLogin);
            if (newPassword != null) {
                accountLogin.setPassword(newPassword);
                System.out.println("Change password success");
            }
        }
    }

    public String getNewPassword(Account accountLogin) {
        while (true) {
            try {
                String oldPassword = Validation.checkInputString("Enter old password: ");
                if (!MD5Encryption(oldPassword).equalsIgnoreCase(accountLogin.getPassword())) {
                    throw new Exception("Old password incorrect.");
                }
                String newPassword;
                while (true) {
                    newPassword = Validation.checkInputString("Enter new password: ");
                    if (!MD5Encryption(newPassword).equalsIgnoreCase(accountLogin.getPassword())) {
                        break;
                    }
                    System.err.println("New password must be different from old password.");
                }

                String renewPassword;
                while (true) {
                    renewPassword = Validation.checkInputString("Re-enter new password: ");
                    if (newPassword.trim().equalsIgnoreCase(renewPassword.trim())) {
                        break;
                    }
                    System.err.println("New password and Renew password not the same.");
                }

                return MD5Encryption(newPassword);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
