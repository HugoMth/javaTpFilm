package eni.tp.app.eni_app.genre;

import java.util.List;

public interface IDAOGenre {

    List<Genre> getGenres();

    Genre getGenreById(Long id);
}
