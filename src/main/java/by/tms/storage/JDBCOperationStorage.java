package by.tms.storage;

import by.tms.entity.Operation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class JDBCOperationStorage {
public static final String jdbc  = ("jdbc:postgresql://localhost:5432/postgres");


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
    public List<Operation> showAllStory(){
        List<Operation> allStory=new ArrayList<>();

        try (Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "postgres")){
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from operations");
            while (resultSet.next()){
                double num1 = resultSet.getDouble("num1");
                double num2 = resultSet.getDouble("num2");
                double result = resultSet.getDouble("result");
                String type = resultSet.getString("operation_type");
                Operation operation=new Operation(num1,num2,result,type);
                allStory.add(operation);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return new ArrayList<>(allStory);
    }
}


