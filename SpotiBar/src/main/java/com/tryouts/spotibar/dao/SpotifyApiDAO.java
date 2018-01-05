package com.tryouts.spotibar.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Page;
import org.springframework.stereotype.Component;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Track;

@Component
public class SpotifyApiDAO {


    private static final String clientId = "putyourclientidhere";
    private static final String clientSecret = "putyourclientsecrethere";
    private static final String redirectUri = "http://localhost:8080/";
    private static final String state = "putyourstatehere";
    private Api api;

    public SpotifyApiDAO() throws IOException, WebApiException {
        api = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectUri)
                .build();

        final ClientCredentialsGrantRequest request = api.clientCredentialsGrant().build();
        final ClientCredentials response = request.get();

        api.setAccessToken(response.getAccessToken());
    }

    public Api getApi() {
        return api;
    }

    /* TODO Currently method takes first artist from search results.
     *  Need to add a way to ask user which one is correct.
    */

    public List<String> onArtistsSearch(List<String> listOfArtists) throws IOException, WebApiException {
        List<String> listOfArtistsIDs = new ArrayList<String>();
        for(String artist : listOfArtists) {
            final ArtistSearchRequest request = api.searchArtists(artist).limit(1).build();
            final Page<Artist> artistSearchResult = request.get();
            final List<Artist> artists = artistSearchResult.getItems();
            listOfArtistsIDs.add(artists.get(0).getId());
        }
        return listOfArtistsIDs;
    }

    /* TODO Currently method takes first track from search results.
     *  Need to add a way to ask user which one is correct.
     */

    public List<String> onTrackSearch(List<String> listOfTracks) throws IOException, WebApiException {
        List<String> listOfTracksId = new ArrayList<String>();
        for(String track : listOfTracks) {
            final TrackSearchRequest request = api.searchTracks(track).limit(1).build();
            final Page<Track> trackSearchResult = request.get();
            final List<Track> tracks = trackSearchResult.getItems();
            listOfTracksId.add(tracks.get(0).getId());
        }
        return listOfTracksId;
    }
}
