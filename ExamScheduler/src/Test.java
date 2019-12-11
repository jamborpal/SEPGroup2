import model.*;

public class Test
{
    public static void main(String[] args)
    {
        Teacher teacher1 = new Teacher("Steffen", "lfbnlkd","lbs");
        TeacherList teacherList = new TeacherList();
        teacherList.addTeacher(teacher1);
        Semester semester=new Semester(3)
        Course course = new Course("sdbdg", semester, teacherList);
        CourseList courseList = new CourseList();
        courseList.addCourse(course);
        Room room = new Room("fbs",30,false,true,false);
        RoomList roomList=new RoomList();
        roomList.addRoom(room);

    }
}
