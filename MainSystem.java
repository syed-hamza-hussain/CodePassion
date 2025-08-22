package School;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainSystem {
    private JFrame frame;
    private JTextArea displayArea;

    private final ArrayList<Teacher> teachers = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    public MainSystem() {
        frame = new JFrame("School Management System");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons
        JButton addTeacherBtn = new JButton("Add Teacher");
        JButton addStudentBtn = new JButton("Add Student");
        JButton displayBtn = new JButton("Display All Records");
        JButton searchBtn = new JButton("Search by Name");
        JButton deleteBtn = new JButton("Delete Record");

        displayArea = new JTextArea(20, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(addTeacherBtn);
        panel.add(addStudentBtn);
        panel.add(displayBtn);
        panel.add(searchBtn);
        panel.add(deleteBtn);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);

        // Action Listeners
        addTeacherBtn.addActionListener(e -> addTeacher());
        addStudentBtn.addActionListener(e -> addStudent());
        displayBtn.addActionListener(e -> displayRecords());
        searchBtn.addActionListener(e -> searchRecord());
        deleteBtn.addActionListener(e -> deleteRecord());
    }

    private void addTeacher() {
        String name = JOptionPane.showInputDialog("Enter Teacher Name:");
        String dept = JOptionPane.showInputDialog("Enter Department:");
        String id = JOptionPane.showInputDialog("Enter Teacher ID:");

        if (name != null && dept != null && id != null) {
            teachers.add(new Teacher(name, dept, id));
            JOptionPane.showMessageDialog(frame, "Teacher Added Successfully!");
        }
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        String dept = JOptionPane.showInputDialog("Enter Department:");
        String roll = JOptionPane.showInputDialog("Enter Roll Number:");

        if (name != null && dept != null && roll != null) {
            students.add(new Student(name, dept, roll));
            JOptionPane.showMessageDialog(frame, "Student Added Successfully!");
        }
    }

    private void displayRecords() {
        displayArea.setText("---- Teachers ----\n");
        for (Teacher t : teachers) {
            displayArea.append(t.toString() + "\n");
        }

        displayArea.append("\n---- Students ----\n");
        for (Student s : students) {
            displayArea.append(s.toString() + "\n");
        }
    }

    private void searchRecord() {
        String searchName = JOptionPane.showInputDialog("Enter Name to Search:");

        if (searchName == null || searchName.trim().isEmpty()) return;

        displayArea.setText("---- Search Results ----\n");

        boolean found = false;

        for (Teacher t : teachers) {
            if (t.getName().equalsIgnoreCase(searchName.trim())) {
                displayArea.append(t.toString() + "\n");
                found = true;
            }
        }

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(searchName.trim())) {
                displayArea.append(s.toString() + "\n");
                found = true;
            }
        }

        if (!found) {
            displayArea.setText("No records found for name: " + searchName);
        }
    }

    private void deleteRecord() {
        String choiceInput = JOptionPane.showInputDialog("Delete by:\n1. Teacher ID\n2. Student Roll Number");

        if (choiceInput == null || choiceInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No option entered.");
            return;
        }

        final String choice = choiceInput.trim();

        if (choice.equals("1")) {
            final String inputID = JOptionPane.showInputDialog("Enter Teacher ID to Delete:");
            if (inputID == null || inputID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Teacher ID cannot be empty.");
                return;
            }

            final String id = inputID.trim();
            boolean removedTeacher = teachers.removeIf(t -> t.getTeacherID().equalsIgnoreCase(id));
            showResult("Teacher", removedTeacher, id);

        } else if (choice.equals("2")) {
            final String inputRoll = JOptionPane.showInputDialog("Enter Student Roll Number to Delete:");
            if (inputRoll == null || inputRoll.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Roll Number cannot be empty.");
                return;
            }

            final String roll = inputRoll.trim();
            boolean removedStudent = students.removeIf(s -> s.getRollNumber().equalsIgnoreCase(roll));
            showResult("Student", removedStudent, roll);

        } else {
            JOptionPane.showMessageDialog(frame, "Invalid option. Please enter 1 or 2.");
        }
    }

    private void showResult(String type, boolean removed, String id) {
        if (removed) {
            JOptionPane.showMessageDialog(frame, type + " record deleted for ID: " + id);
        } else {
            JOptionPane.showMessageDialog(frame, type + " record NOT found for ID: " + id);
        }
    }

    // ✅ Main method added
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainSystem::new);
    }
}
