package com.tryouts.spotibar.dao;

import com.wrapper.spotify.exceptions.WebApiException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RecommendationSearchCriteria {

    private final Integer limit;
    private final BigDecimal acousticness;
    private final BigDecimal danceability;
    private final Integer duration;
    private final BigDecimal energy;
    private final BigDecimal instrumentalness;
    private final BigDecimal liveness;
    private final Integer key;
    private final Integer majorOrMinus;
    private final Integer popularity;
    private final BigDecimal speechiness;
    private final Integer tempo;
    private final BigDecimal valence;
    private final List<String> seedGenre;
    private final List<String> seedArtists;
    private final List<String> seedTracks;

    private RecommendationSearchCriteria(RecommendationCriteriaBuilder builder) {
        this.limit = builder.limit;
        this.acousticness = builder.acousticness;
        this.danceability = builder.danceability;
        this.duration = builder.duration;
        this.energy = builder.energy;
        this.instrumentalness = builder.instrumentalness;
        this.liveness = builder.liveness;
        this.key = builder.key;
        this.majorOrMinus = builder.majorOrMinus;
        this.popularity = builder.popularity;
        this.speechiness = builder.speechiness;
        this.tempo = builder.tempo;
        this.valence = builder.valence;
        this.seedGenre = builder.seedGenre;
        this.seedArtists = builder.seedArtists;
        this.seedTracks = builder.seedTracks;
    }

    public Integer getLimit() {
        return limit;
    }

    public BigDecimal getAcousticness() {
        return acousticness;
    }

    public BigDecimal getDanceability() {
        return danceability;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public BigDecimal getInstrumentalness() {
        return instrumentalness;
    }

    public BigDecimal getLiveness() {
        return liveness;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getMajorOrMinus() {
        return majorOrMinus;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public BigDecimal getSpeechiness() {
        return speechiness;
    }

    public Integer getTempo() {
        return tempo;
    }

    public BigDecimal getValence() {
        return valence;
    }

    public List<String> getSeedGenre() {
        return seedGenre;
    }

    public List<String> getSeedArtists() {
        return seedArtists;
    }

    public List<String> getSeedTracks() {
        return seedTracks;
    }


    public static class RecommendationCriteriaBuilder {

        private Integer limit;
        private BigDecimal acousticness;
        private BigDecimal danceability;
        private Integer duration;
        private BigDecimal energy;
        private BigDecimal instrumentalness;
        private BigDecimal liveness;
        private Integer key;
        private Integer majorOrMinus;
        private Integer popularity;
        private BigDecimal speechiness;
        private Integer tempo;
        private BigDecimal valence;
        private List<String> seedGenre;
        private List<String> seedArtists;
        private List<String> seedTracks;

        private SpotifyApiDAO apiDAO = new SpotifyApiDAO();

        public RecommendationCriteriaBuilder() throws IOException, WebApiException {

        }

        public RecommendationCriteriaBuilder limit(Integer limit) {
            if(limit == null) {
                return this;
            }
            if(limit > 0) {
                this.limit = limit;
            }
            return this;
        }

        public RecommendationCriteriaBuilder acousticness(BigDecimal acousticness) {
            if(acousticness == null) {
                return this;
            }
            double value = acousticness.doubleValue();
            if(0 <= value && value <= 1) {
                this.acousticness = acousticness;
            }
            return this;
        }

        public RecommendationCriteriaBuilder danceability(BigDecimal danceability) {
            if(danceability == null) {
                return this;
            }
            double value = danceability.doubleValue();
            if(0 <= value && value <= 1) {
                this.danceability = danceability;
            }
            return this;
        }

        public RecommendationCriteriaBuilder duration(Integer duration) {
            if(duration == null) {
                return this;
            }
            if(duration > 0) {
                this.duration = duration;
            }
            return this;
        }

        public RecommendationCriteriaBuilder energy(BigDecimal energy) {
            if(energy == null) {
                return this;
            }
            double value = energy.doubleValue();
            if(0 <= value && value <= 1) {
                this.energy = energy;
            }
            return this;
        }

        public RecommendationCriteriaBuilder instrumentalness(BigDecimal instrumentalness) {
            if(instrumentalness == null) {
                return this;
            }
            double value = instrumentalness.doubleValue();
            if(0 <= value && value <= 1) {
                this.instrumentalness = instrumentalness;
            }
            return this;
        }

        public RecommendationCriteriaBuilder liveness(BigDecimal liveness) {
            if(liveness == null) {
                return this;
            }
            double value = liveness.doubleValue();
            if(0 <= value && value <= 1) {
                this.liveness = liveness;
            }
            return this;
        }

        public RecommendationCriteriaBuilder key(Integer key) {
            if(key == null) {
                return this;
            }
            if(-1 < key && key < 8) {
                this.key = key;
            }
            return this;
        }

        public RecommendationCriteriaBuilder majorOrMinus(Integer majorOrMinus) {
            if(majorOrMinus == null) {
                return this;
            }
            if(majorOrMinus == 1 || majorOrMinus == 0) {
                this.majorOrMinus = majorOrMinus;
            }
            return this;
        }

        public RecommendationCriteriaBuilder popularity(Integer popularity) {
            if(popularity == null) {
                return this;
            }
            if(-1 < popularity && popularity < 101) {
                this.popularity = popularity;
            }
            return this;
        }

        public RecommendationCriteriaBuilder speechiness(BigDecimal speechiness) {
            if(speechiness == null) {
                return this;
            }
            double value = speechiness.doubleValue();
            if(0 <= value && value <= 1) {
                this.speechiness = speechiness;
            }
            return this;
        }

        public RecommendationCriteriaBuilder tempo(Integer tempo) {
            if(tempo == null) {
                return this;
            }
            if(tempo > 0) {
                this.tempo = tempo;
            }
            return this;
        }

        public RecommendationCriteriaBuilder valence(BigDecimal valence) {
            if(valence == null) {
                return this;
            }
            double value = valence.doubleValue();
            if(0 <= value && value <= 1) {
                this.valence = valence;
            }
            return this;
        }

        public RecommendationCriteriaBuilder seedGenre(String seedGenre) {
            if(seedGenre == null) {
                return this;
            }
            if(!seedGenre.equals("")) {
                String[] genres = seedGenre.split(",");
                List<String> listOfGenres = Arrays.asList(genres);
                this.seedGenre = listOfGenres;
            }
            return this;
        }

        public RecommendationCriteriaBuilder seedArtists(String seedArtists) throws IOException, WebApiException {
            if(seedArtists == null) {
                return this;
            }
            if(!seedArtists.equals("")) {
                String[] artists = seedArtists.split(",");
                List<String> listOfArtists = Arrays.asList(artists);
                List<String> listOfArtistsID = apiDAO.onArtistsSearch(listOfArtists);
                this.seedArtists = listOfArtistsID;
            }
            return this;
        }

        public RecommendationCriteriaBuilder seedTracks(String seedTracks) throws IOException, WebApiException {
            if(seedTracks == null) {
                return this;
            }
            if(!seedTracks.equals("")) {
                String[] tracks = seedTracks.split(",");
                List<String> listOfTracks = Arrays.asList(tracks);
                List<String> listOfTracksID = apiDAO.onTrackSearch(listOfTracks);
                this.seedTracks = listOfTracksID;
            }
            return this;
        }

        public RecommendationCriteriaBuilder searchCriteria(SearchCriteria searchCriteria) throws IOException, WebApiException {
            this.limit(searchCriteria.getLimit());
            this.danceability(searchCriteria.getDanceability());
            this.acousticness(searchCriteria.getAcousticness());
            this.duration(searchCriteria.getDuration());
            this.energy(searchCriteria.getEnergy());
            this.instrumentalness(searchCriteria.getInstrumentalness());
            this.liveness(searchCriteria.getLiveness());
            this.key(searchCriteria.getKey());
            this.majorOrMinus(searchCriteria.getMajorOrMinus());
            this.tempo(searchCriteria.getTempo());
            this.valence(searchCriteria.getValence());
            this.speechiness(searchCriteria.getSpeechiness());
            this.seedArtists(searchCriteria.getSeedArtists());
            this.seedGenre(searchCriteria.getSeedGenre());
            this.seedTracks(searchCriteria.getSeedTracks());
            return this;
        }

        public RecommendationSearchCriteria build() {
            return new RecommendationSearchCriteria(this);
        }

    }

}
