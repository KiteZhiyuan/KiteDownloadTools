package cn.zhiyuan.kitedownloadtool.view;

import cn.zhiyuan.kitedownloadtool.util.ResourcesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static cn.zhiyuan.kitedownloadtool.util.ConfigHandler.readConfig;
import static cn.zhiyuan.kitedownloadtool.util.ConfigHandler.writeConfig;

/**
 * @ClassName : SettingsWindow
 * @Author : Zhiyuan
 * @Date: 2022/8/27 21:00
 */
public class SettingsWindow extends JFrame
{
    ResourcesManager resourcesManager = new ResourcesManager();

    /**
     * 设置窗口
     */
    public SettingsWindow() throws IOException
    {
        this.setTitle("设置");
        this.setSize(400, 170);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/icon.png").getImage());

        Container c = getContentPane();

        JLabel downloadSpeedLabel = new JLabel("下载速度:");
        downloadSpeedLabel.setBounds(0, 10, 70, 25);
        c.add(downloadSpeedLabel);

        String speedText = readConfig("downloadSpeed");
        JTextField downloadSpeedTextField = new JTextField(speedText);
        downloadSpeedTextField.setBounds(75, 10, 270, 25);
        c.add(downloadSpeedTextField);

        JButton saveButton = new JButton("保存");
        saveButton.setBounds(300, 100, 80, 30);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    writeConfig("downloadSpeed", downloadSpeedLabel.getText());
                    dispose();
                }
                catch (IOException ex)
                {
                    new ErrorWindow(ex.getMessage(), SettingsWindow.this);
                }
            }
        });
        c.add(saveButton);
    }
}
