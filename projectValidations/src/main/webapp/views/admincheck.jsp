<html>
<head>
    <title>
        Admin Features
    </title>

</head>
<body>
<form action="uploadItems">

    <input type="hidden" name="adminId" value="${adminId}">
    <input type="submit" value="UploadItems">
</form>
<form action="deleteItems">
    <input type="submit" value="Delete Items">
</form>
<form action="updateItems">
    <input type="submit" value="update Items">
</form>
<form action="viewItems">
    <input type="hidden" name="adminId" value="${adminId}">
    <input type="submit" value="view Items">
</form>
</body>
</html>