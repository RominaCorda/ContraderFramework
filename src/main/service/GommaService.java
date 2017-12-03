package main.service;

import main.dao.GommaDAO;
import main.model.Gomma;

import java.util.List;

public class GommaService {

    private GommaDAO gommaDAO;

    public GommaService() {
        this.gommaDAO = new GommaDAO();
    }

    public List<Gomma> getAllGomme () {
        return this.gommaDAO.getAllGomme();
    }

    public boolean insertGomma (Gomma gomma) {
        return this.gommaDAO.insertGomma(gomma);
    }
    public List<String> getAllManufacturerForTypeVehicle(String type) {return this.gommaDAO.getAllManufacturerForTypeVehicle(type);}
    public List<Gomma> getAllGommeForBrand (String type, String brand) {return this.gommaDAO.getAllGommeForBrand(type,brand);}
    public List<Gomma> getAllGommeForSize(String type, Double wid, Double heig, Double diam) {return this.gommaDAO.getAllGommeForSize(type, wid, heig, diam);}
    public int getIdFromGomma(String type, String mod) {return  this.gommaDAO.getIdFromGomma(type, mod);}
    public void updateQuantity(int quant, int id) {gommaDAO.updateQuantity(quant, id);}
}


