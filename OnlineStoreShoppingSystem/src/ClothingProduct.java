/****************************************************************
 *  Julie Castro, cjc494@rutgers.edu
 *  [Creating a subclass of "Product" called "ClothingProduct"
 *  with additional attributes]
 ****************************************************************/ 
public class ClothingProduct extends ProductClass {
	
	// ATTRIBUTES
	protected double size;
	protected String material;
	protected String availableColors;
	
	// CONSTRUCTOR
	public ClothingProduct(int productID, String name, String description, double price, double size, String material, String availableColors) {
		super(productID, name, description, price);
		this.size = size;
		this.material = material;
		this.availableColors = availableColors;
	}

}
