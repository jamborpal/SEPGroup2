package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseList
{
    private ArrayList<Course> courseList;

    public CourseList(Course courseList)
    {
        this.courseList = new ArrayList<>();
    }

    public int getNumberOfCourses()
    {
        return courseList.size();
    }

    public Course getCourseByName(String name)
    {
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getCourseName().equals(name))
            {
                return courseList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Course> getUnscheduledCourses()
    {
        ArrayList<Course> unscheduled = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).isScheduled() == false)
            {
                unscheduled.add(courseList.get(i));
            }
        }
        return unscheduled;
    }

    public ArrayList<Course> getCoursesBySemester(int semester)
    {
        ArrayList<Course> bySemester = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getSemester().getSemesterNumber() == semester)
            {
                bySemester.add(courseList.get(i));
            }
        }
        return bySemester;
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < courseList.size(); i++)
        {
            s += courseList.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
