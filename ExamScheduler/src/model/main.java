package model;

import parser.ParserException;
import parser.XmlJsonParser;

import java.io.FileNotFoundException;

public class main
{

    public static void main(String[] args) throws ParserException, FileNotFoundException
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
        Course course0 = new Course("SDJ1", teacher0);
        ;
        Course course1 = new Course("MSE1", teacher1);

        Course course2 = new Course("SSE1", teacher0);
        CourseList courseList = new CourseList();
        courseList.add(course0);
        courseList.add(course1);
        courseList.add(course2);
        Class class1 = new Class("Y1", "room1",20);
        Class class2 = new Class("X1", "room2",30);
        Class class3 = new Class("Z1", "room3",10);
        Class class4 = new Class("P1", "room4",11);
        ClassList classList = new ClassList();
        classList.add(class1);
        classList.add(class2);
        classList.add(class3);
        classList.add(class4);
        TeacherList teacherList = new TeacherList();
        teacherList.add(teacher0);
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        Exam exam1 = new Exam(course0, class1, room, true);
        MyDate date = new MyDate(12, 1, 2020);
        MyDate date1 = new MyDate(13, 1, 2020);
        exam1.setExamDate(date);
        exam1.setExamDate(date1);
        Exam exam2 = new Exam(course1, class2, room1, false);
        exam2.setExamDate(date1);
        ExamList examList = new ExamList();
        examList.add(exam1);
        examList.add(exam2);
        XmlJsonParser parser =new XmlJsonParser();
        parser.toXml(classList, "classes.xml");

    }
}

//
//        System.out.println(courseList.getCoursesWithTeacher(teacher0));
//        XmlJsonParser parser = new XmlJsonParser();
//        File file = parser.toXml(examList, "exams.xml");
////    Student student0 = new Student("sfdg", "sdgav", 24,"adf");
////    Student student1 = new Student("afdg", "sdgfgadgav", 2432,"sav");
////    Student student2 = new Student("sfdgadfdg", "sdgdagadgav", 254,"sva");
////    Class class0 = new Class("Y1", room);
////    class0.addStudent(student0);
////    class0.addStudent(student1);
////    class0.addStudent(student2);
////    Exam exam0 = new Oral(course0, class0);
////    exam0.setExamRoom(room2);
////    MyDate date0=new MyDate(1,2,23);
////    MyDate date1=new MyDate(12,11,243);
////    MyDate date2=new MyDate(13,10,2443);
////    ((Oral) exam0).setDates(date0);
////    ((Oral) exam0).setDates(date1);
////
////    System.out.println("\n");
////    System.out.println("\n");
////    System.out.println("\n");
////    System.out.println("\n");
////
////    System.out.println(exam0.toString());
////    Exam exam1 =new Written(course0, class0);
////    ((Written) exam1).setExamDate(date2);
////    ((Written) exam1).setHour(8);
////    ((Written) exam1).setMinute(30);
////
////   //if(!exam1.getTheClass().getClassRoom().equals(room1))
////    //   {
////    //
////    //   }
////    //
////    //   else if(examList.checkForConflicts(room1, exam1.getDate()))
////    //    {
////    //
////    //    }
////    //    else
////    //   {
////    //     exam1.setExamRoom(room1);
////    //  }
////
////    System.out.println("\n");
////    System.out.println("\n");
////    System.out.println("\n");
////    System.out.println("\n");
////
////    System.out.println(exam1.toString());
//    }
//}
