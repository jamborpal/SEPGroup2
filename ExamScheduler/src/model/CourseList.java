package model;

import java.util.ArrayList;

public class CourseList
{
    private ArrayList<Course> courseList;//ArrayList of Courses

    public CourseList()
    {
        this.courseList = new ArrayList<>();
    } //initializing the instance variable courseList

    public int getNumberOfCourses()
    {
        return courseList.size();
    } //returning the number of courses
    public ArrayList<Course> getCourses(){
        return courseList;
    }

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

    public void add(Course course)
    {
        courseList.add(course);
    }
    public int size(){
        return courseList.size();
    }
    public Course get(int index){return courseList.get(index);}

    public ArrayList<Course> getUnscheduledCourses() //returns the unscheduled courses as an ArrayList
    {
        ArrayList<Course> unscheduled = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            if (!courseList.get(i).getIsScheduled())
            {
                unscheduled.add(courseList.get(i));
            }
        }
        return unscheduled;
    }

    public ArrayList<Course> getCoursesWithTeacher(Teacher teacher)
    {
        ArrayList<Course> coursesWithCertainTeacher = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            Teacher teacherC = courseList.get(i).getTeacher();
            if (teacherC.equals(teacher))
            {
                coursesWithCertainTeacher.add(courseList.get(i));
            }
        }
        return coursesWithCertainTeacher;
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
