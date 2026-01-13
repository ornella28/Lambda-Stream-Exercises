package se.lexicon;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        System.out.println("---------------------");

        //Exercise 4: personAction
        PersonAction printName = p -> System.out.println(p.getName());
        PersonAction sendEmail = p -> System.out.println("Sending email to " + p.getName());

        for (Person p: people){
            printName.perform(p);
        }

        for (Person p: people){
            sendEmail.perform(p);
        }

        //Stream
        //Exercise1: filter all active people

        List<Person> activePeopleStream = people.stream()
                .filter(Person::isActive)
                .toList();

        //Exercise2: map all people
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();

        //Exercise3: count adults
        long adultCount = people.stream()
                .filter(p -> p.getAge() >= 18)
                .count();

        //Exercise4: sort people by age
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        //Exercise5: find first active person from Stockholm
        Optional <Person> firstActiveInStockholm = people.stream()
                .filter(Person::isActive)
                .filter(p -> p.getCity().equals("Stockholm"))
                .findFirst();

        //Optional tasks:
        //Exercise 1: Active adults
        List<Person> activeAdults = people.stream()
                .filter(Person::isActive)
                .filter(p-> p.getAge()>=18)
                .toList();

        //Active people in Stockholm
        List<Person> activeInStockholm = people.stream()
                .filter(Person::isActive)
                .filter(p -> p.getCity().equals("Stockholm"))
                .toList();

        //Inactive people older than 30
        List<Person> inactiveOlderThan30 = people.stream()
                .filter(p -> !p.isActive())
                .filter(p -> p.getAge() > 30)
                .toList();

        //Exercise 2:Distinct and Sorting
        //sorted List of unique cities
        List<String> uniqueCities = people.stream()
                .map(Person:: getCity)
                .distinct()
                .sorted()
                .toList();

        //SORTED list of unique first letters of names
        List<Character> uniqueFirstLetters = people.stream()
                .map(p-> p.getName().charAt(0))
                .distinct()
                .sorted()
                .toList();

        //Exercise 3: Mapping and Formatting
        //List of strings in format Name (Age) - city
        List<String> nameAgeCity = people.stream()
                .map(p -> p.getName() + "(" + p.getAge() + ") - "   + p.getCity())
                .toList();

        //List of emails like name.toLowerCase() + "@example.com"
        List<String> emails = people.stream()
                .map(p-> p.getName().toLowerCase() + "@example.com")
                .toList();









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
