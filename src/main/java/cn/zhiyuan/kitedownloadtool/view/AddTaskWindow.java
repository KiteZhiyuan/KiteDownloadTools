package cn.zhiyuan.kitedownloadtool.view;

import cn.zhiyuan.kitedownloadtool.util.AddTaskHandler;
import cn.zhiyuan.kitedownloadtool.util.ResourcesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @ClassName : AddTaskWindow
 * @Author : Zhiyuan
 * @Date: 2022/8/18 16:40
 */
public class AddTaskWindow extends JFrame implements Runnable
{
    JTextField address;
    ResourcesManager resourcesManager = new ResourcesManager();

    /**
     * 下载窗口
     */
    public AddTaskWindow()
    {
        Thread t= new Thread(this);
        t.start();
    }

    @Override
    public void run()
    {
        this.setIconImage(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/icon.png").getImage());
        this.setSize(566, 121);
        this.setTitle("添加任务");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        Container c = getContentPane();

        address = new JTextField("");
        address.setBounds(70, 15, 400, 25);
        c.add(address);

        JLabel theAddress = new JLabel("地址:");
        theAddress.setBounds(16, 18, 30, 16);
        c.add(theAddress);

        JButton sure = new JButton("确定");
        sure.setBorderPainted(false);
        sure.setFocusPainted(false);
        sure.setBounds(480, 15, 65, 24);
        sure.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new AddTaskHandler(address.getText());
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
        c.add(sure);

        JButton cancel = new JButton("取消");
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setBounds(480, 49, 65, 24);
        cancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        c.add(cancel);

        repaint();
    }
}
