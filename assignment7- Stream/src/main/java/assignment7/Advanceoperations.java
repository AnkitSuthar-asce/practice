package assignment7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Advanceoperations {
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<UserWatching> users = new ArrayList<>();

    public void completionrate() {
        if (users.isEmpty()) {
            System.out.println("User Completion Rate: 0.0%");
            return;
        }
        
        long count = users.stream()
            .filter(user -> user.getCompletionPercentage() > 90)
            .count();
            
        double rate = ((double) count / users.size()) * 100;
        System.out.printf("User Completion Rate: %.1f%%%n", rate);
    }

    public void trendingmovie() {
        System.out.println("\nTrending Movies:");
        int currentYear = LocalDate.now().getYear();
        boolean found = false;
        
        for (Movie movie : movies) {
            if ((currentYear - movie.getYear()) <= 2 && movie.getRating() > 7.5 && movie.getViews() > 500000) {
                System.out.println("Name: " + movie.getTitle());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No trending movies found.");
        }
        System.out.println("- - - - - - - - - - - -");
    }
	
    public void hiddengems(String genre) {
        ArrayList<Movie> filteredMovies = (ArrayList<Movie>) movies.stream()
            .filter(m -> m.getGenre().equalsIgnoreCase(genre))
            .sorted(Comparator.comparingLong(Movie::getViews)
                              .thenComparing(Comparator.comparingDouble(Movie::getRating).reversed()))
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("\nTop Five Underviewed Gems in " + genre + ":");
        
        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found for this genre.");
        } else {
            for (Movie m : filteredMovies) {
                System.out.println(m.getTitle() + " - Views: " + m.getViews() + " | Rating: " + m.getRating());
            }
        }
        System.out.println("- - - - - - - - - - - -");	
    }
	
    public void findOverhypedMovies() {
        List<Movie> filteredMovies = movies.stream()
            .sorted(Comparator.comparingLong(Movie::getViews).reversed()
                              .thenComparing(Movie::getRating))
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("\nTop Five Overhyped Movies (High Views, Low Rating):");
        
        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found.");
        } else {
            for (Movie m : filteredMovies) {
                System.out.println(m.getTitle() + " - Views: " + m.getViews() + " | Rating: " + m.getRating());
            }
        }
        System.out.println("- - - - - - - - - - - -"); 
    }
    
    public void suggestMoviesByUserInterest(String userId, List<UserWatching> watchHistory, List<Movie> catalog) {
        List<UserWatching> userHistory = watchHistory.stream()
                .filter(w -> w.getUserId().equals(userId))
                .toList();

        if (userHistory.isEmpty()) {
            System.out.println("No watch history found for user: " + userId);
            return;
        }

        Map<String, Movie> movieMap = catalog.stream()
                .collect(Collectors.toMap(Movie::getMovieId, m -> m, (m1, m2) -> m1));

        Set<String> watchedMovieIds = userHistory.stream()
                .map(UserWatching::getMovieId)
                .collect(Collectors.toSet());

        Map<String, Integer> genreTimeMap = userHistory.stream()
                .filter(w -> movieMap.containsKey(w.getMovieId()))
                .collect(Collectors.groupingBy(
                        w -> movieMap.get(w.getMovieId()).getGenre(),
                        Collectors.summingInt(UserWatching::getWatchedMinutes)
                ));

        Optional<String> favoriteGenreOpt = genreTimeMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        if (favoriteGenreOpt.isEmpty()) {
            System.out.println("Could not determine favorite genre for user: " + userId);
            return;
        }
        
        String favoriteGenre = favoriteGenreOpt.get();

        List<Movie> recommendations = catalog.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(favoriteGenre))
                .filter(m -> !watchedMovieIds.contains(m.getMovieId()))
                .collect(Collectors.toList());

        System.out.println("Recommendations for user " + userId + " (Favorite Genre: " + favoriteGenre + "):");
        if (recommendations.isEmpty()) {
            System.out.println("No new movies to recommend in this genre.");
        } else {
            recommendations.forEach(m -> System.out.println("- " + m.getTitle() + " (" + m.getGenre() + ")"));
        }
    }
    
    public void generateGenreReport() {
        if (movies.isEmpty()) {
            System.out.println("No movies available to generate report.");
            return;
        }

        Map<String, List<Movie>> moviesByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        System.out.println("=== GENRE PERFORMANCE REPORT ===");
        
        moviesByGenre.forEach((genre, movieList) -> {
            long count = movieList.size();
            
            double avgRating = movieList.stream()
                    .mapToDouble(Movie::getRating)
                    .average()
                    .orElse(0.0);
            
            double avgViews = movieList.stream()
                    .mapToLong(Movie::getViews)
                    .average()
                    .orElse(0.0);
            
            Optional<Movie> mostPopular = movieList.stream()
                    .max((m1, m2) -> Long.compare(m1.getViews(), m2.getViews()));

            System.out.println("\nGenre: " + genre);
            System.out.println("- Total Movies: " + count);
            System.out.println("- Average Rating: " + String.format("%.2f", avgRating));
            System.out.println("- Average Views: " + String.format("%.2f", avgViews));
            
            if (mostPopular.isPresent()) {
                System.out.println("- Most Popular Movie: " + mostPopular.get().getTitle() + " (" + mostPopular.get().getViews() + " views)");
            } else {
                System.out.println("- Most Popular Movie: N/A");
            }
        });
    }
}
