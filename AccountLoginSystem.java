
abstract class Account {
    private String username;
    private String password;


    public Account(String username, String password) {
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


class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Google Account " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Google account credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}


class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Facebook Account " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Facebook account credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}


class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String enteredUser, String enteredPass) {
        try {
            if (enteredUser == null || enteredPass == null) {
                throw new Exception("Credentials cannot be null!");
            }
            if (enteredUser.equals(getUsername()) && enteredPass.equals(getPassword())) {
                System.out.println("Twitter Account " + getUsername() + " logged in successfully.");
            } else {
                throw new Exception("Invalid Twitter account credentials!");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
    }
}


public class AccountLoginSystem {
    public static void main(String[] args) {

        Account google = new GoogleAccount("sita@gmail.com", "google123");
        Account facebook = new FacebookAccount("ram_fb", "fbpass");
        Account twitter = new TwitterAccount("hari_twt", "twtpass");
        Account wrong = new GoogleAccount(null, ""); // Invalid test case


        google.login("sita@gmail.com", "google123");   // success
        facebook.login("ram_fb", "wrongpass");         // invalid password
        twitter.login(null, "twtpass");                // null input
        google.login("wrongUser", "google123");        // invalid username
    }
}

