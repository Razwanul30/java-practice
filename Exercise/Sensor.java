class SensorReading {
  String sensorId;
  String location;
  double value;
  String unit;
  String timestamp;

  SensorReading(String sensorId, String location,
      double value, String unit, String timestamp) {
    this.sensorId = sensorId;
    this.location = location;
    this.value = value;
    this.unit = unit;
    this.timestamp = timestamp;
  }

  void display() {
    System.out.println(sensorId + " | " + location +
        " | " + value + unit + " | " + timestamp);
  }
}

public class Sensor {
  public static void main(String[] args) {

    SensorReading[] readings = new SensorReading[4];

    readings[0] = new SensorReading("S1", "RoomA", 25, "C", "10:00");
    readings[1] = new SensorReading("S2", "RoomA", 28, "C", "11:00");
    readings[2] = new SensorReading("S3", "RoomB", 30, "C", "10:30");
    readings[3] = new SensorReading("S4", "RoomB", 27, "C", "11:30");

    double highest = readings[0].value;

    for (SensorReading r : readings) {
      r.display();
      if (r.value > highest)
        highest = r.value;
    }

    System.out.println("Highest Reading: " + highest);

    double roomA = 0, roomB = 0;
    int countA = 0, countB = 0;

    for (SensorReading r : readings) {
      if (r.location.equals("RoomA")) {
        roomA += r.value;
        countA++;
      } else if (r.location.equals("RoomB")) {
        roomB += r.value;
        countB++;
      }
    }

    System.out.println("Average RoomA: " + (roomA / countA));
    System.out.println("Average RoomB: " + (roomB / countB));
  }
}