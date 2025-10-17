class StudentPortalFacade {
    private final NotificationCenter notificationCenter = new NotificationCenter();
    private final ProgressTracker progressTracker = new ProgressTracker();
    private final StudentRepository studentRepository = new InMemoryStudentRepository();

    // ---------- STUDENT MANAGEMENT ----------
    public void registerStudent(Student student) {
        studentRepository.addStudent(student);
        notificationCenter.sendNotification(student.getName(), "Welcome to LMS platform!");
    }

    public void removeStudent(String id) {
        studentRepository.removeStudent(id);
    }

    public void showAllStudents() {
        studentRepository.listAllStudents();
    }

    // ---------- COURSE MANAGEMENT ----------
    public void enrollInCourse(String studentName, Course course) {
        System.out.println(studentName + " has enrolled in " + course.getCourseName() + ".");
        notificationCenter.sendNotification(studentName, "You are now enrolled in " + course.getCourseName() + ".");
        progressTracker.updateProgress(studentName + "-" + course.getCourseName(), 0);
    }

    public void startLearning(String studentName, Course course) {
        System.out.println(studentName + " has started learning " + course.getCourseName() + "...");
        notificationCenter.sendNotification(studentName, "Your learning journey has begun!");
        simulateProgress(studentName, course);
    }

    private void simulateProgress(String studentName, Course course) {
        String key = studentName + "-" + course.getCourseName();
        for (int i = 25; i <= 100; i += 25) {
            progressTracker.updateProgress(key, i);
            progressTracker.showProgress(studentName, course.getCourseName());
            notificationCenter.sendNotification(studentName, "Progress: " + i + "% in " + course.getCourseName());
        }
    }

    public void completeCourse(String studentName, Course course) {
        course.deliverContent();
        progressTracker.updateProgress(studentName + "-" + course.getCourseName(), 100);
        notificationCenter.sendNotification(studentName, "Congratulations! You finished " + course.getCourseName() + ".");
        System.out.println("✅ Progress tracked and all notifications sent.\n");
    }
}
