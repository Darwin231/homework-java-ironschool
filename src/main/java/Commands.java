import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commands {
    private Map<String, Course> courseList = new HashMap<>();
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Teacher> teacherList = new HashMap<>();


    public Commands(Map<String, Course> courseList, Map<String, Student> studentList, Map<String, Teacher> teacherList) {
        setCourseList(courseList);
        setStudentList(studentList);
        setTeacherList(teacherList);
    }


    public Map<String, Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Map<String, Course> courseList) {
        this.courseList = courseList;
    }

    public Map<String, Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Map<String, Student> studentList) {
        this.studentList = studentList;
    }

    public Map<String, Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Map<String, Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void selector(){
        System.out.println("Choose a command:\n");
        System.out.println("1. Enroll:\n");
        System.out.println("2. Assign:\n");
        System.out.println("3. Show courses:\n");
        System.out.println("4. Lookup course:\n");
        System.out.println("5. Show students:\n");
        System.out.println("6. Lookup student\n");
        System.out.println("7. Show teachers:\n");
        System.out.println("8. Lookup teacher:\n");
        System.out.println("9. Show profit:\n");
        Scanner scanner = new Scanner(System.in);
        int commandoption = scanner.nextInt();
        commandSelector(CommandEnum.ENROLL, scanner);
    }
    public void commandSelector(CommandEnum commandAction, Scanner scanner){
        String studentID = "asdfasdf";
        String courseID = "asdfasdf";
        String teacherID = "asdfasdf";
        switch (commandAction){
        case ENROLL:
            System.out.println("Which course do you want to enroll? (write the id):\n");
            courseList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName() + " ");
            });
            courseID = scanner.next();
            System.out.println("Which student do you want to enroll in this course? (write the id):\n");
            studentList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName()+ " ");

            });
            studentID = scanner.next();
            enroll(studentID,courseID);
            break;
        case ASSIGN:
            System.out.println("In which course do you want to assign a teacher? (write the id):\n");
            courseList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName() + " ");
            });
            courseID = scanner.next();
            System.out.println("Which teacher do you want to assign to this course? (write the id):\n");
            teacherList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName()+ " ");

            });
            studentID = scanner.next();
            assign(teacherID,courseID);
            break;
        case SHOW_COURSES:
            ShowCourses();
            break;
        case LOOKUP_COURSE:
            System.out.println("Which course do you want to look up? (write the id):\n");
            courseList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName() + " ");
            });
            courseID = scanner.next();
            LookupCourse(courseID);
            break;
        case SHOW_STUDENTS:
            ShowStudents();
            break;
        case LOOKUP_STUDENT:
            System.out.println("Which student do you want to look up? (write the id):\n");
            studentList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName() + " ");
            });
            studentID = scanner.next();
            LookupStudent(studentID);
            break;
        case SHOW_TEACHERS:
            ShowTeachers();
            break;
        case LOOKUP_TEACHER:
            System.out.println("Which teacher do you want to look up? (write the id):\n");
            teacherList.forEach((key,value) -> {
                System.out.println(key + " = " + value.getName() + " ");
            });
            teacherID = scanner.next();
            LookupTeacher(teacherID);
            break;
        case SHOW_PROFIT:
            ShowProfit();
            break;
        default:
            System.err.println("The command selected is not available");
            break;
        }
    }

    public void enroll(String studentID, String courseID){ // This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price

    }

    public void assign(String teacherID,String courseID){   //This command will help assign the teacher specified to the corresponding course

    }

    public void ShowCourses(){    //This command will display a list of all courses
        System.out.println("List of Courses: ");
        for (Map.Entry<String, Course> entry : courseList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupCourse(String courseID){ // This command will display the full details of the specified course
        if(courseList.containsKey(courseID)) {
            System.out.println("Course ID: " + courseID);
            System.out.println("Course Name: " + courseList.get(courseID).getName());
            System.out.println("Course Price: " + courseList.get(courseID).getPrice());
            System.out.println("Course Money Earned: " + courseList.get(courseID).getMoney_earned());
            System.out.println("Course Teacher: " + courseList.get(courseID).getTeacher().getName());
        }
    }

    public void ShowStudents(){ //This command will display a list of all students
        System.out.println("List of Students: ");
        for (Map.Entry<String, Student> entry : studentList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupStudent(String studentID){ //This command will display the full details of the specified student
        if(studentList.containsKey(studentID)){
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentList.get(studentID).getName());
            System.out.println("Student Address: " + studentList.get(studentID).getAddress());
            System.out.println("Student Email: " + studentList.get(studentID).getEmail());
            System.out.println("Student Course: " + studentList.get(studentID).getCourse().getName());
        }
    }

    public void ShowTeachers(){ //This command will display a list of all teachers
        System.out.println("List of Teachers: ");
        for (Map.Entry<String, Teacher> entry : teacherList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupTeacher(String teacherID){ // This command will display the full details of the specified teacher
        if(teacherList.containsKey(teacherID)){
            System.out.println("Teacher ID: " + teacherID);
            System.out.println("Teacher Name: " + teacherList.get(teacherID).getName());
            System.out.println("Teacher Salary: " + teacherList.get(teacherID).getSalary());
        }
    }

    public void ShowProfit(){ //This command will calculate (The total money earned from all courses) - (The sum of all the teachers' salaries) and return the result
    }
}

