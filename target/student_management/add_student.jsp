<%--
  Created by IntelliJ IDEA.
  User: arun
  Date: 4/4/19
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<div align="center">
    <h1 align="center">Add Student</h1>
    <form name="addstudent" method="post" action="StudentOperationServlet">
        <table>
            <tbody>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" required name="student_name" value="" placeholder="Enter Name"/>
                </td>
            </tr>
            <tr>
                <td>Roll No.:</td>
                <td>
                    <input type="number" required name="student_roll" value="" placeholder="Enter Roll No"/>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="email" required name="student_email" value="" placeholder="Enter Email"/>
                </td>
            </tr>
            <tr>
                <td>Course:</td>
                <td>
                    <input type="text" required name="student_course" value="" placeholder="Enter Course"/>
                </td>
            </tr>
            <tr>
                <td>Contact No.:</td>
                <td>
                    <input type="number" required name="student_contact_number" value=""
                           placeholder="Enter Contact Number"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add Student"/>
                </td>
                <td>
                    <input type="reset" value="Reset">
                </td>
            </tr>
            </tbody>
        </table>

    </form>
</div>
</body>
</html>
