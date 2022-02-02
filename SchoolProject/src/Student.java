/*
The Student class simply represents a student with a first and last name, aswell as a grade and a unique
student number for each student.
 */

public class Student {
    private static int staticNum = 1;
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNum;

    //constructors
    Student(String firstName,String lastName,int grade){    //Constructs a student with the given first and last name, grade, and creates a uniqe student number
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNum = staticNum;
        staticNum++;
    }

    Student(){    //Constructs a student with no name and default grade
        this.firstName = "first";
        this.lastName = "last";
        this.grade = 10;
        this.studentNum = staticNum;
        staticNum++;
    }


    public String toString(){       //When Student object is called returns "Name: full name Grade: grade"
        return "Name: " + this.firstName + " " + this.lastName + " " + "Grade: " + this.grade;
    }

    //getters and setters
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static int getStaticNum() {
        return staticNum;
    }

    public int getStudentNum() {
        return studentNum;
    }
}
