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
  public ArrayList<Room> getRoomsForOral()
  {
    ArrayList<Room> roomsForOral = new ArrayList<>();
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).isCompatibleForOral())
      {
        roomsForOral.add(rooms.get(i));
      }
    }
    return roomsForOral;
  }

  public ArrayList<Room> getRoomsForWritten()
  {
    ArrayList<Room> roomsForWritten = new ArrayList<>();
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).isCompatibleForWritten())
      {
        roomsForWritten.add(rooms.get(i));
      }
    }
    return roomsForWritten;
  }


  public void add(Room room)
  {
    rooms.add(room);
  }

  public void remove(Room room)
  {
    rooms.remove(room);
  }

  public String toString()
  {
    String s = "The rooms with their data that are currently in the system: ";
    for (int i = 0; i < rooms.size(); i++)
    {
      s += "\n" + i + 1;
      s += ". " + rooms.get(i).toString();
    }
    return s;
  }

  public int size()
  {
    return rooms.size();
  }
}
