abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public void deliverContent() {
        decoratedCourse.deliverContent();
    }

    @Override
    public String getCourseName() {
        return decoratedCourse.getCourseName();
    }
}

class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course decoratedCourse) { super(decoratedCourse); }

    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("Certificate granted after completion!");
    }
}

class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course decoratedCourse) { super(decoratedCourse); }

    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("Personal mentor support added!");
    }
}

class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course decoratedCourse) { super(decoratedCourse); }

    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("Gamification: Points and leaderboard activated!");
    }
}
