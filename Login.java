import java.util.ArrayList;
import java.util.Scanner;

public class Login extends BMI_Bakery {
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;

    // Constructor to initialize the user data
    public Login() {
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();

        // Adding some initial users
        usernames.add("mawda");
        passwords.add("m321");
        usernames.add("ibtihal");
        passwords.add("i321");
        usernames.add("raghda");
        passwords.add("r321");
    }

    //-------------------------------------------------------------------------------
    public void handleUserLogin(ProductManager productManager, Scanner scanner) {
        System.out.print("Do you have an account? (yes/no): ");
        String hasAccount = scanner.nextLine();

        if (hasAccount.equalsIgnoreCase("yes")) {
            loginUser(productManager, scanner);
        } else {
            createAccount(scanner);
            productManager.order();
        }
    }
    
    public boolean login(String username, String password) {
        for (int i = 0; i < usernames.size(); i++) {
            if (username.equals(usernames.get(i)) && password.equals(passwords.get(i))) {
                return true;
            }
        }
        return false;
    }
    //-------------------------------------------------------------------------------
    private void loginUser(ProductManager productManager, Scanner scanner) {
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (login(inputUsername, inputPassword)) {
            System.out.println("\n✿ Welcome back ✿");
            productManager.order();
        } else {
            System.out.println("\nLogin failed! You need to create an account.");
            System.exit(0);
        }
    }
    

    public void createAccount(Scanner scanner) {
        System.out.print("Create username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Create password: ");
        String newPassword = scanner.nextLine();

        if (usernames.contains(newUsername)) {
            System.out.println("Username already exists! Please choose a different one.");
            return;
        }

        usernames.add(newUsername);
        passwords.add(newPassword);
        System.out.println("Account created successfully!");
    }

    
}

