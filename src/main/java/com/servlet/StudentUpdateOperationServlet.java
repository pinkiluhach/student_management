package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.Student;
import com.dao.StudentDao;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


@WebServlet("/StudentUpdateOperationServlet")
public class StudentUpdateOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public StudentUpdateOperationServlet() {
        super();
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        LOGGER.info("Perform Edit Operation");
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        Student student = dao.getStudent(student_id);
        forward = "/_editstudent.jsp";
        request.setAttribute("student", student);
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

        if (student_id != null || !(student_id.isEmpty())) {

            LOGGER.info("Update Student Details");
            student.setStudent_id(Integer.parseInt(student_id));
            dao.updateStudent(student);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/_showstudents.jsp");
        request.setAttribute("students", dao.getAllStudents());
        requestDispatcher.forward(request, response);
    }

}