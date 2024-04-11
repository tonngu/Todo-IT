package se.lexicon.student.model;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoitem;
    private Person assignee; //the person who's assigned to do the task

    public TodoItemTask(TodoItem todoitem, Person assignee) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoitem=" + todoitem +
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
        TodoItemTask other = (TodoItemTask) obj;
        return id == other.id &&
                assigned == other.assigned &&
                Objects.equals(todoitem, other.todoitem);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (assigned ? 1231 : 1237);
        result = prime * result + ((todoitem == null) ? 0 : todoitem.hashCode());
        return result;
    }
}
