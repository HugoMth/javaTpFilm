package eni.tp.app.eni_app.membre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MembreManager {
    @Autowired
    IDAOMembre daoMembre;

    public Membre getMembreByEmail(String email) {

        Membre membre = daoMembre.getMembreByEmail(email);
        return membre;
    }
}
