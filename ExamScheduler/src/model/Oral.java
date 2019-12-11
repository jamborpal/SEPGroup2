package model;

import java.util.ArrayList;

public class Oral extends Exam
{
  private Course course;
  private Class theClass;
  private ArrayList<MyDate> dates;

  public Oral(Course course, Class theClass)
  {
    super(course, theClass);
    this.dates = new ArrayList<>();
  }

  public void setDates(MyDate date)
  {
    dates.add(date);
  }

  public void setExamRoom(Room room)
  {

    if (room.isCompatibleForOral())
    {
      super.setExamRoom(room);
    }
  }
  public ArrayList<MyDate> getDate(){
    return dates;
  }

  public String toString()
  {
    String s = "";
    s = "Course: " + getCourse() + ", class: " + getTheClass() + ", room: "
        + getRoom() + ", dates: ";
    for (int i = 0; i < dates.size(); i++)
    {
      s += dates.get(i).toString();
      s += "\n";
    }
    return s;
  }

}
