package model;

import parser.ParserException;
import parser.XmlJsonParser;

import javax.swing.*;
import java.io.File;

public class main
{
  public static void main(String[] args) throws ParserException
  {
    Room room = new Room("301a", 15, true, false, false);
    Room room1 = new Room("301b", 14, false, true, true);
    Room room2 = new Room("302", 20, true, true, true);
    Room room3 = new Room("303", 30, false, false, false);
    RoomList roomList = new RoomList();
    roomList.add(room);
    roomList.add(room1);
    roomList.add(room2);
    roomList.add(room3);
    Teacher teacher0 = new Teacher("Steffen", "Vissing Andersen", "something");
    Teacher teacher1 = new Teacher("Something something", "This and That",
        "someone");
    Teacher teacher2 = new Teacher("everzthing something", "agsge", "wsd");
    Teacher teacher3 = new Teacher("all something", "gaerfdg",
        "someascvfsdeone");
    Course course0 = new Course("SDJ1");
    course0.addTeacher(teacher0);
    course0.addTeacher(teacher1);
    course0.addTeacher(teacher2);
    course0.addTeacher(teacher3);
    Student student0 = new Student("sfdg", "sdgav", 24);
    Student student1 = new Student("afdg", "sdgfgadgav", 2432);
    Student student2 = new Student("sfdgadfdg", "sdgdagadgav", 254);
    Class class0 = new Class("Y1", room);
    class0.addStudent(student0);
    class0.addStudent(student1);
    class0.addStudent(student2);
    Exam exam0 = new Oral(course0, class0);
    exam0.setExamRoom(room2);
    MyDate date0=new MyDate(1,2,23);
    MyDate date1=new MyDate(12,11,243);
    MyDate date2=new MyDate(13,10,2443);
    ((Oral) exam0).setDates(date0);
    ((Oral) exam0).setDates(date1);

    System.out.println("\n");
    System.out.println("\n");
    System.out.println("\n");
    System.out.println("\n");

    System.out.println(exam0.toString());
    Exam exam1 =new Written(course0, class0);
    ((Written) exam1).setExamDate(date2);
    ((Written) exam1).setHour(8);
    ((Written) exam1).setMinute(30);

   if(!exam1.getTheClass().getClassRoom().equals(room1))
   {

   }

   else if(examList.checkForConflicts(room1, exam1.getDate()))
    {

    }
    else
   {
     exam1.setExamRoom(room1);
  }

    System.out.println("\n");
    System.out.println("\n");
    System.out.println("\n");
    System.out.println("\n");

    System.out.println(exam1.toString());
  }
}
