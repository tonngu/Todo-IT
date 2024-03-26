package se.lexicon.student.model;



import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TodoItem other = (TodoItem) obj;
        return id == other.id &&
                done == other.done &&
                Objects.equals(title, other.title) &&
                Objects.equals(taskDescription, other.taskDescription) &&
                Objects.equals(deadLine, other.deadLine);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (done ? 1231 : 1237);
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
        result = prime * result + ((deadLine == null) ? 0 : deadLine.hashCode());
        return result;
    }

}
