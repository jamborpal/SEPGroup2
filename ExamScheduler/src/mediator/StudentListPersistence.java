package mediator;

import model.StudentList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.IOException;

public interface StudentListPersistence
{
  StudentList load(String path) throws IOException, ClassNotFoundException;
  void save(String filename, StudentList list) throws IOException;
}
