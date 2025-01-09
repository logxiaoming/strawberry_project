
package kafka_flink

import java.io._
import java.net.Socket

//case class SensorData( id: String,
//                       date: String,
//                       value1: Int,
//                       value2: Int,
//                       value3: Int,
//                       value4: Int,
//                       value5: Int,
//                       value6: Int,
//                       status1: String,
//                       status2: String,
//                       status3: String )


object SensorDataReader {

  def readDataFromPort(host: String, port: Int): Option[SensorData] = {

    try {
      val socket = new Socket(host, port)
      try {

        val inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream))
        val line = inputStream.readLine()
        if (line != null) {
          val parts = line.split("\\s+")
          if (parts.length >= 11) {

//            p001 2024/3/1  10 70 20 76 781 0 正常 正常 正常
//            大棚id 日期 空气温度(℃)	空气湿度(%) 土壤温度(℃)	土壤湿度(%)	二氧化碳浓度(ppm)	光照强度(lux)

            val id = parts(0)
            val date = parts(1)
            val value1 = parts(2).toInt
            val value2 = parts(3).toInt
            val value3 = parts(4).toInt
            val value4 = parts(5).toInt
            val value5 = parts(6).toInt
            val value6 = parts(7).toInt
            val status1 = parts(8)
            val status2 = parts(9)
            val status3 = parts(10)
            Some(SensorData(id, date, value1, value2, value3, value4, value5, value6, status1, status2, status3))
          } else {
            None
          }
        } else {
          None
        }
      } finally {
        socket.close()
      }
    } catch {
      case e: IOException =>
        println(s"Error reading from socket: ${e.getMessage}")
        None
    }
  }

  def judgeData(): Unit = {
    val host = "192.168.197.129" // 或者其他IP地址
    val port = 8888 // 假设nc在这个端口上监听

    while (true) {

      val dataOption = readDataFromPort(host, port)

      dataOption match {
        case Some(data) =>
          println(s"Received data: ${data}")

          if (data.value1 > 40 || data.value1<10) {
            println("空气温度异常！！！！！！！！！")
            SendEmail.sendEmail("空气温度异常警告", data.id+"号大棚当前空气温度为"+data.value1+"℃，建议立即调整空气温度")
          }
          if (data.value2 > 80 || data.value2<30) {
            println("空气湿度异常！！！！！！！！！")
            SendEmail.sendEmail("空气湿度异常警告", data.id+"号大棚当前空气湿度为"+data.value2+"%，建议立即调整空气湿度")
          }
          if (data.value3 > 40 || data.value3<10) {
            println("土壤温度异常！！！！！！！！！")
            SendEmail.sendEmail("土壤温度异常警告", data.id+"号大棚当前土壤温度为"+data.value3+"℃，建议立即调整土壤温度")
          }
          if (data.value4 > 90 || data.value4<40) {
            println("土壤湿度异常！！！！！！！！！")
            SendEmail.sendEmail("土壤湿度异常警告", data.id+"号大棚当前土壤湿度为"+data.value4+"%，建议立即调整土壤湿度")
          }
          if (data.value5 > 1000) {
            println("二氧化碳浓度异常！！！！！！！！！")
            SendEmail.sendEmail("二氧化碳浓度异常警告", data.id+"号大棚当前二氧化碳浓度为"+data.value5+"ppm，建议立即调整CO2浓度")
          }
          if (data.value6 > 50000) {
            println("光照强度异常！！！！！！！！！")
            SendEmail.sendEmail("光照强度异常警告", data.id+"号大棚当前光照强度为"+data.value6+"lux，建议立即调整光照强度")
          }
          if (data.status1 == "异常" ) {
            println("加热器状态异常！！！！！！！！！")
            SendEmail.sendEmail("加热器状态异常警告", data.id+"号大棚当前加热器状态异常，建议立即检查加湿器状态")
          }
          if (data.status2 == "异常" ) {
            println("加湿器状态异常！！！！！！！！！")
            SendEmail.sendEmail("加湿器状态异常警告", data.id+"号大棚当前加湿器状态异常，建议立即检查加热器状态")
          }
          if (data.status3 == "异常" ) {
            println("传感器状态异常！！！！！！！！！")
            SendEmail.sendEmail("传感器状态异常警告", data.id+"号大棚当前传感器状态异常，建议立即检查传感器状态")
          }
          //        else{
          //          println("没有出现异常！佛祖保佑~")
          //        }
          println("--------------------------------------------------------------------")

        case None =>
          println("无法从端口读取数据或数据格式不正确")
      }
    }

  }

  def main(args: Array[String]): Unit = {
    judgeData()

  }
}