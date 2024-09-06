package eni.tp.app.eni_app.movie;

import eni.tp.app.eni_app.genre.Genre;
import eni.tp.app.eni_app.genre.GenreManager;
import eni.tp.app.eni_app.participant.Participant;
import eni.tp.app.eni_app.participant.ParticipantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SessionAttributes({"loggedUser"})
@Controller
public class MoviePostController {
    @Autowired
    MovieManager movieManager;

    @Autowired
    GenreManager genreManager;

    @Autowired
    ParticipantManager participantManager;

    @GetMapping("/film-form")
    public String showMovieForm(Model model) {
        Movie movie = new Movie();
        movie.title = "Moooooooooooovie";
        movie.genre = new Genre();
        movie.participants = new ArrayList<>();
        movie.note = 4;
        movie.year = 2019;
        movie.duration = 95;
        movie.synopsis = "Movie synopsis, un test de film, Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.";
        model.addAttribute("movie", movie);

        List<Genre> genres = genreManager.getGenres();
        model.addAttribute("genres", genres);

        List<Participant> participants = participantManager.getParticipants();
        model.addAttribute("participants", participants);


        return "movie/movie-form";

    }

    @PostMapping("/film-form")
    public String processMovieForm(@ModelAttribute Movie movie, Model model) {
        System.out.println(movie);
//        movieManager.addMovie(movie);

        return "redirect:/films";
    }
}
