package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.MainService;

public abstract class RegisterUser extends GuestUser implements IPostCreate{ //netiks veidoti objekti no šīs klases, bet šī klase tiks izmantota ka super klase
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private String username;
	private String password;
	
	 
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String inputUsername) {
		if(inputUsername != null && inputUsername.matches("[A-Za-z0-9._$]{5,25}")) {
			username = inputUsername;
		}
		else
		{
			username = "No username";
		}
	}
	
	public void setPassword(String inputPassword) {
		if(inputPassword != null && inputPassword.matches("[A-Za-z0-9!@#$%^&*() ]{8,15}"))
		{
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				password = new String(md.digest());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			password = "No password";
		}
	}
	
	public RegisterUser()
	{
		super();//Guestuser klases konstruktors
		setUsername("testa.lietotajs");
		setPassword("123qwerty");
	}
	
	public RegisterUser(String inputUsername, String inputPassword) {
		super();//Guestuser klases konstruktors
		setUsername(inputUsername);
		setPassword(inputPassword);
	}
	
	public String toString() {
		return super.toString() + ": " + username + " " + password;
	}
	
	//TODO izveidot sekojošas funkcijas
	//followPage
	public void followPage(String inputTitle) throws NullPointerException {
		if(inputTitle != null) {
			for(GuestUser tempU : MainService.getAllUsers())
			{
				if(tempU instanceof BusinessUser) {
					BusinessUser tempBU = (BusinessUser)tempU;
					for(Page tempP: tempBU.getAllPagesForBusinessUser()) {
						if(tempP.getTitle().equals(inputTitle))
						{
							tempP.getAllFollowers().add(this);
						}
					}
				}
			}
		}
		else
		{
			throw new NullPointerException("Title should be with real reference");
		}
		
	}
	//followPrivateUser
	public void followPrivateUser(String inputUsername) throws NullPointerException {
		if(inputUsername != null)
		{
			for(GuestUser tempU : MainService.getAllUsers())
			{
				if(tempU instanceof PrivateUser)
				{
					PrivateUser tempPU = (PrivateUser)tempU;
					if(tempPU.getUsername().equals(inputUsername))
					{
						tempPU.getAllFollowers().add(this);
					}
				}
			}
		}
		else
		{
			throw new NullPointerException("Username should be with real reference");
		}
	}
	
	
	//login
	
	
	
	
}
