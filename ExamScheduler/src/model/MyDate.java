package model;


public class MyDate

{
  private int day;
  private int month;
  private int year;

  public MyDate(int day, int month, int year)
  {
    set(day, month, year);
  }

  public void set(int day, int month, int year)
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
    if (year < 0)
    {
      year = -year;
    }
    this.year = year;

    if (day < 1)
    {
      day = 1;
    }
    else if (day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }

  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        return "December";
    }
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
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
    s += month + "/";
    s += year;
    return s;
  }

  public boolean isLeapYear()
  {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
  }

  public int numberOfDaysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  public boolean isBefore(MyDate other)
  {
    if (this.year < other.year)
    {
      return true;
    }
    else if (this.year > other.year)
    {
      return false;
    }
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

  public String dayOfWeek()
  {
    int q, m, k, j, h;
    q = day;
    if (month <= 2)
    {
      m = 12 + month;
    }
    else
    {
      m = month;
    }
    k = year % 100;
    if (month == 13 || month == 14)
    {
      year = year-1;
    }
    j = year / 100;
    h = (q + ((13*(m+1))/5)+k+(k/4)+(j/4)+(5*j))%7;

    switch(h)
    {
      case 0: return "Saturday";
      case 1: return "Sunday";
      case 2: return "Monday";
      case 3: return "Tuesday";
      case 4: return "Wednesday";
      case 5: return "Thursday";
      case 6: return "Friday";
      default: return "Error";
    }

    }
  }
