import java.util.InputMismatchException;
import java.util.Scanner;

class Opinion extends BMI_Bakery {
    public void collectFeedback() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nHow was your experience at our bakery?");
        System.out.println("1. ★★★ Amazing");
        System.out.println("2. ☆★★ Good");
        System.out.println("3. ☆☆★ Bad");
        System.out.print("Choose a number from 1 to 3: ");

        try {
            int choice = scanner.nextInt();
            FeedbackRating rating = null;
            for (FeedbackRating feedback : FeedbackRating.values()) {
                if (feedback.getValue() == choice) {
                    rating = feedback;
                    break;
                }
            }

            if (rating != null) {
                System.out.println(rating.getMessage());
            } else {
                System.out.println("Please enter a number from 1 to 3.");
            }
        } catch (InputMismatchException e) {
            System.out.println("That is not a number.");
        }
    }
}
