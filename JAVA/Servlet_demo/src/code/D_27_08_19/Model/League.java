package code.D_27_08_19.Model;


import java.io.Serializable;

@SuppressWarnings("serial")
public class League implements Serializable{
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	public static int serialVersionUID = 100;
	private String title;
	private String season;
	private int year;
	public League() {
		super();
	}
	public League(String title, String season, int year) {
		super();
		this.title = title;
		this.season = season;
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	

}