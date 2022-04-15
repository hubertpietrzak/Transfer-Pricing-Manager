<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hubert
  Date: 07.04.2022
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<a href="<c:url value="/coordinator/add"/>">Dodaj koordynatora</a>
<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${coordinators}" var="coordinator">
        <tr>
            <td>${coordinator.id}</td>
            <td>${coordinator.firstName}</td>
            <td>${coordinator.lastName}</td>
            <td>
                <a href="<c:url value="/coordinator/delete/${coordinator.id}"/>">Usuń</a>
                <a href="<c:url value="/coordinator/edit/${coordinator.id}"/>">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
