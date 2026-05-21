import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminServer {

    String server = "src/Admins.txt";
    String username;
    String password;

    public AdminServer(String username, String password)  {
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
                System.out.println(line);
                if (line.equals(id)) {
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
