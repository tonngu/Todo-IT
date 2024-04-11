package se.lexicon.student.data;

import se.lexicon.student.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDao {
    TodoItemTask persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(int id);
}
