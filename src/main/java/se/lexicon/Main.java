package se.lexicon;


import java.util.ArrayList;
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

       /* for (Person p: people){
            if(isAdult .test(p)){
                System.out.println(p.getName()+ " is an adult");
            }
        }*/

        PersonRule isFromStockholm = p -> p.getCity().equals("Stockholm");

        /*for (Person p: people){
            if(isFromStockholm .test(p)){
                System.out.println(p.getName()+ " is from Stockholm");
            }

        }*/
        PersonRule isActive = p -> p.isActive();
        /*for (Person p: people){
            if(isActive .test(p)){
                System.out.println(p.getName()+ " is active");
            }

        }*/

        List<Person> adults = filteredPeople(people, isAdult);
        List<Person> stockholmers = filteredPeople(people, isFromStockholm);
        List<Person> activePeople = filteredPeople(people, isActive);

        System.out.println("Adults: ");
        adults.forEach(System.out::println);//for better printout
        System.out.println("-----------------");
        System.out.println("People from Stockholm: ");
        stockholmers.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Active People: ");
        activePeople.forEach(System.out::println);






    }
    //Exercise 3: filterPeople method
    public static List<Person> filteredPeople(List<Person> people, PersonRule rule){
        List<Person> result = new ArrayList<>();

        for(Person p: people){
            if(rule.test(p)){
                result.add(p);
            }
        }
        return result;
    }



}
