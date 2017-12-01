package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;
    private  String nomeUtente;
    private String password;

  public GommaView () {
      this.gommaService = new GommaService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
        role = (String) request.get("role");
        nomeUtente = (String) request.get("nomeUtente");
        password = (String) request.get("password");
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Veicolo");
                String typevehicle = getInput();
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Quantità:");
                double quantity = Double.parseDouble(getInput());
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter = Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight = Double.parseDouble(getInput());
                System.out.println("Velocità:");
                String speed = getInput();
                System.out.println("Stagione:");
                String season = getInput();
                gommaService.insertGomma(new Gomma(null, typevehicle, model, manufacturer, quantity,  price, width, height, diameter, weight, speed, season));
                break;
            case "allBrandForVehicle":
                System.out.println("Scegli il tuo veicolo ( auto| moto| commerciale| )");
                String type = getInput();
                List<String> brands = gommaService.getAllManufacturerForTypeVehicle(type);
                System.out.println(" ----Brand disponibili---- ");
                System.out.println();
                brands.forEach(String -> System.out.println(String));
                System.out.println(" Scegli il Brand ");
                String brand = getInput();
                List<Gomma> listaGomma = gommaService.getAllGommeForBrand(type, brand);
                if (listaGomma.isEmpty()) {
                    System.out.println(" ----Brand non disponibile---- ");
                } else {
                    listaGomma.forEach(gomma -> System.out.println(gomma));
                }
                break;
            case "allSizeForVehicle":
                System.out.println("Scegli il tuoi veicolo ( auto| moto| commerciale| )");
                type = getInput();
                Scanner in= new Scanner(System.in);
                System.out.println("Pezzi:  ");
                double quant = in.nextDouble();
                System.out.println("Larghezza:  ");
                in.nextLine();
                double wid = in.nextDouble();
                System.out.println("Altezza:  ");
                in.nextLine();
                double heig = in.nextDouble();
                System.out.println("Diametro:  ");
                in.nextLine();
                double diam = in.nextDouble();
                List<Gomma> listaSize = gommaService.getAllGommeForSize(type, quant, wid, heig, diam);
                listaSize.forEach(gomma -> System.out.println(gomma));
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
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        request.put("role", role);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }



}
