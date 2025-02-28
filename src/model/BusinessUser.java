package model;

import java.util.ArrayList;

public class BusinessUser extends RegisterUser {
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private String businessName;
	private ArrayList<Page> allPagesForBusinessUser = new ArrayList<Page>();
	
	public String getBusinessName() {
		return businessName;
	}

	public ArrayList<Page> getAllPagesForBusinessUser() {
		return allPagesForBusinessUser;
	}


	public void setBusinessName(String inputBusinessName) {
		if(inputBusinessName != null && inputBusinessName.matches("[A-Za-z ]{5,30}")) {
			businessName = inputBusinessName;
		}
		else
		{
			businessName = "No business name";
		}
	}

	public BusinessUser()
	{
		super();
		setBusinessName("Testa uznemums");
	}
	
	public BusinessUser(String inputUsername, 
			String inputPassword, String inputBusinessName) {
		super(inputUsername, inputPassword);
		setBusinessName(inputBusinessName);
	}


	public String toString() {
		return businessName + ", " + super.toString();
	}
	
	@Override
	public void createPost(PostType postType, String... params) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
