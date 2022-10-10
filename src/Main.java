import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John", "Sam", "Rick", "ChunLi", "Peter", "Adam");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown", "Scott", "Goodman", "Hill", "Tree");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        persons.stream()
                .filter(f -> f.getEducation() == Education.HIGHER)
                .filter(f -> f.getAge() >= 18)
                .filter(f -> f.getSex() == Sex.WOMAN && f.getAge() < 60 || f.getSex() == Sex.MAN && f.getAge() < 65)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}