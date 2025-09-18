import java.util.Scanner;

    public class MainClass {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Login loginSystem = new Login();
            ProductManager productManager = new ProductManager(scanner);
            Opinion feedback = new Opinion();

            loginSystem.welcome();
            loginSystem.handleUserLogin(productManager, scanner);
            feedback.collectFeedback();

            scanner.close();
        }


    }
