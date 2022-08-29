package cn.zhiyuan.kitedownloadtool.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static cn.zhiyuan.kitedownloadtool.util.ConfigHandler.readConfig;
import static cn.zhiyuan.kitedownloadtool.util.LoggerHandler.writeErr;

/**
 * @ClassName : DownloadHandler
 * @Author : Zhiyuan
 * @Date: 2022/8/21 23:03
 */
public class DownloadHandler
{
    /**
     * 从网络上下载文件
     * @param address 文件网络地址
     */
    public static void downloadNet(String address, String filename) throws IOException
    {
        int byteRead = 0;
        URL url = new URL(address);

        try
        {
            String path = readConfig("downloadFilePath");
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(path + filename);

            byte[] buffer = new byte[1024*1024];
            while ((byteRead = inStream.read(buffer)) != -1)
            {
                fs.write(buffer, 0, byteRead);
            }
        }
        catch (FileNotFoundException e)
        {
            writeErr("A exception has happened : " + e.getMessage());
        }
        catch (IOException e)
        {
            writeErr("A exception has happened : " + e.getMessage());
        }
    }
}
