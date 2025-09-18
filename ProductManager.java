import java.util.Scanner;

public class ProductManager extends BMI_Bakery {
    private String[] products; // Array for product codes (or names)
    private String[] cart;     // Array for cart items (product codes)
    private int productCount; 
    private int cartCount; 
    private Scanner scanner; 

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
        products = new String[5]; 
        cart = new String[10]; 
        productCount = 0;
        cartCount = 0;
        initializeProducts(); // Populate the product list
    }

    private void initializeProducts() {
        // A 2D array containing product data
        String[][] productData = {
            {"111", "Pancake 🥞", "3.0"},
            {"201", "Pizza 🍕", "5.0"},
            {"321", "Cupcake 🧁", "3.0"},
            {"222", "Croissant 🥐", "2.0"},
            {"443", "Pretzel 🥨", "1.0"}
        };

        for (int i = 0; i < productData.length; i++) {
            String code = productData[i][0];
            String name = productData[i][1];
            double price = Double.parseDouble(productData[i][2]);
            // Store product name in the products array
            products[productCount++] = code + ": " + name + " - $" + price;
        }
    }

    public void menu() {
        System.out.println("\n-------- Menu --------");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i]); // Display product details
       }
        System.out.println("----------------------");
    }
    
    

    public void order() {
        boolean continueOrdering = true;

        menu(); // Display the menu
while (continueOrdering) {
            try {
                System.out.print("Enter the product code to order: ");
                String code = scanner.nextLine();
                String orderedProduct = findProductByCode(code);

                if (orderedProduct != null) {
                    cart[cartCount++] = orderedProduct; // Add to cart
                    System.out.println("Added to cart: " + orderedProduct);
                } else {
                    System.out.println("Product not found.");
                }

                System.out.print("Do you want to order another item? (yes/no): ");
                String response = scanner.nextLine();
                continueOrdering = response.equalsIgnoreCase("yes");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Cart is full. Cannot add more items.");
                continueOrdering = false; // Stop ordering if cart is full
            }
        }

        displayCart();
    }
    

    private String findProductByCode(String code) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].startsWith(code + ":")) { // Check if product code matches
                return products[i];
            }
        }
        return null;
    }

    public void displayCart() {
        System.out.println("\n------ Your Cart ------");
        if (cartCount == 0) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;
            for (int i = 0; i < cartCount; i++) {
                String[] cartDetails = cart[i].split(" - \\$");
                System.out.println(cart[i]);
                total += Double.parseDouble(cartDetails[1]);
            }
            System.out.println("\nTotal Amount: $" + total);
        }
        System.out.println("-----------------------");
    }
}
