import java.util.ArrayList; 

public class Chat extends Taggable  {
	private String name;
	private String description;
	private ArrayList<User> members;
	private ArrayList<Message> messages;
	/**
          * Asocia las etiquetas con los miembros.
         * @param tags- ArrayList<Tag>
         * */
	public void tag(ArrayList<Tag>tags){
	   for(User member:members){
	     member.tag(tags);
	   }
	}
}
