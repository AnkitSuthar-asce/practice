package assignment7;

class Movie{
	private String movieId;
	private String title;
	private String genere;
	private int releaseyear;
	private int duration;
	private double rating;
	private long views;
	
	public Movie(String movieId, String title, String genere, int year, int duration, double rating, long views) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genere = genere;
		this.releaseyear = year;
		this.duration = duration;
		this.rating = rating;
		this.views = views;
	}

	public String getMovieId() {
		return movieId;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre(){
		return genere;
	}
	public int getYear() {
		return releaseyear;
	}
	public int getDuration() {
		return duration;
	}
	public double getRating() {
		return rating;
	}
	public long getViews() {
		return views;
	}	
}