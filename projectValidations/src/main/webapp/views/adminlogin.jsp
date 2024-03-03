<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Admin Page
    </title>

</head>
<body>

<form:form action="adminchecking" modelAttribute="adminModel">
    <label for="adminId">Admin Id:</label><br>
    <form:input path="adminId"/><br>
    <form:errors path="adminId" style="color: red;"/><br>
    <label for="adminPassword">Admin Password:</label><br>
    <form:input path="adminPassword"/><br><br>
    <form:errors path="adminPassword" style="color: red;"/><br>

    <input type="submit" value="submit" required>
</form:form>

<%--<form action="uploadItems">--%>
<%--    <input type="submit" value="upload or add items">--%>
<%--</form>--%>
</body>
</html>