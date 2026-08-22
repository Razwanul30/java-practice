enum SensorType {

    TEMPERATURE("°C"),
    HUMIDITY("%"),
    LIGHT("Lux");

    private final String unit;

    SensorType(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}

enum Room {
    ROOMA,
    ROOMB
}

class SensorReading {

    String sensorId;
    SensorType sensorType;
    Room room;
    double value;

    SensorReading(String sensorId,
                  SensorType sensorType,
                  Room room,
                  double value) {

        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.room = room;
        this.value = value;
    }
}

class Stats {

    double sum = 0;
    int count = 0;
    double highest = Double.MIN_VALUE;
    String highestSensor = "";

    void add(SensorReading r) {
        sum += r.value;
        count++;

        if (r.value > highest) {
            highest = r.value;
            highestSensor = r.sensorId;
        }
    }

    double getAverage() {
        return sum / count;
    }
}

public class SensorSystem {

    public static void main(String[] args) {

        SensorReading[] readings = {

            // ROOMA
            new SensorReading("S1", SensorType.TEMPERATURE, Room.ROOMA, 25),
            new SensorReading("S2", SensorType.TEMPERATURE, Room.ROOMA, 27),

            new SensorReading("S3", SensorType.HUMIDITY, Room.ROOMA, 60),
            new SensorReading("S4", SensorType.HUMIDITY, Room.ROOMA, 65),

            new SensorReading("S5", SensorType.LIGHT, Room.ROOMA, 300),
            new SensorReading("S6", SensorType.LIGHT, Room.ROOMA, 320),

            // ROOMB
            new SensorReading("S7", SensorType.TEMPERATURE, Room.ROOMB, 28),
            new SensorReading("S8", SensorType.TEMPERATURE, Room.ROOMB, 30),

            new SensorReading("S9", SensorType.HUMIDITY, Room.ROOMB, 55),
            new SensorReading("S10", SensorType.HUMIDITY, Room.ROOMB, 58),

            new SensorReading("S11", SensorType.LIGHT, Room.ROOMB, 350),
            new SensorReading("S12", SensorType.LIGHT, Room.ROOMB, 370)
        };

        // 2D Stats Array
        Stats[][] stats =
                new Stats[Room.values().length][SensorType.values().length];

        // Initialize
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[i].length; j++) {
                stats[i][j] = new Stats();
            }
        }

        // Single Pass Aggregation
        for (SensorReading r : readings) {
            int roomIndex = r.room.ordinal();
            int typeIndex = r.sensorType.ordinal();
            stats[roomIndex][typeIndex].add(r);
        }

        // Print Room Wise Same Unit Average
        System.out.println("===== ROOM + SAME UNIT REPORT =====");

        for (Room room : Room.values()) {

            System.out.println("\nRoom: " + room);

            for (SensorType type : SensorType.values()) {

                Stats s = stats[room.ordinal()][type.ordinal()];

                if (s.count > 0) {
                    System.out.printf("  Type: %s\n", type);
                    System.out.printf("  Average: %.2f %s\n",
                            s.getAverage(),
                            type.getUnit());
                    System.out.printf("  Highest: %.2f %s (Sensor: %s)\n\n",
                            s.highest,
                            type.getUnit(),
                            s.highestSensor);
                }
            }
        }
    }
}
