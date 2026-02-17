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
    System.out.println("ID: " + id);
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Price: TK " + price);
    System.out.println("Release Year: " + releaseYear);
    System.out.println("---------------------------");
  }
}

public class DeviceSpecificationTracker {
  public static void main(String[] args) {
    Device[] devices = new Device[5];
    devices[0] = new Device(1, "Redmi", "Redmi note 13", 20999.00, 2022);
    devices[1] = new Device(2, "Google", "Google pixel 5", 40000.00, 2023);
    devices[2] = new Device(3, "Dell", "XPS 15", 75000.00, 2021);
    devices[3] = new Device(4, "Lenovo", "Lenovo Ideapad slim 5", 98000.00, 2023);
    devices[4] = new Device(5, "HP", "Spectre x360", 100000.00, 2022);

    System.out.println("All Devices:");
    for (int i = 0; i < devices.length; i++) {
      devices[i].display();
    }

    Device newest = devices[0];
    for (int i = 1; i < devices.length; i++) {
      if (devices[i].releaseYear > newest.releaseYear) {
        newest = devices[i];
      }
    }
    System.out.println("Newest Device:");
    newest.display();

    Device oldest = devices[0];
    for (int i = 1; i < devices.length; i++) {
      if (devices[i].releaseYear < oldest.releaseYear) { // < erokom
        oldest = devices[i];
      }
    }
    System.out.println("Oldest Device:");
    oldest.display();

    Device expensive = devices[0];
    for (int i = 1; i < devices.length; i++) {
      if (devices[i].price > expensive.price) {
        expensive = devices[i];
      }
    }
    System.out.println("Most Expensive Device:");
    expensive.display();

    Device cheapest = devices[0];
    for (int i = 1; i < devices.length; i++) {
      if (devices[i].price < cheapest.price) {
        cheapest = devices[i];
      }
    }

    System.out.println("Cheapest Device:");
    cheapest.display();

  }
}
