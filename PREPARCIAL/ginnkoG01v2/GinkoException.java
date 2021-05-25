
/**
 * Write a description of class GinkoException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GinkoException extends Exception
{
    public static final String AVAILABLE_ERROR="no es posible calcular por error en los datos (existencias negativas o producto mal definido)";
    public static final String  PRICE_PROBLEM="el producto no se puede vender porque todavía no se conoce su precio";
    public static final String  NO_TODAY ="No hay ordenes aprobadas para el dia de hoy";
    /**
     * Constructor for objects of class GinkoException
     */
    public GinkoException(String mensaje)
    {
        super(mensaje);
    }
}
