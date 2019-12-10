package model;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int viaId) {
        students.remove(viaId);
    }

    public Student getStudent(int viaId) {

    }

    public int getNumberOfStudents() {

    }

    public String toString() {
    }
}
