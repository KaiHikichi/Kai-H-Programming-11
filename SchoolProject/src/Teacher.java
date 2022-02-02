/*
The Teacher class simply represents a teacher with a first and last name, and the subject they teach.
 */

public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    //constructors
    Teacher(String firstName,String lastName,String subject){      //Constructs a teacher with a given first and last name, and a subject.
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    Teacher(){      //Constructs a teacher with no name and default subject
        this.firstName = "first";
        this.lastName = "last";
        this.subject = "subject";
    }

    public String toString() {       //When Teacher object is called returns "Name: full name Subject: subject"
        return "Name: " + this.firstName + " " + this.lastName + " " + "Subject: " + this.subject;
    }

    //setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
