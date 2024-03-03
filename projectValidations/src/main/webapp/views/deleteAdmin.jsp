<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Delete Admin
    </title>

</head>
<body>
<h3>Delete Admin</h3>
<form:form action="deletedAdmin" ModelAttribute="adminModel">
    <label for="adminId">Admin Id:</label>
    <form:input path="adminId"/>
    <form:errors path="adminId" style="color:red"/><br>
    <input type="submit" value="submit">
</form:form>

</body>
</html>