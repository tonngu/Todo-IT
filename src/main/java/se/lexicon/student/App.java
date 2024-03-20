package se.lexicon.student;

import se.lexicon.student.model.Person;
import se.lexicon.student.model.TodoItem;
import se.lexicon.student.model.TodoItemTask;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person bruno = new Person("Bruno","Lengyel","bruno.lengyel@home.se");

        Person anna = new Person("Anna","Holm","anna.holm@home.se");

        //System.out.println(bruno.getSummary());

        TodoItem washDishes = new TodoItem("washDishes", "Don't use too much hot water", LocalDate.of(2024, 03, 20 ), false, anna);

        System.out.println(washDishes.getSummary());

        TodoItemTask washDishesTask = new TodoItemTask(washDishes,bruno);

        System.out.println(washDishesTask.getSummary());
    }

}
