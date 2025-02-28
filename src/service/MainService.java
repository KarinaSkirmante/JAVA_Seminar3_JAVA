package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.BusinessUser;
import model.GuestUser;
import model.Page;
import model.PostType;
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
		
		try {
			u3.createPost(PostType.publicPost, "Man patik JAVA!");
			u3.createPost(PostType.privatePost, "Man gribas majas!");
			
			System.out.println(u3.getSurname() + " privatas ziņas: " + u3.getPrivatePosts());
			System.out.println(u3.getSurname() + " publiskas ziņas: " + u3.getPublicPosts());
		
			u4.createPage("Ziedi Ventspili", "Mana lapa par ziediem Ventspili");
			u4.createPage("Ziedi Daugavpili", "Mana lapa par ziediem Daugavpili");
			
			u4.createPost(PostType.publicPost,
					"Ventspils svetki - 20% atlaide visiem ziediem", "Ziedi Ventspili");
			u4.createPost(PostType.publicPost,"Priecigas Lieldienas",
					"Ziedi Daugavpili", "Ziedi Ventspili");
			
			for(Page tempP : u4.getAllPagesForBusinessUser())
			{
				System.out.println(tempP);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
