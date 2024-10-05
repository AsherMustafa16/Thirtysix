package thirtyhack.hona.pall;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton signUpButton, cancelButton;

    SignUp() {
        setTitle("Sign Up");
        setLocation(400, 270);
        setSize(600, 300);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40, 20, 100, 30);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        usernameLabel.setForeground(Color.WHITE);
        add(usernameLabel);

        // Password Label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);
        add(passwordLabel);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(150, 20, 150, 30);
        usernameField.setBackground(new Color(3, 45, 48));
        usernameField.setForeground(Color.WHITE);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(usernameField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        passwordField.setBackground(new Color(3, 45, 48));
        passwordField.setForeground(Color.WHITE);
        add(passwordField);

        // Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(40, 140, 120, 30);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener(this);
        add(signUpButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 140, 120, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                Von c = new Von();
                String query = "INSERT INTO login (username, password) VALUES ('" + username + "', '" + password + "')";
                c.statement.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Sign Up Successful");
                setVisible(false); 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false); 
        }
    }

    public static void main(String[] args) {
        new SignUp(); // Launch sign-up window
    }
}