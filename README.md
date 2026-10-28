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

## Output
### Output jika memilih pilihan PS4 dengan minuman
!(././saya%20skrinsot%20kelakuan%20mu/Screenshot 2026-10-28 160348.png)

### Output jika memilih piilihan PS5 tanpa minuman
!(././saya%20skrinsot%20kelakuan%20mu/Screenshot 2026-10-28 160436.png)

### Output jika memilih pilihan PS5 dengan minuman
!(././saya%20skrinsot%20kelakuan%20mu/Screenshot 2026-10-28 160513.png)

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
