package model;

public class Room
{
  private String roomName;
  private int size;
  private boolean vga;
  private boolean hdmi;
  private boolean isArrangedW;

  public Room(String roomName, int size, boolean vga, boolean hdmi,
      boolean isArrangedW)
  {
    this.roomName = roomName;
    this.size = size;
    this.vga = vga;
    this.hdmi = hdmi;
    this.isArrangedW = isArrangedW;
  }

  public boolean isVga()
  {
    return vga;
  }

  public boolean isHdmi()
  {
    return hdmi;
  }

  public boolean isArrangedForWritten()
  {
    return isArrangedW;
  }

  public String getRoomName()
  {
    return roomName;
  }

  public int getSize()
  {
    return size;
  }

  public void setIsArrangedForWritten(boolean isArrangedW)
  {
    this.isArrangedW = isArrangedW;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public boolean isCompatibleForOral()
  {
    return vga && hdmi;
  }

  public boolean equals(Object obj)
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
  }
}
