// TUGAS KELOMPOK - WEEK 7
// Implementasi Queue, Stack, dan Linked List
// Kelompok 4:
// 1. AKHMAD FARUQ - NIM 2902820176
// 2. ALVITA KRIDAPRAKOSA - NIM 2602296406
// 3. CUCU CINTIA WIDIANI - NIM 2902806455
// 4. HASRIN CITRA UTAMI - NIM 2902816645
// 5. WIDIYA PRAMESTIKA - NIM 2902816304

public class Main {
    public static void main(String[] args) {

        // =========================================================
        // SISTEM MANAJEMEN ANTREAN (QUEUE)
        // =========================================================
        System.out.println("======================================");
        System.out.println("SISTEM MANAJEMEN ANTREAN (QUEUE)");
        System.out.println("======================================\n");

        QueueAntrean antrean = new QueueAntrean();
        antrean.tambahPelanggan("Andi");
        antrean.tambahPelanggan("Budi");
        antrean.tambahPelanggan("Siti");
        System.out.println();
        antrean.tampilkanAntrean();

        System.out.println();
        antrean.layaniPelanggan();
        antrean.tampilkanAntrean();

        // =========================================================
        // FITUR UNDO/REDO EDITOR TEKS (STACK)
        // =========================================================
        System.out.println("\n======================================");
        System.out.println("FITUR UNDO/REDO EDITOR TEKS (STACK)");
        System.out.println("======================================\n");

        EditorUndoRedo editor = new EditorUndoRedo();
        editor.tambahTeks("Indonesia Juara Asean Championship 2026");
        editor.tambahTeks("Indonesia Akan Masuk Piala Dunia 2030");
        editor.undo();
        editor.redo();

        // =========================================================
        // KASUS C: MANAJEMEN DATA MAHASISWA (LINKED LIST)
        // =========================================================
        System.out.println("\n======================================");
        System.out.println("MANAJEMEN DATA MAHASISWA (LINKED LIST)");
        System.out.println("======================================\n");

        DaftarMahasiswa daftar = new DaftarMahasiswa();
        daftar.tambahMahasiswa("12345", "Andi", 85);
        daftar.tambahMahasiswa("67890", "Budi", 90);
        daftar.tampilkanDaftar();

        System.out.println("\nMengupdate nilai mahasiswa (Budi -> 95)");
        daftar.updateNilai("67890", 95);
        System.out.println("Daftar Mahasiswa setelah update:");
        daftar.tampilkanDaftar();

        System.out.println("\nMenghapus mahasiswa dengan NIM 12345 (Andi)");
        daftar.hapusMahasiswa("12345");
        System.out.println("Daftar Mahasiswa setelah penghapusan:");
        daftar.tampilkanDaftar();

        // =========================================================
        // ANALISIS PERBANDINGAN EFISIENSI (System.nanoTime)
        // =========================================================
        System.out.println();
        PerbandinganPerforma.jalankanPerbandingan();
    }
}
