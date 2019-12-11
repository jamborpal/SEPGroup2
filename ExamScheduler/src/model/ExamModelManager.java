package model;

import java.util.ArrayList;

public class ExamModelManager
{
    private ArrayList<Exam> exams;

    public ArrayList<Exam> getTeachersScheduleById(String id)
    {
        ArrayList<Exam> teachersSchedule = new ArrayList<>();
        for (int i = 0; i < exams.size(); i++)
        {
            for (int j = 0; j < exams.get(i).getCourse().getTeacherList().getNumberOfTeachers(); j++)
            {
                if (exams.get(i).getCourse().getTeacherList().getTeacher(j).getViaId().equals(id))
                {
                    teachersSchedule.add(exams.get(i));
                }
            }
        }
        return teachersSchedule;
    }
}
