package package_homework_4.product;

public class Album {
	//Fields
	private String albumName;
	private String singerName;
	private int publishYear;
	private Track[] trackList;
	
	//Constructor
	public Album(String albumName, String singerName, int publishYear, Track[] trackList) {
		this.albumName = albumName;
		this.singerName = singerName;
		this.publishYear = publishYear;
		this.trackList = trackList;
	}
	
	//Getters
	public String getAlbumName() {
		return this.albumName;
	}
	
	public String getSingerName() {
		return this.singerName;
	}
	
	public int getPublishYear() {
		return this.publishYear;
	}
	
	public Track[] getTrackList() {
		return this.trackList;
	}
	
	//Setters
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public void setTracklist(Track[] trackList) {
		this.trackList = trackList;
	}
	
	public String toString() {
		String info = "\n" + this.albumName + ", " + this.singerName + ", " + this.publishYear + "\n";
		String[] strings = new String[this.trackList.length];
		for(int i = 0; i < this.trackList.length; i++) {
			strings[i] = "Track #" + i + "\n" + this.trackList[i].toString();
		}
		return info + String.join("\n", strings) + "\n\n";
		
		
	}
	
}
