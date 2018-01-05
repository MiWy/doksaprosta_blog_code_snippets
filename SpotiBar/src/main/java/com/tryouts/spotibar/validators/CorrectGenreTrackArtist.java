package com.tryouts.spotibar.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectSeedsValidator.class)
@Documented
public @interface CorrectGenreTrackArtist {

    String message() default "You have to provide 1-5 artists, track names or genres.";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};

    String seedGenres();
    String seedArtists();
    String seedTracks();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List{
        CorrectGenreTrackArtist[] value();
    }

}
