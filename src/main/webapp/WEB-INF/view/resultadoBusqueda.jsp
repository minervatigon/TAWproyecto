<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="es.uma.taw.tawmovies.movies.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.tawmovies.movies.UserType" %>
<html>
<head>
    <title>Resultados de búsqueda</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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

<div class="container mt-5">

    <div class="row align-items-center mb-3">
        <div class="col">
<%--            <h1>Resultados de búsqueda para "<%= request.getAttribute("query") %>"</h1>--%>
        </div>
        <div class="col text-end">
            <a href="/" class="btn btn-primary">⬅️ Volver a inicio</a>
        </div>
    </div>

    <jsp:include page="filtros.jsp"/>


    <%
        List<Movie> resultados = (List<Movie>) request.getAttribute("resultados");
        if (resultados == null || resultados.isEmpty()) {
    %>
    <p>No se encontraron resultados.</p>
    <%
    } else {
    %>


    <div class="row">
        <%
            for (Movie movie : resultados) {
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
            }
        %>
    </div>

    <%
        }
    %>
</div>

</body>
</html>
