import java.util.ArrayList;

public class Manufactured extends Product {
	private int addedValue;
	private ArrayList<Product> products;
	public void unitsSold(int units) {
	}
	/**
	 * Calcula el número de unidades que se pueden vender del producto
	 * @return int unidades que se pueden vender 
	 * @exception GinnkoException
         * AVAILABLE_ERROR Si no es posible calcular por error en los datos (existencias negativas o producto mal definido).
         * PRICE_PROBLEM Si el producto no se puede vender porque todavía no se conoce su precio
	 */
        public int available() throws GinkoException{
            int min = 9999999;
             for(int i=0;i<products.size();i++){
                 if (products.get(i).available() < min)
                 {
                     min = products.get(i).available();
                 }
            }
            if (min<0)
            {
                throw new GinkoException(GinkoException.AVAILABLE_ERROR);
             }
            if (addedValue<0){
                throw new GinkoException(GinkoException.PRICE_PROBLEM);
            }
            return min;
        }
 }

