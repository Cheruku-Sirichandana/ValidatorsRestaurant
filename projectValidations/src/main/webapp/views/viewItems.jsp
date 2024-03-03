<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.SpringBoot.ValidationsProject.Model.ItemModel" %>
<%@ page import="com.SpringBoot.ValidationsProject.Entity.Admin" %>


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
        <th>Item Admin Id</th>
    </tr>



    <%
        List<ItemModel> item = (List<ItemModel>) request.getAttribute("ItemsList");
        //Admin admin=(Admin)request.getAttribute("adminId");
        if (item != null) {
            //Admin s1=item.getAdmin();
            for (ItemModel ad : item) {
                // Admin a=item.getAdminId();
                Admin admin=ad.getAdmin();
    %>

    <tr>
        <td><%= ad.getIid() %></td>
        <td><%= ad.getIname() %></td>
        <td><%= ad.getIprice() %></td>
        <td>
            <%=admin!=null?admin.getAdminId():"NA"%>
        </td>



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
<h3><a href="admincheck">Features</a></h3>
<h3> <a href="home">Home</a></h3>
</body>
</html>







