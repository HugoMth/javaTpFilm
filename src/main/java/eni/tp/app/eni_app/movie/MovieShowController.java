package eni.tp.app.eni_app.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SessionAttributes({"loggedUser"})
@Controller
public class MovieShowController {
    @Autowired
    MovieManager movieManager;

    @GetMapping("/films/{id}")
    public String showMovieShowPage(@PathVariable Long id, final Model model) {
        model.addAttribute("id", id);
        Movie movie = movieManager.getMovieById(id);

        if (movie == null) {
            System.out.println("Movie not found");
            return "movie/show-error";
        }

        model.addAttribute("movie", movie);


//        retourne le nom du fichier htl à charger à partir du dossier resources/templates
        return "movie/show";

    }
}
