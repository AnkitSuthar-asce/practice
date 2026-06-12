package assignment7;

import java.util.ArrayList;

class BasicOperations{
	ArrayList<Movie> movies= new ArrayList<>();
	public void eightplus() {
		for(Movie m: movies) {
			if(m.getRating()>8) {
				System.out.println("Rating 8+: "+m.getTitle()+", Rating: "+m.getRating());
			}
		}
	}
	
	public void actiongenre() {
		for(Movie m: movies) {
			if(m.getGenre()=="Action") {
				System.out.println("Action: "+m.getTitle());
			}
		}
	}
	
	public void countTotal(){
		System.out.println("\nTotal Movies: "+movies.size());		
	}
	
	public void sortbyRating() {
	    movies.sort((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()));
	    System.out.println("\nMovies sorted by rating (High to Low):");
	    for (Movie m : movies) {
	        System.out.println(m.getTitle() + " - " + m.getRating());
	    }
	    System.out.println("- - - - - - - - - - - -");
	}
	
	public void movieafter2020() {
		for(Movie m:movies) {
			if(m.getYear()>2020) {
				System.out.println("\nMovie: "+m.getTitle()+", Release Year: "+m.getYear());
			}
		}
	}
	
	public void averageRating() {
		double rating=0;
		for(Movie m:movies) {
			rating +=m.getRating();
		}
		System.out.println("\nAverage Rating: "+(rating/movies.size()));
	}
}