package com.servlet;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.bean.Student;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@WebServlet("/StudentListOperationServlet")
public class StudentListOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public StudentListOperationServlet() {
        super();
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listStudent")) {
            LOGGER.info("Perform Operation Get All Students Record");
            request.setAttribute("students", dao.getAllStudents());
            forward = "/_showstudents.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}