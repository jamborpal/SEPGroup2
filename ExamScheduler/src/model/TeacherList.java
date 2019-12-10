package model;

import java.util.ArrayList;

public class TeacherList
{
    private ArrayList<Teacher> teachers;

    public TeacherList()
    {
        this.teachers = new ArrayList<>();
    }

    public Teacher getTeacher(String viaId)
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
    }

    public String toString()
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
