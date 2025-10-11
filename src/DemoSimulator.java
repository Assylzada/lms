public class DemoSimulator {
    public static void main(String[] args) {
        StudentPortalFacade portal = new StudentPortalFacade();

        Course mathCourse = new MentorSupportDecorator(new CertificateDecorator(new MathCourse()));

        Course programmingCourse = new GamificationDecorator(new ProgrammingCourse());

        System.out.println("======");
        portal.enrollInCourse("Barbie", mathCourse);
        portal.startLearning("Barbie", mathCourse);
        portal.completeCourse("Barbie", mathCourse);

        System.out.println("======");
        portal.enrollInCourse("Batman", programmingCourse);
        portal.startLearning("Batman", programmingCourse);
        portal.completeCourse("Batman", programmingCourse);
    }
}
