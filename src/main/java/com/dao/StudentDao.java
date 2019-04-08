package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


import com.bean.Student;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class StudentDao {

    private Connection connection;

    public StudentDao() {
        connection = DbConnection.getConnection();
    }

    public void addStudent(Student student) {
        try {
            LOGGER.info("Add Student");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Student_Details(student_name,student_roll_no,student_course,student_email,student_contact_number) values (?, ?, ?, ?,? )");
            preparedStatement.setString(1, student.getStudent_name());
            preparedStatement.setInt(2, student.getStudent_roll());
            preparedStatement.setString(3, student.getStudent_course());
            preparedStatement.setString(4, student.getStudent_email());
            preparedStatement.setInt(5, student.getStudent_contact_number());
            preparedStatement.executeUpdate();
            LOGGER.finer("Record Inserted Successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occur in Insert Student Record Functionality", e);
        }
    }

    public List<Student> getAllStudents() {
        LOGGER.info("Get All Students Record");
        List<Student> students = new ArrayList<Student>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Student_Details");
            while (rs.next()) {
                Student student = new Student();
                student.setStudent_id(rs.getInt("student_id"));
                student.setStudent_name(rs.getString("student_name"));
                student.setStudent_roll(rs.getInt("student_roll_no"));
                student.setStudent_course(rs.getString("student_course"));
                student.setStudent_email(rs.getString("student_email"));
                student.setStudent_contact_number(rs.getInt("student_contact_number"));
                students.add(student);
            }
            LOGGER.finer("All Record fetch Succesfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error Occur while fetching student records", e);
        }
        return students;
    }

    public Student getStudent(int student_id) {
        LOGGER.info("Edit Student Record");
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Student_Details where student_id=?");
            preparedStatement.setInt(1, student_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                student.setStudent_id(rs.getInt("student_id"));
                student.setStudent_name(rs.getString("student_name"));
                student.setStudent_roll(rs.getInt("student_roll_no"));
                student.setStudent_email(rs.getString("student_email"));
                student.setStudent_course(rs.getString("student_course"));
                student.setStudent_contact_number(rs.getInt("student_contact_number"));
                LOGGER.finer("Student Record Fetch Successfully according to respective studentId");
            }
        } catch (SQLException e) {

            LOGGER.log(Level.SEVERE, "Error Occur While getting student record");
        }
        return student;
    }


    public void updateStudent(Student student) {
        LOGGER.info("Update Student Record");
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Student_Details set student_name=?,student_roll_no=?, student_course=?, student_email=?, student_contact_number=? where student_id=?");
            preparedStatement.setString(1, student.getStudent_name());
            preparedStatement.setInt(2, student.getStudent_roll());
            preparedStatement.setString(3, student.getStudent_course());
            preparedStatement.setString(4, student.getStudent_email());
            preparedStatement.setInt(5, student.getStudent_contact_number());
            preparedStatement.setInt(6, student.getStudent_id());
            preparedStatement.executeUpdate();
            LOGGER.finer("Student Record Updated Successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error Occur while updating Student Record", e);
        }
    }

    public void deleteStudent(int student_id) {
        LOGGER.info("Delete Record Query");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Student_Details where student_id=?");
            preparedStatement.setInt(1, student_id);
            preparedStatement.executeUpdate();
            LOGGER.finer("Record Delete Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Error Occur while deleting Student record", e);
        }
    }
}
