package package_homework_4.product;

public class Track {
	//Fields
	private String trackName;
	private String singerName;
	private Album album;
	private int lengthSeconds;
	private int price;
	
	//Constructor
	public Track(String trackName, String singerName, 
			int lengthSeconds, int price) {
		this.trackName = trackName;
		this.singerName = singerName;
		this.lengthSeconds = lengthSeconds;
		this.price = price;
	}

	//Getters
	public String getTrackName() {
		return this.trackName;
	}
	
	public String getSingerName() {
		return this.singerName;
	}
	
	public Album getAlbum() {
		return this.album;
	}
	
	public int getLengthSeconds() {
		return this.lengthSeconds;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	//Setters
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public void setLengthSeconds(int lengthSeconds) {
		this.lengthSeconds = lengthSeconds;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "\nTrack Name: " + this.trackName + "\nSinger: " + this.singerName + "\nLength: " +
			   this.lengthSeconds + " seconds\nPrice: " + this.price + " dollars.";
	}
}









