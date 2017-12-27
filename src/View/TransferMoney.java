package View;

import Controller.AccountQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMoney implements ActionListener{

    private JPanel panel;
    private JTextArea textArea;
    private JTextField textField;
    private JButton determine;
    private JButton cancel;


    public TransferMoney() {

        //初始化面板并将布局设置为空
        panel = new JPanel(null);
        textArea = new JTextArea("\n\t                  请输入转账卡号");
        textArea.setFont(new Font("微软雅黑", Font.BOLD, 30));
        textArea.setBounds(0,0,1000,100);
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        textField.setBounds(260,200,500,100);
        determine = new JButton("确定");
        determine.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        determine.setBounds(0,500,300,100);
        determine.addActionListener(this);
        cancel = new JButton("取消");
        cancel.addActionListener(this);
        cancel.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        cancel.setBounds(700,500,300,100);
        //初始化组件
        panel.add(textArea);
        panel.add(textField);
        panel.add(determine);
        panel.add(cancel);
        new BasePanel("转账", 800, 1000, false, panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "确定"){
            if (!AccountQuery.isID(textField.getText())){
                JOptionPane.showMessageDialog(null, "该卡号不存在","用户不存在", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    private void determineAmount(){
        
    }

}
