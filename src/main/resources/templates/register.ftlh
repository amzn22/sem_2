<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Register page</title>
    <#include "bootstrap.ftlh">
</head>
<body>

<form action="/register" method="post">
    <div><label> E-mail: <input type="text" name="email"/> </label></div>
    <div><label> User Name: <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Register"/></div>
</form>
</body>
</html>