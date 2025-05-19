<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="es.uma.taw.tawmovies.movies.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.tawmovies.movies.UserType" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TAW Movies</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container my-3">
    <%
        UserType loggedInUser = (UserType) session.getAttribute("user");

        if (loggedInUser != null) {
    %>
        <a href="/salir" class="btn btn-outline-secondary btn-sm">Logout</a>
    <%
    } else {

        String errorMessage = (String) request.getAttribute("error");
        // Si hay un mensaje de error, lo mostramos
        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
    <div class="alert alert-danger alert-dismissible fade show p-2" role="alert">
        <%= errorMessage %> <%-- Mostramos el error con una expresión JSP --%>
        <button type="button" class="btn-close p-2" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <%--@elvariable id="usuario" type="es.uma.taw.tawmovies.ui.Usuario"--%>
    <form:form method="post" modelAttribute="usuario" action="/autentica">
        <table>
            <tr>
                <td>Usuario:</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><form:password path="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><form:button>Enviar</form:button></td>
            </tr>
        </table>
    </form:form>
    <%
        }
    %>
</div>

<div class="hero-section m-5">
    <div class="hero-text">
        <h1>Bienvenido a TAW Movies</h1>
        <p>Descubre las últimas películas, las más populares y próximos estrenos.</p>
    </div>
</div>

<%
    List<Movie> trending = (List<Movie>) request.getAttribute("trending");
    List<Movie> topRated = (List<Movie>) request.getAttribute("topRated");
    List<Movie> upcoming = (List<Movie>) request.getAttribute("upcoming");
%>


<jsp:include page="filtros.jsp"/>



<div class="container mt-5">
    <%
        if(loggedInUser!=null && (loggedInUser.getIdRole()==1 || loggedInUser.getIdRole()==3)){
    %>
    <form method="post" action="/añadir">
        <button type="submit">Añadir película</button>
    </form>
    <%
        }
    %>
    <section>
        <h2 class="section-title">Tendencias</h2>
        <div class="row">
            <%
                if (trending != null) {
                    for (Movie movie : trending) {
            %>
            <div class="col-6 col-md-3 mb-4">
                    <div class="card tmdb-card">
                        <a href="/movie/<%= movie.getId() %>" style="text-decoration: none; color: inherit;">
                            <img src="<%= movie.getHomepage() %>" class="card-img-top" alt="<%= movie.getTitle() %>">
                            <div class="card-body">
                                <h5 class="card-title"><%= movie.getTitle() %></h5>
                                <p class="card-text">⭐ <%= movie.getVoteAverage() %></p>
                                <%
                                    if(loggedInUser!=null && loggedInUser.getIdRole()==1){
                                %>
                                <a href="/eliminar?act=<%=movie.getId()%>">Eliminar película</a>
                                <%
                                    }
                                %>
                            </div>
                        </a>
                    </div>
            </div>
            <%
                    } // end for trending
                } // end if trending
            %>
        </div>
    </section>

    <section>
        <h2 class="section-title">Mejor Valoradas</h2>
        <div class="row">
            <%
                if (topRated != null) {
                    for (Movie movie : topRated) {
            %>
            <div class="col-6 col-md-3 mb-4">
                <div class="card tmdb-card">
                    <a href="/movie/<%= movie.getId() %>" style="text-decoration: none; color: inherit;">
                        <img src="<%= movie.getHomepage() %>" class="card-img-top" alt="<%= movie.getTitle() %>">
                        <div class="card-body">
                            <h5 class="card-title"><%= movie.getTitle() %></h5>
                            <p class="card-text">⭐ <%= movie.getVoteAverage() %></p>
                            <%
                                if(loggedInUser!=null && loggedInUser.getIdRole()==1){
                            %>
                            <a href="/eliminar?act=<%=movie.getId()%>">Eliminar película</a>
                            <%
                                }
                            %>
                        </div>
                    </a>
                </div>
            </div>
            <%
                    } // end for topRated
                } // end if topRated
            %>
        </div>
    </section>

    <section>
        <h2 class="section-title">Próximos Estrenos</h2>
        <div class="row">
            <%
                if (upcoming != null) {
                    for (Movie movie : upcoming) {
            %>
            <div class="col-6 col-md-3 mb-4">
                <div class="card tmdb-card">
                    <a href="/movie/<%= movie.getId() %>" style="text-decoration: none; color: inherit;">
                        <img src="<%= movie.getHomepage() %>" class="card-img-top" alt="<%= movie.getTitle() %>">
                        <div class="card-body">
                            <h5 class="card-title"><%= movie.getTitle() %></h5>
                            <p class="card-text">⭐ <%= movie.getVoteAverage() %></p>
                            <%
                                if(loggedInUser!=null && loggedInUser.getIdRole()==1){
                            %>
                            <a href="/eliminar?act=<%=movie.getId()%>">Eliminar película</a>
                            <%
                                }
                            %>
                        </div>
                    </a>
                </div>
            </div>
            <%
                    } // end for upcoming
                } // end if upcoming
            %>
        </div>
    </section>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
