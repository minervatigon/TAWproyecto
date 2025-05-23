package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_movie")
    private Movie idMovie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_list")
    private Lista idList;

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

    public Lista getIdList() {
        return idList;
    }

    public void setIdList(Lista idList) {
        this.idList = idList;
    }
}