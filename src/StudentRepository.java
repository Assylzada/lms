interface StudentRepository {
    void addStudent(Student student);
    void removeStudent(String id);
    Student getStudentById(String id);
    void listAllStudents();
}
