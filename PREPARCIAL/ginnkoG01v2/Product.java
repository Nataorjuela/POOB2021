import java.time.LocalDate; 

public abstract class Product {
	private String name;
	private String presentation;
	private String description;
	private float weight;
	private int size;
	private LocalDate createdAt;
	private LocalDate updatedAt;

	/**
	 * Actualiza los inventarios considerando las unidades vendidas
	 * (Precondicion: existen suficientes existencias para hacer la actualizacion)
	 * @param units numero de unidades vendidas
	 */
	public abstract void unitsSold(int units);
        
        /**
         * Calcula el número de unidades que se pueden vender del producto
         * @return int unidades que se pueden vender
         *
         */
        public abstract int available() throws GinkoException;
}
