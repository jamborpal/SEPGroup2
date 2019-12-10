package mediator;
import model.RoomList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.IOException;

public interface RoomListPersistence
{
  RoomList load(String path) throws IOException, ClassNotFoundException;
  void save(String filename, RoomList list) throws IOException;
}
