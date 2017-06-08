<%--
  Created by IntelliJ IDEA.
  User: vladyour
  Date: 06.06.17
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SmartMed</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
  </head>
  <body>
  <section id="hat">
    <header class="container">
      <div class="name">
        Юревич Владислав
      </div>
      <div class="demonstration">
        демонстрация выпускной квалификационной работы
      </div>
    </header>

    <div class="container">
      <div class="right">
        <div class="info">
          Данное приложение было разработано для лаборанта, принимающего анализы у пациентов.
          Войдя в систему, вы сможете получить результаты анализа голоса и речи нескольких пациентов с подозрением на заболевание Паркинсона,
          просмотреть архив ранее проведённых анализов, добавить в базу новый анализ, загрузив большой набор маркированных данных.
        </div>
        <%--<a class="button" href="#email">--%>
        <%--узнать первым!--%>
        <%--</a>--%>
        <a href="/addlabwork.form" class="button">Начать</a>
      </div>
    </div>
  </section>

  <section class="kira">
    <div class="text">
        github.com/vladyour/SmartMed
    </div>
  </section>

  <section id="bottom">
    <div class="bottom">
      <div class="uni">
        Санкт-Петербургский государственный университет
      </div>
      <div class="fac">
        Факультет прикладной математики - процессов управления
      </div>
    </div>
  </section>
  </body>
</html>
