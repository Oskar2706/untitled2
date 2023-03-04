package by.tms.storage;

import by.tms.entity.Operation;

import java.sql.*;

public class JDBCOperationStorage {



    public void save (Operation operation){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "postgres")){


            PreparedStatement preparedStatement = connection.prepareStatement("insert into operations values (default, ?,?,?,?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setDouble(3, operation.getResult());
            preparedStatement.setString(4, operation.getType());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


