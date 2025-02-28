package model;

import java.util.ArrayList;

public class PrivateUser extends RegisterUser{
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private String name;
	private String surname;
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<RegisterUser> allFollowers = new ArrayList<RegisterUser>();
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	

	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}

	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}

	public ArrayList<RegisterUser> getAllFollowers() {
		return allFollowers;
	}

	public void setName(String inputName) {
		if(inputName != null 
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?"))
		{
			name = inputName;
		}
		else
		{
			name = "unknown";
		}
	}
	
	public void setSurname(String inputSurname) {
		if(inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([-][A-Z]{1}[a-z]{3,10})?"))
		{
			surname = inputSurname;
		}
		else
		{
			surname = "unknown";
		}
	}

	public PrivateUser() {
		super();//RegisterUser bezargumenta konstruktora izsaukums
		setName("Testa");
		setSurname("Indlietotajs");
	}

	public PrivateUser(String inputUsername, String inputPassword, String inputName,
			String inputSurname)
	{
		super(inputUsername, inputPassword);
		setName(inputName);
		setSurname(inputSurname);
	}

	
	public String toString() {
		return name + " " + surname + ", " + super.toString();
	}
	
	//params[0] -  zinas teksts
	@Override
	public void createPost(PostType postType, String... params) throws Exception{
		if(postType != null && params != null) {
			if(params.length != 0) {
				Post newPost = new Post(params[0]);
				if(postType.equals(PostType.privatePost)) {
					privatePosts.add(newPost);
				}
				else if(postType.equals(PostType.publicPost)) {
					publicPosts.add(newPost);
				}
				
			}
			else
			{
				throw new Exception("Message text is necessary");
			}
		}
		else
		{
			throw new NullPointerException("Params should be with real reference");
		}
		
	}

}
