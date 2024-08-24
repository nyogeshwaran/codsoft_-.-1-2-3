import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class StudentGradeCalculator {

    private static final String FILE_NAME = "grade_history.txt";
    private JFrame frame;
    private JTextField nameField;
    private JTextField gradeField;
    private JTextArea historyArea;
    private ArrayList<String> history;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentGradeCalculator().createAndShowGUI());
    }

    public StudentGradeCalculator() {
        history = new ArrayList<>();
        loadHistory();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Student Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(10, 20, 150, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(150, 20, 165, 25);
        panel.add(nameField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(10, 50, 150, 25);
        panel.add(gradeLabel);

        gradeField = new JTextField(20);
        gradeField.setBounds(150, 50, 165, 25);
        panel.add(gradeField);

        JButton calculateButton = new JButton("Calculate GPA");
        calculateButton.setBounds(10, 80, 150, 25);
        panel.add(calculateButton);

        JButton saveButton = new JButton("Save Entry");
        saveButton.setBounds(180, 80, 150, 25);
        panel.add(saveButton);

        historyArea = new JTextArea();
        historyArea.setBounds(10, 110, 360, 140);
        panel.add(historyArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGPA();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEntry();
            }
        });

        updateHistoryArea();
    }

    private void calculateGPA() {
        try {
            String name = nameField.getText();
            double grade = Double.parseDouble(gradeField.getText());
            double gpa = grade / 20; // Simple GPA calculation
            JOptionPane.showMessageDialog(frame, "Student: " + name + "\nGPA: " + gpa);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid grade entered.");
        }
    }

    private void saveEntry() {
        String name = nameField.getText();
        String grade = gradeField.getText();
        history.add("Name: " + name + ", Grade: " + grade);
        updateHistoryArea();
        saveHistory();
    }

    private void updateHistoryArea() {
        StringBuilder sb = new StringBuilder();
        for (String entry : history) {
            sb.append(entry).append("\n");
        }
        historyArea.setText(sb.toString());
    }

    private void saveHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
