<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Item</title>
</head>

<body>

    <h2>Update Item</h2>
    <form:form action="updatedItem" modelAttribute="itemModel">
        <label for="iid">Item Id:</label><br>
        <form:input type="number" id="iid" name="iid" value="${iid}" path="iid"/><br>
        <form:errors path="iid" style="color:red"/><br>

        <label for="iname">Item Name:</label><br>
        <form:input type="text" id="iname" name="iname" path="iname"/><br>
        <form:errors path="iname" style="color:red"/><br>

        <label for="iprice">Item Price:</label><br>
        <form:input type="text" id="iprice" name="iprice" path="iprice"/><br><br>
        <form:errors path="iprice" style="color:red"/><br>

        <label for="iquantity">Item Quantity:</label><br>
        <form:input type="number" id="iquantity" name="iquantity" path="iquantity"/><br><br>
        <form:errors path="iprice" style="color:red"/><br>

        <input type="submit" value="Submit">
    </form:form>
<%--    <h3><a href="admincheck">Admin Check</a></h3>--%>
    <h3> <a href="home">Home</a></h3>


</body>
</html>