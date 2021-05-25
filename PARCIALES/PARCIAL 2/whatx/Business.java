import java.util.ArrayList;

public class Business extends User{

	private String description;
	private String adress;
	private String email;
	private ArrayList<Tag> configTags;
	
	/**
	 * Create a new tag for user business
	 * @param name - Tag name
	 * @param color - Tag color
	 * @Exception NOMBRE_IGUAL
	 */
	public void createTag(String name, String color) throws TAGExcepcion{
	    for(Tag tag:configTags) {   
	        if(name.equals(tag.getName())){
	            throw new TAGExcepcion(TAGExcepcion.NOMBRE_IGUAL);
	         }
	       }
            configTags.add(new Tag(name, color));
	}
}
