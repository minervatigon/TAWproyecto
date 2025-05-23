<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="es.uma.taw.tawmovies.movies.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.tawmovies.movies.UserType" %>
<%@ page import="es.uma.taw.tawmovies.movies.Gender" %>
<%@ page import="es.uma.taw.tawmovies.movies.SpokenLanguage" %>
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

    <%
        List<Gender> generos = (List<Gender>) request.getAttribute("generos");
        List<SpokenLanguage> languages = (List<SpokenLanguage>) request.getAttribute("languages");
    %>
 <div  class="container mt-4">
     <h1>Añadir película</h1>
     <h3>Rellena los siguientes campos: </h3>
    <form method="post" action="/crearMovie">
        <label>Presupuesto: </label>
        <input name="budget" type="number" size="5"><br/>
        <label>Enlace: </label>
        <input name="homepage" type="text" size="100"><br/>
        <label>Idioma original: </label>
        <input name="orlan" type="text" size="50"><br/>
        <label>Título original: </label>
        <input name="ortit" type="text" size="100"><br/>
        <label>Resumen: </label>
        <textarea name="overview" rows="3" cols="20"></textarea><br/>
        <label>Popularidad: </label>
        <input name="pop" type="number" size="5"><br/>
        <label>Fecha de estreno: </label>
        <input name="reldate" type="date"><br/>
        <label>Duración: </label>
        <input name="runtime" type="number"><br/>
        <label>Beneficios: </label>
        <input name="revenue" type="number"><br/>
        <label>Estatus: </label>
        <input name="status" type="text" size="45"><br/>
        <label>Title: </label>
        <input name="title" type="text" size="100"><br/>
        <label>Eslogan: </label>
        <input name="tagline" type="text" size="100"><br/>
        <label>Valoración: </label>
        <input name="voteavg" type="number" step="any"><br/>
        <label>Votantes: </label>
        <input name="votecount" type="number"><br/>

        <label>Géneros: </label><br/>
        <%
            for(Gender g:generos){
        %>
         <%=g.getName()%> <input name="generos" type="checkbox" value="<%=g.getId()%>">
        <%
            }
        %>
        <br/>
        <label>Idiomas: </label><br/>
        <%
            for(SpokenLanguage l:languages){
        %>
        <%=l.getName()%> <input name="languages" type="checkbox" value="<%=l.getId()%>">
        <%
            }
        %>
        <br/>
           <script>
               function anyadirpersonaje(){
                   const char = document.createElement('input');
                   char.type = 'text';
                   char.name = 'castChar';
                   char.placeholder = 'Nombre del personaje';

                   const person = document.createElement('input');
                   person.type = 'text';
                   person.name = 'castPer';
                   person.placeholder = 'Nombre de la persona';

                   const genero = document.createElement('input');
                   genero.type = 'number';
                   genero.name = 'castGen';
                   genero.placeholder = 'Género(0 mujer,1 hombre)';

                   const ord = document.createElement('input');
                   ord.type = 'number';
                   ord.name = 'ord';
                   ord.placeholder = 'Orden(prioridad del actor)';

                   const contenedorReparto = document.getElementById('contenedorReparto');

                   contenedorReparto.appendChild(char);
                   contenedorReparto.appendChild(person);
                   contenedorReparto.appendChild(genero);
                   contenedorReparto.appendChild(ord);
                   contenedorReparto.appendChild(document.createElement('br'));

                   return char;
               }
           </script>
        <label>Reparto: </label><br/>
        <button type="button" onclick="anyadirpersonaje()">Añadir personaje principal</button><br/>
        <div id="contenedorReparto"></div>
        <br/>
        <button type="submit">Crear</button>
    </form>

 </div>
</body>