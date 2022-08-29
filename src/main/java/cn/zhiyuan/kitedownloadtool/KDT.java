package cn.zhiyuan.kitedownloadtool;

import cn.zhiyuan.kitedownloadtool.selfInspection.SelfInspection;
import cn.zhiyuan.kitedownloadtool.view.Window;

import java.io.IOException;

import static cn.zhiyuan.kitedownloadtool.util.ConfigHandler.readConfig;
import static cn.zhiyuan.kitedownloadtool.util.LoggerHandler.writeInfo;

/**
 * @ClassName : KDT
 * @Author : Zhiyuan
 * @Date: 2022/8/17 15:14
 */
public class KDT extends Thread
{
    @Override
    public void run()
    {
        try
        {
            if(SelfInspection.FileInspection() == true)
            {
                writeInfo("Program starting");
                writeInfo("Check version = " + readConfig("version"));
                new Window().setVisible(true);
                writeInfo("Main window loaded successfully");
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException
    {
        KDT kdt = new KDT();
        kdt.start();
    }
}
