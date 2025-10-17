import java.util.HashMap;
import java.util.Map;

class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("Student added: " + student.getName());
    }

    @Override
    public void removeStudent(String id) {
        if (students.containsKey(id)) {
            System.out.println("Student removed: " + students.get(id).getName());
            students.remove(id);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    @Override
    public Student getStudentById(String id) {
        return students.get(id);
    }

    @Override
    public void listAllStudents() {
        System.out.println("Current students:");
        for (Student s : students.values()) {
            System.out.println(" - " + s.getName() + " (ID: " + s.getId() + ")");
        }
    }
}
