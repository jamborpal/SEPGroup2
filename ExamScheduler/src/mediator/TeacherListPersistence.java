package mediator;

import model.TeacherList;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface TeacherListPersistence
{
    TeacherList load(String path) throws IOException, ClassNotFoundException;
    void save(String filename, TeacherList list) throws IOException;
  }


