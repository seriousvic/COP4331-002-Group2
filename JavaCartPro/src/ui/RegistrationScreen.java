package JavaCartPro.src.ui;
// a
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import JavaCartPro.src.model.*;

public class RegistrationScreen extends JFrame {
    private static final String USERS_FILE_PATH = "JavaCartPro/src/data/users.dat";

    public RegistrationScreen() {
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
                // Get the entered username and password
                String newUsername = newUsernameField.getText();
                char[] newPasswordChars = newPasswordField.getPassword();
                String newPassword = new String(newPasswordChars);
                
                // Check if username or password is empty
                if (newUsername.isEmpty() || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Please fill in both username and password fields",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the username already exists
                if (usernameExists(newUsername)) {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Username already exists. Please choose a different username",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Determine the selected role
                String selectedRole = customerRadioButton.isSelected() ? "Customer" :
                        sellerRadioButton.isSelected() ? "Seller" : "";

                if (!selectedRole.isEmpty()) {
                    User newUser = new User(newUsername, newPassword, selectedRole);
                    saveUser(newUser);
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Registration successful as a " + selectedRole,
                            "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the registration screen
                } else {
                    JOptionPane.showMessageDialog(RegistrationScreen.this,
                            "Please select a role",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean usernameExists(String username) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE_PATH))) {
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    if (username.equals(user.getUsername())) {
                        return true; // Username exists
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (EOFException eof) {
            // End of file reached, username does not exist
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH, true))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationScreen().setVisible(true));
    }
}
