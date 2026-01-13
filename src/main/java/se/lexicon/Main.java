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

        //Exercise 2:

        PersonRule isAdult = p -> p.getAge() >=18;

        for (Person p: people){
            if(isAdult .test(p)){
                System.out.println(p.getName()+ " is an adult");
            }
        }
        PersonRule isFromStockholm = p -> p.getCity().equals("Stockholm");

        for (Person p: people){
            if(isFromStockholm .test(p)){
                System.out.println(p.getName()+ " is from Stockholm");
            }

        }
        PersonRule isActive = p -> p.isActive();
        for (Person p: people){
            if(isActive .test(p)){
                System.out.println(p.getName()+ " is active");
            }

        }

    }



}
