package mediator;
import model.CourseList;

import java.io.FileNotFoundException;
import java.io.IOException;
public interface CourseListPersistence
{
  CourseList load(String path) throws IOException, ClassNotFoundException;
  void save(String filename, CourseList list) throws IOException;
}
