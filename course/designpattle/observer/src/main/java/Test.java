public class Test {
    public static void main(String[] args) {
        SubjectFactory subjectFactory = new SubjectFactory();
        Subject subject = subjectFactory.getSubject();

        Worker worker = new Worker(subject);
        QualityInspector qualityInspector = new QualityInspector(subject);

        subject.attach(worker);
        subject.attach(qualityInspector);

        System.out.println("设定state = 10");
        subject.setState(10);
        System.out.println("设定state = 15");
        subject.setState(15);
    }
}
