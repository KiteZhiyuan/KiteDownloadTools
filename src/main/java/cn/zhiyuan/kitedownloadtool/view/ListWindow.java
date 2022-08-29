package cn.zhiyuan.kitedownloadtool.view;

import cn.zhiyuan.kitedownloadtool.util.DownloadFile;
import cn.zhiyuan.kitedownloadtool.util.ResourcesManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : ListWindow
 * @Author : Zhiyuan
 * @Date: 2022/8/27 21:09
 */
public class ListWindow extends JFrame
{
    ResourcesManager resourcesManager = new ResourcesManager();

    /**
     * 下载列表
     */
    public ListWindow()
    {
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("下载列表");
        this.setSize(600, 300);
        this.setIconImage(resourcesManager.getImageIcon("/assets/kitedownloadtools/resources/icon.png").getImage());
    }
}
