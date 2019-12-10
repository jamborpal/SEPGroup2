package model;

public class Teacher
{
    private String firstName;
    private String lastName;
    private String viaId;

    public Teacher(String firstName, String lastName, String viaId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.viaId = viaId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getViaId()
    {
        return viaId;
    }

    public String toString()
    {
        String s = "";
        s += "Name: ";
        s += firstName + " " + lastName + ", ";
        s += "VIA ID: ";
        s += viaId + ". ";
        return s;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Teacher)) return false;
        Teacher other = (Teacher) obj;
        return this.lastName.equals(other.lastName) && this.viaId.equals(other.viaId) && this.firstName.equals(other.lastName);
    }
}
