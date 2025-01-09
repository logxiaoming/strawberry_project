package kafka_flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import java.util.Properties;

public class KafkaFlinkExample2 {
    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.197.129:9092");
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(
                "test1", new SimpleStringSchema(), properties);
        DataStream<String> stream = env.addSource(consumer);
        stream.print();
        env.execute("Flink Kafka Integration");
    }
}
