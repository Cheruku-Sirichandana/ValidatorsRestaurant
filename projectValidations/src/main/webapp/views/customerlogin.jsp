<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Customer Login
    </title>

</head>
</html>
<h3>CustomerLogin</h3>

<form:form action="customerchecking" modelAttribute="customerModel">
    <label for="cid">Customer Id:</label><br>
    <form:input path="cid"/><br>
    <form:errors path="cid" style="color:red;"/><br>
    <label for="cname">Customer name:</label><br>
    <form:input path="cname"/><br><br>
    <form:errors path="cname" style="color:red;"/><br>
    <label for="cphone">Customer phone:</label><br>
    <form:input path="cphone"/><br><br>
    <form:errors path="cphone" style="color:red;"/><br>
    <label for="cmail">Customer Mail:</label><br>
    <form:input path="cmail"/><br><br>
    <form:errors path="cmail" style="color:red;"/><br>
    <label for="cpassword">Customer password:</label><br>
    <form:input path="cpassword"/><br><br>
    <form:errors path="cpassword" style="color:red;"/><br>


    <input type="submit" value="submit" required>
</form:form>