package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.service.UserService;
import org.springframework.expression.spel.ast.NullLiteral;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private UserService userService;
    private String mode;
    private String role;
    private String username;
    private String password;


    public UserView() {
        this.userService = new UserService();
        this.mode = "insert";
    }


    @Override
    public void showResults(Request request) {
        this.mode=(String)request.get("mode");
        role = (String)request.get("role");
        username = (String) request.get("nomeUtente");
        password = (String) request.get("password");

    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i tuoi dati:");
                System.out.println("Username");
                String username = getInput();
                System.out.println("Password");
                String password = getInput();
                System.out.println("Nome:");
                String firstname = getInput();
                System.out.println("Cognome:");
                String lastname = getInput();
                System.out.println("Data di nascita:");
                String dateofbirth = getInput();
                System.out.println("Codice Fiscale:");
                String CF = getInput();
                System.out.println("Ragione Sociale:");
                String businessname = getInput();
                System.out.println("Partita IVA:");
                String vat = getInput();
                System.out.println("Comune:");
                String town = getInput();
                System.out.println("CAP:");
                String CAP = getInput();
                System.out.println("Provincia:");
                String city = getInput();
                System.out.println("Indirizzo:");
                String address = getInput();
                System.out.println("Telefono:");
                String telephone = getInput();
                userService.insertUser(new User(null, username, password, firstname, lastname, dateofbirth, CF, businessname, vat, town, CAP, city, address, telephone, ""));

                break;

            case "viewUser":
                List<User> users = userService.getAlluser();
                System.out.println("-----Lista utenti registrati-----");
                System.out.println();
                users.forEach(user->System.out.println(users));

                break;

        }

    }

    @Override
    public String getInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        request.put("nomeUtente", username);
        request.put("password", password);
        MainDispatcher.getInstance().callAction("Login", "doControl",null);

    }
}

