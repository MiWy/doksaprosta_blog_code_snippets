<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="row content">

        <!-- Left column -->
        <div class="row">
            <h1 class="searchresults">SEARCH RESULTS</h1>
        </div>

        <%--Center grid-based layout--%>
        <div class="container">
            <c:forEach items="${searchResults}" var="track" varStatus="rowCounter">
                <c:if test="${rowCounter.count % 4 == 1}">
                    <div class="row row-eq-height justify-content-center rowmargins">
                </c:if>
                <div class="col-sm-3">
                    <img src="${track.album.images.get(track.album.images.size()-2).url}" width="200px" height="200px"/>
                    <p class="firstparagraphingrid paragraphingrid">
                        <c:forEach items="${track.artists}" var="artist">
                            <a class="spotify-font-artist-name" href="${artist.uri}">${artist.name}</a>
                        </c:forEach>
                    </p>
                    <p class="paragraphingrid"><strong><a class="text-warning" href="${track.uri}">${track.name}</a></strong></p>
                    <p class="paragraphingrid"><a class="spotify-font-color" href="${track.album.uri}">${track.album.name}</a></p>
                    <p class="paragraphingrid spotify-font-color" style="font-size: smaller">Popularity: ${track.popularity}</p>
                </div>
                <c:if test="${rowCounter.count % 4 == 0 || rowCounter.count == fn:length(searchResults)}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<br/>
<!-- Footer -->
<footer class="container-fluid text-center">
    <p><a href="http://doksaprosta.scholaris-edu.pl">Tryouts</p>
</footer>

</body>

</html>
