import java.io.IOException;

public class Server {

    public void Login(String username, String password, boolean user, boolean admin) throws UserDoesNotExistException{
        if (user) {
            UserServer userServer = new UserServer(username, password);
            if (userServer.accountExists() == false) {
                throw new UserDoesNotExistException("Invalid username or password. Please try again");
            } else {
                System.out.println("Login successful!");
            }
        } else if (admin) {
            AdminServer adminServer = new AdminServer(username, password);
            if (adminServer.accountExists() == false) {
                throw new UserDoesNotExistException("Invalid username or password. Please try again");
            } else {
                System.out.println("Login successful!");
            }
        } else {
            throw new UserDoesNotExistException("Invalid login choice. Please try again");
        }
    }

    public void Register(String username, String password) throws IOException  {
        UserServer userServer = new UserServer(username, password);
        userServer.registerAccount();
    }

}
