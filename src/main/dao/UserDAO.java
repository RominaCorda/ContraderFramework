package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final String QUERY_INSERT = "insert into users (U_id, username, password, firstname, lastname, dateofbirth, CF, businessname, vat, town, CAP, city, address, telephone, role) values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public UserDAO() {

    }



    public boolean insertUser(User user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getDateofbirth());
            preparedStatement.setString(6, user.getCF());
            preparedStatement.setString(7, user.getBusinessname());
            preparedStatement.setString(8, user.getVat());
            preparedStatement.setString(9, user.getTown());
            preparedStatement.setString(10, user.getCAP());
            preparedStatement.setString(11, user.getCity());
            preparedStatement.setString(12, user.getAddress());
            preparedStatement.setString(13, user.getTelephone());
            preparedStatement.setString(14, "User");

            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public List<User> getAlluser(){
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String var = "User";
        String query_user = "SELECT * from users WHERE role = \""+var+"\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_user);
            while (resultSet.next()){
                int U_id = resultSet.getInt("U_id");
                String username = resultSet.getString("username");
                String password = "*******";
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String dateofbirth = resultSet.getString("dateofbirth");
                String CF = resultSet.getString("CF");
                String businessname = resultSet.getString("businessname");
                String vat = "*******";
                String town = resultSet.getString("town");
                String CAP = resultSet.getString("CAP");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String role = resultSet.getString("role");
                users.add(new User(U_id, username, password, firstname, lastname, dateofbirth, CF, businessname, vat, town, CAP, city, address, telephone, role));

            }



        } catch (SQLException e) {
            e.printStackTrace();
        } return users;

    }
}