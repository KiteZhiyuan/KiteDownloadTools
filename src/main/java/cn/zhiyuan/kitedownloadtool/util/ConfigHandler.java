package cn.zhiyuan.kitedownloadtool.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static cn.zhiyuan.kitedownloadtool.util.LoggerHandler.writeErr;

/**
 * @ClassName : ConfigHandler
 * @Author : Zhiyuan
 * @Date: 2022/8/18 12:55
 */
public class ConfigHandler
{
    static Properties properties = new Properties();

    /**
     * 查询键所对应的值
     * @param key 需要查询的键
     * @return 键的值
     * @throws IOException
     */
    public static String readConfig(String key) throws IOException
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("config.ini");
            properties.load(fileInputStream);
            String value = properties.getProperty(key);
            return value;
        }
        catch (FileNotFoundException e)
        {
            writeErr(e.getMessage());
            return null;
        }
    }

    /**
     * 修改键值
     * @param key 需要修改的键
     * @param value 键对应的新值
     * @throws IOException
     */
    public static void writeConfig(String key, String value) throws IOException
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("config.ini");
            properties.load(fileInputStream);
            properties.setProperty(key, value);
        }
        catch (IOException e)
        {
            writeErr(e.getMessage());
        }
    }
}
