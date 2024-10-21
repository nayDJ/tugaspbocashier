import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("|\tProgram Transaksi Kasir\t\t |");
            System.out.println("----------------------------------");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tampilkan Total & Bayar");
            System.out.println("4. Keluar");
            System.out.println("----------------------------------");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------------------------");
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next();
                    System.out.print("Masukkan harga barang: ");
                    int addPrice = scanner.nextInt();
                    System.out.print("Masukkan jumlah barang: ");
                    int addQty = scanner.nextInt();
                    cashier.addItem(addPrice, addCode, addName, addQty);
                    break;

                case 2:
                    if (cashier.isEmpty()) {
                        System.out.println("Daftar barang kosong. Tambahkan barang terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan kode barang yang akan dihapus: ");
                        String removeCode = scanner.next();
                        cashier.removeItem(removeCode);
                    }
                    break;

                case 3:
                    if (cashier.isEmpty()) {
                        System.out.println("Daftar barang kosong. Tambahkan barang terlebih dahulu.");
                    } else {
                        System.out.println("----------------------------------");
                        cashier.displayTotal();
                        System.out.print("Masukkan jumlah pembayaran: ");
                        int payment = scanner.nextInt();
                        cashier.processPayment(payment);
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}


