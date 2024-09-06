package eni.tp.app.eni_app.movie;

import eni.tp.app.eni_app.membre.Membre;
import eni.tp.app.eni_app.membre.MembreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@SessionAttributes({"loggedUser"})
@Controller
public class MovieIndexController {

    @Autowired
    MovieManager movieManager;

    @Autowired
    MembreManager membreManager;


    @GetMapping({"/", "/films"})
    public String showMovieIndexPage(Model model, Principal principal) {
//        retourne le nom du fichier htl à charger à partir du dossier resources/templates

        if (principal != null) {
            Membre user = membreManager.getMembreByEmail(principal.getName());
            model.addAttribute("loggedUser", user);
        }
//        if(principal.getName())
        List<Movie> movies = movieManager.getMovies();
        System.out.println(movies.get(0).toString());

        List<Integer> maxStars = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("movies", movies);
        model.addAttribute("maxStars", maxStars);
        return "movie/index";

    }

}
