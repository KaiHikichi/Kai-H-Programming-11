import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        School Poppy = new School(teachers,students,"Poppy","Langley");

        for(int i=0;i<10;i++){
            students.add(new Student());
        }
        for(int i=0;i<3;i++){
            teachers.add(new Teacher());
        }
        Poppy.showStudents();
        Poppy.showTeachers();
        for(int i=0;i<2;i++){
            Poppy.delStudent(i);
        }
        Poppy.delTeacher(1);
        Poppy.showStudents();
        Poppy.showTeachers();
    }
}
