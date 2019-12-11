package model;

import java.util.ArrayList;

public class Class
{
  private ArrayList<Student> students; //instance variables
  private String className;
  private Room classRoom;

  public Class(String className,
      Room classRoom) //initializing instance the variables
  {
    this.students = new ArrayList<>();
    this.className = className;
    this.classRoom = classRoom;
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public String getClassName() //returning the name of the class
  {
    return className;
  }

  public ArrayList<Student> getStudents()
  {
    return students;
  }

  public Room getClassRoom() //returning the class room of the class
  {
    return classRoom;
  }

  public boolean equals(Object obj) //equals method to compare Class objects
  {
    if (!(obj instanceof Class))
      return false;
    Class other = (Class) obj;
    return this.classRoom.equals(other.classRoom) && this.className
        .equals(other.className) && this.students.equals(other.students);
  }

  public String toString() //returning a String of all the information of a Class
  {
    String s = "";
    s += "Class name: " + className + ", class room: " + classRoom
        + ", students: \n";
    for (int i = 0; i < students.size(); i++)
    {
      s += students.get(i).toString();
      s += "\n";
    }
    return s;
  }
}
