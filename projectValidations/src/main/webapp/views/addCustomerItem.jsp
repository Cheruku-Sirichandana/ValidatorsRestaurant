<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Item To Customer</title>

</head>
<body>
<center>
    <h2>Add Item To Customer</h2>
    <form action="addingCustomerItem" modelAttribute="addingCustomerItem">

        <label for="iid">Item ID:</label><br>
        <form:input path="iid"><br>
        <form:errors path="iid" style="color:red;"/>
        <label for="iname">Customer Id:</label>
        <form:input path="iname"><br>
        <form:errors path="iname" style="colr:red;"/>
        <input type="submit" value="Submit" required>
    </form>
    <h3> <a href="home">Home</a></h3>

</center>
</body>
</html>