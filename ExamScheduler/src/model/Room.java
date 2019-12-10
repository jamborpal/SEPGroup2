package model;

public class Room
{
  private String roomName; //instance variables for the data
  private int size;
  private boolean vga;
  private boolean hdmi;
  private boolean isArrangedW;

  public Room(String roomName, int size, boolean vga, boolean hdmi,
      boolean isArrangedW) //initializing instance variables
  {
    this.roomName = roomName;
    this.size = size;
    this.vga = vga;
    this.hdmi = hdmi;
    this.isArrangedW = isArrangedW;
  }

  public boolean isVga() //returning if there is VGA connection in the room
  {
    return vga;
  }

  public boolean isHdmi()//returning if there is HDMI connection in the room
  {
    return hdmi;
  }

  public boolean isArrangedForWritten()//returning if the room is arranged for a written exam
  {
    return isArrangedW;
  }

  public String getRoomName() //returns the name of the room
  {
    return roomName;
  }

  public int getSize()
  {
    return size;
  } //returns the size of the room

  public void setIsArrangedForWritten(boolean isArrangedW)
  {
    this.isArrangedW = isArrangedW;
  } //setting the isArrangedW variable

  public void setSize(int size)
  {
    this.size = size;
  } //sets the size of the room

  public boolean isCompatibleForOral()
  {
    return vga && hdmi;
  }//returns if the rooms is compatible for an oral exam

  public boolean equals(Object obj) //equals method for the RoomList class to compare Room objects
  {
    if(!(obj instanceof  Room))
    {
      return false;
    }
    Room other = (Room) obj;
    return roomName.equals(other.roomName)
        && size == other.size && vga == other.vga && hdmi == other.hdmi && isArrangedW == other.isArrangedW;
  }

  public String toString(){
    return "The name of the room: " + roomName + System.lineSeparator() + "The size of the room: " + size + System.lineSeparator() + "Has VGA?: " + vga + System.lineSeparator() + "Has HDMI?: " + hdmi + System.lineSeparator() + "Is arranged for written?: " + isArrangedW;
  }//returning a String of all the information of the room
}
