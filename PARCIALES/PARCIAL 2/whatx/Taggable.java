import java.util.ArrayList; 
/**
 * Le permite configurar diferentes etiquetas para agrupar elementos relacionados con temas en común (Ej: proveedores,
clientes premium, entre otras). Se podrán relacionar chats y otros usuarios a las etiquetas definidas, teniendo en cuenta:
○ De cada etiqueta se define: nombre y color.
○ No pueden existir etiquetas con el mismo nombre (criterio de unicidad).
○ Cada empresa configura sus propias etiquetas.

 */
public abstract class Taggable
{
    // instance variables - replace the example below with your own
    private ArrayList<Tag> tags;

    /**
     * Constructor for objects of class Taggable
     */
    public Taggable()
    {
        
    }
    /**
     * Asocia las etiquetas que ingresan con las ya guardadas.
     * @param tags- ArrayList<Tag>
     */
    public void tag(ArrayList<Tag>tags){
        this.tags=tags;
    }

}
