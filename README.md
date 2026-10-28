# GameZone - Aplikasi Penyewaan PlayStation

Aplikasi berbasis console (Java) untuk membantu petugas GameZone menghitung biaya penyewaan PlayStation dan menampilkan rincian pembayaran pelanggan dalam bentuk struk.

## Fitur

- Input nama pelanggan
- Pilihan konsol:
  - PS4 - Rp8.000/jam
  - PS5 - Rp12.000/jam
- Input lama bermain (jam, bilangan bulat positif)
- Diskon 10% dari biaya sewa jika bermain minimal 3 jam
- Tambahan 1 minuman seharga Rp5.000 (opsional)
- Struk transaksi berisi pelanggan, konsol, durasi, biaya sewa, diskon, minuman, dan total pembayaran
- Pilihan untuk transaksi baru atau mengakhiri program
- Validasi input (nama kosong, pilihan konsol, durasi non-angka/nol/negatif, jawaban y/n)

## Rumus Perhitungan

```
Biaya Sewa = harga per jam x lama bermain
Diskon     = 10% x Biaya Sewa   (jika lama bermain >= 3 jam, selain itu 0)
Total      = Biaya Sewa - Diskon + Biaya Minuman
```

## Persyaratan

- Java Development Kit (JDK) 8 atau lebih baru

## Cara Menjalankan

```bash
javac GameZone.java
java GameZone
```

## Contoh Penggunaan

```
Masukkan nama pelanggan: Budi

Pilihan Konsol:
1. PS4 - Rp8.000/jam
2. PS5 - Rp12.000/jam
Pilih konsol (1/2): 2
Lama bermain (jam): 3

Tambah 1 minuman seharga Rp5.000? (y/n): y

=====================================
          STRUK GAMEZONE
=====================================
Pelanggan       : Budi
Konsol          : PS5 (Rp12.000/jam)
Durasi          : 3 jam
-------------------------------------
Biaya Sewa      : Rp36.000
Diskon (10%)    : -Rp3.600
Minuman         : Rp5.000
-------------------------------------
TOTAL BAYAR     : Rp37.400
=====================================
   Terima kasih, selamat bermain!
=====================================

Transaksi baru? (y/n): n
```

## Konsep Pemrograman yang Digunakan

| Konsep | Penerapan |
|---|---|
| `Scanner` | Semua input pengguna |
| Variabel, tipe data, operator aritmatika | Perhitungan biaya, diskon, dan total |
| Percabangan (`if-else`, `switch`) | Pemilihan konsol dan penentuan diskon |
| Perulangan (`do-while`, `while`) | Transaksi berulang dan validasi input |
| Method buatan sendiri | `hitungDiskon`, `bacaNama`, `bacaPilihanKonsol`, `bacaDurasi`, `bacaYaTidak`, `formatRupiah`, `cetakStruk` |

## Struktur File

```
.
├── GameZone.java
└── README.md
```
