package com.tryouts.spotibar.dao;

import com.tryouts.spotibar.validators.CorrectGenreTrackArtist;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@CorrectGenreTrackArtist.List({
        @CorrectGenreTrackArtist(seedGenres = "seedGenre", seedArtists = "seedArtists", seedTracks = "seedTracks")
})
public class SearchCriteria {

    @Min(1)
    @Max(100)
    private Integer limit;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal acousticness;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal danceability;
    @Min(1)
    private Integer duration;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal energy;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal instrumentalness;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal liveness;
    @Min(1)
    private Integer key;
    @Min(0)
    @Max(1)
    private Integer majorOrMinus;
    @Min(0)
    @Max(100)
    private Integer popularity;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal speechiness;
    @Min(1)
    private Integer tempo;
    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private BigDecimal valence;

    private String seedGenre;
    private String seedArtists;
    private String seedTracks;


    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public BigDecimal getAcousticness() {
        return acousticness;
    }
    public void setAcousticness(BigDecimal acousticness) {
        this.acousticness = acousticness;
    }
    public BigDecimal getDanceability() {
        return danceability;
    }
    public void setDanceability(BigDecimal danceability) {
        this.danceability = danceability;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public BigDecimal getEnergy() {
        return energy;
    }
    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }
    public BigDecimal getInstrumentalness() {
        return instrumentalness;
    }
    public void setInstrumentalness(BigDecimal instrumentalness) {
        this.instrumentalness = instrumentalness;
    }
    public BigDecimal getLiveness() {
        return liveness;
    }
    public void setLiveness(BigDecimal liveness) {
        this.liveness = liveness;
    }
    public Integer getKey() {
        return key;
    }
    public void setKey(Integer key) {
        this.key = key;
    }
    public Integer getMajorOrMinus() {
        return majorOrMinus;
    }
    public void setMajorOrMinus(Integer majorOrMinus) {
        this.majorOrMinus = majorOrMinus;
    }
    public Integer getPopularity() {
        return popularity;
    }
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
    public BigDecimal getSpeechiness() {
        return speechiness;
    }
    public void setSpeechiness(BigDecimal speechiness) {
        this.speechiness = speechiness;
    }
    public Integer getTempo() {
        return tempo;
    }
    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }
    public BigDecimal getValence() {
        return valence;
    }
    public void setValence(BigDecimal valence) {
        this.valence = valence;
    }
    public String getSeedGenre() {
        return seedGenre;
    }
    public void setSeedGenre(String seedGenre) {
        this.seedGenre = seedGenre;
    }

    public String getSeedArtists() {
        return seedArtists;
    }

    public void setSeedArtists(String seedArtists) {
        this.seedArtists = seedArtists;
    }

    public String getSeedTracks() {
        return seedTracks;
    }

    public void setSeedTracks(String seedTracks) {
        this.seedTracks = seedTracks;
    }
}
