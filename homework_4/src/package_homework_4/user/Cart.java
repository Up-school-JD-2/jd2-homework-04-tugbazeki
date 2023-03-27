package package_homework_4.user;

import java.util.ArrayList;
import java.util.List;

import package_homework_4.product.Track;

public class Cart {
	//Fields
	private User user;
	private List<Track> addedTracks = new ArrayList<Track>();
	private double totalAmount = 0;
	
	public Cart(User user) {
		this.user = user;
	}
	
	//Getters
	public User getUser() {
		return this.user;
	}
	
	public List<Track> getAddedTracks() {
		return this.addedTracks;
	}
	
	public double getTotalAmount() {
		return this.totalAmount;
	}
	
	//Setters
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setAddedTracks(List<Track> addedTracks) {
		this.addedTracks = addedTracks;
	}
	
	public void setTotalAmount (double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void addToCart (Track track) {
		this.addedTracks.add(track);
		this.totalAmount += track.getPrice();
	}
	
	public boolean isAdded (Track track) {
		for(Track tr : this.addedTracks) {
			if (tr.getTrackName() == track.getTrackName()) return true;
		}
		return false;
	}
	
	public boolean removeFromCart (String trackName) {
		for(int i=0; i<this.addedTracks.size();i ++) {
			if(this.addedTracks.get(i).getTrackName().equals(trackName)) {
				this.totalAmount -= this.addedTracks.get(i).getPrice();
				this.addedTracks.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String[] strArray = new String[this.addedTracks.size()];
		for(int i = 0; i < this.addedTracks.size(); i++) {
			strArray[i] = this.addedTracks.get(i).toString();
		}
		return this.user.getName() + "'s Cart:\n" + String.join("\n", strArray) + "\n" + 
			   "Total Amount: " + this.totalAmount;
				
		
	}
}
