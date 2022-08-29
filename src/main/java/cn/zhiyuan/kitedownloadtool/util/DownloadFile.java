package cn.zhiyuan.kitedownloadtool.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName : DownloadFile
 * @Author : Zhiyuan
 * @Date: 2022/8/29 15:31
 */
public class DownloadFile
{
    public DownloadFile(String name, String address) throws IOException
    {
        File list = new File("list.txt");
        FileWriter fw = new FileWriter(list, true);
        fw.write(name +address);
    }
}
