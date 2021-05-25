import java.time.LocalDateTime;
/**
 * Esta clase permite saber si un mensaje fue leido, y permite eliminar un mensaje notificando que fue eliminado.
 */
public class Message {
    private int id;
    private String text;
    private LocalDateTime date;
    private boolean read;
    private User sender;
    private File file;
    public int getId(){
       return id;
    }
    public boolean isRead(){
       return read;
    }
    /**
     * este método elimina un mensaje notificandoq mue fue eliminado.
     * @return True si el mensaje fue eliminado.
     */
    public boolean deleteMessage(){
       text="este mensaje ha sido eliminado";
       file=null;
       return true;
    }
}
