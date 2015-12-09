
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>List kiosko</title>
    </head>
    <body>
    <table>
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Descripcion</th>
            </tr>
        <c:forEach var="kiosko" items="${kioskos}">
            <tr>
                <td>${kiosko.code}</td>
                <td>${kiosko.nombre}</td>
                <td>${kiosko.description}</td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
