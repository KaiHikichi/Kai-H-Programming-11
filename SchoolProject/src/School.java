/*
The School class represents a school with an ArrayList of teachers and students, the courses available, the name,
the city its in and the size equal to the number of students + number of teachers.
 */
import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();
    private String name;
    private String city;
    private int size;

    //constructor
    School(ArrayList<Teacher> teachers, ArrayList<Student> students, String name, String city){     //constructs a school with a given list of teachers and students, name, and city.
        this.teachers = teachers;
        this.students = students;
        for(int i=0;i<teachers.size();i++){
            courses.add(teachers.get(i).getSubject());
        }
        this.name = name;
        this.city = city;
        this.size = teachers.size() + students.size();
    }

    public void addTeacher(Teacher teacher){    //adds a teacher to the ArrayList of teachers.
        teachers.add(teacher);
    }

    public void addStudent(Student student){    //adds a student to the ArrayList of students.
        students.add(student);
    }

    public void delTeacher(int index){      //removes a teacher from the ArrayList of teachers at a given index
        teachers.remove(index);
    }

    public void delStudent(int index){      //removes a student from the ArrayList of students at a given index
        students.remove(index);
    }

    public void showTeachers(){         //shows all teachers in a school
        System.out.println("Teacher List: "+teachers);
    }

    public void showStudents(){         //shows all students in a school
        System.out.println("Student List: "+students);
    }

}
