
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID = "^\\d{10,11}$";
//    private static final String EMAIL_VALID = "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    private static final String EMAIL_VALID = "^(?=.{1,64}@)[\\w+-_]+(\\.[\\w-_]+)*@[^-][\\w_+-]+(\\.[\\w-]+)*(\\.[A-Za-z]{2,4})$";
//^(?=.{1,64}@)[\\w+][\\w+-.]*[\\w+]@[^-][\\w_+-]+(\\.[\\w-]+)*(\\.[A-Za-z]{2,4})$
    public static Scanner getScanner() {
        return sc;
    }

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputDate(String str) {
        System.out.println(str);
        while (true) {
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputPhone(String str) {
        System.out.println(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() != 0 && result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputEmail(String str) {
        System.out.println(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() != 0 && result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString(String str) {
        System.out.println(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Not empty");
            }
        }
    }

    public static String checkInputUsername(ArrayList<Account> list, String str) {
        System.out.println(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else {
                boolean usernameExists = false;
                for (Account acc : list) {
                    if (result.equals(acc.getUsername())) {
                        System.err.println("Username exist!!!");
                        usernameExists = true;
                        break;
                    }
                }
                if (!usernameExists) {
                    return result;
                }
            }
        }
    }

    public static boolean checkUniqueEmailAndPhone(ArrayList<Account> list, String email, String phone) {
        for (Account acc : list) {
            if (acc.getEmail().equals(email) || acc.getPhone().equals(phone)) {
                System.err.println("Email or phone number already exists.");
                return false;
            }
        }
        return true;
    }
}
