class Ride {
  int rideId;
  double distanceKm;
  double durationMinutes;
  double fare;

  Ride(int rideId, double distanceKm, double durationMinutes, double fare) {
    this.rideId = rideId;
    this.distanceKm = distanceKm;
    this.durationMinutes = durationMinutes;
    this.fare = fare;
  }

  void display() {
    System.out.println("Ride " + rideId +
        " | Distance: " + distanceKm +
        "km | Duration: " + durationMinutes +
        "min | Fare: $" + fare);
  }

  double costPerKm() {
    return fare / distanceKm;
  }
}

public class Rides {
  public static void main(String[] args) {

    Ride[] rides = new Ride[3];

    rides[0] = new Ride(1, 10, 20, 200);
    rides[1] = new Ride(2, 15, 30, 350);
    rides[2] = new Ride(3, 8, 15, 150);

    double totalFare = 0;
    Ride longest = rides[0];

    for (Ride r : rides) {
      r.display();
      totalFare += r.fare;

      if (r.distanceKm > longest.distanceKm)
        longest = r;

      System.out.println("Cost per km: " + r.costPerKm());
      System.out.println();
    }

    System.out.println("Average Fare: " + (totalFare / rides.length));
    System.out.println("Longest Ride: Ride " + longest.rideId);
  }
}