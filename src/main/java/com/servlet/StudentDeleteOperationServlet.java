package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.StudentDao;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@WebServlet("/StudentDeleteOperationServlet")
public class StudentDeleteOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public StudentDeleteOperationServlet() {
        super();
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        LOGGER.info("Perform Delete Operation");
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        dao.deleteStudent(student_id);
        forward = "/_showstudents.jsp";
        request.setAttribute("students", dao.getAllStudents());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
