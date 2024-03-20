package se.lexicon.student.model;

public class TodoItemTask {
    private static int taskCount = 0;
    private int id;
    private boolean assigned;
    private TodoItem todoitem;
    private Person assignee; //the person who's assigned to do the task

    public TodoItemTask(TodoItem todoitem, Person assignee) {
        ++taskCount;
        this.id = taskCount;;
        setTodoitem(todoitem);
        setAssignee(assignee);
        if (this.assignee != null) {
            this.assigned = true;
        }
    }

    public boolean isAssigned(){
        return this.assigned;
    }

    public void setAssigned(boolean assigned){
        this.assigned = assigned;
    }

    public TodoItem getTodoitem() {
        return todoitem;
    }

    public void setTodoitem(TodoItem todoitem) {
        if (todoitem == null) {
            throw new IllegalArgumentException("A task Todo must be included.");}
        this.todoitem = todoitem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public String getSummary() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoitem=" + "Id: " + todoitem.getId() + ", Title: " + todoitem.getTitle() + ", Description: " + todoitem.getTaskDescription() + ", Deadline: " + todoitem.getDeadLine() + ", Done: " + todoitem.isDone() +
                ", assignee=" + "Id: " + assignee.getId() + ", Assignee: " + assignee.getFirstName() + " " + assignee.getLastName() +
                '}';
    }
}
