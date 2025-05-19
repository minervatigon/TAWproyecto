package es.uma.taw.tawmovies.movies;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lista {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

}