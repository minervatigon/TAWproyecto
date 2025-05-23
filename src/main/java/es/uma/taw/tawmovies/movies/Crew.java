package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Crew {
    @Id
    @Column(name = "ID_credit", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_pelicula")
    private es.uma.taw.tawmovies.movies.Movie idPelicula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_persona")
    private es.uma.taw.tawmovies.movies.Person idPersona;

    @Column(name = "department", length = 100)
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Movie idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Person getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Person idPersona) {
        this.idPersona = idPersona;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}