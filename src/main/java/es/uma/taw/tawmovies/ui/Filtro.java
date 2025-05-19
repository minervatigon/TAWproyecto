package es.uma.taw.tawmovies.ui;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Filtro {

    private String originalLanguage;
    private Double popMin;
    private Double popMax;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private Integer durMin;
    private Integer durMax;
    private Double voteMin;
    private Double voteMax;
    private Long genreId;
    private Long languageId;

    private String title;

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Double getPopMin() {
        return popMin;
    }

    public void setPopMin(Double popMin) {
        this.popMin = popMin;
    }

    public Double getPopMax() {
        return popMax;
    }

    public void setPopMax(Double popMax) {
        this.popMax = popMax;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDurMin() {
        return durMin;
    }

    public void setDurMin(Integer durMin) {
        this.durMin = durMin;
    }

    public Integer getDurMax() {
        return durMax;
    }

    public void setDurMax(Integer durMax) {
        this.durMax = durMax;
    }

    public Double getVoteMin() {
        return voteMin;
    }

    public void setVoteMin(Double voteMin) {
        this.voteMin = voteMin;
    }

    public Double getVoteMax() {
        return voteMax;
    }

    public void setVoteMax(Double voteMax) {
        this.voteMax = voteMax;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}