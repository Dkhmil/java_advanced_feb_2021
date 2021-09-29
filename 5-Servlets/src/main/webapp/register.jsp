
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="/register" method="post">
    <label>First name : </label><input type="text" name="firstName"><br>
    <label>Last name : </label><input type="text" name="lastName"><br>
    <label>Email : </label><input type="email" name="email"><br>
    <label>Password : </label><input type="password" name="password"><br>
    <input type="submit" value="Oki">
</form>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
