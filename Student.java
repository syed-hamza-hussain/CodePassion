package School;

public class Student extends Person {
    private final String rollNumber;

    public Student(String name, String department, String rollNumber) {
        super(name, department); // calling Person constructor
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Student [Name: " + name + ", Department: " + department + ", Roll No: " + rollNumber + "]";
    }
}
