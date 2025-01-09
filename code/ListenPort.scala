package socket

import java.io._
import java.net._

object ListenPort {
  def startListening(port: Int): Unit = {
    val serverSocket = new ServerSocket(port)
    println(s"SensorDataReader is listening on port $port...")

    try {
      while (true) {
        // 等待客户端连接
        val clientSocket = serverSocket.accept()
        println(s"Accepted connection from ${clientSocket.getInetAddress}:${clientSocket.getPort}")

        // 处理客户端连接（这里我们简单地读取数据并打印出来）
        handleClient(clientSocket)

        // 关闭客户端套接字（注意：在实际应用中，你可能希望在其他线程中处理连接，以避免在这里关闭它）
        clientSocket.close()
      }
    } catch {
      case e: IOException =>
        e.printStackTrace()
      // 根据需要处理异常，例如优雅地关闭服务器
    } finally {
      // 关闭服务器套接字
      serverSocket.close()
    }
  }

  def handleClient(clientSocket: Socket): Unit = {
    val in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream))
    try {
      Iterator.continually(in.readLine()).takeWhile(_ != null).foreach(println)
    } catch {
      case e: IOException =>
        e.printStackTrace()
    } finally {
      try {
        in.close()
      } catch {
        case e: IOException =>
          e.printStackTrace()
      }
    }
  }


  def main(args: Array[String]): Unit = {
    startListening(8888)
  }
}
