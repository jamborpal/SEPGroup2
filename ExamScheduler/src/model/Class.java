package model;

public class Class
{
    private StudentList studentList; //instance variables
    private String className;
    private String classRoomName;
    private Semester semester;

    public Class(String className, String classRoomName, StudentList studentList, Semester semester) //initializing instance the variables
    {
        this.studentList = studentList;
        this.className = className;
        this.classRoomName = classRoomName;
        this.semester = semester;
    }

    public String getClassName() //returning the name of the class
    {
        return className;
    }

    public String getClassRoomName() //returning the class room of the class
    {
        return classRoomName;
    }

    public boolean equals(Object obj) //equals method to compare Class objects
    {
        if (!(obj instanceof Class)) return false;
        Class other = (Class) obj;
        return this.classRoomName.equals(other.classRoomName) && this.className.equals(other.className) && this.semester.equals(other.semester) && this.studentList.equals(other.studentList);
    }

    public String toString() //returning a String of all the information of a Class
    {
        String s = "";
        s += "Class name: " + className + ", class room: " + classRoomName + ", semester: " + semester + ", students: \n";
        s += studentList.toString();
        return s;
    }
}
