package eni.tp.app.eni_app.participant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipantManager {


    @Autowired
    IDAOParticipant daoParticipant;

    public List<Participant> getParticipants() {
        // Récupérer les films via la DAO
        List<Participant> participants = daoParticipant.getParticipants();
        return participants;
    }

    public Participant getParticipantById(Long id) {
        Participant participant = daoParticipant.getParticipantById(id);
        return participant;
    }
}
