<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Update
    </title>

</head>
<body>
<form:form action="updatingItems" modelAttribue="itemModel">
    <label for="iid">Enter Item Id:</label>
    <input type="number" id="iid" name="iid" /><br>
    <form:errors path="iid" style="color:red"/><br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>