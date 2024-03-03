
<!DOCTYPE html>
<html>
<head>
    <title>View Item</title>

</head>
<body>

<h2>View Item</h2>
<form action="deletedCustomerItems">
    <label for="cid">Customer Id:</label><br>
    <input type="number" id="cid" name="cid" value="${cid}"><br>
    <label for="iid">Item Id:</label><br>
    <input type="number" id="iid" name="iid" value="iid" required><br>

    <input type="submit" value="Submit">
</form>
<%--    <h3><a href="admincheck">Admin Check</a></h3>--%>
<h3> <a href="home">Home</a></h3>


</body>
</html>