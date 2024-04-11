package se.lexicon.student.data;

import se.lexicon.student.model.TodoItem;

import java.time.LocalDateTime;
import java.util.Collection;

public interface TodoItemDao {
    TodoItem persist(TodoItem item);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDateTime date);
    Collection<TodoItem> findByDeadlineAfter(LocalDateTime date);
    void remove(int id);
}
