import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
public class Application {
    private Map<String, Course> courseList = new HashMap<>();
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Teacher> teacherList = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public Application() {
        createSchoolName();

        setTeacherList(teacherDetails());
        setStudentList(studentDetails());
        setCourseList(courseDetails());
    }

    public void run() {
        Commands commands = new Commands(this.getCourseList(), this.getStudentList(), this.getTeacherList());
        while (true) {
            String commandStr = scanner.nextLine();
            try {
                CommandEnum commandEnum = commands.findCommandEnum(commandStr);
                String[] ids = commands.findIDs(commandStr, commandEnum);
                commands.commandSelector(commandEnum, ids[0], ids[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.print("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }

    private static int numberOfComponents(SchoolComponents schoolComponents) {
        int number;

        do {
            System.out.print(String.format("How many %s are there in the school: ", schoolComponents));
            while (!scanner.hasNextInt()) {
                System.out.println(String.format("Please enter a valid number for the %s ", schoolComponents));
                scanner.next();
            }
            number = scanner.nextInt();

            if (number <= 0) {
                System.err.println(String.format("The number of %s can't be 0 or negative", schoolComponents));
            } else if (number == 1) {
                System.out.println(String.format("In your school there is only " + number + " %s", schoolComponents));
            } else {
                System.out.println(String.format("In your school there are " + number + " %s", schoolComponents));
            }

        } while (number <= 0);

        return number;

    }

    private Map<String,Teacher> teacherDetails() {
        Map<String,Teacher> teachersMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.TEACHERS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            teachersMap.put(teacher.getTeacherId(), teacher);
        }

        for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary());
            }

          return teachersMap;

    }

    private Map<String,Student> studentDetails() {
        Map<String,Student> studentMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.STUDENTS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, address, email);
            studentMap.put(student.getStudentId(), student);
        }

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Address: " + entry.getValue().getAddress() + ", Email: " + entry.getValue().getEmail());
            }

        return studentMap;

    }

    private Map<String,Course> courseDetails() {
        Map<String,Course> coursesMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.COURSES);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Course course = new Course(name, price);
            coursesMap.put(course.getCourseId(), course);
        }

        for (Map.Entry<String, Course> entry : coursesMap.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Price: " + entry.getValue().getPrice());
        }

        return coursesMap;

    }
}




