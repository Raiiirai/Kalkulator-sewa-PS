import java.util.Scanner;

public class GameZone_Latihan2 {

    // Konstanta harga dan aturanKu
    static final int HARGA_PS4 = 8000;
    static final int HARGA_PS5 = 12000;
    static final int HARGA_MINUMAN = 5000;
    static final int MIN_JAM_DISKON = 3;
    static final int PERSEN_DISKON = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ulang;

        System.out.println("=====================================");
        System.out.println("   SELAMAT DATANG DI GAMEZONE");
        System.out.println("   Penyewaan PlayStation PS4 & PS5");
        System.out.println("=====================================");

        do {
            String nama = bacaNama(input);

            System.out.println("\nPilihan Konsol:");
            System.out.println("1. PS4 - " + formatRupiah(HARGA_PS4) + "/jam");
            System.out.println("2. PS5 - " + formatRupiah(HARGA_PS5) + "/jam");
            int pilihan = bacaPilihanKonsol(input);

            String namaKonsol;
            int hargaPerJam;
            switch (pilihan) {
                case 1:
                    namaKonsol = "PS4";
                    hargaPerJam = HARGA_PS4;
                    break;
                default:
                    namaKonsol = "PS5";
                    hargaPerJam = HARGA_PS5;
                    break;
            }

            int durasi = bacaDurasi(input);

            int biayaSewa = hargaPerJam * durasi;
            int diskon = hitungDiskon(biayaSewa, durasi);

            boolean beliMinuman = bacaYaTidak(input,
                    "\nTambah 1 minuman seharga " + formatRupiah(HARGA_MINUMAN) + "? (y/n): ");
            int biayaMinuman = beliMinuman ? HARGA_MINUMAN : 0;

            int total = biayaSewa - diskon + biayaMinuman;

            cetakStruk(nama, namaKonsol, hargaPerJam, durasi, biayaSewa, diskon, beliMinuman, biayaMinuman, total);

            System.out.print("\nTransaksi baru? (y/n): ");
            ulang = input.nextLine().trim().toLowerCase();
            while (!ulang.equals("y") && !ulang.equals("n")) {
                System.out.print("Input tidak valid. Transaksi baru? (y/n): ");
                ulang = input.nextLine().trim().toLowerCase();
            }
            System.out.println();

        } while (ulang.equals("y"));

        System.out.println("Terima kasih telah menggunakan aplikasi GameZone!");
        input.close();
    }

    static int hitungDiskon(int biayaSewa, int durasi) {
        if (durasi >= MIN_JAM_DISKON) {
            return biayaSewa * PERSEN_DISKON / 100;
        }
        return 0;
    }

    static String bacaNama(Scanner input) {
        String nama;
        do {
            System.out.print("\nMasukkan nama pelanggan: ");
            nama = input.nextLine().trim();
            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
            }
        } while (nama.isEmpty());
        return nama;
    }

    static int bacaPilihanKonsol(Scanner input) {
        int pilihan = 0;
        while (pilihan != 1 && pilihan != 2) {
            System.out.print("Pilih konsol (1/2): ");
            String teks = input.nextLine().trim();
            if (teks.equals("1")) {
                pilihan = 1;
            } else if (teks.equals("2")) {
                pilihan = 2;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan 1 atau 2.");
            }
        }
        return pilihan;
    }

    static int bacaDurasi(Scanner input) {
        int durasi = 0;
        while (durasi <= 0) {
            System.out.print("Lama bermain (jam): ");
            String teks = input.nextLine().trim();
            try {
                durasi = Integer.parseInt(teks);
                if (durasi <= 0) {
                    System.out.println("Durasi harus bilangan bulat positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan bilangan bulat positif.");
                durasi = 0;
            }
        }
        return durasi;
    }

    static boolean bacaYaTidak(Scanner input, String pesan) {
        System.out.print(pesan);
        String jawab = input.nextLine().trim().toLowerCase();
        while (!jawab.equals("y") && !jawab.equals("n")) {
            System.out.print("Input tidak valid. Ketik y atau n: ");
            jawab = input.nextLine().trim().toLowerCase();
        }
        return jawab.equals("y");
    }

    static String formatRupiah(int angka) {
        return "Rp" + String.format("%,d", angka).replace(',', '.');
    }

    static void cetakStruk(String nama, String konsol, int hargaPerJam, int durasi,
                           int biayaSewa, int diskon, boolean minuman, int biayaMinuman, int total) {
        String garis = "=====================================";
        System.out.println("\n" + garis);
        System.out.println("          STRUK GAMEZONE");
        System.out.println(garis);
        System.out.printf("%-16s: %s%n", "Pelanggan", nama);
        System.out.printf("%-16s: %s (%s/jam)%n", "Konsol", konsol, formatRupiah(hargaPerJam));
        System.out.printf("%-16s: %d jam%n", "Durasi", durasi);
        System.out.println("-------------------------------------");
        System.out.printf("%-16s: %s%n", "Biaya Sewa", formatRupiah(biayaSewa));
        System.out.printf("%-16s: -%s%n", "Diskon (10%)", formatRupiah(diskon));
        System.out.printf("%-16s: %s%n", "Minuman", minuman ? formatRupiah(biayaMinuman) : "-");
        System.out.println("-------------------------------------");
        System.out.printf("%-16s: %s%n", "TOTAL BAYAR", formatRupiah(total));
        System.out.println(garis);
        System.out.println("   Terima kasih, selamat bermain!");
        System.out.println(garis);
    }
}