package JavaCartPro.src.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JavaCartPro.src.model.*;

/**
 * The main class for the JavaCartPro shopping application
 * This class extends JFrame and provides the user interface for
 * user login and registration
 */
public class ShoppingCartApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private AppData appData;

    /**
     * Constructs a new instance of ShoppingCartApp
     * Sets up the user interface components and event listeners
     */
    public ShoppingCartApp() {
        appData = DataManager.loadData();
        setTitle("JavaCartPro");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel bannerLabel = new JLabel("Welcome to JavaCartPro!");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adding components to the layout

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(bannerLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(usernameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passwordLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(registerButton, gbc);

        // Event listeners for buttons

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration screen
                new RegistrationScreen().setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(ShoppingCartApp.this, "Please fill in both username and password fields",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User user = login(username, new String(password));
                    if (user != null){
                        JOptionPane.showMessageDialog(ShoppingCartApp.this, "Login successful");
                        new DashboardView(appData, user).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(ShoppingCartApp.this, "Invalid username or password",
                                "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private User login(String username, String password) {
        for (User user : appData.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * The main method to launch the ShoppingCartApp
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingCartApp().setVisible(true);
            }
        });
    }
}
