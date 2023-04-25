package tracker;

public class Subject {
    private final String subject;
    private final int id;


    public Subject(String subject, int id){
        this.subject = subject;
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }
}
