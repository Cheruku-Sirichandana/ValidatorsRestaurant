<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBoot.MappingsAll.Model.ItemModel" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item Details</title>

</head>
<body>
<h1>Item Details</h1>
<table>
    <tr>
        <th>Item ID</th>
        <th>Item Name</th>
        <th>Item Price</th>
    </tr>
    <%
        List<ItemModel> item = (List<ItemModel>) request.getAttribute("ItemList2");
        if (item != null) {
            for (ItemModel ad : item) {
    %>

    <tr>
        <td><%= ad.getIid() %></td>
        <td><%= ad.getIname() %></td>
        <td><%= ad.getIprice() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td>No items found</td>
    </tr>
    <% } %>

</table>
<h3><a href="customercheck">Features</a></h3>
<h3> <a href="home">Home</a></h3>
</body>
</html>
