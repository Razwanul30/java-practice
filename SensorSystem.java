enum SensorType {

    TEMPERATURE("°C"),
    HUMIDITY("%"),
    LIGHT("Lux"),
    SMOKE("ppm"),
    PRESSURE("kPa");

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
    ROOMB,
    ROOMC,
    ROOMD,
    ROOME
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

    void display() {
        System.out.printf("%s | %s | %s | %.2f %s\n",
                sensorId,
                sensorType,
                room,
                value,
                sensorType.getUnit());
    }
}

public class SensorSystem {

    public static void main(String[] args) {

        SensorReading[] readings = {

                // ROOMA
                new SensorReading("S1",  SensorType.TEMPERATURE, Room.ROOMA, 25),
                new SensorReading("S2",  SensorType.HUMIDITY,    Room.ROOMA, 60),
                new SensorReading("S3",  SensorType.LIGHT,       Room.ROOMA, 300),
                new SensorReading("S4",  SensorType.SMOKE,       Room.ROOMA, 12),
                new SensorReading("S5",  SensorType.PRESSURE,    Room.ROOMA, 100),

                // ROOMB
                new SensorReading("S6",  SensorType.TEMPERATURE, Room.ROOMB, 28),
                new SensorReading("S7",  SensorType.HUMIDITY,    Room.ROOMB, 55),
                new SensorReading("S8",  SensorType.LIGHT,       Room.ROOMB, 350),
                new SensorReading("S9",  SensorType.SMOKE,       Room.ROOMB, 18),
                new SensorReading("S10", SensorType.PRESSURE,    Room.ROOMB, 105),

                // ROOMC
                new SensorReading("S11", SensorType.TEMPERATURE, Room.ROOMC, 30),
                new SensorReading("S12", SensorType.HUMIDITY,    Room.ROOMC, 65),
                new SensorReading("S13", SensorType.LIGHT,       Room.ROOMC, 400),
                new SensorReading("S14", SensorType.SMOKE,       Room.ROOMC, 20),
                new SensorReading("S15", SensorType.PRESSURE,    Room.ROOMC, 102),

                // ROOMD
                new SensorReading("S16", SensorType.TEMPERATURE, Room.ROOMD, 22),
                new SensorReading("S17", SensorType.HUMIDITY,    Room.ROOMD, 58),
                new SensorReading("S18", SensorType.LIGHT,       Room.ROOMD, 280),
                new SensorReading("S19", SensorType.SMOKE,       Room.ROOMD, 14),
                new SensorReading("S20", SensorType.PRESSURE,    Room.ROOMD, 99),

                // ROOME
                new SensorReading("S21", SensorType.TEMPERATURE, Room.ROOME, 27),
                new SensorReading("S22", SensorType.HUMIDITY,    Room.ROOME, 62),
                new SensorReading("S23", SensorType.LIGHT,       Room.ROOME, 320),
                new SensorReading("S24", SensorType.SMOKE,       Room.ROOME, 16),
                new SensorReading("S25", SensorType.PRESSURE,    Room.ROOME, 110)
        };

        System.out.println("===== ALL SENSOR DATA =====");
        for (SensorReading r : readings) {
            r.display();
        }

        int n = readings.length;

       
        // ROOM WISE ANALYSIS
       

        Room[] rooms = new Room[Room.values().length];
        double[] roomSum = new double[Room.values().length];
        double[] roomHighest = new double[Room.values().length];
        String[] roomHighestSensor = new String[Room.values().length];
        SensorType[] roomHighestType = new SensorType[Room.values().length];
        int[] roomCount = new int[Room.values().length];
        int roomIndex = 0;

        for (SensorReading r : readings) {

            int index = -1;

            for (int i = 0; i < roomIndex; i++) {
                if (rooms[i] == r.room) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                rooms[roomIndex] = r.room;
                roomSum[roomIndex] = r.value;
                roomHighest[roomIndex] = r.value;
                roomHighestSensor[roomIndex] = r.sensorId;
                roomHighestType[roomIndex] = r.sensorType;
                roomCount[roomIndex] = 1;
                roomIndex++;
            } else {
                roomSum[index] += r.value;
                roomCount[index]++;

                if (r.value > roomHighest[index]) {
                    roomHighest[index] = r.value;
                    roomHighestSensor[index] = r.sensorId;
                    roomHighestType[index] = r.sensorType;
                }
            }
        }

        System.out.println("\n===== ROOM WISE REPORT =====");

        for (int i = 0; i < roomIndex; i++) {
            System.out.printf("Room: %s\n", rooms[i]);
            System.out.printf("Average: %.2f\n", roomSum[i] / roomCount[i]);
            System.out.printf("Highest: %.2f %s (Sensor: %s - %s)\n\n",
                    roomHighest[i],
                    roomHighestType[i].getUnit(),
                    roomHighestSensor[i],
                    roomHighestType[i]);
        }

       
        // SENSOR TYPE WISE ANALYSIS
        

        SensorType[] types = new SensorType[SensorType.values().length];
        double[] typeSum = new double[SensorType.values().length];
        double[] typeHighest = new double[SensorType.values().length];
        String[] typeHighestSensor = new String[SensorType.values().length];
        int[] typeCount = new int[SensorType.values().length];
        int typeIndex = 0;

        for (SensorReading r : readings) {

            int index = -1;

            for (int i = 0; i < typeIndex; i++) {
                if (types[i] == r.sensorType) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                types[typeIndex] = r.sensorType;
                typeSum[typeIndex] = r.value;
                typeHighest[typeIndex] = r.value;
                typeHighestSensor[typeIndex] = r.sensorId;
                typeCount[typeIndex] = 1;
                typeIndex++;
            } else {
                typeSum[index] += r.value;
                typeCount[index]++;

                if (r.value > typeHighest[index]) {
                    typeHighest[index] = r.value;
                    typeHighestSensor[index] = r.sensorId;
                }
            }
        }

        System.out.println("===== SENSOR TYPE WISE REPORT =====");

        for (int i = 0; i < typeIndex; i++) {
            System.out.printf("Sensor Type: %s\n", types[i]);
            System.out.printf("Average: %.2f %s\n",
                    typeSum[i] / typeCount[i],
                    types[i].getUnit());
            System.out.printf("Highest: %.2f %s (Sensor ID: %s)\n\n",
                    typeHighest[i],
                    types[i].getUnit(),
                    typeHighestSensor[i]);
        }
    }
}
