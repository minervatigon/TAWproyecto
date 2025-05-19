package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("select p from Person p where p.name=:nombre")
    public Person findByNombre(@Param("nombre") String nombre);
}
