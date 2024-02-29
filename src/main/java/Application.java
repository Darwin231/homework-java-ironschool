import java.util.*;

public class Application {

    public static void main(String[] args) {

        createSchoolName();
        teacherDetails();
        //Commands comandos = new Commands();
        //Selector(comandos); TODO Descomenta estas dos lineas cuando estén los tres mapas listos
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.println("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }

    private static int number(SchoolComponents classToCount) {
        int number;

        do {
            System.out.println(String.format("How many %s are there in the school: ", classToCount));
            while (!scanner.hasNextInt()) {
                System.out.println(String.format("Please enter a valid number for the %s ", classToCount));
                scanner.next();
            }
            number = scanner.nextInt();

            if (number <= 0) {
                System.err.println(String.format("The number of %s can't be 0 or negative", classToCount));
            } else if (number == 1) {
                System.out.println(String.format("In your school there is only " + number + " %s", classToCount));
            } else {
                System.out.println(String.format("In your school there are " + number + " %s", classToCount));
            }

        } while (number <= 0);

        return number;

    }

    private static Map<String,Teacher> teacherDetails() {
        Map<String,Teacher> teachersMap = new HashMap<>();
        int number = number(SchoolComponents.TEACHERS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            teachersMap.put(teacher.getTeacherId(), teacher);
        }

        /*for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary());
            }*/

          return teachersMap;

    }

    public static void Selector(Commands comandos){
        System.out.println("Choose a command:\n");
        System.out.println("1. Enroll\n");
        System.out.println("2. Assign\n");
        System.out.println("3. Show courses\n");
        System.out.println("4. Lookup course\n");
        System.out.println("5. Show students\n");
        System.out.println("6. Lookup student\n");
        System.out.println("7. Show teachers\n");
        System.out.println("8. Lookup teacher\n");
        System.out.println("9. Show profit\n");
        try {
            Scanner scanner = new Scanner(System.in);
            int commandoption = scanner.nextInt();
            switch (commandoption) {
                case 1:
                    comandos.commandSelector(CommandEnum.ENROLL, scanner);
                    break;
                case 2:
                    comandos.commandSelector(CommandEnum.ASSIGN, scanner);
                    break;
                case 3:
                    comandos.commandSelector(CommandEnum.SHOW_COURSES, scanner);
                    break;
                case 4:
                    comandos.commandSelector(CommandEnum.LOOKUP_COURSE, scanner);
                    break;
                case 5:
                    comandos.commandSelector(CommandEnum.SHOW_STUDENTS, scanner);
                    break;
                case 6:
                    comandos.commandSelector(CommandEnum.LOOKUP_STUDENT, scanner);
                    break;
                case 7:
                    comandos.commandSelector(CommandEnum.SHOW_TEACHERS, scanner);
                    break;
                case 8:
                    comandos.commandSelector(CommandEnum.LOOKUP_TEACHER, scanner);
                    break;
                case 9:
                    comandos.commandSelector(CommandEnum.SHOW_PROFIT, scanner);
                    break;
                default:
                    System.err.println("The option selected is not available");
                    break;
            }
        }catch(InputMismatchException ime) {
            System.err.println("The option selected is not available");
        }
    }
}




