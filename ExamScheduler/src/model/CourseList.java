package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseList
{
    private ArrayList<Course> courseList;//ArrayList of Courses

    public CourseList(Course courseList)
    {
        this.courseList = new ArrayList<>();
    } //initializing the instance variable courseList

    public int getNumberOfCourses()
    {
        return courseList.size();
    } //returning the number of courses

    public Course getCourseByName(String name)////gets a course by its name
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

    public ArrayList<Course> getUnscheduledCourses() //returns the unscheduled courses as an ArrayList
    {
        ArrayList<Course> unscheduled = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            if (!courseList.get(i).isScheduled())
            {
                unscheduled.add(courseList.get(i));
            }
        }
        return unscheduled;
    }



    public String toString() //returns a String of all the data
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
