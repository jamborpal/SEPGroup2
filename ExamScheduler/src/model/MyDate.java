package model;

import java.time.LocalDate;

public class MyDate
{
  private int day;
  private int month;

  public MyDate(int day, int month)
  {
    set(day, month);
  }

  public void set(int day, int month)
  {

    if (month < 1)
    {
      month = 1;
    }
    else if (month > 12)
    {
      month = 12;
    }
    this.month = month;


    if (day < 1)
    {
      day = 1;
    }
    else if (day > 31)
    {
      day = 31;
    }
    this.day = day;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public String toString()
  {
    String s = "";
    if (day < 10)
    {
      s += "0";
    }
    s += day + "/";
    if (month < 10)
    {
      s += "0";
    }

    return s;
  }

  public boolean isBefore(MyDate other)
  {

    if (this.month < other.month)
    {
      return true;
    }
    if (this.month > other.month)
    {
      return false;
    }
    return this.day < other.day;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month;
  }

  public MyDate copy()
  {
    MyDate other = new MyDate(day, month);
    return other;
  }

}
