package model;


import files.fileConsole;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamModelManager implements ExamListModel
{
    private ExamList examList;
    private CourseList courseList;
    private ClassList classList;
    private fileConsole fileConsole;
    private RoomList roomList;
    ListOfDates dates;


    public ExamModelManager() throws ParserException
    {
        this.fileConsole = new fileConsole();
        this.examList = new ExamList();
        this.courseList = fileConsole.readCourseList();
        this.classList = fileConsole.readClassList();
        this.roomList = fileConsole.readRoomList();
        this.dates=new ListOfDates();
    }


    //the following methods are for the checkScheduleView, also I made a few extra methods in other classes in order to make these
    public fileConsole getFileConsole(){
        return fileConsole;
    }
    public ExamList getTeachersScheduleById(String viaId) throws ParserException
    {
        ExamList teacherExams = examList;
        for (int i = 0; i < teacherExams.size(); i++)
        {
            if (teacherExams.getExam(i).getTeacher().equals(viaId))
            {
                teacherExams.add(teacherExams.getExam(i));
            }
        }
        return teacherExams;
    }

    public ArrayList<Exam> getClassSchedule(String className)
    {
        ArrayList<Exam> classExams = new ArrayList<>();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getTheClass().getClassName().equals(className))
            {
                classExams.add(examList.getExam(i));
            }
        }
        return classExams;
    }

    public ArrayList<Exam> getCourseSchedule(String courseName)
    {
        ArrayList<Exam> courseExams = new ArrayList<>();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getCourse().getCourseName().equals(courseName))
            {
                courseExams.add(examList.getExam(i));
            }
        }
        return courseExams;
    }

    public ArrayList<Exam> getScheduleByDate(MyDate date)
    {
        ArrayList<Exam> examsByDate = new ArrayList<>();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getDate().getDates().get(i).equals(date))
            {

                examsByDate.add(examList.getExam(i));
            }
        }
        return examsByDate;
    }

    public CourseList getCourses()
    {

        return courseList;
    }

    public Teacher getTeacher(Course course)
    {
        return course.getTeacher();
    }
    public ListOfDates getDates(){
        return dates;
    }

    public ClassList getTheClasses()
    {
        return classList;
    }

    public RoomList getRooms()
    {
        return roomList;
    }
    public ExamList getExamList(){
        return examList;
    }

    public ListOfDates getDate(Exam exam)
    {
        for(int i=0;i<examList.size();i++){
            if(examList.getExam(i).equals(exam)){
                return examList.getExam(i).getDate();
            }
        }return null;
    }
    //end of methods for checkScheduleView

    //start of methods necessary for ManageDataView
    public void setExamRoom(Room room, Exam exam)
    {
        for(int i=0;i<examList.size();i++){
            if(examList.getExam(i).equals(exam)){
                examList.getExam(i).setExamRoom(room);
            }
        }
    }

    public void setDate(MyDate newDate, Exam exam)
    {
        for (int i = 0; i < examList.size(); i++)
        {
            if(examList.getExam(i).equals(exam)){
                examList.getExam(i).setExamDate(newDate);
            }
        }
    }

    public int examListSize()
    {
        return examList.size();
    }

    public Exam getExam(int index)
    {
        return examList.getExam(index);
    }

    private void createDummyData()
    {
        try
        {
            String[] course = {"SDJ", "RWD", "MSE", "SEP", "DBS" };
            String[] classes = {"Y", "Z", "X", "V", "C" };
            String[] rooms = {"E301", "B345", "D567", "R458", "B841" };
            String[] names = {"Steffen", "Line", "Mona", "Lars", "Someone" };
            String[] lastNames = {"Andersen", "ZHKZJ", "Jensen", "sadjaksja", "Bacon" };
            String[] viaIds = {"842222", "798787", "665242", "7845478", "7854245" };
            int[] sizes = {30, 50, 15, 10, 14};
            for (int i = 0; i < course.length; i++)
            {
                Teacher teacherDum = new Teacher(names[i], lastNames[i], viaIds[i]);
                Course courseDum = new Course(course[i], teacherDum);
                Class theClass = new Class(classes[i],"room",30);
                Room room = new Room(rooms[i], sizes[i], true, true, true);
                MyDate mydate = new MyDate(8, 12, 2019);
            }
        } catch (Exception e)
        {
            //ok
        }
    }

    public void PlanAnExam(Course course, Class theClass, Room room, ListOfDates dates, boolean isWritten) throws ParserException, FileNotFoundException
    {
        Exam exam = new Exam(course, theClass, room,isWritten);
        for(int i=0;i<dates.size();i++){
            exam.setExamDate(dates.getDates().get(i));
        }
        examList.add(exam);
        fileConsole.writeExamList(examList);
//        System.out.println(examList.size());
    }
    public void removeAnExam(Exam exam){
        for (int i = 0; i < examList.size(); i++)
        {
            if(examList.getExam(i).equals(exam)){
                examList.remove(exam);
            }
        }
    }

//    public void addDate(MyDate date, Exam exam)
//    {
//        ArrayList<MyDate> xoxo = ((Written)exam).getDate();
//    }
//
//    public void PlanAnOralExam(Course course, Class theClass)


    //end methods for Managing data
    //start methods for planning an exam
//    public void planAWrittenExam(Course course, Class theClass, MyDate date, Room room, int hour, int minute)
//    {
//        for(int i=0;i<examList.size();i++) {
//            if(examList.getExam(i).getCourse().equals(course)&&examList.getExam(i).getTheClass().equals(theClass)){
//              return; //it exits from the method if the condition is not true
//            }
//        }
//        if(examList.checkConflictRoom(room, date)&&examList.checkConflictClass(theClass,date)&&examList.checkConflictTeacher(course.getTeacher()))
//        Exam exam = new Written(course, theClass);
//        exam.setExamRoom(room);
//        ((Written) exam).setExamDate(date);
//        ((Written) exam).setHour(hour);
//        ((Written) exam).setMinute(minute);
//        examList.add(exam);
//    }

//    public void planAnOralExam(Course course, Class theClass, MyDate date, Room room)
//    {//it is supposed to get a bunch of dates and put it to the exam
//        Exam exam = new Oral(course, theClass);
//        exam.setExamRoom(room);
//        ((Oral) exam).setDates(date);
//    }//end of methods necessary for ManageDataView


}