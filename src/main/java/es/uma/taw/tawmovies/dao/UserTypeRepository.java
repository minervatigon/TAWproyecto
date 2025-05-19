package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

    @Query("select u from UserType u where trim(u.user) =trim(:usuario) and trim(u.password) =trim(:password)")
    public UserType autenticaUsuario (@Param("usuario") String usuario, @Param("password") String password);

}
