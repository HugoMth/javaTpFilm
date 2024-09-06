//package eni.tp.app.eni_app.movie;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Profile("mock")
//@Component
//public class DAOMovieMock implements IDAOMovie {
//
//////    List<Movie> movies = Arrays.asList(
//////            new Movie(1L, "Velocipastor", 3, 2017, 65, "In the enchanting town of Rustlewood, 11-year-old Carolina is an adventurous girl with an insatiable love for pizza and her mischievous pet raccoon, Bandit. When the iconic local pizzeria, known for its magical recipes, suddenly closes down, Carolina discovers that the legendary \"Slice of Secrets\" pizza has been cursed by a vengeful spirit who once worked there."),
//////            new Movie(2L, "Carolina and the Raccoon's Pizza Quest",5, 2024, 95, "In the enchanting town of Rustlewood, 11-year-old Carolina is an adventurous girl with an insatiable love for pizza and her mischievous pet raccoon, Bandit. When the iconic local pizzeria, known for its magical recipes, suddenly closes down, Carolina discovers that the legendary \"Slice of Secrets\" pizza has been cursed by a vengeful spirit who once worked there."),
//////            new Movie(3L, "Bulk",2, 2015, 65, "In the enchanting town of Rustlewood, 11-year-old Carolina is an adventurous girl with an insatiable love for pizza and her mischievous pet raccoon, Bandit. When the iconic local pizzeria, known for its magical recipes, suddenly closes down, Carolina discovers that the legendary \"Slice of Secrets\" pizza has been cursed by a vengeful spirit who once worked there.")
//////    );
////
////
////    @Override
////    public List<Movie> getMovies() {
////        return movies;
////    }
////
////    public Movie getMovieById(long id) {
////        Movie movie = movies.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
////        return movie;
////    }
////
////    public void addMovie(Movie movie) {
////
////    }
//}
