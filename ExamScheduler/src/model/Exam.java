package model;

public class Exam
{
    private Room examRoom;
    private Course course;
    private Class theClass;
    private Teacher teacher;
    private ListOfDates dates;
    private boolean isWritten;
    private int hour;
    private int minute;


    public Exam(Course course, Class theClass, Room examRoom, boolean isWritten)
    {
        this.examRoom = examRoom;
        this.course = course;
        this.theClass = theClass;
        this.teacher=course.getTeacher();
        this.dates=new ListOfDates();
        this.isWritten=isWritten;
        this.hour=8;
        this.minute=30;

    }



    public Room getRoom()
    {
        return examRoom;
    }
    public void setExamRoom(Room room){this.examRoom=room;}
    public int getMinute()
    {
        return minute;
    }

    public int getHour()
    {
        return hour;
    }
    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }
    public void setExamDate(MyDate date)
    {
        dates.add(date);
    }
    public String isWrittenString(){
        String s="";
        s+=isWritten;
        return s;
    }

    public Course getCourse()
    {
        return course;
    }
    public boolean isWritten(){return isWritten;}

    public Class getTheClass()
    {
        return theClass;
    }
    public Teacher getTeacher(){return teacher;}
    public ListOfDates getDate()
    {
        return dates;
    }
    public void removeDate(MyDate date)
    {
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.getDates().get(i).equals(date))
            {
                dates.remove(date);
                return;
            }
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Exam)) return false;
        Exam other = (Exam) obj;
        return this.examRoom.equals(other.examRoom) && this.course.equals(other.course) && this.teacher.equals(other.teacher)&& this.theClass.equals(other.theClass);
    }


    public String toString()
    {

        return "Course: " + getCourse() + System.lineSeparator() + "Class: "
                + getTheClass() + System.lineSeparator() + "Room: " + examRoom
                .getRoomName();

    }
    public String dateString()
    {
        String s = "";
        for (int i = 0; i < dates.size(); i++)
        {
            s += dates.getDates().get(i).toString() + "\n";
        }
        return s;
    }

}
