import java.util.Scanner;

public class Mahasiswa {
    // Atribut
    String nama;
    String nim;
    String jurusan;
    private double ipk; // dienkapsulasi menjadi private

    // Constructor
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter untuk ipk
    public double getIpk() {
        return ipk;
    }

    // Setter untuk ipk (dengan validasi sederhana 0.0 - 4.0)
    public void setIpk(double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
        } else {
            System.out.println("IPK tidak valid! Harus antara 0.0 - 4.0");
        }
    }

    // Method untuk menampilkan data mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.printf("IPK: %.2f%n", ipk);
    }

    // Method untuk mengecek status kelulusan
    public void cekKelulusan() {
        if (ipk >= 3.00) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Belum Lulus");
        }
    }

    // Method untuk menentukan predikat akademik
    public void hitungPredikat() {
        String predikat;
        if (ipk >= 3.75) {
            predikat = "Dengan Pujian";
        } else if (ipk >= 3.50) {
            predikat = "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            predikat = "Memuaskan";
        } else {
            predikat = "Perlu Perbaikan";
        }
        System.out.println("Predikat: " + predikat);
    }

    // Method untuk memperbarui IPK
    public void updateIpk(double ipkBaru) {
        setIpk(ipkBaru); // memakai setter agar validasi tetap berjalan
    }

    public static void main(String[] args) {
        // Membuat 5 objek mahasiswa
        Mahasiswa[] daftar = {
            new Mahasiswa("Andi Pratama", "2440001", "Teknik Informatika", 3.75),
            new Mahasiswa("Budi Santoso", "2440002", "Sistem Informasi", 3.40),
            new Mahasiswa("Citra Lestari", "2440003", "Teknik Informatika", 3.90),
            new Mahasiswa("Joni Suhartono", "2440004", "Teknik Industri", 3.00),
            new Mahasiswa("Bulan Suci", "2440005", "Akuntansi", 3.20)
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine();

        System.out.print("Masukkan IPK baru: ");
        double ipkBaru = scanner.nextDouble();

        // Mencari mahasiswa berdasarkan NIM
        Mahasiswa ditemukan = null;
        for (Mahasiswa m : daftar) {
            if (m.nim.equals(nimInput)) {
                ditemukan = m;
                break;
            }
        }

        if (ditemukan != null) {
            ditemukan.updateIpk(ipkBaru);
            System.out.println("Data berhasil diperbarui!");
            System.out.println();

            // Menampilkan kembali informasi dan status kelulusan
            System.out.println("=== Data Mahasiswa ===");
            ditemukan.tampilkanInfo();
            ditemukan.cekKelulusan();
            ditemukan.hitungPredikat();
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimInput + " tidak ditemukan.");
        }

        scanner.close();
    }
}