package eni.tp.app.eni_app.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieManager {

    @Autowired
    IDAOMovie daoMovie;

    public List<Movie> getMovies() {
        // Récupérer les films via la DAO
        List<Movie> movies = daoMovie.getMovies();
        return movies;
    }

    public Movie getMovieById(long id) {
        Movie movie = daoMovie.getMovieById(id);
        return movie;
    }

    public void addMovie(Movie movie) {
        daoMovie.addMovie(movie);
    }
}
