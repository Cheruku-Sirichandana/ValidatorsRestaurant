<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AdminRegistration</title>

</head>

<body>
<h2>Admin Registration</h2>


<form:form action="addedAdmin" modelAttribute="adminModel">
    <label for="adminId">ID:</label>
    <form:input path="adminId"/><br>
    <form:errors path="adminId" style="color:red;"/><br>

    <label for="adminPassword" >Password:</label>
    <form:input path="adminPassword" /><br>
    <form:errors path="adminPassword" style="color: red;"/><br>



    <input type="submit" value="Register">
</form:form>
</body>
</html>

