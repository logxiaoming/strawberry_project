package socket

import org.apache.flink.api.scala.createTypeInformation
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import java.io._
import java.net.Socket
import scala.io.Source
import scala.SensorDataReader
import scala.SendEmail

object DataSender {

  def sendDataToSocket(filePath: String, hostname: String, port: Int): Unit = {
    val source = Source.fromFile(filePath).getLines().toIterator // 移除try语句块

    while (source.hasNext) {
      val line = source.next()
      val socket = new Socket(hostname, port);
      val writer = new PrintWriter(socket.getOutputStream(), true)

      // 发送数据到Socket
      writer.println(line)
      println(s"Sent: $line")

      // 休眠10秒
      Thread.sleep(1000)

    }

  }

  def main(args: Array[String]): Unit = {

    val filePath = "C:\\Users\\xiaoming\\Desktop\\农业大数据实训2024-06\\草莓农业大棚实时数据异常监控\\data\\error_data.txt"
    val hostname = "192.168.197.129"
    val port = 8888
    println("Starting DataSender...")


    sendDataToSocket(filePath, hostname, port)


  }
}
