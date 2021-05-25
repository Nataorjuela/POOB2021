 

public class Simple extends Product {
    private int unitPrice;
    private int stock;
    
    public void unitsSold(int units){
    }
    /**
     * en este metodo se calcula  el número de unidades que se pueden vender del producto
     * @return int stock valor de las unidades que se pueden vender
     * @exception AVAILABLE_ERROR  Si no es posible calcular por error en los datos (existencias negativas o producto mal definido).
     * @exception PRICE_PROBLEM Si el producto no se puede vender porque todavía no se conoce su precio 

     */
     public int available()throws GinkoException{
         if(unitPrice<0){
            throw new GinkoException(GinkoException.PRICE_PROBLEM);
         }
         if(stock<0){
            throw new GinkoException(GinkoException.AVAILABLE_ERROR);
         }
         return stock;
    }
}
