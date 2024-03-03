<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Customer Registration</title>
</head>
<body>
<h2>Customer Registration</h2>
<form:form action="addedcustomer" modelAttribute="customerModel">
    <label for="cid">ID:</label>
    <form:input type="number" id="cid" name="cid" path="cid"/><br>
    <form:errors path="cid" style="color:red;"/><br>
    <label for="cname">Name:</label>
    <form:input type="text" id="cname" name="cname" path="cname" /><br>
    <form:errors path="cname" style="color: red;"/><br>
    <label for="cmail">Email:</label>
    <form:input type="text" id="cmail" name="cmail" path="cmail"/><br>
    <form:errors path="cmail" style="color: red;"/><br>
    <label for="cpassword">Password:</label>
    <form:input type="text" id="cpassword" name="cpassword" path="cpassword" /><br>
    <form:errors path="cpassword" style="color: red;"/><br>
    <label for="cphone">Phone:</label>
    <form:input type="text" id="cphone" name="cphone" path="cphone"/><br>
    <form:errors path="cphone" style="color: red;"/><br>
    <label for="cage">Age:</label>
    <form:input type="text" id="cage" name="cage" path="cage" /><br>
    <form:errors path="cage" style="color: red;"/><br>
    <input type="submit" value="Register">
</form:form>
</body>
</html>
