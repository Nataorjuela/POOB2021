 import java.util.ArrayList;

public class Unique extends Product {
	private ArrayList<Unit> units;
	public void unitsSold(int units) {
	}
	/**
         * en este metodo se calcula  el número de unidades que se pueden vender del producto
         * @return int cont valor de las unidades que se pueden vender
         * @exception AVAILABLE_ERROR  Si no es posible calcular por error en los datos (existencias negativas o producto mal definido).
         * @exception PRICE_PROBLEM Si el producto no se puede vender porque todavía no se conoce su precio 
         */
	public int available()throws GinkoException{
	   int cont=0;
	   boolean tienePrecio=true;
	   for(int i =0;i<units.size();i++){
	       if(!units.get(i).sold()){
	          cont+=1;
	          if(units.get(i).getUnitPrice()<0){
	             tienePrecio=false;
	          }
	       }
	   }
	   if(cont<0){
	      throw new GinkoException(GinkoException.AVAILABLE_ERROR);
	   }
	   if(!tienePrecio){
	       throw new GinkoException(GinkoException.PRICE_PROBLEM);
	   }
	   return cont;
	}
}
