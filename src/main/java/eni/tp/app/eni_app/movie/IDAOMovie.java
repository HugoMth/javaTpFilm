package eni.tp.app.eni_app.movie;

import java.util.List;

public interface IDAOMovie {

    List<Movie> getMovies();
    Movie getMovieById(long id);
    void addMovie(Movie movie);
}
