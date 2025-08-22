package School;

public class Teacher extends Person {
    private final String teacherID;

    public Teacher(String name, String department, String teacherID) {
        super(name, department); // calling Person constructor
        this.teacherID = teacherID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    @Override
    public String toString() {
        return "Teacher [Name: " + name + ", Department: " + department + ", ID: " + teacherID + "]";
    }
}
