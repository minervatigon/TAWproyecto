package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Language_Movie")
public class LanguageMovie {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_movie")
    private es.uma.taw.tawmovies.movies.Movie idMovie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISO_3166_1")
    private es.uma.taw.tawmovies.movies.SpokenLanguage iso31661;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
    }

    public SpokenLanguage getIso31661() {
        return iso31661;
    }

    public void setIso31661(SpokenLanguage iso31661) {
        this.iso31661 = iso31661;
    }
}