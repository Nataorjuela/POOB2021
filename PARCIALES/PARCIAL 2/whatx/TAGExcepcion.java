
public class TAGExcepcion extends Exception{
   public static final String NOMBRE_IGUAL="Etiqueta con el mismo nombre";
   
    public TAGExcepcion(String mensaje){
        super(mensaje);
    }
}

