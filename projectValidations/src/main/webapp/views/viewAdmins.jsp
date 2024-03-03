<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBoot.MappingsAll.Model.AdminModel" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Details</title>

</head>
<body>
<h1>Admin Details</h1>
<table>
    <tr>
        <th>Admin ID</th>
        <th>AdminPassword</th>
    </tr>
    <%
        List<AdminModel> admin = (List<AdminModel>) request.getAttribute("AdminsList");
        if (admin != null) {
            for (AdminModel ad : admin) {
    %>

    <tr>
        <td><%= ad.getAdminId() %></td>
        <td><%= ad.getAdminPassword() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td>No students found</td>
    </tr>
    <% } %>

</table>
<%--<h3><a href="admincheck"> Features</a></h3>--%>
<h3> <a href="home">Home</a></h3>
</body>
</html>
