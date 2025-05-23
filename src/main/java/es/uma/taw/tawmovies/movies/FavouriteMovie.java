package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Favourite_movie")
public class FavouriteMovie {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_user")
    private es.uma.taw.tawmovies.movies.UserType idUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_movie")
    private es.uma.taw.tawmovies.movies.Movie idMovie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserType getIdUser() {
        return idUser;
    }

    public void setIdUser(UserType idUser) {
        this.idUser = idUser;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
    }
}