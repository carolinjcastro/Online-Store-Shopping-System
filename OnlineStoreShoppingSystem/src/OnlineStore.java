/****************************************************************
 *  Julie Castro, cjc494@rutgers.edu
 *  [Creating an "OnlineStore" class that manages a list of 
 *  products and user shopping carts]
 ****************************************************************/
import java.util.ArrayList;

public class OnlineStore {
	
	// DECLARING ARRAYLISTS FOR THE INSTANCES OF THE PRODUCT CLASS,
	// USERS CLASS AND THE USER SHOPPING CLASS
	public ArrayList<ProductClass> products; 
	public ArrayList<Users> users;
	public ArrayList<UserShoppingCart> userCarts;
	
	// CONSTRUCTOR TO INITIALIZE ARRAYLISTS
	public OnlineStore() {
		products = new ArrayList<>();
		users = new ArrayList<>();
		userCarts = new ArrayList<>();
	}
	
	// ADDING PRODUCTS TO THE STORE INVENTORY
	public void addProduct(ProductClass product) {
		products.add(product);
	}
	
	// REGISTERING USERS AND ASSIGNING SHOPPING CARTS
	public void registerUser(Users user) {
	    UserShoppingCart cart = new UserShoppingCart(); // Creates a new shopping cart for the user
	    userCarts.add(cart); // Adds the cart to the list of user carts
	    users.add(user); // Adds the user to the list of registered users
	    System.out.println("User " + user.getUsername() + " registered with a shopping cart.");
	}
	
	//METHOD FOR DISPLAYING AVAILABLE PRODUCTS
	public void displayAvailableProducts() {
		System.out.println("Available products: ");
		for (ProductClass product:products) {
			System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
		}
	}
	
	// METHOD TO ADD A PRODUCT TO A USER'S CART
	public void addToCart(Users user, ProductClass product) {
        int index = users.indexOf(user);
        if (index != -1 && index < userCarts.size()) {
            UserShoppingCart cart = userCarts.get(index);
            cart.addToCart(product);
        } else {
            System.out.println("User not registered or doesn't have a cart.");
        }
    }
    
    // METHOD TO HANDLE THE CHECKOUT PROCESS FOR A USER'S CART
    public void checkout(Users user) {
        int index = users.indexOf(user);
        if (index != -1 && index < userCarts.size()) {
            UserShoppingCart cart = userCarts.get(index);
            cart.checkout();
        } else {
            System.out.println("User not registered or doesn't have a cart.");
        }
    }
	
	

}
