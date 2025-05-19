<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.tawmovies.movies.*" %>
<html>
<head>
    <title>Detalles de Película</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <a href="/" class="btn btn-secondary mb-3">⬅️ Volver</a>

    <%
        UserType loggedInUser = (UserType) session.getAttribute("user");
        Movie movie = (Movie) request.getAttribute("movie");
        List<SpokenLanguage> languages = (List<SpokenLanguage>) request.getAttribute("languages");
        List<Gender> generos = (List<Gender>) request.getAttribute("generos");
    %>

    <div class="row">
        <div class="col-md-4">
            <img src="<%= movie.getHomepage() %>" class="img-fluid rounded" alt="<%= movie.getTitle() %>">
        </div>
        <%
            if(loggedInUser!=null && (loggedInUser.getIdRole()==1) || loggedInUser.getIdRole()==3){

        %>
        <div class="col-md-8">
            <form method="post" action="/editar">
                <input name="id" type="hidden" value="<%=movie.getId()%>">
                <h1><input name="titulo" type="text" size="50" value="<%=movie.getTitle()%>"/></h1><br/>
                <label><strong>Fecha de estreno:</strong></label>
                <input name="fecha" type="date" size="15" value="<%= movie.getReleaseDate() %>"/><br/>
                <label><strong>Duración:</strong></label>
                <input name="duracion" type="number" size="5" value="<%= movie.getRuntime() %>">mins<br/>
                <p><strong>Valoración:</strong> ⭐<%= movie.getVoteAverage() %> / 10</p>
                <label><strong>Idioma original:</strong></label>
                <input name="idioma" type="text" size="5" value="<%=movie.getOriginalLanguage() %>"><br/>
                <label><strong>Resumen:</strong></label><br/>
                <textarea name="resumen" cols="50" rows="5"> <%=movie.getOverview()%></textarea><br/>

                <h3 class="mt-4">Reparto principal:</h3>
                <%
                    List<Cast> castList = movie.getCastList();
                    for (Cast actor : castList) {
                %>
                <input name="character" type="text" value="<%= actor.getCharacters() %>">
                interpreted by  <input name="actor" type="text" value="<%=actor.getIdPerson().getName()%>">
                with order <input name="order" type="number" value="<%=actor.getOrder()%>">
                <br/>
                <%
                    }
                %>

                <h3 class="mt-4">Idiomas de la pelicula</h3>
                <%
                    List<SpokenLanguage> languagesMovie = movie.getLanguages();
                    String checked = "";
                    for (SpokenLanguage l : languages) {
                        if(languagesMovie.contains(l)){
                            checked="checked";
                        }else{
                            checked="";
                        }
                %>
                <%=l.getName()%> <input name="languages" type="checkbox" value="<%= l.getId() %>" <%=checked%>>
                <%
                    }
                %>

                <h3 class="mt-4">Géneros de la pelicula</h3>
                <%
                    List<Gender> gendersMovie = movie.getGenres();
                    String checked2="";
                    for (Gender g : generos) {
                        if(gendersMovie.contains(g)){
                            checked2 = "checked";
                        }else{
                            checked2 = "";
                        }
                %>
                <%=g.getName()%> <input name="generos" type="checkbox" value="<%= g.getId() %>" <%=checked2%>>
                <%
                    }
                %>

                <button type="submit">Guardar cambios</button>

            </form>
        </div>
        <%
            }else{
        %>
        <div class="col-md-8">
            <h1><%= movie.getTitle() %></h1>
            <p><strong>Fecha de estreno:</strong> <%= movie.getReleaseDate() %></p>
            <p><strong>Duración:</strong> <%= movie.getRuntime() %> min</p>
            <p><strong>Valoración:</strong> ⭐ <%= movie.getVoteAverage() %> / 10</p>
            <p><strong>Idioma original:</strong> <%= movie.getOriginalLanguage() %></p>
            <p><strong>Resumen:</strong> <%= movie.getOverview() %></p>

            <h3 class="mt-4">Reparto principal:</h3>
            <ul>
                <%
                    List<Cast> castList = movie.getCastList();
                    for (Cast actor : castList) {
                %>
                <li><%= actor.getCharacters() %></li>
                <%
                    }
                %>
            </ul>

            <h3 class="mt-4">Idiomas de la pelicula</h3>
            <ul>
                <%
                    List<SpokenLanguage> languagesMovie = movie.getLanguages();
                    for (SpokenLanguage l : languagesMovie) {
                %>
                <li><%= l.getName() %></li>
                <%
                    }
                %>
            </ul>

            <h3 class="mt-4">Géneros de la pelicula</h3>
            <ul>
                <%
                    List<Gender> gendersMovie = movie.getGenres();
                    for (Gender g : gendersMovie) {
                %>
                <li><%= g.getName() %></li>
                <%
                    }
                %>
            </ul>

         </div>
    </div>
    <%
        }
    %>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
