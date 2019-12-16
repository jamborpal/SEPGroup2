package model;

import java.util.ArrayList;

public class ListOfDates
{
  private ArrayList<MyDate> dates;

  public ListOfDates()
  {
    this.dates = new ArrayList<>();
  }
  public String allDates(){
    String s="";
    for(int i=0; i<dates.size();i++){
      s+=dates.get(i).toString();
      s+="\n";
    }return s;
  }

  public void add(MyDate date)
  {
    dates.add(date);
  }

  public void remove(MyDate date)
  {
    dates.remove(date);
  }

  public ArrayList<MyDate> getDates()
  {
    return dates;
  }

  public int size()
  {
    return dates.size();
  }


  public String toString()
  {
    String s = "";
    for (int i = 0; i < dates.size(); i++)
    {
      s += dates.get(i).toString();
      s += "\n";
    }
    return s;
  }
}
