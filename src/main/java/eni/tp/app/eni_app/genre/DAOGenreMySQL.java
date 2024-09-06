package eni.tp.app.eni_app.genre;

import eni.tp.app.eni_app.genre.Genre;
import eni.tp.app.eni_app.genre.Genre;
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
public class DAOGenreMySQL implements IDAOGenre {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final RowMapper<Genre> GENRE_ROW_MAPPER = new RowMapper<Genre>() {
        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Genre genre = new Genre();

            genre.setId(rs.getLong("id"));
            genre.setTitre(rs.getString("titre"));
            return genre;
        }

        ;
    };

    public List<Genre> getGenres() {
        return jdbcTemplate.query("SELECT * FROM genre", GENRE_ROW_MAPPER);
    }

    ;

    public Genre getGenreById(Long id) {
        List<Genre> genres = jdbcTemplate.query("SELECT * FROM genre WHERE id = ?", GENRE_ROW_MAPPER, id);

        if (genres.isEmpty()) {
            return null;
        }
        return genres.get(0);
    }

    ;
}
