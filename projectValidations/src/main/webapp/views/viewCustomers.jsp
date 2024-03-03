<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBoot.ValidationsProject.Model.CustomerModel" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Details</title>

</head>
<body>
<h1>Customer Details</h1>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Customer Phone</th>
        <th>Customer Items</th>
    </tr>
    <%
        List<CustomerModel> customer = (List<CustomerModel>) request.getAttribute("CustomersList");
        if (customer != null) {
            for (CustomerModel ad : customer) {
    %>

    <tr>
        <td><%= ad.getCid() %></td>
        <td><%= ad.getCname() %></td>
        <td><%= ad.getCphone() %></td>
        <td><form action="viewItems">
            <input type="submit" value="submit">
        </form> </td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td>No customers found</td>
    </tr>
    <% } %>

</table>
<h3><a href="customercheck">Features</a></h3>
<h3> <a href="home">Home</a></h3>
</body>
</html>
