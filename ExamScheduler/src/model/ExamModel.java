package model;


import java.util.ArrayList;

public interface ExamModel
{
ArrayList<Exam> getTeachersScheduleById(String id);
ArrayList<Exam> getScheduleByClass(String ClassName);
ArrayList<Exam> getScheduleByCourse(String courseName);
ArrayList<Exam> getSchedulesByDate(MyDate date);
void setClasss(Class className);
void setRoom(Room room);
void setStartDate(MyDate start);
void setEndDate(MyDate end);
void setSemester(Semester semester);
void setCourse(Course course);
Class getClasss();
Course getCourse();
Semester getSemester();
Room getRoom();
MyDate getStartDate();
MyDate getEndDate();

}
