class InventoryItem {
  String itemCode;
  String name;
  int stock;
  double price;

  InventoryItem(String itemCode, String name, int stock, double price) {
    this.itemCode = itemCode;
    this.name = name;
    this.stock = stock;
    this.price = price;
  }

  void increaseStock(int amount) {
    stock += amount;
  }

  void decreaseStock(int amount) {
    stock -= amount;
  }

  double totalValue() {
    return stock * price;
  }
}

public class Inventory {
  public static void main(String[] args) {

    InventoryItem[] items = new InventoryItem[3];

    items[0] = new InventoryItem("A1", "Mouse", 10, 20);
    items[1] = new InventoryItem("A2", "Keyboard", 0, 50);
    items[2] = new InventoryItem("A3", "Monitor", 5, 200);

    double totalInventory = 0;

    for (InventoryItem i : items) {
      totalInventory += i.totalValue();

      if (i.stock == 0)
        System.out.println("Out of Stock: " + i.name);
    }

    System.out.println("Total Inventory Value: $" + totalInventory);
  }
}