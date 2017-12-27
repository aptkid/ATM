package Model;

import java.sql.*;

public class ConnectionDB extends Config{

    Connection connection = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    String databasePoint = "jdbc:mysql://"+ address +":"+ port +"/"+ databaseName +"?"+ "user="+ user +"&password="+ password +"&useUnicode="+ unicode +"&characterEncoding="+ encoding;

    public ConnectionDB() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(databasePoint);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }

    public void getUserCount() {
        String sql = "SELECT * FROM user";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            } else {
                System.out.println("无结果");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("请检查数据库或SQL语句");
        }

    }

    public ResultSet query(String id, String password){

        String sql = "SELECT * FROM users WHERE id = ? and password = ?";
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    public ResultSet update(int money, String id, String password){

        String sql = "UPDATE users SET balance = balance - ? WHERE id = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, money);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet isExist(String id){

        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            return preparedStatement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
