package package_homework_4.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import package_homework_4.product.Album;
import package_homework_4.product.Track;
import package_homework_4.user.Cart;
import package_homework_4.user.User;

public class Main {
	
	private static User userExists(String email, List<User> userList) {
		User user = null;
		for(int i=0; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(email)) {
				user = userList.get(i);
				break;
			}
		}
		return user;
	}
	
	private static Album albumExists(String albumName, Album[] albumList) {
		Album album = null;
		for(int i=0; i < albumList.length; i++) {
			if (albumList[i].getAlbumName().equals(albumName)) {
				album = albumList[i];
				break;
			}
		}
		return album;
	}
	
	private static Track trackExists(String trackName, Track[] trackList) {
		Track track = null;
		for(Track tr : trackList) {
			if (tr.getTrackName().equals(trackName)) {
				track = tr;
				break;
			}
		}
		return track;
	}
	

	public static void main(String[] args) {
		//User declaration
		User user = null;
		
		// Track Declaration & Initialization
		Track sSadness = new Track("Summertime Sadness", "Lana Del Rey", 180, 10);
		Track ride = new Track("Ride", "Lana Del Rey", 160, 8);
		Track starBoy = new Track("Star Boy", "The Weekend", 140, 5);
		
		//Album Declaration
		Track[] paradiseList = {sSadness,ride};
		Track[] weekendNowList = {starBoy};
		Album paradise = new Album("Paradise", "Lana Del Rey", 2012, paradiseList);
		Album weekendNow = new Album("Weekend Now", "The Weekend", 2016, weekendNowList);
		Album[] albums = {paradise,weekendNow};
		
		//Setting Albums of Tracks
		sSadness.setAlbum(paradise);
		ride.setAlbum(paradise);
		starBoy.setAlbum(weekendNow);

		//User List Declaration & Initialization
		List<User> userList = new ArrayList<User>();
		userList.add(new User("Tugba Zeki", "tzeki@upschool.com", "tzeki3334", 100));
		userList.add(new User("Busra Kar", "bkar@upschool.com", "bkar3334", 100));
		userList.add(new User("Naime Akgun", "nakgun@upschool.com", "nakgun3334", 100));
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to the M-Store App.");
		System.out.println("Please enter email (type sign-in) or create account (type sign-up)\n"
				+ "or any other input to exit: ");
		
		String respond = reader.nextLine();
		
		if(respond.equals("sign-in")) {
			System.out.println("\n\nPlease enter email: ");
			//email is read from the user
			String email = reader.nextLine();
			user = userExists(email,userList);
			//if user does not exist, return statement terminates the app.
			if(user == null) {
				System.out.println("\n\n User does not exist. App is terminated!");
				reader.close();
				return;
			}
			//password is read. if password is wrong, return statement terminates the app.
			System.out.println("\n\n Please enter your password: ");
			String password = reader.nextLine();
			if(!user.getPassword().equals(password)) {
				System.out.println("\n\n Password is wrong. App is terminated!");
				reader.close();
				return;
			}
		} else if (respond.equals("sign-up")) {
			user = new User(null,null,null,0);
			System.out.println("\n\n Please enter your name: ");
			user.setName(reader.nextLine());
			System.out.println("\n\n Please enter your email: ");
			user.setEmail(reader.nextLine());
			System.out.println("\n\n Please enter your password: ");
			user.setPassword(reader.nextLine());
			System.out.println("\n\n Please enter your balance (double): ");
			user.setBalance(Double.parseDouble(reader.nextLine()));
			userList.add(user);
		} else {
			// no matter the input, if the respond is not one of above, the app will terminate.
			reader.close();
			return;
		}
		
		System.out.println("Welcome to the M-app dear " + user.getName());
		Cart cart = new Cart(user);
				
		// The user is shown his options.
		while(true) {
			System.out.println("\n\nYou can enter the option number to do the corresponding action:");
			System.out.println("1. Search an album");
			System.out.println("2. View all albums");
			System.out.println("3. Add a music to your cart");
			System.out.println("4. View your cart");
			System.out.println("5. Remove an item from your cart");
			System.out.println("6. Purchase your cart");
			System.out.println("7. View your profile");
			System.out.println("8. Quit the application");
			
			int option = Integer.parseInt(reader.nextLine());
			switch(option) {
				case 1:
					System.out.println("\n\nPlease enter the name of the album: ");
					String albumName = reader.nextLine();
					Album album = albumExists(albumName, albums);
					if(album == null) {
						System.out.println("The album "+ albumName + " does not exist");
					} else {
						System.out.println("We found the album!\n" + album.toString());
					}
					break;
				case 2:
					System.out.println("\n\nWe have the following albums:");
					for(Album alb : albums) 
						System.out.println(alb.toString());
					break;
				case 3:
					Track track = null;
					for(Album alb : albums) {
						System.out.println(alb.toString());
						System.out.print("\n\nPlease enter the music you want to add to cart from "
								+ "above: ");
						String trackName = reader.nextLine();
						for(Album alb1: albums) {
							track = trackExists(trackName, alb1.getTrackList());
							if(track != null) break;
						}
						if(track != null) break;
					}
					if(track != null && !user.isPurchased(track) && !cart.isAdded(track)) {
						cart.addToCart(track);
						System.out.println("The track" + track.getTrackName() + " is added to"
								+ "your cart.");
					} else {
						System.out.println("The track cannot be added to your cart.");
					}
					break;
				case 4:
					System.out.println(cart.toString());
					break;
				case 5:
					System.out.println("\n\nPlease enter the song you want to remove: ");
					String trackToRemoveName = reader.nextLine();
					boolean isRemoved = cart.removeFromCart(trackToRemoveName);
					if(isRemoved) System.out.println(trackToRemoveName + " is removed from your "
							+ "cart.");
					else System.out.println("Track cannot be removed.");
					break;
				case 6:
					for(Track tr: cart.getAddedTracks()) {
						user.addToPurchasedTracks(tr);
					}
					cart.setAddedTracks(new ArrayList<Track>());
					cart.setTotalAmount(0);
					System.out.println("Cart is successfully purchased.");
					break;
				case 7:
					System.out.println(user.toString());
					break;
				case 8:
					System.out.println("Goodbye dear " +  user.getName());
					reader.close();
					return;
					
			}
		}
		
	}

}
