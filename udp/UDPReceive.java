import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UDPReceive {

  public static void main(String[] args) {
    try {
      System.out.println("Receive Start......");

      // 建立 UDP 的 Socket 服务
      DatagramSocket ds = new DatagramSocket(10000);

      while (true) {
        // 数据包准备
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 接收数据
        ds.receive(dp);

        // 解析数据包
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String text = new String(dp.getData(), 0, dp.getLength(), StandardCharsets.UTF_8);

        System.out.printf("[%s]:[%d] %s%n", ip, port, text);
        // 发送POST请求到指定地址
        postDataToServer("http://localhost/system/data/add", text);
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      // 关闭 DatagramSocket（如果需要）
      // ds.close();
    }
  }


    public static String jsonToQueryString(String jsonString) {
      jsonString = jsonString.substring(1, jsonString.length() - 1);
        jsonString = jsonString.replace("\"", ""); // 移除双引号
        jsonString = jsonString.replace(":", "="); // 将冒号替换为等号
        jsonString = jsonString.replace(",", "&"); // 将逗号替换为&符号

        return jsonString;
    }
private static void postDataToServer(String baseUrl, String jsonData) {

    String queryData = jsonToQueryString(jsonData);

    try {

        String fullUrl = baseUrl + "?" + queryData;
        URL url = new URL(fullUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
        }

        int code = conn.getResponseCode();
        System.out.println("POST RES: " + code);

        if (code >= 200 && code < 300) {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println("SUCCESS RES: " + content.toString());
            }
        } else {
            System.err.println("POST ERROR CODE: " + code);
        }
    } catch (Exception e) {
        System.err.println("POST ERROR MESSAGE: " + e.getMessage());
    }
}
}