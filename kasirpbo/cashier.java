import java.util.ArrayList;
import java.util.Scanner;


class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(int price, String code, String name, int qty) {
        items.add(new Item(code, name, price, qty));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        items.removeIf(item -> item.getCode().equals(code));
        System.out.println("Barang dihapus.");
    }

    public void displayTotal() {
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "Kode", "Nama Barang", "Harga", "Jumlah", "SubTotal");
        System.out.println("------------------------------------------------");

        int total = 0;
        for (Item item : items) {
            int subTotal = item.getSubTotal();
            total += subTotal;
            System.out.printf("%-10s %-20s %-10d %-10d %-10d\n",
                    item.getCode(), item.getName(), item.getPrice(), item.getQty(), subTotal);
        }

        System.out.println("------------------------------------------------");
        System.out.printf("%-40s %-10d\n", "Total Belanja:", total);
    }

    public void processPayment(int payment) {
        int total = items.stream().mapToInt(Item::getSubTotal).sum();
        int change = payment - total;

        System.out.println("Total bayar: " + total);
        System.out.println("Dibayar: " + payment);

        if (payment < total) {
            int shortage = total - payment;
            System.out.println("Kekurangan bayar: " + shortage);
        } else {
            System.out.println("Kembalian: " + change);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

