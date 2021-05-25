 

public class Avion extends Maquina{
	private String placa;
	private boolean enAire;
	private Marino piloto;
	private Marino copiloto;
	public boolean esDebil(){
	   boolean result=false;
	   if(piloto==null){
	     result=true;
	   }
	   return result;
	 }
	public boolean getEnAire(){
	   return enAire;
	   }
}
