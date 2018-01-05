package com.tryouts.spotibar.utils;

import com.tryouts.spotibar.dao.RecommendationSearchCriteria;
import com.tryouts.spotibar.dao.SpotifyApiDAO;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.RecommendationsRequest;

import java.io.IOException;

public class RecommendationRequestUtil {

    private RecommendationsRequest.Builder requestBuilder;

    private SpotifyApiDAO apiDAO;

    public RecommendationRequestUtil(RecommendationSearchCriteria criteria) throws IOException, WebApiException {

        apiDAO = new SpotifyApiDAO();

        requestBuilder = apiDAO.getApi().getRecommendations();

        if(criteria.getLimit() != null) {
            requestBuilder = requestBuilder.limit(criteria.getLimit());
        }
        if(criteria.getAcousticness() != null) {
            requestBuilder = requestBuilder.acousticness(criteria.getAcousticness().floatValue());
        }
        if(criteria.getDanceability() != null) {
            requestBuilder = requestBuilder.danceability(criteria.getDanceability().floatValue());
        }
        if(criteria.getDuration() != null) {
            requestBuilder = requestBuilder.durationMs(criteria.getDuration() * 1000);
        }
        if(criteria.getEnergy() != null) {
            requestBuilder = requestBuilder.energy(criteria.getEnergy().floatValue());
        }
        if(criteria.getInstrumentalness() != null) {
            requestBuilder = requestBuilder.instrumentalness(criteria.getInstrumentalness().floatValue());
        }
        if(criteria.getLiveness() != null) {
            requestBuilder = requestBuilder.liveness(criteria.getLiveness().floatValue());
        }
        if(criteria.getKey() != null) {
            requestBuilder = requestBuilder.key(criteria.getKey());
        }
        if(criteria.getMajorOrMinus() != null) {
            requestBuilder = requestBuilder.mode(criteria.getMajorOrMinus());
        }
        if(criteria.getPopularity() != null) {
            requestBuilder = requestBuilder.popularity(criteria.getPopularity());
        }
        if(criteria.getSpeechiness() != null) {
            requestBuilder = requestBuilder.speechiness(criteria.getSpeechiness().floatValue());
        }
        if(criteria.getTempo() != null) {
            requestBuilder = requestBuilder.tempo(criteria.getTempo());
        }
        if(criteria.getValence() != null) {
            requestBuilder = requestBuilder.valence(criteria.getValence().floatValue());
        }
        if(!(criteria.getSeedGenre() == null || criteria.getSeedGenre().equals(""))) {
            requestBuilder = requestBuilder.seedGenre(criteria.getSeedGenre());
        }
        if(!(criteria.getSeedArtists() == null || criteria.getSeedArtists().equals(""))) {
            requestBuilder = requestBuilder.seedArtists(criteria.getSeedArtists());
        }
        if(!(criteria.getSeedTracks() == null || criteria.getSeedTracks().equals(""))) {
            requestBuilder = requestBuilder.seedTrack(criteria.getSeedTracks());
        }
    }

    public RecommendationsRequest getRecommendationRequest() {
        return requestBuilder.build();
    }

}
