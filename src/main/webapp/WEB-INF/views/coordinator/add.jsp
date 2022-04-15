<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hubert
  Date: 07.04.2022
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="coordinator">
    Imię <form:input path="firstName"/><br>
    <form:errors path="firstName"/><br>
    Nazwisko <form:input path="lastName"/><br>
    <form:errors path="lastName"/><br>

    <input type="submit">
</form:form>

</body>
</html>
