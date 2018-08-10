<%@ page import="ru.gontov.enterprise.constant.FieldConst" %>
<%@ page import="ru.gontov.enterprise.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>EDIT PRODUCT</h1>

<%
    final Object productObject = request.getAttribute(FieldConst.PRODUCT);
    final Product product = (Product) productObject;
%>

<form action="product-save" method="post">
    <table width="100%" cellspacing="10" cellpadding="10" border="1" style="border-collapse: collapse;">
        <tr>
            <td width="300" nowrap="nowrap" align="left">
                ID:
            </td>
            <td width="100%" align="left">
                <input name="id" value="<%=product.getId()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                NAME:
            </td>
            <td align="left">
                <input name="name" value="<%=product.getName()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                DESCRIPTION:
            </td>
            <td align="left">
                <input name="description" value="<%=product.getDescription()%>"/>
            </td>
        </tr>
    </table>

    <br />
    <button type="submit" style="font-size: 1.5em;">SAVE</button>
</form>


</body>
</html>
