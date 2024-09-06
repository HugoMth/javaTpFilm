package eni.tp.app.eni_app.participant;

import eni.tp.app.eni_app.participant.Participant;

import java.util.List;

public interface IDAOParticipant {

    List<Participant> getParticipants();

    Participant getParticipantById(Long id);
}
