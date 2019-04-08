package com.bean;

public class Student {
    private int student_id;
    private String student_name;
    private int student_roll;
    private String student_email;
    private String student_course;
    private int student_contact_number;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getStudent_roll() {
        return student_roll;
    }

    public void setStudent_roll(int student_roll) {
        this.student_roll = student_roll;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_course() {

        return student_course;
    }

    public void setStudent_course(String student_course) {
        this.student_course = student_course;
    }

    public int getStudent_contact_number() {
        return student_contact_number;
    }

    public void setStudent_contact_number(int student_contact_number) {
        this.student_contact_number = student_contact_number;
    }

    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ",student_name=" + student_name + ", student_roll_no=" + student_roll
                + ", student_email=" + student_email + ", student_course" + student_course + ", student_contact_number="
                + student_contact_number + "]";
    }

}
