package View;

import javax.swing.*;

public class Dialog {

    public static void getMoney(int money){
        JOptionPane.showMessageDialog(null, "已出钞"+money+"元，请清点","取款成功", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void getMoney(){
        JOptionPane.showMessageDialog(null, "余额不足","取款失败", JOptionPane.WARNING_MESSAGE);
    }


}
