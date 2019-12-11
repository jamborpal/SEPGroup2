package model;

import javax.swing.plaf.ColorUIResource;
import java.util.ArrayList;

public class Course
{
  private String courseName; //private instance variables for the data of a course
  private boolean isScheduled;
  private ArrayList<Teacher> teachers;

  public Course(String courseName) //initializing instance variables
  {
    this.courseName = courseName;
    this.isScheduled = false;
    this.teachers = new ArrayList<>();
  }

  public String getCourseName()
  {
    return courseName;
  } //returning the name of the course

  public ArrayList<Teacher> getTeachers()
  {
    return teachers;
  }//returning the teacher(s) of the course

  public int courseTeacherCount()
  {
    return teachers.size();
  }

  public boolean isScheduled()
  {
    return isScheduled;
  }//returning if the exam is already scheduled for the course

  public boolean equals(
      Object obj) //equals method for the comparison of two Course objects
  {
    if (!(obj instanceof Course))
      return false;
    Course other = (Course) obj;
    return this.courseName.equals(other.courseName) && this.teachers
        .equals(other.teachers) && this.isScheduled == other.isScheduled;
  }
  public void addTeacher(Teacher teacher){
      teachers.add(teacher);
  }

  public String toString() //returns a String of every information
  {
    String s = "";
    s += "Course name: " + courseName;
    if (isScheduled)
    {
      s += ", an exam is already scheduled";
    }
    else
      s += ", exam is not scheduled yet";
    s += ", the teacher(s) are: ";
    for (int i = 0; i < teachers.size(); i++)
    {
      s += teachers.get(i).toString();
      s += "\n";
    }
    return s;
  }
}
