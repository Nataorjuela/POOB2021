 
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Store {
	private String name;
	private String identificationType;
	private int identificationNumber;
	private String email;
	private String address;
	private HashMap<Integer,Order> orders;
	private ArrayList<Benefit> benefits;
	private Zone zone;
}
