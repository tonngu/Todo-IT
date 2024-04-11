package se.lexicon.student;

import se.lexicon.student.data.impl.AppUserDAOCollection;
import se.lexicon.student.model.AppUser;
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
        /*Person bruno = new Person("Bruno","Lengyel","bruno.lengyel@home.se");

        Person anna = new Person("Anna","Holm","anna.holm@home.se");

        TodoItem washDishes = new TodoItem("washDishes", "Don't use too much hot water", LocalDate.of(2024, 03, 20 ), false, anna);

        System.out.println(washDishes.toString());

        TodoItemTask washDishesTask = new TodoItemTask(washDishes,bruno);

        System.out.println(washDishesTask.toString());
        */

        AppUser user1 = new AppUser("carl1","1234567");
        AppUserDAOCollection appUserStorage1 = new AppUserDAOCollection();
        appUserStorage1.persist(user1);
        System.out.println(appUserStorage1.findByUsername("carl1"));
        appUserStorage1.remove("carl1");
        System.out.println(appUserStorage1.findByUsername("carl1"));

    }

}
