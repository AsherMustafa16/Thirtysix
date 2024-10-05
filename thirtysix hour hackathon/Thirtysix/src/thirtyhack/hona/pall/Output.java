package thirtyhack.hona.pall;

import javax.swing.*;
import java.awt.GridLayout;


public class Output extends JFrame {
    public Output(String symptom, String causes, String medication, String precautions) {
        // Create the frame for displaying results
        JFrame frame = new JFrame("Medical Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        
        // Display the fetched data
        frame.add(new JLabel("Symptom: " + symptom));
        frame.add(new JLabel("Causes: " + causes));
        frame.add(new JLabel("Medication: " + medication));
        frame.add(new JLabel("Precautions: " + precautions));

        // Set the frame size and visibility
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
