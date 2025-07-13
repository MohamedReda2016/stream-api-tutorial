import com.dailycodebuffer.model.Employee;
import com.dailycodebuffer.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static List<Employee> employees = new ArrayList<>();

    static {

        employees.add(new Employee("mohamed", "reda", 5000.0, List.of("project1", "project2", "project3", "project4")));
        employees.add(new Employee("mostafa", "mansour", 4000.0, List.of("project2", "project3", "project4")));
        employees.add(new Employee("ali", "mohamed", 6000.0, List.of("project1", "project3", "project4")));
        employees.add(new Employee("wael", "ahmed", 8000.0, List.of("project1", "project2")));
    }

    public static void main(String[] args) {
//       employees.stream().forEach(System.out::println);
//        List<Employee> employeesAfterRaise = employees.stream().map(employee ->
//                new Employee(employee.getFirstName(),
//                        employee.getLastName(),
//                        employee.getSalary() * 1.10,
//                        employee.getProjects())).toList();
//
//        employeesAfterRaise.forEach(System.out::println);

     /*  List<Employee> filteredEmployeesAfterRaise= employees.stream().filter(employee->employee.getSalary() >5000)
                .map(employee ->
                        new Employee(employee.getFirstName(),
                       employee.getLastName(),
                       employee.getSalary() * 1.10,
                       employee.getProjects())).toList();
        filteredEmployeesAfterRaise.forEach(System.out::println);

        String result =employees.stream().map(Employee::getProjects).flatMap(List::stream).distinct().collect(Collectors.joining(","));
        System.out.println(result);

        employees.stream().skip(2).limit(1).forEach(System.out::println);

        Stream.generate(Math::random).limit(3).forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName)).forEach(System.out::println);

        Employee maxEmployee =employees.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
        System.out.printf("Max Salary for this employee %s",maxEmployee);*/

        List<Person> persons = Person.getPersons();
       // printPersonsOlderThan(persons, 30);
       // printPersonsWithInAgeRange(persons, 20, 30);
        printPersonsWithMultiCriteria(persons, new CheckPersonEligableForSelectiveSearch());
        printPersonsWithMultiCriteria(persons, person -> {
            return  person.getAge() >= 30 &&  person.getAge() <= 100 && person.getGender() == Person.Sex.MALE;
        });

        printPersonsWithMultiCriteria(persons, person->person.getAge() >= 30 &&  person.getAge() <= 100 && person.getGender() == Person.Sex.MALE);
    }

    public static void printPersonsWithInAgeRange(List<Person> persons,  Integer minAge, Integer maxAge) {
        for (Person person : persons) {
            if (person.getAge() >= minAge && person.getAge() <= maxAge) {
                System.out.println(person);
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> persons, int age) {
        for (Person person : persons) {
            if (person.getAge() >= age) {
                System.out.println(person);
            }
        }
    }

    public static void printPersonsWithMultiCriteria(List<Person> persons,  CheckPerson  checkPerson) {
        for (Person person : persons) {
            if(checkPerson.test(person)) {
                person.printPerson();
            }
        }
    }

    interface CheckPerson{
        boolean test(Person person);
    }

    static class CheckPersonEligableForSelectiveSearch implements CheckPerson{
        @Override
        public boolean test(Person person) {
            return  person.getAge() >= 30 &&  person.getAge() <= 100 && person.getGender() == Person.Sex.FEMALE;

        }
    }
}