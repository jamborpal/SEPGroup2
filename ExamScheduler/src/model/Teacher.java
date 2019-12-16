package model;

public class Teacher
{
    private String firstName; //Creating private instance variables to hold teacher's data
    private String lastName;
    private String viaId;

    public Teacher(String firstName, String lastName, String viaId) //initializing the instance variables
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.viaId = viaId;
    }

    public String getFirstName()
    {
        return firstName;
    } //this method returns the firstname of the teacher

    public String getLastName()
    {
        return lastName;
    } //this method returns the lastname of the teacher

    public String getViaId()
    {
        return viaId;
    } //this method returns the VIA ID of the teacher

    public String toString() //returning all the information as a String
    {
        String s = "";
        s += firstName + " " + lastName + ", ";
        s += "VIA ID: ";
        s += viaId + ". ";
        return s;
    }

    public boolean equals(Object obj) //equals method, which gives back if two objects are the same, it is used in class TeacherList
    {
        if (!(obj instanceof Teacher)) return false;
        Teacher other = (Teacher) obj;
        return this.lastName.equals(other.lastName) && this.viaId.equals(other.viaId) && this.firstName.equals(other.firstName);
    }
}
