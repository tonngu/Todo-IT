package se.lexicon.student.data.impl;

import se.lexicon.student.data.TodoItemTaskDao;
import se.lexicon.student.data.sequencer.TodoItemTaskIdSequencer;
import se.lexicon.student.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOCollection implements TodoItemTaskDao {
    List<TodoItemTask> storage = new ArrayList<>();

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if (todoItemTask == null) throw new IllegalArgumentException("Todo Item Task cannot be null");
        int id = TodoItemTaskIdSequencer.nextId();
        todoItemTask.setId(id);
        storage.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask todoItemTask : storage) {
            if (todoItemTask.getId() == id) {
                return todoItemTask;
            }
        }
        System.out.println("Todo Item Task not found");
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> findResult = new ArrayList<>();
        for (TodoItemTask todoItemTask : storage) {
            if (todoItemTask.isAssigned() == status) {
                findResult.add(todoItemTask);
            }
        }
        return findResult;
    }

    //Search by assignee's ID
    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> findResult = new ArrayList<>();
        for (TodoItemTask todoItemTask : storage) {
            if (todoItemTask.getAssignee().getId() == personId) {
                findResult.add(todoItemTask);
            }
        }
        return findResult;
    }

    @Override
    public void remove(int id) {
        storage.remove(findById(id));
    }
}
