package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    static JPanel mainPanel;


    public Main(){

        mainPanel = new JPanel(null);

        JTextArea textArea = new JTextArea("\n\t                  请选择服务类型");
        textArea.setFont(new Font("微软雅黑", Font.BOLD, 30));

        JButton getMoney = new JButton("取款");
        getMoney.setFont(new Font("微软雅黑", Font.PLAIN, 26));

        JButton queryBalance = new JButton("查询余额");
        queryBalance.setFont(new Font("微软雅黑", Font.PLAIN, 26));

        JButton transferMoney = new JButton("转账");
        transferMoney.setFont(new Font("微软雅黑", Font.PLAIN, 26));

        JButton modifyMoney = new JButton("修改密码");
        modifyMoney.setFont(new Font("微软雅黑", Font.PLAIN, 26));


        // 设置组件绝对位置大小
        textArea.setBounds(0, 0, 1000, 100);
        getMoney.setBounds(0, 100, 300, 100);
        queryBalance.setBounds(700, 500, 300, 100);
        transferMoney.setBounds(0, 500, 300, 100);
        modifyMoney.setBounds(700, 100, 300, 100);
        //设置按钮监听
        getMoney.addActionListener(this);
        queryBalance.addActionListener(this);
        transferMoney.addActionListener(this);
        modifyMoney.addActionListener(this);
        //将组件添加进panel
        mainPanel.add(textArea);
        mainPanel.add(getMoney);
        mainPanel.add(queryBalance);
        mainPanel.add(transferMoney);
        mainPanel.add(modifyMoney);

        new BasePanel("请选择", 800, 1000, false, mainPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "取款":
//                mainPanel.setVisible(false);
//                mainPanel.revalidate();
                new GetMoney();
                break;
            case "查询余额":
                break;
            case "转账":
                new TransferMoney();
                break;
            case "修改密码":
                break;
            default:
                return;
        }

    }
}
