package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.BusinessUser;
import model.GuestUser;
import model.PrivateUser;


public class MainService {
	private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

	public static void main(String[] args) {
		GuestUser u1 = new GuestUser();
		GuestUser u2 = new GuestUser();
		
		PrivateUser u3 = new  PrivateUser("karina.skirmante",
				"1234qwer", "Karina", "Skirmante");
		BusinessUser u4 = new BusinessUser("ziedu.veikals",
				"4321rewq", "SIA Ziedu veikals");
		
		allUsers.addAll(Arrays.asList(u1, u2, u3, u4));
		for(GuestUser tempU: allUsers) {
			System.out.println(tempU.getClass().getName() + "->" + tempU);
		}

	}

}
