package model;

public class Course
{
  private String courseName; //private instance variables for the data of a course
  private Teacher teacher;
  private boolean isScheduled;

  public Course(String courseName, Teacher teacher) //initializing instance variables
  {
    this.courseName = courseName;
    this.teacher=teacher;
    this.isScheduled=false;
  }

  public String getCourseName()
  {
    return courseName;
  } //returning the name of the course

  public Teacher getTeacher()
  {
    return teacher;
  }//returning the teacher(s) of the course
  public boolean getIsScheduled(){return isScheduled;}
  public void setIsScheduled(){this.isScheduled=true;}
  public void addTeacher(Teacher teacher){
    this.teacher = teacher;
  }

  public boolean equals(
      Object obj) //equals method for the comparison of two Course objects
  {
    if (!(obj instanceof Course))
      return false;
    Course other = (Course) obj;
    return this.courseName.equals(other.courseName) && this.teacher.equals(other.teacher)&&this.isScheduled==other.isScheduled;
  }

  public String toString() //returns a String of every information
  {
    String s = "";
    s += courseName;
    s+=", teacher: " + teacher.toString();
    return s;
  }
}
