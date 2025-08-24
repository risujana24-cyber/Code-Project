
abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        try {
            if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
                throw new Exception("Username or Password cannot be null/empty!");
            }
            this.username = username;
            this.password = password;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.username = "Unknown";
            this.password = "Unknown";
        }
    }

    public String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    public abstract void login(String enteredUser, String enteredPass);
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Admin " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Admin credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}

class Editor extends User {
    public Editor(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Editor " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Editor credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}

class Viewer extends User {
    public Viewer(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Viewer " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Viewer credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}

public class UserLoginSystem {
    public static void main(String[] args) {
        User admin = new Admin("adminUser", "adminPass");
        User editor = new Editor("editUser", "editPass");
        User viewer = new Viewer("viewUser", "viewPass");
        User wrong = new Admin(null, "");
        admin.login("adminUser", "adminPass");
        editor.login("editUser", "wrongPass");
        viewer.login(null, "viewPass");
    }
}
