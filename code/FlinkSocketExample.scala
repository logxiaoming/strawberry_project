package socket

import org.apache.flink.streaming.api.scala._

object FlinkSocketExample {
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val hostname = "192.168.197.129"
    val port = 8888

    // 从Socket读取数据
    val text = env.socketTextStream(hostname, port)

    text.print()
    val line = text.toString().split("\\s+")
    println("<><><>")

    env.execute("Flink Scala Socket Stream Example")
  }

}
