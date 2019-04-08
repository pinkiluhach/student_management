<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Information</title>
</head>
<body>
<div align="center">
    <h1 align="center">Select Choice</h1>
    <a href="add_student.jsp"><input type="button" value="Add Student"></a>
    <a href="/StudentOperationServlet?action=listStudent">
        <input type="button" value="Show Students"></a>
</div>
</body>
</html>