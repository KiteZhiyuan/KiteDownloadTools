package cn.zhiyuan.kitedownloadtool.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static cn.zhiyuan.kitedownloadtool.util.DownloadHandler.downloadNet;

/**
 * @ClassName : AddtaskHandler
 * @Author : Zhiyuan
 * @Date: 2022/8/29 15:38
 */
public class AddTaskHandler
{
    public AddTaskHandler(String address) throws IOException
    {
        URL url = new URL(address);
        File list = new File("list.txt");

        String theAddress = String.valueOf(url);
        int a = theAddress.lastIndexOf("/");
        String filename = theAddress.substring(a + 1);

        FileWriter fw = new FileWriter(list, true);
        fw.write(filename + " " + address + "\n");
        fw.close();

        downloadNet(address, filename);
    }
}
