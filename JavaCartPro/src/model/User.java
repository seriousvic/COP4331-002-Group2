package JavaCartPro.src.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * class representing a user
 */
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 8851151635568048702L;

    private String username;
    private String password;
    private String role;

    /**
     * constructor
     * @param username user's username
     * @param password user's password
     * @param role user's role
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * get function for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * get function for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * get function for role
     * @return role
     */
    public String getRole() {
        return role;
    }
}
