package model;

public class Class
{
  //instance variables
  private String className;
  private String classRoom;
  private int studentCount;

  public Class(String className,String classRoom,int studentCount) //initializing instance the variables
  {
    this.className = className;
    this.classRoom=classRoom;
    this.studentCount=studentCount;
  }


  public String getClassName() //returning the name of the class
  {
    return className;
  }
  public String getClassRoom(){
    return classRoom;
  }
  public int getStudentCount(){
    return studentCount;
  }



  public boolean equals(Object obj) //equals method to compare Class objects
  {
    if (!(obj instanceof Class))
      return false;
    Class other = (Class) obj;
    return this.className.equals(other.className);
  }

  public String toString() //returning a String of all the information of a Class
    {
      String s = "";
    s +=className +", classroom: "+classRoom +".";
    return s;
  }
}
