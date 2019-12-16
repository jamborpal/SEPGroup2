package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Exam;
import model.ExamListModel;

import java.util.ArrayList;

public class ExamListViewModel
{
    private ObservableList<ExamViewModel> list;
    private ExamListModel model;

    public ExamListViewModel(ExamListModel model)
    {
        this.model = model;
        list = FXCollections.observableArrayList();
    }

    public ObservableList<ExamViewModel> getList()
    {
        return list;
    }

    public ObservableList<ExamViewModel> update()
    {
        ArrayList<Exam> exams = new ArrayList<>();
        for (int i = 0; i < model.examListSize(); i++)
        {
            exams.add(model.getExam(i));
        }
        list.clear();
        for (int i = 0; i < exams.size(); i++)
        {
            list.add(new ExamViewModel(exams.get(i)));
        }
        return list;
    }

    public void add(Exam exam)
    {
        list.add(new ExamViewModel(exam));
    }

    public void remove(Exam exam)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getclassProperty().get().equals(exam.getTheClass()) && list.get(i).getCourseProperty().get().equals(exam.getCourse()) && list.get(i).getexaminerProperty().get().equals(exam.getTeacher()) && list.get(i).getroomProperty().get().equals(exam.getRoom()))
            {
                list.remove(i);
                break;
            }
        }
    }
}
