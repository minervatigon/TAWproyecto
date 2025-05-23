<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="es.uma.taw.tawmovies.movies.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.tawmovies.movies.UserType" %>
<%@ page import="es.uma.taw.tawmovies.movies.Lista" %>
<%@ page import="es.uma.taw.tawmovies.movies.MovieList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TAW Movies</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <%
        UserType user = (UserType) request.getAttribute("user");
        List<Lista> listas = (List<Lista>) request.getAttribute("listas");
    %>
    <h1>Listas de <%=user.getUser()%></h1>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Películas</th>
            <th>Duración maratón</th>
            <th> </th>
            <th></th>
        </tr>
        <%
            for(Lista l:listas){
                List<MovieList> movies = l.getMovies();
                Long totalTime = 0L;
        %>
        <tr>
            <td><%=l.getNombre()%></td>
            <td>
                <%
                    for(MovieList m: movies){
                        totalTime += m.getIdMovie().getRuntime();
                %>
                <%=m.getIdMovie().getTitle()%>
                <%
                    }
                %>
            </td>
            <td><%=totalTime%></td>
            <td><a href="/editarLista?act=<%=l.getId()%>">Editar</a> </td>
            <td><a href="/eliminarLista?act=<%=l.getId()%>">Eliminar</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <form method="post" action="/añadirLista">
        <input type="hidden" name="userId" value="<%=user.getId()%>">
        <button type="submit">Añadir película</button>
    </form>
</body>