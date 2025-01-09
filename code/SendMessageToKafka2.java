package kafka_flink;

import org.apache.kafka.clients.producer.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class SendMessageToKafka2 {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.197.129:9092"); // 虚拟机的 Kafka 地址
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String filePath = "C:\\Users\\xiaoming\\Desktop\\农业大数据实训2024-06\\草莓农业大棚实时数据异常监控\\data2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                ProducerRecord<String, String> record = new ProducerRecord<>("test", null, line);
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("Sent: " + record + " to topic " + metadata.topic());
                        } else {
                            exception.printStackTrace();
                        }
                    }
                });
                Thread.sleep(3000);  //3秒钟发一条数据
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}

