package kafka_flink;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import scala.SendEmail;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ReadMessageFromKafka {
    public static void main(String[] args) {
        // 设置Kafka消费者的配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.197.129:9092"); // 替换为你的Kafka集群地址
        props.put("group.id", "test-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        // 创建Kafka消费者实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅test主题
        consumer.subscribe(Collections.singletonList("test"));

        long nums = 0;

        // 持续消费消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

                String[] parts = record.value().split(",");
                if (parts.length != 11) {
                    System.out.println("无法从端口读取数据或数据格式不正确");
                    System.out.println("Invalid data format: " + record.value());
                }
                else{
                    String id = parts[0];
                    String date = parts[1];
                    int value1 = Integer.parseInt(parts[2]);
                    int value2 = Integer.parseInt(parts[3]);
                    int value3 = Integer.parseInt(parts[4]);
                    int value4 = Integer.parseInt(parts[5]);
                    int value5 = Integer.parseInt(parts[6]);
                    int value6 = Integer.parseInt(parts[7]);
                    String status1 = parts[8];
                    String status2 = parts[9];
                    String status3 = parts[10];

                    if (value1 > 40 || value1<10) {
                        System.out.println("空气温度异常！！！！！！！！！");
                        SendEmail.sendEmail("空气温度异常警告", "当地时间"+date+","+id+"号大棚当前空气温度为"+value1+"℃，建议立即调整空气温度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","空气温度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (value2 > 80 || value2<30) {
                        System.out.println("空气湿度异常！！！！！！！！！");
                        SendEmail.sendEmail("空气湿度异常警告", "当地时间"+date+","+id+"号大棚当前空气湿度为"+value2+"%，建议立即调整空气湿度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","空气湿度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (value3 > 40 || value3<10) {
                        System.out.println("土壤温度异常！！！！！！！！！");
                        SendEmail.sendEmail("土壤温度异常警告", "当地时间"+date+","+id+"号大棚当前土壤温度为"+value3+"℃，建议立即调整土壤温度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","土壤温度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (value4 > 90 || value4<40) {
                        System.out.println("土壤湿度异常！！！！！！！！！");
                        SendEmail.sendEmail("土壤湿度异常警告", "当地时间"+date+","+id+"号大棚当前土壤湿度为"+value4+"%，建议立即调整土壤湿度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","土壤湿度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (value5 > 1000) {
                        System.out.println("二氧化碳浓度异常！！！！！！！！！");
                        SendEmail.sendEmail("二氧化碳浓度异常警告", "当地时间"+date+","+id+"号大棚当前二氧化碳浓度为"+value5+"ppm，建议立即调整CO2浓度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","二氧化碳浓度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (value6 > 50000) {
                        System.out.println("光照强度异常！！！！！！！！！");
                        SendEmail.sendEmail("光照强度异常警告", "当地时间"+date+","+id+"号大棚当前光照强度为"+value6+"lux，建议立即调整光照强度");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","光照强度");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (status1 == "异常" ) {
                        System.out.println("加热器状态异常！！！！！！！！！");
                        SendEmail.sendEmail("加热器状态异常警告", "当地时间"+date+","+id+"号大棚当前加热器状态异常，建议立即检查加湿器状态");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","加热器");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (status2 == "异常" ) {
                        System.out.println("加湿器状态异常！！！！！！！！！");
                        SendEmail.sendEmail("加湿器状态异常警告", "当地时间"+date+","+id+"号大棚当前加湿器状态异常，建议立即检查加热器状态");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","加湿器");
                        System.out.println("异常数据已同步到数据库-----------");
                    }
                    if (status3 == "异常" ) {
                        System.out.println("传感器状态异常！！！！！！！！！");
                        SendEmail.sendEmail("传感器状态异常警告", "当地时间"+date+","+id+"号大棚当前传感器状态异常，建议立即检查传感器状态");
                        DBInserter.asynchronousExcetion(date,id,"当地时间"+date+","+id+"号大棚发出现异常，建议及时查看","传感器");
                        System.out.println("异常数据已同步到数据库-----------");
                    }

                    DBInserter.synchronousInsert(id, date, value1, value2, value3, value4, value5, value6, status1, status2, status3);
                    System.out.println("Inserted num " + nums + " row of data.");
                    nums++;
                }

            }
        }
    }
}

