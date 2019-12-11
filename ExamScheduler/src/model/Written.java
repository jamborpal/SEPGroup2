package model;

public class Written extends Exam
{

  private MyDate examDate;
  private int minute;
  private int hour;

  public Written(Course course, Class theClass)
  {
    super(course, theClass);
    this.hour = 0;
    this.minute = 0;
    this.examDate = null;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getHour()
  {
    return hour;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public void setExamDate(MyDate date)
  {
    this.examDate = date;
  }

  public void setExamRoom(Room room)
  {

    if (room.isCompatibleForWritten())
    {
      super.setExamRoom(room);
    }

  }
  public MyDate getDate(){
    return examDate;
  }

  public String toString()
  {
    String s = "";
    s = "Course: " + getCourse() + ", class: " + getTheClass() + ", room: "
        + getRoom() + ", date: " + examDate + ", hour: " + hour + ", minute: "
        + minute + ".";
    return s;
  }
}
