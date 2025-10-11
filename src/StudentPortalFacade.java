class StudentPortalFacade {
    private final NotificationCenter notificationCenter = new NotificationCenter();
    private final ProgressTracker progressTracker = new ProgressTracker();

    public void enrollInCourse(String studentName, Course course) {
        System.out.println(studentName + " is in " + course.getCourseName() + ".");
        notificationCenter.sendNotification(studentName, "You are now enrolled in " + course.getCourseName() + ".");
        progressTracker.updateProgress(studentName + "-" + course.getCourseName(), 0);
    }

    public void startLearning(String studentName, Course course) {
        System.out.println(studentName + " has started learning " + course.getCourseName() + "...");
        notificationCenter.sendNotification(studentName, "You started your course!");
        simulateProgress(studentName, course);
    }

    private void simulateProgress(String studentName, Course course) {
        String key = studentName + "-" + course.getCourseName();
        for (int i = 20; i <= 100; i += 40) {
            progressTracker.updateProgress(key, i);
            progressTracker.showProgress(studentName, course.getCourseName());
            notificationCenter.sendNotification(studentName, "Good job! You reached " + i + "% completion.");
        }
    }

    public void completeCourse(String studentName, Course course) {
        System.out.println(studentName + " has completed " + course.getCourseName() + "!");
        course.deliverContent();
        progressTracker.updateProgress(studentName + "-" + course.getCourseName(), 100);
        notificationCenter.sendNotification(studentName, "Congratulations! You finished " + course.getCourseName() + ".");
        System.out.println("Progress tracked and all notifications sent.\n");
    }
}
