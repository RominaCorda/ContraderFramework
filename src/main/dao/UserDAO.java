package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}