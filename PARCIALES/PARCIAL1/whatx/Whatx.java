import java.util.ArrayList; 
/**
 * Esta clase es para poder utilizar Whatsapp desde consola en servidores que no tienen interfaz gráfica.
 * INVARIANTE:dentro del ArrayList chats ningun chat tiene el mismo chatName.
 */
public class Whatx {
    private ArrayList<Chat>chats;
    private Socket socket;
    private User owner;
    /**
     * Delete a message specifying the chat name and the message’s id.
     * @param chatName, Name of the chat which the message is for
     * @param  msgId, Id of the message to delete.
     * @return True if the message could be deleted, False otherwise.
     */
    public boolean deleteMessage( String chatName,int msgId){
        Chat chat=findChat(chatName);
        boolean deleted;
        ArrayList<User>members;
        if(chat!=null){
            deleted=chat.deleteMessage(msgId);
            if (deleted){
                members=chat.getMembers();
                for(User user:members){
                    String toPhone=user.getPhone();
                    socket.deleteMessage(toPhone,chatName,msgId);
                }
            }
        }
        return false;
    }
    /**
     * Find a chat specific
     * @param chatName, Name of the chat which the message is for
     * @return encontrado, Chat 
     */
    public Chat findChat(String chatName){
        Chat encontrado=null;
        for(Chat chat: chats){ 
            if(chat.getName().equals(chatName)){
                encontrado=chat;
            }
        }
        return encontrado;
    }
}