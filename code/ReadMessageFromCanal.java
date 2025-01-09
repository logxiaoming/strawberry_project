package kafka_flink;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import scala.SendEmail;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static java.lang.System.exit;


public class ReadMessageFromCanal {

    public static void main(String[] args) throws Exception {

        // 设置Kafka消费者的配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.197.129:9092"); // 替换为你的Kafka集群地址
        props.put("group.id", "test-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        // 创建Kafka消费者实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅example主题
        consumer.subscribe(Collections.singletonList("example"));

        long nums = 0;

        // 持续消费消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {

                String data = record.value();
                System.out.println("id:"+nums+" log:"+data);
                DBInserter.synchronousCanal(String.valueOf(nums), data);
                nums++;

                if (nums > 100) {
//                    MysqlToHdfs.writeToHDFS();
                    System.out.println("日志数据已持久化到HDFS-----------------------------------------");
                }

            }

        }


    }
}

