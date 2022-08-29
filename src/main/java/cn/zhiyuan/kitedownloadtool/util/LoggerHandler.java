package cn.zhiyuan.kitedownloadtool.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.zhiyuan.kitedownloadtool.util.ConfigHandler.readConfig;

/**
 * @ClassName : LoggerHandler
 * @Author : Zhiyuan
 * @Date: 2022/8/17 15:15
 */
public class LoggerHandler
{
    private final static String INFO = "[INFO]";
    private final static String ERROR = "[ERROR]";
    private final static String WARN = "[WARN]";
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    static FileWriter fw;
    static File log;

    static
    {
        try
        {
            log = new File(readConfig("logFile"));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 记录信息
     * @param info 需要记录的信息
     * @throws IOException
     */
    public static void writeInfo(String info) throws IOException
    {
        Date date = new Date();
        fw = new FileWriter(log, true);
        String time = "[" + sdf.format(date) + "]";
        String output = time + INFO + info;
        System.out.println(output);
        fw.write(output + "\n");
        fw.close();
    }

    /**
     * 记录错误
     * @param error 需要记录的错误
     * @throws IOException
     */
    public static void writeErr(String error) throws IOException
    {
        Date date = new Date();
        fw = new FileWriter(log, true);
        String time = "[" + sdf.format(date) + "]";
        String output = time + ERROR + error;
        System.out.println(output);
        fw.write(output + "\n");
        fw.close();
    }

    /**
     * 记录警告
     * @param warning 需要记录的警告
     * @throws IOException
     */
    public static void writeWarn(String warning) throws IOException
    {
        Date date = new Date();
        fw = new FileWriter(log, true);
        String time = "[" + sdf.format(date) + "]";
        String output = time + WARN + warning;
        System.out.println(output + "\n");
        fw.write(output);
        fw.close();
    }
}
