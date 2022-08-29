package cn.zhiyuan.kitedownloadtool.util;

import javax.swing.*;

/**
 * @ClassName : ReourcesManager
 * @Author : Zhiyuan
 * @Date: 2022/8/28 22:22
 */
public class ResourcesManager
{
    /**
     * 获取图片
     * @param path 图片路径,需要加/
     * @return ImageIcon类型
     */
    public static ImageIcon getImageIcon(String path)
    {
        ImageIcon imageIcon = new ImageIcon(ResourcesManager.class.getResource(path));
        return imageIcon;
    }
}
