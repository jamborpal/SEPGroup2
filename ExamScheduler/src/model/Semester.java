package model;

public class Semester
{
    private int semester;

    public Semester(int semester)
    {
        this.semester = semester;
    }

    public int getSemesterNumber()
    {
        return semester;
    }
    public void nextSemester(){
        semester++;
    }
}
