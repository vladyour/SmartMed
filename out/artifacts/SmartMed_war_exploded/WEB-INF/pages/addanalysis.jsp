<%--
  Created by IntelliJ IDEA.
  User: vladyour
  Date: 06.06.17
  Time: 22:05
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
    <title>Добавить анализ</title>
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
        <a class="button" href="addlabwork.form">Провести анализ</a>
        <a class="button" href="archive.form">Архив анализов</a>
        <a class="button act" href="addanalysis.form">Добавить анализ</a>
    </div>

    <div class="center">
        <c:url var="addAction" value="/addanalysis/add.form"/>
        <form:form action="${addAction}" modelAttribute="analysis">
            <div class="field">
                Введите название анализа
                <form:input path="analysisTitle" placeholder="Название" cssClass="select"/>
            </div>

            <div class="info">
                *В базе есть набор только анализа голоса и речи. Введите следующее название: "analyzes.csv".
            </div>

            <div class="field">
                <div class="text">Введите название файла с анализом</div>
                <form:input path="analysisKey" placeholder="somename.csv" cssClass="select"/>
            </div>


            <div class="field">
                <div class="text">Введите название файла, где будет храниться нейронная сеть</div>
                <form:input path="analysisWeights" placeholder="somename" cssClass="select"/>
            </div>

            <input type="submit" class="submit" value="<spring:message text="Получить результат"/>"/>
        </form:form>
    </div>
</section>
</body>
</html>
