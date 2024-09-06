package eni.tp.app.eni_app;

import eni.tp.app.eni_app.movie.Movie;
import eni.tp.app.eni_app.participant.Participant;

public class acteur {
    Movie movie;
    Participant participant;

    public acteur(Movie movie, Participant participant) {
        this.movie = movie;
        this.participant = participant;
    }

    public acteur() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
