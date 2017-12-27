package View;

import Controller.AccountQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetMoney implements ActionListener{

    //面板
    private JPanel getMoney;
    //取款按钮
    private JButton get300;
    private JButton get500;
    private JButton get1000;
    private JButton get3000;
    private JButton getOther;
    private JButton cancel;
    //输入框
    private JTextField textField;

    public GetMoney(){
        //将布局设置为空
        getMoney = new JPanel(null);
        //初始化按钮
        get300 = new JButton("300");
        get500 = new JButton("500");
        get1000 = new JButton("1000");
        get3000 = new JButton("3000");
        getOther = new JButton("其他金额");
        cancel = new JButton("取消");
        //设置字体
        get300.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        get500.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        get1000.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        get3000.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        getOther.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        cancel.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        //设置位置
        get300.setBounds(0,100,300,100);
        get500.setBounds(700,100,300,100);
        get1000.setBounds(0,300,300,100);
        get3000.setBounds(700,300,300,100);
        getOther.setBounds(0,500,300,100);
        cancel.setBounds(700,500,300,100);
        //添加入panel
        getMoney.add(get300);
        getMoney.add(get500);
        getMoney.add(get1000);
        getMoney.add(get3000);
        getMoney.add(getOther);
        getMoney.add(cancel);
        //设置按钮监听
        get300.addActionListener(this);
        get500.addActionListener(this);
        get1000.addActionListener(this);
        get3000.addActionListener(this);
        getOther.addActionListener(this);
        cancel.addActionListener(this);
        new BasePanel("请选择金额",800,1000,false, getMoney);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "300":
                callback(300);
                break;
            case "500":
                callback(500);
                break;
            case "1000":
                callback(1000);
                break;
            case "3000":
                callback(3000);
                break;
            case "其他金额":
                getOtherMoney();
                break;
            case "取消":
                System.out.println("取消");
                break;
            case "确定":
                int money = Integer.parseInt(textField.getText());
                if (money % 100 != 0){
                    JOptionPane.showMessageDialog(null, "情输入100的倍数","非法数据", JOptionPane.WARNING_MESSAGE);
                }
                callback(money);
                break;
            default:
                return;
        }
    }

    private void callback(int money){
        if (AccountQuery.isBalance(money)){
            Dialog.getMoney(money);
        } else {
            Dialog.getMoney();
        }
    }
    private void getOtherMoney(){
        //将布局置为null
        JPanel panel = new JPanel(null);
        //组件
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        textField.setBounds(350,200,300,100);
        JButton button = new JButton("确定");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        button.setBounds(350,400,300,100);
        button.addActionListener(this);

        panel.add(textField);
        panel.add(button);
        new BasePanel("其他金额",800,1000,false, panel);
    }


}
