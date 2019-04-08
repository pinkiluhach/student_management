<%--
  Created by IntelliJ IDEA.
  User: arun
  Date: 5/4/19
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Show Students</title>
</head>
<body>
<div align="center">
    <h1 align="center">Student Details</h1>
    <table border="1" width="90%">
        <thead>
        <tr>
            <td>Student Id</td>
            <td>Student Name</td>
            <td>Student Roll Number</td>
            <td>Student Email</td>
            <td>Student Course</td>
            <td>Student Contact Number</td>
            <td colspan="2">Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td><c:out value="${student.student_id}"/></td>
                <td><c:out value="${student.student_name}"/></td>
                <td><c:out value="${student.student_roll}"/></td>
                <td><c:out value="${student.student_email}"/></td>
                <td><c:out value="${student.student_course}"/></td>
                <td><c:out value="${student.student_contact_number}"/></td>
                <td>
                    <a href="/StudentDeleteOperationServlet?student_id=<c:out value="${student.student_id}"/>">Delete</a>
                </td>
                <td><a href="/StudentUpdateOperationServlet?student_id=<c:out value="${student.student_id}"/>">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="_addstudent.jsp">Add Student</a>
</div>
</body>
</html>

