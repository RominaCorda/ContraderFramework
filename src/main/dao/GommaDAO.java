package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (G_id, typevehicle ,model, manufacturer, price, width, height, diameter, weight, speed, season) values (null,?,?,?,?,?,?,?,?,?,?)";

    public GommaDAO() {

    }

    public List<String> getAllManufacturerForTypeVehicle(String type){
        List<String> manufacturers= new ArrayList<>();
        Connection connection=ConnectionSingleton.getInstance();
        String query="SELECT DISTINCT manufacturer FROM gomme WHERE typevehicle=\""+type+"\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
            String manufacturer = resultSet.getString("manufacturer");
            manufacturers.add(manufacturer);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    public List<Gomma> getAllGomme () {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int G_id = resultSet.getInt("G_id");
               String typevehicle = resultSet.getString("typevehicle");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed = resultSet.getString("speed");
               String season = resultSet.getString("season");
               gomme.add(new Gomma(G_id,typevehicle,model,manufacturer,price,width,height,diameter,weight,speed,season));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public boolean insertGomma(Gomma gomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString( 1, gomma.getTypevehicle());
            preparedStatement.setString(2, gomma.getModel());
            preparedStatement.setString(3, gomma.getManufacturer());
            preparedStatement.setDouble(4, gomma.getPrice());
            preparedStatement.setDouble(5, gomma.getWidth());
            preparedStatement.setDouble(6, gomma.getHeight());
            preparedStatement.setDouble(7, gomma.getDiameter());
            preparedStatement.setDouble(8, gomma.getWeight());
            preparedStatement.setString(9, gomma.getSpeed());
            preparedStatement.setString(10, gomma.getSeason());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
