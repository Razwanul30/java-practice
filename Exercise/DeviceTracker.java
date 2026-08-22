class Device {
    int id;
    String brand;
    String model;
    double price;
    int releaseYear;

    Device(int id, String brand, String model, double price, int releaseYear) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseYear = releaseYear;
    }

    void display() {
        System.out.println(id + " | " + brand + " | " + model +
                " | $" + price + " | " + releaseYear);
    }
}

public class DeviceTracker {
    public static void main(String[] args) {

        Device[] devices = new Device[5];

        devices[0] = new Device(1, "Apple", "iPhone 14", 999, 2022);
        devices[1] = new Device(2, "Samsung", "Galaxy S23", 1099, 2023);
        devices[2] = new Device(3, "Dell", "XPS 15", 1500, 2021);
        devices[3] = new Device(4, "Lenovo", "ThinkPad X1", 1400, 2024);
        devices[4] = new Device(5, "Apple", "iPad Pro", 1200, 2023);

        System.out.println("All Devices:");
        for (Device d : devices) {
            d.display();
        }

        Device newest = devices[0];
        Device expensive = devices[0];

        for (int i = 1; i < devices.length; i++) {
            if (devices[i].releaseYear > newest.releaseYear)
                newest = devices[i];

            if (devices[i].price > expensive.price)
                expensive = devices[i];
        }

        System.out.println("\nNewest Device:");
        newest.display();

        System.out.println("\nMost Expensive Device:");
        expensive.display();
    }
}