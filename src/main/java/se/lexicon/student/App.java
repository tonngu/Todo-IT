package se.lexicon.student;

import se.lexicon.student.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person erik = new Person("Erik","Lengyel","erik.lengyel@lexicon.se");
        System.out.println(erik.getId());
        Person anna = new Person("Anna","Holm","anna.holm@lexicon.se");
        System.out.println(anna.getId());
        erik.getSummary();
    }
}
