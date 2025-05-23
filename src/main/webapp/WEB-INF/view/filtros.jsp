
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container mt-4">
    <h2 class="mb-4">Filtrar películas</h2>

    <form:form modelAttribute="filtro" method="post" action="/filtrarPeliculas">
        <div class="row g-3">

            <div class="col-md-4">
                <form:label path="originalLanguage" cssClass="form-label">Idioma original</form:label>
                <form:input path="originalLanguage" cssClass="form-control"/>
            </div>

            <div class="col-md-4">
                <form:label path="popMin" cssClass="form-label">Popularidad mín.</form:label>
                <form:input path="popMin" type="number" step="0.01" cssClass="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="popMax" cssClass="form-label">Popularidad máx.</form:label>
                <form:input path="popMax" type="number" step="0.01" cssClass="form-control"/>
            </div>

            <div class="col-md-4">
                <form:label path="startDate" cssClass="form-label">Fecha desde</form:label>
                <form:input path="startDate" type="date" cssClass="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="endDate" cssClass="form-label">Fecha hasta</form:label>
                <form:input path="endDate" type="date" cssClass="form-control"/>
            </div>

            <div class="col-md-4">
                <form:label path="durMin" cssClass="form-label">Duración mín. (min)</form:label>
                <form:input path="durMin" type="number" cssClass="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="durMax" cssClass="form-label">Duración máx. (min)</form:label>
                <form:input path="durMax" type="number" cssClass="form-control"/>
            </div>

            <div class="col-md-4">
                <form:label path="voteMin" cssClass="form-label">Voto mín.</form:label>
                <form:input path="voteMin" type="number" step="0.1" cssClass="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="voteMax" cssClass="form-label">Voto máx.</form:label>
                <form:input path="voteMax" type="number" step="0.1" cssClass="form-control"/>
            </div>

            <div class="col-md-4">
                <form:label path="genreId" cssClass="form-label">Género</form:label>
                <form:select path="genreId" cssClass="form-select">
                    <form:option value="">--Todos--</form:option>
                    <form:options items="${genders}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>

            <div class="col-md-4">
                <form:label path="languageId" cssClass="form-label">Idioma</form:label>
                <form:select path="languageId" cssClass="form-select">
                    <form:option value="">--Todos--</form:option>
                    <form:options items="${spokenLanguages}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>

            <div class="col-md-4">
                <form:label path="title" cssClass="form-label">Título contiene</form:label>
                <form:input path="title" cssClass="form-control"/>
            </div>

            <div class="col-12 text-end">
                <button type="submit" class="btn btn-primary">Filtrar</button>
            </div>
        </div>
    </form:form>


</div>
