package model;

public class Exam
{
  private Room room;
  private int hour;
  private int minute;
  private MyDate examDate;
  private MyDate examFrom;
  private MyDate examTo;

  public Exam(Room room, int hour, int minute, MyDate examDate)
  {
    this.room = room;
    this.hour = hour;
    this.minute = minute;
    this.examDate = examDate;
  }
  public Exam(Room room, MyDate examFrom, MyDate examTo)
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

  public String toString()
  {
    return "Room: " + room.getRoomName() + System.lineSeparator()
        + "Exam date: " + examDate + System.lineSeparator() + "Hour: " + hour
        + System.lineSeparator() + "Minute: " + minute;

  }

}
