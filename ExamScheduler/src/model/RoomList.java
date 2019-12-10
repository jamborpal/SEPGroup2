package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> rooms;
  public RoomList()
  {
    this.rooms = new ArrayList<>();
  }

  public Room getRoomByName(String roomName)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if(rooms.get(i).getRoomName().equals(roomName))
      {
        return rooms.get(i);
      }
    }
    return null;
  }

  public ArrayList<Room> getRoomsBySize(int size)
  {
    ArrayList<Room> roomList = new ArrayList<>();
    for (Room room : rooms)
    {
      if (room.getSize() >= size)
      {
        roomList.add(room);
      }
    }
    return roomList;

  }
}
