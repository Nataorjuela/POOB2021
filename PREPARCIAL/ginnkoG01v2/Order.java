import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
	private Integer number;
	private LocalDate createdAt;
	private int shippingCost;
	private LocalDate deliveryDate;
	private char status;
	private Schedule schedule;
	private ArrayList<ProductLine> productLines;
	

}
