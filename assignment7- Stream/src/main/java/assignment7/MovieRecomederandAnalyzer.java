package assignment7;

import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;


public class MovieRecomederandAnalyzer {
	public static void main(String[] args) {
		BasicOperations operations = new BasicOperations();
		operations.movies.add(new Movie("B001", "The Shawshank Redemption", "Drama", 1994, 142, 9.3, 2500000));
		operations.movies.add(new Movie("B002", "The Dark Knight", "Action", 2008, 152, 9.0, 3000000));
		operations.movies.add(new Movie("B003", "Spiderman: No Way Home", "Action", 2021, 148, 8.2, 1800000));
		operations.movies.add(new Movie("B004", "Dune: Part Two", "Sci-Fi", 2024, 166, 8.8, 1200000));
		operations.movies.add(new Movie("B005", "The Godfather", "Drama", 1972, 175, 9.2, 1900000));
		operations.movies.add(new Movie("B006", "The Batman", "Action", 2022, 176, 7.8, 900000));
		operations.movies.add(new Movie("B007", "Top Gun: Maverick", "Action", 2022, 130, 8.3, 2200000));
		operations.movies.add(new Movie("B008", "Oppenheimer", "Drama", 2023, 180, 8.4, 1400000));
		operations.movies.add(new Movie("B009", "Inception", "Sci-Fi", 2010, 148, 8.8, 2100000));
		operations.movies.add(new Movie("B010", "Fast X", "Action", 2023, 141, 5.8, 800000));

		System.out.println("=== BASIC OPERATIONS TEST ===");
		operations.eightplus();
		operations.actiongenre();
		operations.countTotal();
		operations.sortbyRating();
		operations.movieafter2020();
		operations.averageRating();

		IntermediadteOperations intermediate = new IntermediadteOperations();
		intermediate.movies.add(new Movie("I001", "Avatar: Way of Water", "Sci-Fi", 2022, 192, 7.6, 2900000));
		intermediate.movies.add(new Movie("I002", "Everything Everywhere", "Sci-Fi", 2022, 139, 7.8, 1100000));
		intermediate.movies.add(new Movie("I003", "John Wick 4", "Action", 2023, 169, 7.7, 1500000));
		intermediate.movies.add(new Movie("I004", "The Whale", "Drama", 2022, 117, 7.7, 400000));
		intermediate.movies.add(new Movie("I005", "Puss in Boots", "Animation", 2022, 102, 7.9, 1300000));
		intermediate.movies.add(new Movie("I006", "Barbie", "Comedy", 2023, 114, 6.9, 2500000));
		intermediate.movies.add(new Movie("I007", "The Super Mario Movie", "Animation", 2023, 92, 7.0, 2600000));
		intermediate.movies.add(new Movie("I008", "Gladiator", "Action", 2000, 155, 8.5, 1700000));
		intermediate.movies.add(new Movie("I009", "Parasite", "Drama", 2019, 132, 8.5, 1200000));
		intermediate.movies.add(new Movie("I010", "Alien: Romulus", "Horror", 2024, 119, 7.4, 600000));

		System.out.println("=== INTERMEDIATE OPERATIONS TEST ===");
		intermediate.groupMoviesByGenre();
		intermediate.displayMap();
		intermediate.topFiveByViews();
		intermediate.halftwohour();
		intermediate.millionclub();
		intermediate.longestmoviegenre();
		

		System.out.println("\n=== ADVANCE OPERATIONS TEST ===");
		Advanceoperations advance = new Advanceoperations();

		advance.movies.add(new Movie("A001", "Dune: Part Two", "Sci-Fi", 2024, 166, 8.8, 1200000));
		advance.movies.add(new Movie("A002", "Oppenheimer", "Drama", 2023, 180, 8.4, 1400000));
		advance.movies.add(new Movie("A003", "The Batman", "Action", 2022, 176, 7.8, 900000));
		advance.movies.add(new Movie("A004", "Gladiator", "Action", 2000, 155, 8.5, 1700000));
		advance.movies.add(new Movie("A005", "Fast X", "Action", 2023, 141, 5.8, 800000));    
		advance.movies.add(new Movie("A006", "Spider-Man: No Way Home", "Action", 2021, 148, 8.2, 1800000));
		advance.movies.add(new Movie("A007", "Top Gun: Maverick", "Action", 2022, 130, 8.3, 2200000));
		advance.movies.add(new Movie("A008", "Avatar 2", "Sci-Fi", 2022, 192, 7.6, 2900000));
		advance.movies.add(new Movie("A009", "Barbie", "Comedy", 2023, 114, 6.9, 2500000));
		advance.movies.add(new Movie("A010", "Alien: Romulus", "Horror", 2024, 119, 7.4, 600000));

		advance.users.add(new UserWatching("U1", "A001", 160, 96.0, 9.0, LocalDate.now()));
		advance.users.add(new UserWatching("U2", "A002", 170, 94.0, 8.5, LocalDate.now()));
		advance.users.add(new UserWatching("U3", "A003", 40, 22.0, 3.0, LocalDate.now()));
		advance.users.add(new UserWatching("U4", "A004", 150, 97.0, 9.0, LocalDate.now()));
		advance.users.add(new UserWatching("U5", "A005", 20, 15.0, 2.0, LocalDate.now()));
		advance.users.add(new UserWatching("U6", "A006", 140, 95.0, 8.0, LocalDate.now()));
		advance.users.add(new UserWatching("U7", "A007", 120, 92.0, 8.5, LocalDate.now()));
		advance.users.add(new UserWatching("U8", "A008", 180, 93.0, 7.5, LocalDate.now()));
		advance.users.add(new UserWatching("U9", "A009", 30, 26.0, 5.0, LocalDate.now()));
		advance.users.add(new UserWatching("U10", "A010", 110, 91.0, 7.0, LocalDate.now()));

		// Running tests
		advance.completionrate();
		advance.trendingmovie();
		advance.hiddengems("Action");
		advance.findOverhypedMovies();
        advance.suggestMoviesByUserInterest("U3", advance.users, advance.movies);
        advance.generateGenreReport();

	}
}

