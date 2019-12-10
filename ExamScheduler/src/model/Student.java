package model;

public class Student {
    private String firstName;
    private String lastName;
    private int viaId;

    public Student(String firstName, String lastName, int viaId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.viaId = viaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getViaId() {
        return viaId;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;

        return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName) && this.viaId == other.viaId;
    }

    public String toString() {
        return firstName + " " + lastName + " " + viaId;
    }
}
