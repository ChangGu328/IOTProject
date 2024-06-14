import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UDPSend {

  private static final String UDP_IP = "127.0.0.1"; // 目标IP地址
  private static final int UDP_PORT = 10000; // 目标端口号
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static void main(String[] args) {
    // Random random = new Random();
    LocalDateTime startDate = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
    LocalDateTime endDate = LocalDateTime.of(2024, 12, 31, 23, 59, 59);

    while (!startDate.isAfter(endDate)) {
      EnvironmentData environmentData = generateEnvironmentData(startDate);
      sendUdpData(environmentData);
      startDate = startDate.plusDays(1);
      try {
        TimeUnit.MILLISECONDS.sleep(1500); // 每次发送间隔500毫秒
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread interrupted.");
      }
    }
  }

  private static EnvironmentData generateEnvironmentData(LocalDateTime recordTime) {
    Random random = new Random();
    double indoorTemperature = Math.round(random.nextDouble(16, 26) * 10) / 10.0; // 室温
    int indoorHumidity = random.nextInt(31) + 40; // 湿度
    int illumination = random.nextInt(801) + 200; // 照明
    int co2Concentration = random.nextInt(401) + 400; // CO2浓度
    int pm25Concentration = random.nextInt(51); // PM2.5浓度
    int pm10Concentration = random.nextInt(51); // PM10浓度
    double formaldehydeLevel = Math.round(random.nextDouble() * 0.1 * 1000) / 1000.0; // 甲醛浓度
    int noiseLevel = random.nextInt(41) + 30; // 噪音

    return new EnvironmentData(
        recordTime.format(formatter),
        indoorTemperature,
        indoorHumidity,
        illumination,
        co2Concentration,
        pm25Concentration,
        pm10Concentration,
        formaldehydeLevel,
        noiseLevel);
  }

  private static void sendUdpData(EnvironmentData data) {
    try (DatagramSocket ds = new DatagramSocket()) {
      String message = data.toJsonString();
      byte[] sendData = message.getBytes(StandardCharsets.UTF_8);
      DatagramPacket dp = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(UDP_IP), UDP_PORT);
      ds.send(dp);
      System.out.println("Sent UDP message: " + message);
    } catch (IOException e) {
      System.err.println("Error sending UDP message: " + e.getMessage());
    }
  }

static class EnvironmentData {
    private final String recordTime;
    private final double indoorTemperature;
    private final int indoorHumidity;
    private final int illumination;
    private final int co2Concentration;
    private final int pm25Concentration;
    private final int pm10Concentration;
    private final double formaldehydeLevel;
    private final int noiseLevel;

    // 完整的构造方法，初始化所有字段
    EnvironmentData(String recordTime, double indoorTemperature, int indoorHumidity, int illumination,
                          int co2Concentration, int pm25Concentration, int pm10Concentration,
                          double formaldehydeLevel, int noiseLevel) {
        this.recordTime = recordTime;
        this.indoorTemperature = indoorTemperature;
        this.indoorHumidity = indoorHumidity;
        this.illumination = illumination;
        this.co2Concentration = co2Concentration;
        this.pm25Concentration = pm25Concentration;
        this.pm10Concentration = pm10Concentration;
        this.formaldehydeLevel = formaldehydeLevel;
        this.noiseLevel = noiseLevel;
    }

    String toJsonString() {
    return "{\"recordTime\":\"" + recordTime + "\","
            + "\"indoorTemperature\":" + indoorTemperature + ","
            + "\"indoorHumidity\":" + indoorHumidity + ","
            + "\"illumination\":" + illumination + ","
            + "\"co2Concentration\":" + co2Concentration + ","
            + "\"pm25Concentration\":" + pm25Concentration + ","
            + "\"pm10Concentration\":" + pm10Concentration + ","
            + "\"formaldehydeLevel\":" + formaldehydeLevel + ","
            + "\"noiseLevel\":" + noiseLevel
            + "}";    }
  }
}