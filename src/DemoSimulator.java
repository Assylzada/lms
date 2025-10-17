import java.util.Scanner;

public class DemoSimulator {
    public static void main(String[] args) {
        StudentPortalFacade portal = new StudentPortalFacade();
        Scanner scanner = new Scanner(System.in);

        Course mathCourse = new MentorSupportDecorator(new CertificateDecorator(new MathCourse()));
        Course programmingCourse = new GamificationDecorator(new ProgrammingCourse());

        boolean running = true;

        while (running) {
            System.out.println("\n===== ONLINE EDUCATION PLATFORM =====");
            System.out.println("1. Register new student");
            System.out.println("2. Remove student");
            System.out.println("3. Show all students");
            System.out.println("4. Enroll student in course");
            System.out.println("5. Start learning");
            System.out.println("6. Complete course");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    portal.registerStudent(new Student(id, name));
                }

                case 2 -> {
                    System.out.print("Enter student ID to remove: ");
                    String id = scanner.nextLine();
                    portal.removeStudent(id);
                }

                case 3 -> {
                    portal.showAllStudents();
                }

                case 4 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Choose course: 1. Math  2. Programming");
                    int c = Integer.parseInt(scanner.nextLine());
                    Course chosenCourse = (c == 1) ? mathCourse : programmingCourse;
                    portal.enrollInCourse(name, chosenCourse);
                }

                case 5 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Choose course: 1. Math  2. Programming");
                    int c = Integer.parseInt(scanner.nextLine());
                    Course chosenCourse = (c == 1) ? mathCourse : programmingCourse;
                    portal.startLearning(name, chosenCourse);
                }

                case 6 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Choose course: 1. Math  2. Programming");
                    int c = Integer.parseInt(scanner.nextLine());
                    Course chosenCourse = (c == 1) ? mathCourse : programmingCourse;
                    portal.completeCourse(name, chosenCourse);
                }

                case 7 -> {
                    running = false;
                    System.out.println("Exiting the system... Goodbye!");
                }

                default -> System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
