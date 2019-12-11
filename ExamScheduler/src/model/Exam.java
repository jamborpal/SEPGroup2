package model;

import java.io.ObjectOutputStream;

public abstract class Exam
{
  private Room examRoom;
  private Course course;
  private Class theClass;


  public Exam(Course course, Class theClass)
  {
    this.examRoom = null;
    this.course = course;
    this.theClass = theClass;
  }

  public Room getRoom()
  {
    return examRoom;
  }

  public Course getCourse()
  {
    return course;
  }

  public Class getTheClass()
  {
    return theClass;
  }



  public String toString()
  {

    return "Course: " + getCourse() + System.lineSeparator() + "Class: "
        + getTheClass() + System.lineSeparator() + "Room: " + examRoom
        .getRoomName();

  }

  public void setExamRoom(Room room)
  {
    this.examRoom=room;
  }

}
