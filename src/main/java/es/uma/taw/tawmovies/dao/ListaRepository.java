package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Integer> {
}
