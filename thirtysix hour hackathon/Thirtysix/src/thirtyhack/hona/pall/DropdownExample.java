package thirtyhack.hona.pall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DropdownExample extends JFrame implements ActionListener {
    JComboBox<String> dropdown;
    JButton searchButton;
    
    public DropdownExample() {
        // Create the frame
        JFrame frame = new JFrame("Dropdown Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.black);
        frame.setLocation(300, 80);

        // Create a dropdown (combo box)
        String[] options = {"Select...", "headache", "Cough", "Cold", "fever"};
        dropdown = new JComboBox<>(options);

        // Create a search button
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        // Add the dropdown and button to the frame
        frame.add(dropdown);
        frame.add(searchButton);

        // Set the frame size and visibility
        frame.setSize(1500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            // Get the selected symptom from the dropdown
            String selectedSymptom = (String) dropdown.getSelectedItem();
            if (!selectedSymptom.equals("Select...")) {
                fetchAndDisplayResults(selectedSymptom);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a symptom.");
            }
        }
    }

    // Fetch data from the database based on the selected symptom
    private void fetchAndDisplayResults(String symptom) {
        try {
            Von c = new Von();
            String query = "SELECT causes, medication, precautions FROM symptoms WHERE symptom = '" + symptom + "'";

            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                String causes = resultSet.getString("causes");
                String medication = resultSet.getString("medication");
                String precautions = resultSet.getString("precautions");

                // Forward the results to the Output class
                new Output(symptom, causes, medication, precautions);
            } else {
                JOptionPane.showMessageDialog(null, "No data found for the selected symptom.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DropdownExample();
    }
}
