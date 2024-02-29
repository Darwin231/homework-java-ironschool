import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Map<String, Course> courseList = new HashMap<>();
        Map<String, Student> studentList = new HashMap<>();
        Map<String, Teacher> teacherList = new HashMap<>();
        Course curso1 = new Course("asdfasdf1", "Barista", 1200, 500);
        courseList.put(curso1.getCourseId(),curso1);
        Course curso2 = new Course("asdfasdf2", "Informatico", 100, 600);
        courseList.put(curso2.getCourseId(),curso2);
        Course curso3 = new Course("asdfasdf3", "Electricista", 700, 300);
        courseList.put(curso3.getCourseId(),curso3);
        Student estudiante1 = new Student("Xavi", "Mi calle","email@gmail.com");
        studentList.put(estudiante1.getStudentId(),estudiante1);
        Student estudiante2 = new Student("Xavi", "Mi calle","email@gmail.com");
        studentList.put(estudiante2.getStudentId(),estudiante2);
        Student estudiante3 = new Student("Xavi", "Mi calle","email@gmail.com");
        studentList.put(estudiante3.getStudentId(),estudiante3);
        Teacher profesor1 = new Teacher("Toni", 3000);
        teacherList.put(profesor1.getTeacherId(),profesor1);
        Teacher profesor2 = new Teacher("Toni", 3000);
        teacherList.put(profesor2.getTeacherId(),profesor2);
        Teacher profesor3 = new Teacher("Toni", 3000);
        teacherList.put(profesor3.getTeacherId(),profesor3);
        Application app = new Application();

        Commands comandos = new Commands(courseList,studentList,teacherList);
        Scanner scanner = new Scanner(System.in);
        app.Selector(comandos);
        //comandos.commandSelector( CommandEnum.ENROLL,scanner);

    }
}
