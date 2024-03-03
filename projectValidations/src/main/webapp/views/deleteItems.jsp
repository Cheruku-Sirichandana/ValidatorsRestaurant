<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Delete Items
    </title>

</head>
<body>
<form:form action="deletedItems" modelAttribute="itemModel">
<label for="iid">Item Id:</label><br>
<input type="number" name="iid"/><br><br>
    <form:errors path="iid" style="color:red"/>
    <input type="submit" value="submit">

</form:form>
</body>
</html>