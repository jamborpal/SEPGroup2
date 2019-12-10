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
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getViaId() == viaId) {
                return students.get(i);
            }
        }
        return null;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < students.size(); i++) {
            s += students.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
