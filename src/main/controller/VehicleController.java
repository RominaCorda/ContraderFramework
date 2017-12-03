package main.controller;

import main.MainDispatcher;

public class VehicleController implements Controller {
    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        String role = (String) request.get("role");

        switch (choice){
            case 7:
                request.put("mode", "insert");
                break;
            case 6:
                request.put("mode", "all");
                break;
        }
        MainDispatcher.getInstance().callView("Vehicle", request);
    }
}
