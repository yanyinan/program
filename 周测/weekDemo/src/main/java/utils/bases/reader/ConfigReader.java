package utils.bases.reader;

import entity.dbutilentity.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取基本数据源 存储在 basicData
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 10:25
 */
public class ConfigReader {
    public static BasicDataSource basicData;
    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        try {// 通过 ClassLoader 获取资源文件的输入流
            ClassLoader classLoader = ConfigReader.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("BasicDataSource.properties");

            if (inputStream != null) {
                Properties properties = new Properties();
                properties.load(inputStream);

                // 读取属性值并赋给静态变量
                basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
                basicDataSource.setUrl(properties.getProperty("url"));
                basicDataSource.setUsername(properties.getProperty("username"));
                basicDataSource.setPassword(properties.getProperty("password"));
                basicData = basicDataSource;

                inputStream.close();
            } else {
                System.err.println("未找到资源: BasicDataSource.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
