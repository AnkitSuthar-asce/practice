package assignment7;

import java.time.LocalDate;

class UserWatching{
	private String userId;
	private String movieId;
	private int watchedMinutes;
	private double completionPercentage;
	private double userRating;
	private LocalDate watchedDate;
	
	public UserWatching(String userId, String movieId, int watchedMinutes, double completionPercentage,
			double userRating, LocalDate watchedDate) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.watchedMinutes = watchedMinutes;
		this.completionPercentage = completionPercentage;
		this.userRating = userRating;
		this.watchedDate = watchedDate;
	}
	public String getUserId() {
		return userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public int getWatchedMinutes() {
		return watchedMinutes;
	}
	public double getCompletionPercentage() {
		return completionPercentage;
	}
	public double getUserRating() {
		return userRating;
	}
	public LocalDate getWatchedDate() {
		return watchedDate;
	}
}