package se.lexicon;


import java.util.List;

public class Main {

    void main(){
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Göteborg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        //Exercise 1: Create a functional interface named PersonRule

        PersonRule isAdult = p -> p.getAge() >=18;
        PersonRule isFromStockholm = p -> p.getCity().equals("Stockholm");
        PersonRule isActive = p -> p.isActive();

    }



}
