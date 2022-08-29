package cn.zhiyuan.kitedownloadtool.view;

import cn.zhiyuan.kitedownloadtool.util.ResourcesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @ClassName : Window
 * @Author : Zhiyuan
 * @Date: 2022/8/17 20:55
 */
public class Window extends JFrame
{
    ResourcesManager resourcesManager = new ResourcesManager();
    /**
     * 主窗口
     */
    public Window()
    {
        this.setTitle("Kite Download Tools");
        this.setSize(814, 450);
        this.setLayout(null);
        this.setIconImage(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/icon.png").getImage());
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        Container c = getContentPane();

        JButton addTaskButton = new JButton(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/add_photo.png"));
        addTaskButton.setBounds(20, 60, 240, 135);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setBorderPainted(false);
        addTaskButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddTaskWindow().setVisible(true);
            }
        });
        c.add(addTaskButton);

        JButton listButton = new JButton(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/list_photo.png"));
        listButton.setFocusPainted(false);
        listButton.setBorderPainted(false);
        listButton.setBounds(280, 60, 240, 135);
        listButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ListWindow().setVisible(true);
            }
        });
        c.add(listButton);

        JButton settingsButton = new JButton(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/settings_photo.png"));
        settingsButton.setFocusPainted(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setBounds(540, 60, 240, 135);
        settingsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new SettingsWindow().setVisible(true);
                }
                catch (IOException ex)
                {
                    new ErrorWindow(ex.getMessage(), Window.this);
                }
            }
        });
        c.add(settingsButton);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("文件");
        fileMenu.setFocusPainted(false);
        menuBar.add(fileMenu);

        JMenuItem aboutMenuItem = new JMenuItem("关于");
        aboutMenuItem.setFocusPainted(false);
        aboutMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AboutWindow().setVisible(true);
            }
        });
        fileMenu.add(aboutMenuItem);

        JMenuItem settingsMenuItem = new JMenuItem("设置");
        settingsMenuItem.setFocusPainted(false);
        settingsMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new SettingsWindow().setVisible(true);
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
        fileMenu.add(settingsMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("退出");
        exitMenuItem.setFocusPainted(false);
        exitMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        JMenu downloadMenu = new JMenu("下载");
        downloadMenu.setFocusPainted(false);
        menuBar.add(downloadMenu);

        JMenuItem addTaskMenuItem = new JMenuItem("添加任务");
        addTaskMenuItem.setFocusPainted(false);
        addTaskMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddTaskWindow().setVisible(true);
            }
        });
        downloadMenu.add(addTaskMenuItem);

        JMenuItem listMenuItem = new JMenuItem("下载列表");
        listMenuItem.setFocusPainted(false);
        listMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ListWindow().setVisible(true);
            }
        });
        downloadMenu.add(listMenuItem);
    }
}
