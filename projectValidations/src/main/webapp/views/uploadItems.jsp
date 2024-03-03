<html>
<head>
    <title>
        Uploading New Items
    </title>

</head>
<body>
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
    <label for="adminId">Admin Id:</label><br>
    <input type="text" id="adminId" name="adminId" value="${admindId}" readonly><br><br>
<%--    <input type="number" id="cid" name="cid" value="${cid}"><br>--%>
    <input type="submit" value="submit" required>



</form>
</body>
</html>