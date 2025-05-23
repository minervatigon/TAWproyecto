<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    %>
    <%--@elvariable id="Movie" type="Movie"--%>
    <form:form method="post" action="/crearLista" modelAttribute="Movie">
        <form:hidden path="userId"><%=user.getId()%></form:hidden>
        <form:checkboxes path="movie" itemLabel="title" itemValue="id" items="movies" element="br"/>
        <form:button>Crear</form:button>
    </form:form>
</body>