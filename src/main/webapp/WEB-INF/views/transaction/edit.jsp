<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hubert
  Date: 11.04.2022
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="transaction" action="/transaction/update">
    <form:hidden path="id"/>
    Spółka <form:input path="companies"/><br>
    <form:errors path="companies"/><br>
    Kontrahent <form:input path="contractors"/><br>
    <form:errors path="contractors"/><br>
    Typ transakcji <form:input path="typeOfTransaction"/><br>
    <form:errors path="typeOfTransaction"/><br>
    Kategoria transakcji <form:input path="categoryOfTransaction"/><br>
    <form:errors path="categoryOfTransaction"/><br>
    Opis transakcji <form:input path="description"/><br>
    <form:errors path="description"/><br>
    Wartość netto <form:input path="netValue"/><br>
    <form:errors path="netValue"/><br>
    Wartość dokonanych płatności <form:input path="paidValue"/><br>
    <form:errors path="paidValue"/><br>

    <input type="submit">
</form:form>



</body>
</html>
