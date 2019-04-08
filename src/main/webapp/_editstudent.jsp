<%--
  Created by IntelliJ IDEA.
  User: arun
  Date: 6/4/19
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<div align="center">
    <h1 align="center">Student Details</h1>
    <form name="editstudent" method="post" action="StudentUpdateOperationServlet">
        <input type="hidden" name="student_id" value="<c:out value="${student.student_id}"/>"/><br/>
        <table>
            <tbody>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="student_name" required
                           value="<c:out value="${student.student_name}"/>"/><br/>
                </td>
            </tr>
            <tr>
                <td>Roll No.:</td>
                <td>
                    <input type="number" name="student_roll" value="<c:out value="${student.student_roll}"/>"/><br/>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="email" name="student_email" value="<c:out value="${student.student_email}"/>"/>
                </td>
            </tr>
            <tr>
                <td>Course:</td>
                <td>
                    <input type="text" name="student_course" value="<c:out value="${student.student_course}"/>"/>
                </td>
            </tr>
            <tr>
                <td>Contact No.:</td>
                <td>
                    <input type="number" name="student_contact_number"
                           value="<c:out value="${student.student_contact_number}"/>"/><br/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
            </tbody>
        </table>

    </form>
</div>
</body>
</html>

