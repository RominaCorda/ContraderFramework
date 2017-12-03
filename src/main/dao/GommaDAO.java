package main.dao;

import com.sun.org.apache.regexp.internal.RE;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (G_id, typevehicle ,model, manufacturer, quantity, price, width, height, diameter, weight, speed, season) values (null,?,?,?,?,?,?,?,?,?,?,?)";

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

    public List<Gomma> getAllGommeForBrand (String type, String brand) {
        List<Gomma> gommaBrand = new ArrayList<>();
        Connection connection=ConnectionSingleton.getInstance();
        String queryBrand = "SELECT * FROM gomme WHERE typevehicle=\""+type+"\" AND manufacturer =\""+brand+"\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryBrand);
            while (resultSet.next()){
                int G_id = resultSet.getInt("G_id");
                String typevehicle = resultSet.getString("typevehicle");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                gommaBrand.add(new Gomma(G_id,typevehicle,model,manufacturer,quantity,price,width,height,diameter,weight,speed,season));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
         }
        return gommaBrand;

    }




    public int getIdFromGomma (String type, String mod) {
        int G_id= 0;
        Connection connection = ConnectionSingleton.getInstance();
        String queryQuan ="SELECT G_id FROM gomme WHERE  typevehicle=\""+type+"\" AND model=\""+mod+"\"";

            try {
                Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(queryQuan);
                 while (resultSet.next()) {
                     G_id = resultSet.getInt("G_id");
                                      }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return G_id;

        }

    public void updateQuantity (int quant, int id) {
        Connection connection = ConnectionSingleton.getInstance();
        String queryUpdate = "UPDATE gomme SET quantity = \"" + quant + "\"  WHERE G_id=\"" + id + "\"";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);

            final boolean execute = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





   public List<Gomma> getAllGommeForSize(String type, Double wid, Double heig, Double diam){
      List<Gomma> gommaSize = new ArrayList<>();
        Connection connection=ConnectionSingleton.getInstance();
        String querySize="SELECT * FROM gomme WHERE typevehicle=\""+type+"\" AND width =\""+wid+"\" AND height =\""+heig+"\" AND diameter =\""+diam+"\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySize);
            while (resultSet.next()){
                int G_id = resultSet.getInt("G_id");
                String typevehicle = resultSet.getString("typevehicle");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                gommaSize.add(new Gomma(G_id,typevehicle,model,manufacturer,quantity,price,width,height,diameter,weight,speed,season));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
       return gommaSize;
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
               int quantity = resultSet.getInt("quantity");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed = resultSet.getString("speed");
               String season = resultSet.getString("season");
               gomme.add(new Gomma(G_id,typevehicle,model,manufacturer,quantity,price,width,height,diameter,weight,speed,season));
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
            preparedStatement.setInt(4, (int) gomma.getQuantity());
            preparedStatement.setDouble(5, gomma.getPrice());
            preparedStatement.setDouble(6, gomma.getWidth());
            preparedStatement.setDouble(7, gomma.getHeight());
            preparedStatement.setDouble(8, gomma.getDiameter());
            preparedStatement.setDouble(9, gomma.getWeight());
            preparedStatement.setString(10, gomma.getSpeed());
            preparedStatement.setString(11, gomma.getSeason());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
