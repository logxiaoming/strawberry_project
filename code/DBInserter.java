package kafka_flink;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DBInserter {

    public static void synchronousInsert( String id, String date, int value1, int value2, int value3,
                 int value4, int value5, int value6, String status1, String status2, String status3) {

        String url = "jdbc:mysql://94ra779qv012.vicp.fun:30387/myrdb";
        String user = "root";
        String password = "root";

//        date = date.replace("/", "-");


        String query = "INSERT INTO strawberryhouse (largeshelfid,time,airtemperature,airhumidity," +
                "soiltemperature,soilhumidity,co2,lightibtensity,heaterstatus,humidifierstatus,sensorstatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id);
            pstmt.setString(2, date);
            pstmt.setInt(3, value1);
            pstmt.setInt(4, value2);
            pstmt.setInt(5, value3);
            pstmt.setInt(6, value4);
            pstmt.setInt(7, value5);
            pstmt.setInt(8, value6);
            pstmt.setString(9, status1);
            pstmt.setString(10, status2);
            pstmt.setString(11, status3);

            int affectedRows = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("往strawberryhouse表中插入一条数据---------------");

    }


    public static void asynchronousExcetion(String v1, String v2, String v3, String v4){

        String url = "jdbc:mysql://94ra779qv012.vicp.fun:30387/myrdb";
        String user = "root";
        String password = "root";

//        v1 = v1.replace("/", "-");

        String query = "INSERT INTO exception (current_datetime, largeshelfId, exception_info, exception_treasure) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, v1);
            pstmt.setString(2, v2);
            pstmt.setString(3, v3);
            pstmt.setString(4, v4);

            int affectedRows = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("往exception表中插入一条数据---------------");
    }

    public static void synchronousCanal( String id,String data){
        String url = "jdbc:mysql://94ra779qv012.vicp.fun:30387/myrdb";
        String user = "root";
        String password = "root";

        String clearTableQuery = "TRUNCATE TABLE mysql_log";
        String query = "INSERT INTO mysql_log (id,log) VALUES (?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

//            stmt.executeUpdate(clearTableQuery);

            pstmt.setString(1, id);
            pstmt.setString(2, data);
            int affectedRows = pstmt.executeUpdate();
            System.out.println("往mysql_log表中插入一条数据---------------");
//            Thread.sleep(10000);

        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        synchronousInsert("1", "2024/3/1 6:00", 1, 2, 3, 4, 5, 6, "1", "1", "1");
//
//        asynchronousExcetion("2024/3/1 6:00", "1", "2", "3");

        synchronousCanal("1", "hello");


    }
}