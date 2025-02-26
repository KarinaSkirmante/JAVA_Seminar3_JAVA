package model;

public class GuestUser {
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private long id;
	
	private static long counter = 0;

	public long getId() {
		return id;
	}
	
	public void setId() {
		id = counter++;
	}
	
	public GuestUser() {
		setId();
	}
	
	public String toString() {
		return id + "";
	}
	
	//TODO pabeigt ar filtrācijas funkcijā

}
