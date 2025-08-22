package School;

/**
 * The base class for both Student and Teacher.
 */
public class Person {
    protected String name;
    protected String department;

    public Person(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
