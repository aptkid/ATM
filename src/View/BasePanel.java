package View;

import javax.swing.*;

public class BasePanel extends JFrame{

    //参数
    private String title;
    private int height;
    private int width;
    private int EXIT_ON_CLOSE = 3;
    public BasePanel(String title, int height, int width,boolean EXIT_ON_CLOSE, JPanel panel) {
        setValue(title);
        this.add(panel);
        this.setTitle(title);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        if (EXIT_ON_CLOSE){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        this.setVisible(true);
    }

    private void setValue(String title){
        if (title == null){
            this.title = "";
        }
    }


}
