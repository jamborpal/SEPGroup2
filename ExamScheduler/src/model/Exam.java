package model;

public class Exam
{
  private Room room;
  private int hour;
  private int minute;
  private MyDate examDate;
  private MyDate examFrom;
  private MyDate examTo;
  private Course course;
  private Class theClass;

  public Exam(Room room, int hour, int minute, MyDate examDate, Course course,
      Class theClass)
  {
    this.room = room;
    this.hour = hour;
    this.minute = minute;
    this.examDate = examDate;
  }

  public Exam(Room room, MyDate examFrom, MyDate examTo, Course course,
      Class theClass)
  {
    this.room = room;
    this.examFrom = examFrom;
    this.examTo = examTo;
  }

  public Room getRoom()
  {
    return room;
  }

  public MyDate getExamDate()
  {
    return examDate;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
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
        + getTheClass() + System.lineSeparator() + "Room: " + room.getRoomName()
        + System.lineSeparator() + "Exam date: " + examDate + System
        .lineSeparator() + "Hour: " + hour + System.lineSeparator() + "Minute: "
        + minute;

  }

}
