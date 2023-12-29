/****************************************************************
 *  Carolin Castro, cjc494@rutgers.edu
 *  CS 102 (section 06) - Final Homework
 *  [Creating a Main class that creates two users and adds items to 
 *  the shopping cart and checkout cart]
 ****************************************************************/ 
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	// CREATING AN INSTANCE OF ONLINESTORE
        OnlineStore onlineStore = new OnlineStore();

        // CREATING PRODUCTS FOR THE STORE
        ProductClass product1 = new ProductClass(1, "Product 1", "Description 1", 20.0);
        ProductClass product2 = new ProductClass(2, "Product 2", "Description 2", 30.0);

        // ADDING PRODUCTS TO THE STORE
        onlineStore.addProduct(product1);
        onlineStore.addProduct(product2);

        // CREATING USERS
        Users user1 = new Users("Alice");
        Users user2 = new Users("Bob");

        // REGISTERING USERS
        onlineStore.registerUser(user1);
        onlineStore.registerUser(user2);

        // ADDING ITEMS TO USER'S SHOPPING CARTS FROM THE STORE INVENTORY
        onlineStore.addToCart(user1, onlineStore.products.get(0)); // Adding the first product
        onlineStore.addToCart(user1, onlineStore.products.get(1)); // Adding the second product
        onlineStore.addToCart(user2, onlineStore.products.get(1)); // Adding the second product

        // CHECKOUT FOR BOTH USERS
        onlineStore.checkout(user1);
        onlineStore.checkout(user2);
        
        try {
        	// CREATING A FILEREADER INSTANCE TO READ FROM A FILE
            FileReader fileReader = new FileReader("/Users/carolincastro/Downloads/data.txt");
            
            // CREATING A SCANNER TO PARSE THE TEXT CONTEXT
            Scanner scanner = new Scanner(fileReader);
            
            // INITIALIZING THE PRODUCT TYPE AS AN EMPTY STRING
            String productType = "";
            
            // READING EACH LINE FROM THE FILE
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // CHECKING IF THE LINE DENOTES THE TYPE OF PRODUCTS IN THE FILE
                if (line.startsWith("Product ID")) {
                    productType = line.contains("Warranty Period") ? "Electronic" : "Clothing";
                    continue;  //MOVING TO THE NEXT LINE
                }
                
                // SPLITTING THE LINE INTO PARTS BASED ON COMMAS AND SPACE
                String[] parts = line.split(", ");
                
                // IF THE PRODUCT TYPE IS ELECTRONIC, EXTRACTS THE PRODUCT DETAILS AND CREATES AN ELECTRONIC PRODUCT INSTANCE
                if (productType.equals("Electronic")) {
                    int productId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String description = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String brand = parts[4];
                    String model = parts[5];
                    int warrantyPeriod = Integer.parseInt(parts[6]);
                    
                    // CREATES AN ELECTRONIC PRODUCT OBJECT AND ADDS IT TO THE USER'S 1 CART
                    ElectronicProduct electronicProduct = new ElectronicProduct(productId, name, description, price, brand, model, warrantyPeriod);
                    onlineStore.addToCart(user1, electronicProduct);
                } // IF THE PRODUCT TYPE IS CLOTHING, EXTRACTS PRODUCT DETAILS AND CREATES A CLOTHING PRODUCT INSTANCE
                else if (productType.equals("Clothing")) {
                    int productId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String description = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    double size = Double.parseDouble(parts[4]);
                    String material = parts[5];
                    String availableColors = parts[6];
                    
                    // CREATES A CLOTHING PRODUCT OBJECT AND ADDS IT TO USER'S 1 CART
                    ClothingProduct clothingProduct = new ClothingProduct(productId, name, description, price, size, material, availableColors);
                    onlineStore.addToCart(user1, clothingProduct);
                }
            }
            
            // CLOSING FILE READER
            fileReader.close();
            
          // CATCHING ANY IOEXCEPTION THAT MIGHT OCCUR DURING FILE HANDLING
        } catch (IOException e) {
           System.out.println("There has been an error during file handling");
        }

        
   
        
    }
        
}
