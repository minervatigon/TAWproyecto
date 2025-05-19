package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}