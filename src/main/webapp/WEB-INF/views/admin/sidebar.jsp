<%--
  Created by IntelliJ IDEA.
  User: hubert
  Date: 11.04.2022
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/dashboard">
        <div class="sidebar-brand-icon rotate-n-15">
        </div>
        <div class="sidebar-brand-text mx-3">Manager Cen Transferowych</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="/dashboard">
            <span>Pulpit</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">

    </div>
    <!-- Nav Item - Dokumentacje -->
    <li class="nav-item">
        <a class="nav-link" href="/documentation/list">
            <span>Dokumentacje</span></a>
    </li>


    <!-- Nav Item - Transakcje -->
    <li class="nav-item">
        <a class="nav-link" href="/transaction/list">
            <span>Transakcje</span></a>
    </li>

    <!-- Nav Item - Spółki -->
    <li class="nav-item">
        <a class="nav-link" href="/company/list">
            <span>Spółki</span></a>
    </li>

    <!-- Nav Item - Spółki -->
    <li class="nav-item">
        <a class="nav-link" href="/user/list">
            <span>Koordynatorzy</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Opcje
    </div>

    <!-- Nav Item - Dane -->
    <li class="nav-item">
        <a class="nav-link" href="/user/profile">
            <span>Profil</span></a>
    </li>


    <!-- Nav Item - wyloguj -->
    <li class="nav-item">
        <a class="nav-link" href="/logout">
            <span>Wyloguj</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

</ul>
<!-- End of Sidebar -->

</body>
</html>
