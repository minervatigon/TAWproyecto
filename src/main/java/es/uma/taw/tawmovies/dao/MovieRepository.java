package es.uma.taw.tawmovies.dao;

import es.uma.taw.tawmovies.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findTop10ByOrderByPopularityDesc();

    List<Movie> findTop10ByOrderByVoteAverageDesc();

    List<Movie> findTop10ByReleaseDateAfterOrderByReleaseDateAsc(LocalDate date);

    List<Movie> findByTitleContainingIgnoreCase(String title);


        @Query("""
    SELECT DISTINCT m
    FROM Movie m
    LEFT JOIN m.genres g
    LEFT JOIN m.languages l
    WHERE (COALESCE(:originalLanguage, '') = ''    OR m.originalLanguage = :originalLanguage)
      AND (:popMin IS NULL          OR m.popularity    >= :popMin)
      AND (:popMax IS NULL          OR m.popularity    <= :popMax)
      AND (:startDate IS NULL       OR m.releaseDate   >= :startDate)
      AND (:endDate IS NULL         OR m.releaseDate   <= :endDate)
      AND (:durMin IS NULL          OR m.runtime       >= :durMin)
      AND (:durMax IS NULL          OR m.runtime       <= :durMax)
      AND (:voteMin IS NULL         OR m.voteAverage   >= :voteMin)
      AND (:voteMax IS NULL         OR m.voteAverage   <= :voteMax)
      AND (:genreId IS NULL         OR g.id            = :genreId)
      AND (:languageId IS NULL      OR l.id            = :languageId)
      AND (:title IS NULL           OR LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))        )
""")
        List<Movie> findWithFilters(
                @Param("originalLanguage") String originalLanguage,
                @Param("popMin")           Double popMin,
                @Param("popMax")           Double popMax,
                @Param("startDate")        LocalDate startDate,
                @Param("endDate")          LocalDate endDate,
                @Param("durMin")           Integer durMin,
                @Param("durMax")           Integer durMax,
                @Param("voteMin")          Double voteMin,
                @Param("voteMax")          Double voteMax,
                @Param("genreId")          Long genreId,
                @Param("languageId")       Long languageId,
                @Param("title")            String title
        );



}