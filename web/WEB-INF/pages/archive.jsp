<%--
  Created by IntelliJ IDEA.
  User: vladyour
  Date: 06.06.17
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Архив</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
    <link rel="stylesheet" href="../../css/bar.css" type="text/css">
    <link rel="stylesheet" href="../../css/navbar.css" type="text/css">
    <link rel="stylesheet" href="../../css/archives.css" type="text/css">
</head>
<body>
<section id="bar">
    <header>
        <img src="../../img/ava.png" class="img">
        <div class="data">
            <div class="name">
                Умномедов Арсений Германович
            </div>
            <div class="profession">
                лаборант
            </div>
        </div>
    </header>
</section>

<section id="main">
    <div class="navbar">
        <a class="button" href="addlabwork.form">Провести анализ</a>
        <a class="button act" href="archive.form">Архив анализов</a>
        <a class="button" href="addanalysis.form">Добавить анализ</a>
    </div>

    <c:if test="${empty labworks}">
        <div class="info">
            К сожалению, Вы пока не приняли ни одного анализа.

            <a href="addlabwork.form" class="submit">Принять</a>
        </div>
    </c:if>
    <div class="table">
        <c:if test="${!empty labworks}">
            <table class="box">
                <tr><th>Пациент</th><th>Наименование анализа</th><th>Дата проведения</th><th>Статус</th></tr>
                <c:forEach items="${labworks}" var="labwork">
                    <tr><td>${labwork.patientByPatient.patientSecondName}
                            ${labwork.patientByPatient.patientFirstName}
                            ${labwork.patientByPatient.patientPatronymic}</td>
                        <td>${labwork.analysisByAnalysisId.analysisTitle}</td>
                        <td>${labwork.labworkDate}</td>
                        <td>${labwork.diagnosis}</td></tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</section>
</body>
</html>
