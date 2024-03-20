package se.lexicon.student.model;



import java.time.LocalDate;

public class TodoItem {
    private static int itemCount = 0;
    private int id;
    public String title; //according to the UML diagram this variable is not supposed to be private(?)
    public String taskDescription; //according to the UML diagram this variable is not supposed to be private(?)
    public LocalDate deadLine; //according to the UML diagram this variable is not supposed to be private(?)
    public boolean done; //according to the UML diagram this variable is not supposed to be private(?)
    public Person creator; //according to the UML diagram this variable is not supposed to be private(?)

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        ++itemCount;
        this.id = itemCount;
        setTitle(title);
        this.taskDescription = taskDescription;
        setDeadLine(deadLine);
        setDone(done);
        setCreator(creator);
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty.");
        }
        this.title = title;
    }

    public void setDeadLine(LocalDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Deadline must be included.");}
        this.deadLine = deadline;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person person) {
        this.creator = person;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator(){
        return creator;
    }

    public boolean isOverdue(){
        return LocalDate.now().isAfter(this.deadLine);
    }

    public String getSummary() {
        return "TodoItem{" +
                "id=" + id +
                ", title=" + title +
                ", description=" + taskDescription +
                ", deadline=" + deadLine +
                ", done=" + done +
                ", creator=Id:" + creator.getId() + ", Task Creator: " + creator.getFirstName() + " " + creator.getLastName() +
                '}';
    }

}
