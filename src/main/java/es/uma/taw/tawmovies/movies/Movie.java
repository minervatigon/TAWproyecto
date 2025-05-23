package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "homepage", length = 100)
    private String homepage;

    @Column(name = "original_language", length = 50)
    private String originalLanguage;

    @Column(name = "original_title", length = 100)
    private String originalTitle;

    @Column(name = "overview", length = 500)
    private String overview;

    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "runtime")
    private Long runtime;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "tagline", length = 100)
    private String tagline;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;


    @ManyToMany
    @JoinTable(
            name = "Gender_Movie",
            joinColumns = @JoinColumn(name="ID_movie"),
            inverseJoinColumns = @JoinColumn(name="ID_gender")
    )
    private List<Gender> genres;

    @ManyToMany
    @JoinTable(
            name = "Language_Movie",
            joinColumns = @JoinColumn(name="ID_movie"),
            inverseJoinColumns = @JoinColumn(name="ISO_3166_1")
    )

    private List<SpokenLanguage> languages;

    @OneToMany(mappedBy = "idMovie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cast> castList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        this.runtime = runtime;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public List<Gender> getGenres() {
        return genres;
    }

    public void setGenres(List<Gender> genres) {
        this.genres = genres;
    }

    public List<SpokenLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<SpokenLanguage> languages) {
        this.languages = languages;
    }

    public List<Cast> getCastList() {
        return castList;
    }

    public void setCastList(List<Cast> castList) {
        this.castList = castList;
    }
}