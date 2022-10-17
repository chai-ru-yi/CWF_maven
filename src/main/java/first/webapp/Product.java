package first.webapp;
public class Product {
	protected String product_name;
	protected String description;
	protected double price;
	protected String mask_type;
	protected String face_type;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMask_type() {
		return mask_type;
	}
	public void setMask_type(String mask_type) {
		this.mask_type = mask_type;
	}
	public String getFace_type() {
		return face_type;
	}
	public void setFace_type(String face_type) {
		this.face_type = face_type;
	}
	public Product(String product_name, String description, double price, String mask_type, String face_type) {
		super();
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.mask_type = mask_type;
		this.face_type = face_type;
	}
	
	
	
	
	
	
	
}
