
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
<div class="container">
    <div class="content">
        <header class="header">
            <a href="index.jsp" class="logo">
                <img src="#" alt="logo">
            </a>
            <h1>Catalog</h1>
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

        <%--<jsp:include page="/WEB-INF/template/product-list.jsp" />--%>
    </div>

    <footer class="footer"></footer>
</div>
</body>
</html>
