package files;

import model.*;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class fileConsole implements fileManager
{
    private ExamModelManager examModelManager;

    public fileConsole() throws ParserException
    {

    }

    public CourseList readCourseList() throws ParserException
    {

        XmlJsonParser parser = new XmlJsonParser();
        CourseList courseList = parser.fromXml("courses.xml", CourseList.class);
        return courseList;
    }

    public ClassList readClassList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        ClassList classList = parser.fromXml("classes.xml", ClassList.class);
        return classList;
    }

    public TeacherList readTeacherList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        TeacherList teacherList = parser.fromXml("teachers.xml", TeacherList.class);
        return teacherList;
    }

    public ExamList readExamList() throws ParserException//something is wrong with the reading here
    {
        XmlJsonParser parser = new XmlJsonParser();
        ExamList examList = parser.fromXml("exams.xml", ExamList.class);
        return examList;
    }

    public RoomList readRoomList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        RoomList roomList = parser.fromXml("rooms.xml", RoomList.class);
        return roomList;
    }

    public void writeExamList(ExamList examList) throws FileNotFoundException, ParserException
    {

        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(examList, "exams.xml");
        System.out.println(file.getAbsolutePath());
    }

    public void writeExamListManual(ExamList examList) throws FileNotFoundException
    {
        File file = new File("examManual.xml");
        PrintWriter out = new PrintWriter(file);
        String xml = "";
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        xml += "\n<ExamList>";
        for (int i = 0; i < examList.size(); i++)
        {
            xml += "\n<Exam>";
            xml += "\n <Course>" + examList.getExam(i).getCourse().getCourseName() + "</Course>";
            xml += "\n <Class>" + examList.getExam(i).getTheClass().getClassName() + "</Class>";
            xml += "\n <Date>" + examList.getExam(i).getDate().allDates() + "</Date>";
            xml += "\n <Room>" + examList.getExam(i).getRoom().getRoomName() + "</Room>";
            xml += "\n <Examiner>" + examList.getExam(i).getTeacher().toString() + "</Examiner>";
            xml += "\n</Exam>";
        }
        xml += "\n</ExamList>";
        out.println(xml);
        out.close();
    }

}
