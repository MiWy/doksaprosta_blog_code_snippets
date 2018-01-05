package com.tryouts.spotibar.validators;

import com.tryouts.spotibar.dao.SearchCriteria;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CorrectSeedsValidator implements ConstraintValidator<CorrectGenreTrackArtist, SearchCriteria> {

    String seedGenres;
    String seedArtists;
    String seedTracks;
    String errorMessage;

    public void initialize(CorrectGenreTrackArtist constraint) {
        seedGenres = constraint.seedGenres();
        seedArtists = constraint.seedArtists();
        seedTracks = constraint.seedTracks();
        errorMessage = constraint.message();
    }

    public boolean isValid(SearchCriteria value, ConstraintValidatorContext context) {
        boolean toReturn = false;
        try {

            String genresObject = BeanUtils.getProperty(value, seedGenres);
            String artistsObject = BeanUtils.getProperty(value, seedArtists);
            String tracksObject = BeanUtils.getProperty(value, seedTracks);


            toReturn = (genresObject != null || artistsObject != null
                    || tracksObject != null) && isCountValid(genresObject, artistsObject, tracksObject);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if(!toReturn) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(seedGenres).addConstraintViolation();
        }
        return toReturn;

    }

    private boolean isCountValid(String genresObject, String artistsObject, String tracksObject) {

        String allSeeds = Stream.of(genresObject, artistsObject, tracksObject)
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining(","));
        int counter = 0;
        for(int i=0;i<allSeeds.length();i++) {
            if(allSeeds.charAt(i) == ',') {
                counter++;
            }
        }
        counter++;
        if(counter > 0 && counter <= 5) {
            return true;
        }
        return false;

    }


}
