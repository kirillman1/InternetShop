<%@ page import="java.util.Collection" %>
<%@ page import="ru.gontov.enterprise.entity.Product" %>
<%@ page import="ru.gontov.enterprise.constant.FieldConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT LIST</title>
</head>
<body>

<h1>PRODUCT MANAGEMENT</h1>
<%
    final Object productsObject = request.getAttribute(FieldConst.PRODUCTS);
    final Collection<Product> products = (Collection<Product>) productsObject;
%>
<table width="100%" cellpadding="10" cellspacing="10" border="1" style="border-collapse: collapse;">
    <tr>
        <th>№</th>
        <th align="left">NAME</th>
        <th align="left">DESCRIPTION</th>
        <th></th>
        <th></th>
    </tr>
<% int index = 1; %>
<% for (final Product product: products) { %>
    <tr>
        <td align="center"><%=index%>.</td>
        <td width="200" align="left" nowrap="nowrap"><%=product.getName()%></td>
        <td width="100%" align="left"><%=product.getDescription()%></td>
        <td align="center" nowrap="nowrap">
            <a href="product-edit?id=<%=product.getId()%>">EDIT</a>
        </td>
        <td align="center" nowrap="nowrap">
            <a href="product-remove?id=<%=product.getId()%>">REMOVE</a>
        </td>
    </tr>
    <% index++; %>
<% } %>
</table>

<br />

<form action="product-create" method="get">
    <button type="submit" style="font-size: 1.5em;">CREATE</button>
</form>



</body>
</html>
