package model;


import files.fileConsole;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface ExamListModel
{
    ExamList getTeachersScheduleById(String viaId) throws ParserException;

    ArrayList<Exam> getClassSchedule(String ClassName);

    ArrayList<Exam> getCourseSchedule(String courseName);

    ArrayList<Exam> getScheduleByDate(MyDate date);

    CourseList getCourses();
    Teacher getTeacher(Course course);
    ClassList getTheClasses();
    RoomList getRooms();
    ListOfDates getDate(Exam exam);
    int examListSize();
    Exam getExam(int index);
    fileConsole getFileConsole();
    ExamList getExamList();

    void setExamRoom(Room room, Exam exam);
    void setDate(MyDate newDate, Exam exam);
    void PlanAnExam(Course course, Class theClass, Room room, ListOfDates dates, boolean isWritten) throws ParserException, FileNotFoundException;
    void removeAnExam(Exam exam);
    ListOfDates getDates();

}
