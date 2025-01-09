package kafka_flink;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SendMessageToKafka1 {
    public static void main(String[] args) throws Exception {
        // 设置执行环境
//        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Kafka 生产者配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.197.129:9092"); // 虚拟机的 Kafka 地址
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        try {
            ProducerRecord<String, String> record;
            // 发送4条消息
            for (int i = 0; i < 4; i++) {
                record = new ProducerRecord<>("test1", null, "Message: " + i);
                // 发送并发忘记
                producer.send(record);
                System.out.println("Sent: " + record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
        System.exit(130);

    }
}