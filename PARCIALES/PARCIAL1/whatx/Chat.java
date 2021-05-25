import java.util.ArrayList; 
/**
 * Esta clase permite crear un chat, eliminarlo y encontrarlo.
 */
public class Chat {
    private String name;
    private String description;
    private ArrayList<User> members;
    private ArrayList<Message> messages;
    
    public String getName(){
       return name;
    }
    public ArrayList getMembers(){
       return members;
    }
    /**
     * Delete a message specifying the message’s id.
     * @param  msgId, Id of the message to delete.
     * @return True if the message could be deleted, False otherwise.
     */
    public boolean deleteMessage(int msgId){
       Message msg=findMessage(msgId);
       boolean deleted=false;
       if(msg!=null && !msg.isRead()){
           deleted=msg.deleteMessage();
        }
       return deleted;
    } 
    /**
     * Find a message specific
     * @param msgId,Id of the Message which the message 
     * @return encontrado, Message 
     */
    public Message findMessage(int msgId){
        Message encontrado=null;
        for(Message msg: messages){
            if(msg.getId()==msgId){
                encontrado=msg;
            }
        }
        return encontrado;  
       }
}
