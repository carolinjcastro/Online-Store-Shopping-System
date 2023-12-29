
import java.util.ArrayList;

public class UserShoppingCart implements ShoppingCart {
	
	// DECLARING A CART PRODUCT ARRAYLIST
	private ArrayList<ProductClass> cartProducts;
	
	// CONSTRUCTOR INITIALIZING THE CART PRODUCTS ARRAYLIST
	public UserShoppingCart() {
		cartProducts = new ArrayList<>();
	}
	
	// IMPLEMENTING THE ADDTOCART METHOD FROM THE SHOPPINGCART INTERFACE
	@Override
	public void addToCart(ProductClass product) {
		cartProducts.add(product);
		System.out.println(product.getName() + " added to cart");
	}
	
	//DISPLAYING THE CART
	public void displayCart() {
		System.out.println("Products in the cart: ");
		for(ProductClass product:cartProducts) {
			System.out.println("- " + product.getName());
		}
	}
	
	// IMPLEMENTING THE CHECKOUT METHOD FROM THE SHOPPINGCART INTERFACE
	@Override
	public void checkout() {
		double totalPrice = 0.0;
		for (ProductClass product : cartProducts) {
			totalPrice += product.getPrice();
		}
		System.out.println("The total price of items in the cart is: $" + totalPrice);
		
	}
	
	//OVERLOADED ADDTOCART METHOD FOR CLOTHING PRODUCT
    public void addToCart(ClothingProduct clothingProduct) {
        cartProducts.add(clothingProduct);
        System.out.println(clothingProduct.getName() + " (Clothing) added to cart");
    }

    // OVERLOADED ADDTOCART METHOD FOR ELECTRONIC PRODUCT
    public void addToCart(ElectronicProduct electronicProduct) {
        cartProducts.add(electronicProduct);
        System.out.println(electronicProduct.getName() + " (Electronic) added to cart");
    }
	

}
