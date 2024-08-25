<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Com.dau.Connecter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management Mini Project</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: url('https://example.com/your-collage-image.jpg') no-repeat center center fixed; 
        background-size: cover;
        color: #333;
        display: flex;
        flex-direction: column;
        min-height: 100vh;
    }

    nav {
        background-color: rgba(51, 51, 51, 0.8);
        overflow: hidden;
        z-index: 1000;
        position: fixed;
        width: 100%;
        top: 0;
        left: 0;
        padding: 0 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    }

    nav a {
        float: left;
        display: block;
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }

    nav a:hover {
        background-color: #575757;
    }

    .side-menu {
        position: fixed;
        top: 70px; /* Space for fixed nav */
        left: 0;
        width: 200px;
        background-color: rgba(51, 51, 51, 0.8);
        color: white;
        list-style: none;
        padding: 0;
        margin: 0;
        z-index: 1000;
        height: calc(100vh - 70px); /* Adjust height to fill the screen */
        overflow-y: auto;
    }

    .side-menu li {
        padding: 15px;
        border-bottom: 1px solid #444;
    }

    .side-menu li.active {
        background-color: #4CAF50;
    }

    .side-menu li a {
        color: white;
        text-decoration: none;
        display: flex;
        align-items: center;
    }

    .side-menu i {
        margin-right: 10px;
    }

    .side-menu a:hover {
        background-color: #575757;
    }

    header {
        background-color: rgba(76, 175, 80, 0.8);
        color: white;
        padding: 20px;
        text-align: center;
        font-size: 28px;
        position: relative;
        z-index: 1000;
        margin-top: 70px; /* Space for fixed nav */
    }

    .main-header {
        background-color: rgba(76, 175, 80, 0.8);
        color: white;
        padding: 10px;
        text-align: center;
        font-size: 24px;
        margin-top: 20px; /* Space below the header */
    }

    .container {
        padding: 20px;
        margin-left: 90px; /* Ensure space for the sidebar */
        margin-top: 20px; /* Space below the main header */
        margin-bottom: 70px; /* Space for the footer */
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        max-width: calc(100% - 240px); /* Adjust width for sidebar */
    }

    .section {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: calc(33.333% - 20px);
        text-align: center;
        box-sizing: border-box;
        transition: background-color 0.3s, transform 0.3s;
    }

    .section:hover {
        background-color: #f4f4f4;
        transform: scale(1.05);
    }

    footer {
        background-color: rgba(51, 51, 51, 0.8);
        color: white;
        text-align: center;
        padding: 10px;
        position: fixed;
        width: 100%;
        bottom: 0;
        left: 0;
    }
</style>
</head>
<body>

<nav>
    <a href="home.jsp">Home</a>
    <a href="fetch.jsp">View Data</a>
    <a href="#">Contact Us</a>
    <a href="#">Feedback</a>
    <a href="logout">Logout</a>
</nav>

<header>
    Student Management System
</header>
<%Connection con=Connecter.connect();
 PreparedStatement ps=con.prepareStatement("select * from student2");
 ResultSet rs=ps.executeQuery();
 int x=0;
 while(rs.next()){
	 x++;
 }
%>
<div class="container">
    <!-- Sections displayed as squares -->
    <div class="section"><b><%=x%></b><br><br><a href="fetch.jsp" style="text-decoration: none">Students</a></div>
    <div class="section"><b>0</b><br><br>Feedbacks</div>
</div>
<footer>
    &copy; 2024 Student Management System. All rights reserved.
</footer>

</body>
</html>
