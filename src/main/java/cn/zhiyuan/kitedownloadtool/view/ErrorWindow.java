package cn.zhiyuan.kitedownloadtool.view;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName : ErrorWindow
 * @Author : Zhiyuan
 * @Date: 2022/8/26 23:23
 */
public class ErrorWindow
{
    public ErrorWindow(String errorText, JFrame jFrame)
    {
        JDialog errorWindow = new JDialog(jFrame, "错误 : " + errorText, true );
        errorWindow.setSize(300, 125);
        errorWindow.setLocationRelativeTo(null);
        errorWindow.setLayout(null);

        Container c = errorWindow.getContentPane();

        JLabel text = new JLabel("错误: " + errorText);
        text.setBounds(30, 25, 250, 30);
        c.add(text);

        errorWindow.setVisible(true);
    }
}
