public class QualityInspector extends Observer {
    public QualityInspector(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        System.out.println("质检员记录"+subject.getState());
    }
}
