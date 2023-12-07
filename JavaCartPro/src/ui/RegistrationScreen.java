package JavaCartPro.src.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import JavaCartPro.src.model.*;

/**
 * The class representing the registration screen for the JavaCartPro application
 * This class allows users to register by providing a new username, password, and role
 */
public class RegistrationScreen extends JFrame {
//    private static final String USERS_FILE_PATH = "JavaCartPro/src/data/users.dat";
    AppData appData;

    /**
     * Constructs a new instance of the RegistrationScreen
     * Sets up the user interface components and event listeners
     */
    public RegistrationScreen(AppData appData) {
        this.appData = appData;
        setTitle("Registration");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel registerLabel = new JLabel("Registration Screen");
        JLabel newUsernameLabel = new JLabel("New Username:");
        JLabel newPasswordLabel = new JLabel("New Password:");
        JLabel roleLabel = new JLabel("Role:");
        JTextField newUsernameField = new JTextField(20);
        JPasswordField newPasswordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");

        JRadioButton customerRadioButton = new JRadioButton("Customer");
        JRadioButton sellerRadioButton = new JRadioButton("Seller");

        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(customerRadioButton);
        roleGroup.add(sellerRadioButton);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(registerLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(newUsernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(newUsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(newPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(roleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(customerRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(sellerRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUsernameField.getText();
                char[] newPasswordChars = newPasswordField.getPassword();
                String newPassword = new String(newPasswordChars);

                if (newUsername.isEmpty() || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Please fill in both username and password fields",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (usernameExists(newUsername)) {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Username already exists. Please choose a different username",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String selectedRole = customerRadioButton.isSelected() ? "Customer" :
                        sellerRadioButton.isSelected() ? "Seller" : "";

                if (!selectedRole.isEmpty()) {
                    User newUser;
                    if (customerRadioButton.isSelected()) {
                        newUser = new Customer(newUsername, newPassword);
                    } else if (sellerRadioButton.isSelected()) {
                        newUser = new Seller(newUsername, newPassword);
                    } else {
                        JOptionPane.showMessageDialog(RegistrationScreen.this,
                                "Please select a role",
                                "Registration Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    appData.addUser(newUser);
                    DataManager.saveData(appData);
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Registration successful as a " + selectedRole,
                            "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Please select a role",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Checks if a username already exists in the user data file
     * @param username The username to check for existence
     * @return True if the username exists, false otherwise
     */
    private boolean usernameExists(String username) {
        for (User user : appData.getUsers()) {
            if (username.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves a new user to the user data file
     * @param user The user to be saved
     */
//    private void saveUser(User user) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH, true))) {
//            oos.writeObject(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * The main method to launch the RegistrationScreen
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppData appData = DataManager.loadData();
            new RegistrationScreen(appData).setVisible(true);
        });
    }
}
