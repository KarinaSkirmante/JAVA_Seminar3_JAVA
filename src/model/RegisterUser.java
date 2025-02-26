package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class RegisterUser extends GuestUser{ //netiks veidoti objekti no šīs klases, bet šī klase tiks izmantota ka super klase
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
		if(inputUsername != null && inputUsername.matches("[A-Za-z0-9._$]{5,15}")) {
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
}
