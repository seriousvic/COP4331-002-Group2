import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationScreen extends JFrame {
    public RegistrationScreen() {
        setTitle("Registration");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel registerLabel = new JLabel("Registration Screen");
        JLabel newUsernameLabel = new JLabel("New Username:");
        JLabel newPasswordLabel = new JLabel("New Password:");
        JTextField newUsernameField = new JTextField(20);
        JPasswordField newPasswordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");

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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RegistrationScreen.this, "Registration successful!");
                dispose();
            }
        });
    }
}
