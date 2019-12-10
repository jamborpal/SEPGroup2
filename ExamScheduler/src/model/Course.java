package model;

import javax.swing.plaf.ColorUIResource;

public class Course
{
    private String courseName;
    private Semester semester;
    private TeacherList teacherList;
    private boolean isScheduled;

    public Course(String courseName, Semester semester, TeacherList teacherList)
    {
        this.courseName = courseName;
        this.semester = semester;
        this.teacherList = teacherList;
        this.isScheduled = false;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public Semester getSemester()
    {
        return semester;
    }

    public TeacherList getTeacherList()
    {
        return teacherList;
    }

    public boolean isScheduled()
    {
        return isScheduled;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return this.courseName.equals(other.courseName) && this.semester.equals(other.semester) && this.teacherList.equals(other.teacherList) && this.isScheduled == other.isScheduled;
    }

    public String toString()
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
