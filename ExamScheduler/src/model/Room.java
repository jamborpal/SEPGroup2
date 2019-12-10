package model;

public class Room
{
  private String roomName;
  private int size;
  private boolean vga;
  private boolean hdmi;
  private boolean isArrangedW;

  public Room(String roomName, int size, boolean vga, boolean hdmi, boolean isArrangedW)
  {
    this.roomName = roomName;
    this.size = size;
    this.vga = vga;
    this.hdmi = hdmi;
    this.isArrangedW = isArrangedW;
  }
}
