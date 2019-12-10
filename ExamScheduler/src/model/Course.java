package model;

import javax.swing.plaf.ColorUIResource;

public class Course
{
    private String courseName; //private instance variables for the data of a course
    private Semester semester;
    private TeacherList teacherList;
    private boolean isScheduled;

    public Course(String courseName, Semester semester, TeacherList teacherList) //initializing instance variables
    {
        this.courseName = courseName;
        this.semester = semester;
        this.teacherList = teacherList;
        this.isScheduled = false;
    }

    public String getCourseName()
    {
        return courseName;
    } //returning the name of the course

    public Semester getSemester()
    {
        return semester;
    }//returning the semester in which the course is

    public TeacherList getTeacherList()
    {
        return teacherList;
    }//returning the teacher(s) of the course

    public boolean isScheduled()
    {
        return isScheduled;
    }//returning if the exam is already scheduled for the course

    public boolean equals(Object obj) //equals method for the comparison of two Course objects
    {
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return this.courseName.equals(other.courseName) && this.semester.equals(other.semester) && this.teacherList.equals(other.teacherList) && this.isScheduled == other.isScheduled;
    }

    public String toString() //returns a String of every information
    {
        String s = "";
        s += "Course name: " + courseName;
        s += ", semester: " + semester;
        if (isScheduled == true)
        {
            s += ", an exam is already scheduled";
        } else s += ", exam is not scheduled yet";
        s += ", the teacher(s) are: ";
        s += teacherList.toString();
        return s;
    }
}
