<%--
  Created by IntelliJ IDEA.
  User: kiril
  Date: 07.08.2018
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<div class="container">
    <div class="content">
        <header class="header">
            <a href="index.jsp" class="logo">
                <img src="#" alt="logo">
            </a>
            <h1>Cart</h1>
            <nav>
                <ul class="menu">
                    <li><a class="active-menu" href="index">HOME</a></li>
                    <li><a href="catalog">CATALOG</a></li>
                    <li><a href="product">PRODUCT</a></li>
                    <li><a href="cart">CART</a></li>
                    <li><a href="order">ORDER</a></li>
                    <li><a href="contacts">CONTACTS</a></li>
                </ul>
            </nav>
        </header>
        <div class="content">
            <h1>Контакты</h1>
            <form class="contact-form" action="#">
                <h3>Напишите нам</h3>
                <p>Имя <input type="text" placeholder="Иван"></p>
                <p>Email <input type="email" placeholder="email@mail.ru"></p>
                <p>Тема <select>
                    <option value="Продукция">Продукция</option>
                    <option value="Сотрудничество">Сотрудничество</option>
                    <option value="Другое">Другое</option>
                </select></p>
                <textarea cols="30" rows="10" placeholder="Введите текст..."></textarea><br>
                <button type="reset">Сброс</button>
                <button type="submit">Отправить</button>
            </form>


            <h3>Адрес</h3>
            <p>+7 495 999 99 99</p>
            <p>Москва, Красная площадь, 1, строение 1, этаж 3, офис 5</p>
            <p>konskiy-hvost@yandex.ru</p>

            <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A1a4d8a0d41163d1edc33fba6d16e2f24be1c4439346040fad126657cc9b31ca6&amp;source=constructor" width="500" height="400" frameborder="0"></iframe>
        </div>
    </div>

    <footer class="footer"></footer>
</div>

</body>
</html>
