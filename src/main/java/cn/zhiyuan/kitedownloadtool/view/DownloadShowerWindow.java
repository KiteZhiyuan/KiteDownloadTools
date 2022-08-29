package cn.zhiyuan.kitedownloadtool.view;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName : DownloadShowerWindow
 * @Author : Zhiyuan
 * @Date: 2022/8/18 9:31
 */
public class DownloadShowerWindow extends JFrame
{
    /**
     * 显示正在下载窗口
     */
    public DownloadShowerWindow()
    {
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(300, 130);
        this.setLocation((int) screenSize.getWidth() - 310, (int) screenSize.getHeight() - 180);
        this.setTitle("正在下载");
    }
}
