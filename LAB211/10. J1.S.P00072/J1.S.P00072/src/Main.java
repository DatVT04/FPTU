
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Account> list = new ArrayList<>();
        function ob = new function();
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.checkIntLimit(1, 3);
            switch (choice) {
                case 1:
                    ob.addAccount(list);
                    break;
                case 2:
                    ob.login(list);
                    break;
                case 3:
                    return;
            }
        }
    }
}
