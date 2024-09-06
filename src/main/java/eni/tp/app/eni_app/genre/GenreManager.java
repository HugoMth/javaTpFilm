package eni.tp.app.eni_app.genre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreManager {


    @Autowired
    IDAOGenre daoGenre;

    public List<Genre> getGenres() {
        // Récupérer les films via la DAO
        List<Genre> genres = daoGenre.getGenres();
        return genres;
    }

    public Genre getGenreById(Long id) {
        Genre genre = daoGenre.getGenreById(id);
        return genre;
    }
}
