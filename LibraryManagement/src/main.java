import java.io.IOException;
import java.util.Scanner;

public class main {
    static Scanner input = new Scanner(System.in);

    static boolean admin = false;
    static boolean user = false;

    static Server server = new Server();

    public static void main(String[] args) throws UserDoesNotExistException, IOException {
        start();
    }

    private static void AdminLogin() throws UserDoesNotExistException, IOException {
        admin = true;
        System.out.println("----- Admin Login");
         System.out.println("1. Login");
        System.out.println("2. Return");

        System.out.print("Enter your choice of Login: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 2) {
            System.out.print("Invalid choice. Enter your choice of Login: ");
            choice = input.nextInt();
        }

        input.nextLine();

        switch (choice) {
            case 1 -> Login();
            case 2 -> start();
        }
    }

    private static void UserLogin() throws UserDoesNotExistException, IOException {
        user = true;
        System.out.println("----- User Login");
        
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Return");

        System.out.print("Enter your choice of Login: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print("Invalid choice. Enter your choice of Login: ");
            choice = input.nextInt();
        }

        input.nextLine();

        switch (choice) {
            case 1 -> Login();
            case 2 -> Register();
            case 3 -> start();
        }
    }

    private static void start() throws UserDoesNotExistException, IOException {
        user = false;
        admin = false;
        System.out.println("----- Library Login");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.println("3. Exit");

        System.out.print("Enter your choice of Login: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print("Invalid choice. Enter your choice of Login: ");
            choice = input.nextInt();
        }

        switch (choice) {
            case 1 -> UserLogin();
            case 2 -> AdminLogin();
        }
    }

    private static void Login() throws UserDoesNotExistException, IOException {
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        try {
            server.Login(username, password, user, admin);
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private static void Register() throws IOException {
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        server.Register(username, password);
    }
}
