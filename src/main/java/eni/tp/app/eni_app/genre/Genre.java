package eni.tp.app.eni_app.genre;

public class Genre {
    private Long id;
    private String titre;

    public Genre(String titre) {
        this.titre = titre;
    }

    public Genre() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                '}';
    }
}
