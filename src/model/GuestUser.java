package model;

import java.util.ArrayList;

import service.MainService;

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
	
	//TODO uztaisām funjkciju, meklēt lietotājus 
	//pēc vārda vai uzvārda vai nosaukuma(ja tas ir ir biznesa lietotājs)
	public ArrayList<RegisterUser> findUser(String searchText) throws Exception{
		if(searchText == null) {
			throw new Exception("Input text should be with real reference");
		}
		
		ArrayList<RegisterUser> result = new ArrayList<RegisterUser>();
		
		for(GuestUser tempU : MainService.getAllUsers()) {
			if(tempU instanceof PrivateUser) {
				PrivateUser tempPU = (PrivateUser)tempU;
				if(tempPU.getName().contains(searchText)
			|| tempPU.getSurname().contains(searchText)
			|| tempPU.getUsername().contains(searchText))
				{
					result.add(tempPU);
				}
			}
			else if(tempU instanceof BusinessUser) {
				BusinessUser tempBU = (BusinessUser)tempU;
				if(tempBU.getBusinessName().contains(searchText)
				|| tempBU.getUsername().contains(searchText))
				{
					result.add(tempBU);
				}
			}
		}
		
		if(result.isEmpty()) {
			throw new Exception("Not found");
		}
		
		return result;
	}

}
