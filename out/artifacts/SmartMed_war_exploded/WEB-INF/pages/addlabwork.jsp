<%--
  Created by IntelliJ IDEA.
  User: vladyour
  Date: 06.06.17
  Time: 15:10
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
    <title>Провести анализ</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
    <link rel="stylesheet" href="../../css/bar.css" type="text/css">
    <link rel="stylesheet" href="../../css/navbar.css" type="text/css">
    <link rel="stylesheet" href="../../css/getanalysis.css" type="text/css">
</head>
<body>
<section id="bar">
    <header>
        <div class="barinfo">
            <img src="../../img/ava.png" class="img">
            <div class="data">
                <div class="name">
                    Умномедов Арсений Германович
                </div>
                <div class="profession">
                    лаборант
                </div>
            </div>
        </div>

        <div class="logo">
            SmartMed
        </div>
        <div class="diploma">
            Демонстрация выпусной квалификационной работы Выполнил Юревич Владислав
        </div>
    </header>
</section>
<section id="main">
    <div class="navbar">
        <a class="button act" href="addlabwork.form">Провести анализ</a>
        <a class="button" href="archive.form">Архив анализов</a>
        <a class="button" href="addanalysis.form">Добавить анализ</a>
    </div>

    <div class="center">
        <c:url var="addAction" value="/addlabwork/add.form"/>
        <form:form action="${addAction}" modelAttribute="labwork">
            <div class="field">
                Выберите пациента
                <form:select path="patientId" cssClass="select">
                    <c:forEach items="${patients}" var="patient">
                        <form:option value="${patient.patientId}">${patient.patientSecondName} ${patient.patientFirstName} ${patient.patientPatronymic}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="field">
                Выберите анализ
                <form:select path="analysisId" cssClass="select">
                    <c:forEach items="${analyzes}" var="analysis">
                        <form:option value="${analysis.analysisId}">${analysis.analysisTitle}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="info">
                *В базе есть набор только из 5 анализов. Введите один из следующих: "1.csv", "2.csv", "3.csv", "4.csv", "5.csv".
            </div>

            <div class="field">
                Введите название файла с анализом
                <form:input path="labworkResult" placeholder="somename.csv" cssClass="select"/>
            </div>

            <input type="submit" class="submit" value="<spring:message text="Получить результат"/>"/>
        </form:form>
    </div>
</section>
</body>
</html>
