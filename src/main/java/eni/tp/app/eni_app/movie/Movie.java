package eni.tp.app.eni_app.movie;

import eni.tp.app.eni_app.genre.Genre;
import eni.tp.app.eni_app.participant.Participant;

import java.util.List;

public class Movie {
    public Long id;
    public String title;
    public int note;
    public int year;
    public int duration;
    public String synopsis;
    public Genre genre;
    public List<Participant> participants;

    public Movie() {

    }

    public Movie(Long id, String title, int note, int year, int duration, String synopsis, Genre genre) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note=" + note +
                ", year=" + year +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                ", genre=" + genre +
                ", participants=" + participants +
                '}';
    }
}
