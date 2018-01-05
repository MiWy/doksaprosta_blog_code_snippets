<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
	<spring:url value="/resources/css/bootswatch.less.css" var="bootswatchLess" />
	<spring:url value="/resources/css/variables.less.css" var="variablesless" />

	<spring:url value="/resources/css/custom.css" var="customCSS" />

	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<spring:url value="/resources/js/jquery-3.2.1.min.js" var="jqueryJS" />

	<script src="${jqueryJS}"></script>
	<script src="${bootstrapJS}"></script>
	<script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip({
                placement : 'right'
            });
        });
	</script>
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet">
	<link href="${bootstrapCSS}" rel="stylesheet"/>
	<link href="${bootswatchLess}" rel="stylesheet"/>
	<link href="${variablesless}" rel="stylesheet"/>
	<link href="${customCSS}" rel="stylesheet" />
</head>

<body class="altbg">

<!-- Top navigation -->
<nav class="navbar navbar-default altnavbg" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/">SpotiBar - Advanced Spotify Search</a>
		</div>
	</div>
</nav>

<!-- Content -->
<div class="container-fluid text-center">
	<!-- Left column -->
	<div class="col-sm-4 col-sm-offset-1">
		<h2 class="text-danger" style="text-transform: uppercase">How to use it</h2>
		<p class="text-justify">You <strong class="text-primary">have</strong> to provide at least one genre, artist or track name
			(up to five in total, separated by comma). Everything else is optional.</p>
		<p class="text-justify">If the field is left empty it will not be used in the search. Hover over the field to get additional details about it.</p>
		<p class="text-justify"><strong>Example</strong>: search query with "Enslaved" in the <strong class="text-primary">ARTIST</strong> field, "20" in
			the <strong class="text-primary">LIMIT</strong> and "0.8" in the <strong class="text-primary">ENERGY</strong> will result in
			a list of 20 highly energetic tracks that are similar (according to Spotify) to Enslaved music. </p>
		<p class="text-justify">SpotiBar uses <a href="https://developer.spotify.com/web-api/">Spotify Web API's</a> Java wrapper
			by <a href="https://github.com/dhughes/spotify-web-api-java">dhuges</a> (forked,
			originally by <a href="https://github.com/thelinmichael/spotify-web-api-java">thelinmichael</a>).</p>
		<p class="text-justify">Currently, SpotiBar
			uses <a href="https://developer.spotify.com/web-api/authorization-guide/#client-credentials-flow">Client Credentials flow</a>.</p>
		<p class="text-justify">All tooltip information was taken from <a href="https://beta.developer.spotify.com/documentation/web-api/reference/browse/get-recommendations/">Spotify</a>.</p>
	</div>

	<!-- Center column with search options -->
	<div class="col-sm-5 col-sm-offset-1">
		<form:form action="/" modelAttribute="criteria" cssClass="form-horizontal" method="post">
			<div class="form-group">
				<div class="col-sm-12">
					<input class="btn btn-primary btn-block" type="submit" value="Search" />
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label for="inputGenre" class="col-sm-4 control-label" data-toggle="tooltip" title="Available: acoustic, afrobeat, alt-rock, alternative, ambient, anime, black-metal, bluegrass, blues, bossanova, brazil, breakbeat, british, cantopop, chicago-house, children, chill, classical, club, comedy, country, dance, dancehall, death-metal, deep-house, detroit-techno, disco, disney, drum-and-bass, dub, dubstep, edm, electro, electronic, emo, folk, forro, french, funk, garage, german, gospel, goth, grindcore, groove, grunge, guitar, happy, hard-rock, hardcore, hardstyle, heavy-metal, hip-hop, holidays, honky-tonk, house, idm, indian, indie, indie-pop, industrial, iranian, j-dance, j-idol, j-pop, j-rock, jazz, k-pop, kids, latin, latino, malay, mandopop, metal, metal-misc, metalcore, minimal-techno, movies, mpb, new-age, new-release, opera, pagode, party, philippines-opm, piano, pop, pop-film, post-dubstep, power-pop, progressive-house, psych-rock, punk, punk-rock, r-n-b, rainy-day, reggae, reggaeton, road-trip, rock, rock-n-roll, rockabilly, romance, sad, salsa, samba, sertanejo, show-tunes, singer-songwriter, ska, sleep, songwriter, soul, soundtracks, spanish, study, summer, swedish, synth-pop, tango, techno, trance, trip-hop, turkish, work-out, world-music.">Genres:</label>
				<div class="col-sm-8">
					<form:input path="seedGenre" id="inputGenre" class="form-control"/><form:errors path="seedGenre" cssClass="error"/>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label for="inputArtists" class="col-sm-4 control-label">Artists:</label>
				<div class="col-sm-8">
					<form:input path="seedArtists" id="inputArtists" class="form-control"/><form:errors path="seedArtists" cssClass="error"/>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label for="inputTracks" class="col-sm-4 control-label">Tracks:</label>
				<div class="col-sm-8">
					<form:input path="seedTracks" id="inputTracks" class="form-control"/><form:errors path="seedTracks" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputLimit" class="col-sm-4 control-label" data-toggle="tooltip" title="The target size of the list of recommended tracks. For seeds with unusually small pools or when highly restrictive filtering is applied, it may be impossible to generate the requested number of recommended tracks. Default: 20. Minimum: 1. Maximum: 100.">Limit (1-100):</label>
				<div class="col-sm-8">
					<form:input path="limit" id="inputLimit" class="form-control"/><form:errors path="limit" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputAcousticness" class="col-sm-4 control-label" data-toggle="tooltip" title="1.0 represents high confidence the track is acoustic.">Acousticness (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="acousticness" id="inputAcousticness" class="form-control"/><form:errors path="acousticness" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputDanceability" class="col-sm-4 control-label" data-toggle="tooltip" title="Danceability describes how suitable a track is for dancing based on a combination of musical elements including tempo, rhythm stability, beat strength, and overall regularity. A value of 0.0 is least danceable and 1.0 is most danceable.">Danceability (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="danceability" id="inputDanceability" class="form-control"/><form:errors path="danceability" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputDuration" class="col-sm-4 control-label">Duration (in seconds):</label>
				<div class="col-sm-8">
					<form:input path="duration" id="inputDuration" class="form-control"/><form:errors path="duration" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEnergy" class="col-sm-4 control-label" data-toggle="tooltip" title="Represents a perceptual measure of intensity and activity. Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy, while a Bach prelude scores low on the scale. Perceptual features contributing to this attribute include dynamic range, perceived loudness, timbre, onset rate, and general entropy.">Energy (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="energy" id="inputEnergy" class="form-control"/><form:errors path="energy" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputInstrumentalness" class="col-sm-4 control-label" data-toggle="tooltip" title="Predicts whether a track contains no vocals. “Ooh” and “aah” sounds are treated as instrumental in this context. Rap or spoken word tracks are clearly “vocal”. The closer the instrumentalness value is to 1.0, the greater likelihood the track contains no vocal content.">Instrumentalness (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="instrumentalness" id="inputInstrumentalness" class="form-control"/><form:errors path="instrumentalness" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputLiveness" class="col-sm-4 control-label" data-toggle="tooltip" title="Detects the presence of an audience in the recording. Higher liveness values represent an increased probability that the track was performed live. A value above 0.8 provides strong likelihood that the track is live.">Liveness (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="liveness" id="inputLiveness" class="form-control"/><form:errors path="liveness" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputKey" class="col-sm-4 control-label" data-toggle="tooltip" title="The key the track is in. Integers map to pitches using standard Pitch Class notation. E.g. 0 = C, 1 = C#, 2 = D, and so on.">Key (0 = C, 2 = D, and so on):</label>
				<div class="col-sm-8">
					<form:input path="key" id="inputKey" class="form-control"/><form:errors path="key" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputMajorOrMinus" class="col-sm-4 control-label" data-toggle="tooltip" title="Indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived. Major is represented by 1 and minor is 0.">Major/Minus (1/0):</label>
				<div class="col-sm-8">
					<form:input path="majorOrMinus" id="inputMajorOrMinus" class="form-control"/><form:errors path="majorOrMinus" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPopularity" class="col-sm-4 control-label">Popularity (0-100):</label>
				<div class="col-sm-8">
					<form:input path="popularity" id="inputPopularity" class="form-control"/><form:errors path="popularity" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputSpeechiness" class="col-sm-4 control-label" data-toggle="tooltip" title="Speechiness detects the presence of spoken words in a track. The more exclusively speech-like the recording (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value. Values above 0.66 describe tracks that are probably made entirely of spoken words. Values between 0.33 and 0.66 describe tracks that may contain both music and speech, either in sections or layered, including such cases as rap music. Values below 0.33 most likely represent music and other non-speech-like tracks.">Speechiness (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="speechiness" id="inputSpeechiness" class="form-control"/><form:errors path="speechiness" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputTempo" class="col-sm-4 control-label">Tempo (BPM):</label>
				<div class="col-sm-8">
					<form:input path="tempo" id="inputTempo" class="form-control"/><form:errors path="tempo" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputValence" class="col-sm-4 control-label" data-toggle="tooltip" title="A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track. Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric), while tracks with low valence sound more negative (e.g. sad, depressed, angry).">Valence (0.00-1.00):</label>
				<div class="col-sm-8">
					<form:input path="valence" id="inputValence" class="form-control"/><form:errors path="valence" cssClass="error"/>
				</div>
			</div>
		</form:form>
	</div>
</div>

<br/>
<!-- Footer -->
<footer class="container-fluid text-center">
	<p><a href="http://doksaprosta.scholaris-edu.pl">Tryouts</p>
</footer>

</body>

</html>
