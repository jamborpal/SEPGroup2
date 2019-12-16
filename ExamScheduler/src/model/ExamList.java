package model;

import java.util.ArrayList;

public class ExamList
{
    private ArrayList<Exam> exams;

    public ExamList()
    {
        this.exams = new ArrayList<>();
    }

    public Exam getExam(int index)
    {
        return exams.get(index);
    }



    public Exam getExam(Class theClass, Course course)
    {
        for (int i = 0; i < exams.size(); i++)
        {
            if (exams.get(i).getTheClass().equals(theClass)&&exams.get(i).getCourse().equals(course))
            {
                return exams.get(i);
            }
        }
        return null;
    }

    public void remove(Exam exam)
    {
        exams.remove(exam);
    }

    public int size()
    {
        return exams.size();
    }

    public void add(Exam exam)
    {
        exams.add(exam);
    }

//    public boolean checkConflictTeacher(Teacher teacher, MyDate date)
//    {
//        for (int i = 0; i < exams.size(); i++)
//        {
//            if (exams.get(i) instanceof Oral)
//            {
//                return (((Oral) exams.get(i)).getDate().contains(date) && exams.get(i)
//                        .getCourse().getTeachers().contains(teacher));
//
//            } else if (exams.get(i) instanceof Written)
//            {
//                return (((Written) exams.get(i)).getDate().equals(date) && exams.get(i)
//                        .getCourse().getTeachers().contains(teacher));
//            }
//        }
//        return Boolean.parseBoolean(
//                null);//we dont know what to return if nothing is true or nothing is okay
//    }


//    public boolean checkConflictTeacher(Teacher teacher, MyDate date)
//    {
//        ArrayList<Course> list = courses.getCoursesWithTeacher(teacher);
//        {
//            for (int i = 0; i < exams.size(); i++)
//            {
//                list.get(i).
//            }
//            return Boolean.parseBoolean(
//                    null);
//        }
//    }

//    public boolean checkConflictClass(Class classs, MyDate date)
//    {
//        for (int i = 0; i < exams.size(); i++)
//        {
//            if (exams.get(i) instanceof Oral)
//            {
//                return (((Oral) exams.get(i)).getDate().getDates().contains(date) && exams.get(i)
//                        .getTheClass().equals(classs));
//
//            } else if (exams.get(i) instanceof Written)
//            {
//                return (((Written) exams.get(i)).getDate().equals(date) && exams.get(i)
//                        .getTheClass().equals(classs));
//            }
//        }
//        return Boolean.parseBoolean(
//                null);
//    }

//    public boolean checkClassRoomConflict(Room classRoom, MyDate date)
//    {
//        for (int i = 0; i < exams.size(); i++)
//        {
//            if (exams.get(i) instanceof Oral)
//            {
//                return (((Oral) exams.get(i)).getDate().contains(date) && exams.get(i)
//                        .getTheClass().getClassRoom().equals(classRoom));
//
//            } else if (exams.get(i) instanceof Written)
//            {
//                return (((Written) exams.get(i)).getDate().equals(date) && exams.get(i)
//                        .getTheClass().getClassRoom().equals(classRoom));
//            }
//        }
//        return Boolean.parseBoolean(
//                null);
//    }

}
