package com.servlet;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.bean.Student;


public class StudentOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public StudentOperationServlet() {
        super();
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        System.out.println("Perform Action according to User Option");

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listStudent")) {
            System.out.println("Perform Operation Get All Students Record");
            request.setAttribute("students", dao.getAllStudents());
            forward = "/show_students.jsp";
        } else if (action.equalsIgnoreCase("edit")) {
            System.out.println("Perform Edit Operation");
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            Student student = dao.getStudent(student_id);
            forward = "/edit_student.jsp";
            request.setAttribute("student", student);
        } else if (action.equalsIgnoreCase("delete")) {
            System.out.println("Perform Delete Operation");
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            dao.deleteStudent(student_id);
            forward = "/show_students.jsp";
            request.setAttribute("students", dao.getAllStudents());
        } else {
            forward = "add_student.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();
        student.setStudent_name(request.getParameter("student_name"));
        student.setStudent_roll(Integer.parseInt(request.getParameter("student_roll")));
        student.setStudent_email(request.getParameter("student_email"));
        student.setStudent_course(request.getParameter("student_course"));
        student.setStudent_contact_number(Integer.parseInt(request.getParameter("student_contact_number")));
        String student_id = request.getParameter("student_id");
        System.out.println("Student Id" + student_id);

        if (student_id == null || student_id.isEmpty()) {
            System.out.println("Add Student Record to Student Details");
            dao.addStudent(student);
        } else {
            System.out.println("Update Student Details");
            student.setStudent_id(Integer.parseInt(student_id));
            dao.updateStudent(student);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/show_students.jsp");
        request.setAttribute("students", dao.getAllStudents());
        requestDispatcher.forward(request, response);
    }

}