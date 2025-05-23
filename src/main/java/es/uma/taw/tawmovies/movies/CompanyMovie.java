package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Company_Movie")
public class CompanyMovie {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_company")
    private es.uma.taw.tawmovies.movies.ProductionCompany idCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_movie")
    private es.uma.taw.tawmovies.movies.Movie idMovie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductionCompany getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(ProductionCompany idCompany) {
        this.idCompany = idCompany;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
    }
}