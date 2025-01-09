package kafka_flink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.sql.*;

public class MysqlToHdfs {

    public static  void writeToHDFS() throws Exception {
        // 1. 加载MySQL驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 连接到MySQL数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://94ra779qv012.vicp.fun:30387/myrdb", "root", "root");
        Statement statement = connection.createStatement();

        // 3. 查询数据
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mysql_log");

        // 4. 将数据写入CSV文件
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"));
        while (resultSet.next()) {
            // 根据你的表结构获取列数据
            String column1 = resultSet.getString("id");
            String column2 = resultSet.getString("log");
            // ...
            writer.write(column1 + "," + column2 + "\n");
        }
        writer.close();

        // 5. 关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();

        System.out.println("开始将日志文件持久化到hdfs-----------------------------------");
        // 6. 将CSV文件上传到HDFS
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.197.129:9000");
        FileSystem fs = FileSystem.get(conf);
        Path localPath = new Path("data.csv");
        Path hdfsPath = new Path("/data/logs/data.csv");
        fs.copyFromLocalFile(localPath, hdfsPath);
        fs.close();
    }

    public static void main(String[] args) throws Exception {
        writeToHDFS();

    }
}
