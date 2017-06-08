<%--
  Created by IntelliJ IDEA.
  User: vladyour
  Date: 06.06.17
  Time: 18:46
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
    <title>Результат</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
    <link rel="stylesheet" href="../../css/bar.css" type="text/css">
    <link rel="stylesheet" href="../../css/navbar.css" type="text/css">
    <link rel="stylesheet" href="../../css/archives.css" type="text/css">
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
        <a class="button" href="/addlabwork.form">Провести анализ</a>
        <a class="button" href="/archives.form">Архив анализов</a>
        <a class="button" href="/newanalysis.form">Добавить анализ</a>
    </div>
    <div class="info">
        Анализ успешно принят.
        <br>
        Статус болезни пациента Вы можете узнать в архиве.

        <a href="/archive.form" class="submit">Архив</a>
    </div>
</section>
</body>
</html>
