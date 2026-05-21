import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class UserServer {

    String server = "src/Users.txt";
    String tmpServer = "RecentLogins.txt";

    String username;
    String password;

    public UserServer(String username, String password)  {
        this.username = username;
        this.password = password;
    }

    public boolean accountExists() {
        //check if the account exists in users.txt

        String id = username + "," + password;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(server));
            String line = reader.readLine();
            while (line != null) {
                if (line.equals(id)) {
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {

        }
        return false;
    }

    public void registerAccount() throws IOException {
        //register the account in users.txt
        String id = username + "," + password;
    

        if (accountExists() == false) {
            FileWriter writer = new FileWriter(server, true);
            writer.write(id + "\n");
            writer.close();
        } else {
            System.out.println("Account already exists");
        }
    }


    
}
