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
			
			
			if(u3.login("karina.skirmante", "1234qwer"))
			{
			
				u3.createPost(PostType.publicPost, "Man patik JAVA!");
				u3.createPost(PostType.privatePost, "Man gribas majas!");
			
				System.out.println(u3.getSurname() + " privatas ziņas: " + u3.getPrivatePosts());
				System.out.println(u3.getSurname() + " publiskas ziņas: " + u3.getPublicPosts());
		
			
			}
			//TODO uztaisīt mājās arī login pārbaudi u4 jeb Business lietotajam
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
			
			
			u3.followPage("Ziedi Ventspili");
			//get(0) man iedos Ziedi ventspilī lapu
			System.out.println("Sekotaji: " +u4.getAllPagesForBusinessUser().get(0).getTitle() + "->" +
					u4.getAllPagesForBusinessUser().get(0).getAllFollowers());
			
			u4.followPrivateUser("karina.skirmante");//SIA Ziedi ventspili piesekos karina.skirmante
			
			System.out.println(u3.getSurname() + " sekotāji ir-> " + u3.getAllFollowers());
		
			
			System.out.println("Meklēju (karina) ->" +u4.findUser("karina"));
			System.out.println("Meklēju (SIA) ->" +u1.findUser("SIA"));
			System.out.println("Meklēju (a) ->" +u3.findUser("a"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TODO uztaisīt pārejās filtracijas funkcijas GuestUser klasē
		//TODO izveidot like iezīmes uzstādīšanu
		
	}

	public static ArrayList<GuestUser> getAllUsers() {
		return allUsers;
	}

	
	
	
}
