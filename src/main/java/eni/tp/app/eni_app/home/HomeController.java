package eni.tp.app.eni_app.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class HomeController {

//    @GetMapping("/login")
//    public String showHomePage(Model model) {
//        User loggedUser = (User) model.getAttribute("loggedUser");
//        if (loggedUser == null) {
//            model.addAttribute("user", new User());
//            return "home";
//        } else {
//            return "redirect:/films";
//        }
//    }

//    @PostMapping("/login")
//    public String processLogin( @Valid @ModelAttribute User loggedUser, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()){
//            System.out.println("Erreur de contrôle surface");
//            return "home";
//        }
//
//        model.addAttribute("loggedUser", loggedUser);
//        Utils.sendSuccessFlashMessage(redirectAttributes, "Vous êtes connecté(e) avec succès");
//        return "redirect:/films";
//    }

    @GetMapping("/login")
    String login() {
        return "home";
    }

    @GetMapping("/logout")
    public String processLogout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
