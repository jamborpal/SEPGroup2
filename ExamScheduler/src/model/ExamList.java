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

  public void remove(Exam exam)
  {
    exams.remove(exam);
  }

  public boolean checkConfiltTeacher(Teacher teacher, MyDate date)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i) instanceof Oral)
      {
        return (((Oral) exams.get(i)).getDate().contains(date) && exams.get(i)
            .getCourse().getTeachers().contains(teacher));

      }
      else if (exams.get(i) instanceof Written)
      {
        return (((Written) exams.get(i)).getDate().equals(date) && exams.get(i)
            .getCourse().getTeachers().contains(teacher));
      }
    }
    return Boolean.parseBoolean(
        null);//we dont know what to return if nothing is true or nothing is okay
  }

  getcheckconfliotroom
      getcheckconflictclass
  checkclass'classroomconflict

}
