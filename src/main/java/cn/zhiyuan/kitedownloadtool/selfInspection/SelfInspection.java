package cn.zhiyuan.kitedownloadtool.selfInspection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName : SelfInspection
 * @Author : Zhiyuan
 * @Date: 2022/8/21 9:13
 */
public class SelfInspection
{
    static File config = new File("config.ini");
    static File log = new File("log.txt");
    static File downloadPath = new File("download");
    static File list = new File("list.txt");
    public static boolean FileInspection() throws IOException
    {
        if(!config.exists())
        {
            config.createNewFile();
            FileWriter fw = new FileWriter(config, true);
            fw.write("version=Test\n");
            fw.write("logFile=log.txt\n");
            fw.write("downloadFilePath=./download/\n");
            fw.write("downloadSpeed=1024*1024\n");
            fw.close();
        }
        if(!log.exists())
        {
            log.createNewFile();
        }
        if(!downloadPath.exists())
        {
            downloadPath.mkdir();
        }
        if(!list.exists())
        {
            list.createNewFile();
        }
        return true;
    }
}
