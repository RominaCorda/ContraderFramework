package main.controller;

import main.MainDispatcher;

public class GommaController implements Controller {



    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        String role = (String) request.get("role");

        switch (role) {
            case "User":

                switch (choice) {
                    case 1:
                        request.put("mode", "all");
                        break;
                    case 2:
                        request.put("mode", "allBrandForVehicle");
                        break;
                }
                MainDispatcher.getInstance().callView("Gomma", request);
                break;

            case "Admin":
                switch (choice) {
                    case 1:
                        request.put("mode", "insert");
                        break;
                    case 2:
                        request.put("mode", "all");
                        break;
                    case 3:
                        request.put("mode", "allBrandForVehicle");
                        break;
                }

            MainDispatcher.getInstance().callView("Gomma", request);

        }
    }
}
