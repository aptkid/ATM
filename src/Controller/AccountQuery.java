package Controller;

import Model.ConnectionDB;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountQuery {
    //初始化数据库连接
    static ConnectionDB connDB = new ConnectionDB();
    static ResultSet resultSet;

    //查询用户余额是否足够
    public static boolean isBalance(int money){
        float balance = 0;
        resultSet = connDB.query(User.getId(), User.getPassword());
        try {
            if (resultSet.next()){
                balance = resultSet.getFloat("balance");
                if (balance >= money){
                    //如果余额足够，将余额扣除取款额并返回true
                    connDB.update(money, User.getId(), User.getPassword());
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //查询卡号是否存在
    public static boolean isID(String id){
        resultSet = connDB.isExist(id);
        try {
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
