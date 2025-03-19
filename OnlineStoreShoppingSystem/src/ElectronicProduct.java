/****************************************************************
 *  Carolin Castro, cjc494@rutgers.edu
 *  [Creating a subclass of "Product" called "ElectronicProduct"
 *  with additional attributes]
 ****************************************************************/ 
public class ElectronicProduct extends ProductClass {
	
	// ATTRIBUTES
	protected String brand;
	protected String model;
	protected int warrantyPeriod;

    // CONSTRUCTOR
    public ElectronicProduct(int productID, String name, String description, double price, String brand, String model, int warrantyPeriod) {
    	super(productID, name, description, price);
    	this.brand = brand;
    	this.model = model;
    	this.warrantyPeriod = warrantyPeriod;
}

}
