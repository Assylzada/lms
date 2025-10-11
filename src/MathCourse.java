class MathCourse implements Course {
    @Override
    public void deliverContent() {
        System.out.println("Delivering Math course content...");
    }
    @Override
    public String getCourseName() { return "Math Course"; }
}

class ProgrammingCourse implements Course {
    @Override
    public void deliverContent() {
        System.out.println("Delivering Programming course content...");
    }
    @Override
    public String getCourseName() { return "Programming Course"; }
}

