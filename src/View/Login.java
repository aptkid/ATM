package View;

import Model.ConnectionDB;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ActionListener {

    static JPanel loginPanel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField idTextField;
    private JPasswordField passwordField;
    //DB
    private ConnectionDB connectionDB = new ConnectionDB();

    public Login(){
        loginPanel = new JPanel(new GridLayout(15,1));
        idLabel = new JLabel("卡号：");
        idTextField = new JTextField(16);
        passwordLabel = new JLabel("密码：");
        passwordField = new JPasswordField(6);
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(this);
        loginPanel.add(idLabel);
        loginPanel.add(idTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        new BasePanel("欢迎登陆", 800, 1000, true, loginPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "登录"){
            String id = idTextField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if ((id.equals("") || id == null) && (password.equals("") || password == null)){
                return;
            }

            try {
                ResultSet resultSet = connectionDB.query(id, password);
                if (resultSet.next()){
                    User.setId(id);
                    User.setPassword(password);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误","提示", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }


}
