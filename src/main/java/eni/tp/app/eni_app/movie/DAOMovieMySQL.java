package eni.tp.app.eni_app.movie;


import eni.tp.app.eni_app.genre.Genre;
import eni.tp.app.eni_app.genre.GenreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("mysql")
@Component
public class DAOMovieMySQL implements IDAOMovie {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    GenreManager genreManager;

    /**
     * Le code qui permet de savoir comment convertir/mapper un resultat en SQL en Objet/Classe
     * Comment mapper un resultat SQL en Aliment
     */


    private RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();

            movie.id = rs.getLong("id");
            movie.title = rs.getString("title");
            movie.note = rs.getInt("note");
            movie.year = rs.getInt("year");
            movie.duration = rs.getInt("duration");
            movie.synopsis = rs.getString("synopsis");
            movie.genre = genreManager.getGenreById(rs.getLong("id_genre"));
            return movie;
        }

        ;
    };

    @Override
    public List<Movie> getMovies() {
        return jdbcTemplate.query("SELECT * FROM movie", MOVIE_ROW_MAPPER);
    }


    @Override
    public Movie getMovieById(long id) {
        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movie WHERE id = ?", MOVIE_ROW_MAPPER, id);

        if (movies.isEmpty()) {
            return null;
        }
        return movies.get(0);
    }

    public void addMovie(Movie movie) {
        jdbcTemplate.update("INSERT INTO movie(title, note, year, duration, synopsis, id_genre) VALUES (?, ?, ?, ?, ?, ?)", movie.getTitle(), movie.getNote(), movie.getYear(), movie.getDuration(), movie.getSynopsis(), movie.getGenre().getId());
    }


}