package package_homework_4.user;

import java.util.ArrayList;
import java.util.List;

import package_homework_4.product.Track;

public class User {
	//Fields
	private String name;
	private String email;
	private String password;
	private double balance;
	private List<Track> purchasedTracks = new ArrayList<Track>();
	
	//Constructor
	public User(String name, String email, String password, double balance) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	//Getters	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public List<Track> getPurchasedTracks() {
		return this.purchasedTracks;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setPurchasedTracks(List<Track> purchasedTracks) {
		this.purchasedTracks = purchasedTracks;
	}
	
	public void addToPurchasedTracks(Track track) {
		this.purchasedTracks.add(track);
		this.balance -= track.getPrice();
	}
	
	public boolean isPurchased(Track track ) {
		for(Track tr : this.purchasedTracks) {
			if (tr.getTrackName() == track.getTrackName()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String[] strArray = new String[this.purchasedTracks.size()];
		for(int i=0; i<this.purchasedTracks.size(); i++) {
			strArray[i] = "Track #" + i + ": " + this.purchasedTracks.get(i).getTrackName();
		}
		return "User: " + this.name + "\nBalance: " + this.balance + "\nPurchased Tracks:\n" +
			   String.join("\n", strArray);
	}
}
