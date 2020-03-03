public class Worker extends Observer {
    public Worker(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        System.out.println("工人核查"+subject.getState());
    }
}
