package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.Gender;
import es.uma.taw.tawmovies.movies.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Integer> {

}