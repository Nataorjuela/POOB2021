 

public class ProductLine {
	private int quantity;
	private int unitPrice;
	private Product product;
	
	public Product getProduct(){
	    return product;
	}
	
	public int subTotal(){
	    return quantity*unitPrice;
	}
}
