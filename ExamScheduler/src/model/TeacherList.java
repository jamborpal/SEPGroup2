package model;

import java.util.ArrayList;

public class TeacherList
{
    private ArrayList<Teacher> teachers; //creating an ArrayList of Teachers

    public TeacherList()
    {
        this.teachers = new ArrayList<>();
    } //initializing the ArrayList, meaning creating a new

    public Teacher getTeacher(String viaId) //returning a Teacher object by the VIA ID of the Teacher
    {
        for (int i = 0; i < teachers.size(); i++)
        {
            if (teachers.get(i).getViaId().equals(viaId))
            {
                return teachers.get(i);
            }
        }
        return null;
    }

    public int getNumberOfTeachers()
    {
        return teachers.size();
    } //returns the number of Teachers stored

    public String toString() //returns all data in a String
    {
        String s = "";
        for (int i = 0; i < teachers.size(); i++)
        {
            s += teachers.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
