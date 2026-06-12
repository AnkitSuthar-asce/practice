package assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class IntermediadteOperations{
	ArrayList<Movie> movies= new ArrayList<>();
	HashMap<String, ArrayList<Movie>> mapmovie= new HashMap<>();
	public void groupMoviesByGenre() {
	    for (Movie m : movies) {
	        String genre = m.getGenre();  
	        if (!mapmovie.containsKey(genre)) {
	            mapmovie.put(genre, new ArrayList<>());
	        }    
	        mapmovie.get(genre).add(m);
	    }
	}
	public void displayMap() {
		System.out.println("\nGenre Distribution: ");
	    for (String genre : mapmovie.keySet()) {
	        System.out.println("" + genre + ": " + mapmovie.get(genre).size() + " movies");
	    }
		System.out.println("");
	}
	public void topFiveByViews() {
	    movies.sort((m1, m2) -> Long.compare(m2.getViews(), m1.getViews()));
	    System.out.println("Top Five by Views:");
	    int limit = Math.min(5, movies.size());
	    for (int i = 0; i < limit; i++) {
	        Movie m = movies.get(i);
	        System.out.println(m.getTitle() + " - Views: " + m.getViews());
	    }
	    System.out.println("- - - - - - - - - - - -");
	}
	public void halftwohour() {
		System.out.println("\nSuitable for 90-120 min: ");
	    for (Movie m : movies) {
	    	if(m.getDuration()>91 && m.getDuration()<121) {
	    		System.out.println("Name: "+m.getTitle()+" ,Duartion : "+m.getDuration());
	    	}
	    }
	}
	public void millionclub() {
		System.out.println("\nMillion Club: ");
		for (Movie m : movies) {
	    	if(m.getViews()>1000000) {
	    		System.out.println("Name: "+m.getTitle()+" ,Views : "+m.getViews());
	    	}
	    }
	}
	public void longestmoviegenre() {
	    System.out.println("\nLongest Movie per Genre: ");
	    for (String genre : mapmovie.keySet()) {
	        ArrayList<Movie> genreMovies = mapmovie.get(genre);
	        Movie longest = null;
	        for (Movie m : genreMovies) {
	            if (longest == null || m.getDuration() > longest.getDuration()) {
	                longest = m;
	            }
	        }
	        if (longest != null) {
	            System.out.println(genre + ": " + longest.getTitle() + " (" + longest.getDuration() + " min)");
	        }
	    }
	}
}