package model;

import java.util.ArrayList;

public class Page {
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private String title;
	private String description;
	private ArrayList<RegisterUser> allFollowers = new ArrayList<RegisterUser>();
	private ArrayList<Post> allPostsInPage = new ArrayList<Post>();
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<RegisterUser> getAllFollowers() {
		return allFollowers;
	}
	public ArrayList<Post> getAllPostsInPage() {
		return allPostsInPage;
	}
	
	public void setTitle(String inputTitle) {
		if(inputTitle != null && inputTitle.matches("[A-Za-z ]{5,30}")) {
			title = inputTitle;
		}
		else
		{
			title = "No title";
		}
	}
	
	public void setDescription(String inputDescription) {
		if(inputDescription != null && inputDescription.matches("[A-Za-z0-9 !?]{5,100}"))
		{
			description = inputDescription;
		}
		else
		{
			description = "No description";
		}
	}
		
	public Page() {
		setTitle("Testa");
		setDescription("Lapa");
	}
	
	public Page(String inputTitle, String inputDescription)
	{
		setTitle(inputTitle);
		setDescription(inputDescription);
	}
	
	public String toString() {
		return title + " " + description + "->" + allPostsInPage;
				
	}
	
}
