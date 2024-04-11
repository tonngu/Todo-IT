package se.lexicon.student.data.impl;

import se.lexicon.student.data.TodoItemDao;
import se.lexicon.student.data.sequencer.TodoItemIdSequencer;
import se.lexicon.student.model.TodoItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDao {
    private List<TodoItem> storage = new ArrayList<>();

    public TodoItem persist(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("Todo Item cannot be null");
        int id = TodoItemIdSequencer.nextId();
        todoItem.setId(id);
        storage.add(todoItem);
        return todoItem;
    }

    public TodoItem findById(int id) {
        for (TodoItem todoItem : storage) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        System.out.println("Todo Item not found");
        return null;
    }

    public Collection<TodoItem> findAll() {
        return new ArrayList<>(storage);
    }

    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        Collection<TodoItem> findResult = new ArrayList<>();
        for (TodoItem todoItem : storage) {
            if (todoItem.isDone() == done) {
                findResult.add(todoItem);
            }
        }
        return findResult;
    }

    public Collection<TodoItem> findByTitleContains(String title) {
        Collection<TodoItem> findResult = new ArrayList<>();
        for (TodoItem todoItem : storage) {
            if (todoItem.getTitle().contains(title)) {
                findResult.add(todoItem);
            }
        }
        return findResult;
    }

    //this is creator's id
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> findResult = new ArrayList<>();
        for (TodoItem todoItem : storage) {
            if (todoItem.getCreator().getId() == personId) {
                findResult.add(todoItem);
            }
        }
        return findResult;
    }

    public Collection<TodoItem> findByDeadlineBefore(LocalDateTime date) {
        Collection<TodoItem> findResult = new ArrayList<>();
        for (TodoItem todoItem : storage) {
            if (date.isBefore(todoItem.getDeadline())) {
                findResult.add(todoItem);
            }
        }
        return findResult;
    }

    public Collection<TodoItem> findByDeadlineAfter(LocalDateTime date) {
        Collection<TodoItem> findResult = new ArrayList<>();
        for (TodoItem todoItem : storage) {
            if (date.isAfter(todoItem.getDeadline())) {
                findResult.add(todoItem);
            }
        }
        return findResult;
    }

    public void remove (int id){
        storage.remove(findById(id));
    }

}
