// ================= ANALISIS PERBANDINGAN EFISIENSI =================
// Mengukur rata-rata waktu eksekusi (dalam milidetik) untuk operasi utama
// pada Queue, Stack, dan Linked List menggunakan System.nanoTime(),
// dijalankan berulang kali (banyak trial) agar hasil lebih stabil.

public class PerbandinganPerforma {

    private static final int TRIAL = 2000; // jumlah pengulangan per pengukuran

    public static void jalankanPerbandingan() {
        System.out.println("======================================");
        System.out.println(" ANALISIS PERBANDINGAN EFISIENSI OPERASI");
        System.out.println(" (rata-rata dari " + TRIAL + " kali percobaan, satuan milidetik)");
        System.out.println("======================================\n");

        ukurQueueEnqueueDequeue();
        ukurStackUndoRedo();
        ukurLinkedListTambahHapus();
    }

    // Mengukur waktu enqueue + dequeue pada QueueAntrean (operasi O(1) di kedua ujung)
    private static void ukurQueueEnqueueDequeue() {
        long totalEnqueue = 0;
        long totalDequeue = 0;

        for (int i = 0; i < TRIAL; i++) {
            QueueAntrean antrean = new QueueAntrean();
            // ukur enqueue
            long t0 = System.nanoTime();
            antrean.tambahPelangganSenyap("Pelanggan" + i);
            long t1 = System.nanoTime();
            totalEnqueue += (t1 - t0);

            // ukur dequeue
            long t2 = System.nanoTime();
            antrean.layaniPelangganSenyap();
            long t3 = System.nanoTime();
            totalDequeue += (t3 - t2);
        }

        double avgEnqueueMs = (totalEnqueue / (double) TRIAL) / 1_000_000.0;
        double avgDequeueMs = (totalDequeue / (double) TRIAL) / 1_000_000.0;
        System.out.printf("Queue  -> rata-rata ENQUEUE : %.6f ms%n", avgEnqueueMs);
        System.out.printf("Queue  -> rata-rata DEQUEUE : %.6f ms%n", avgDequeueMs);
        System.out.println();
    }

    // Mengukur waktu push (tambahTeks) dan pop (undo) pada EditorUndoRedo (Stack, O(1))
    private static void ukurStackUndoRedo() {
        long totalPush = 0;
        long totalUndo = 0;

        for (int i = 0; i < TRIAL; i++) {
            EditorUndoRedo editor = new EditorUndoRedo();

            long t0 = System.nanoTime();
            editor.tambahTeksSenyap("Teks versi " + i);
            long t1 = System.nanoTime();
            totalPush += (t1 - t0);

            long t2 = System.nanoTime();
            editor.undoSenyap();
            long t3 = System.nanoTime();
            totalUndo += (t3 - t2);
        }

        double avgPushMs = (totalPush / (double) TRIAL) / 1_000_000.0;
        double avgUndoMs = (totalUndo / (double) TRIAL) / 1_000_000.0;
        System.out.printf("Stack  -> rata-rata PUSH (tambah teks) : %.6f ms%n", avgPushMs);
        System.out.printf("Stack  -> rata-rata POP  (undo)        : %.6f ms%n", avgUndoMs);
        System.out.println();
    }

    // Mengukur waktu tambah (akhir list, O(n)) dan hapus (by NIM, O(n)) pada
    // DaftarMahasiswa, dengan list yang sudah berisi N data agar efek O(n) terlihat.
    private static void ukurLinkedListTambahHapus() {
        final int JUMLAH_DATA_AWAL = 500; // ukuran list sebelum operasi diukur

        long totalTambah = 0;
        long totalHapus = 0;

        for (int i = 0; i < TRIAL; i++) {
            DaftarMahasiswa daftar = new DaftarMahasiswa();
            for (int j = 0; j < JUMLAH_DATA_AWAL; j++) {
                daftar.tambahMahasiswa("NIM" + j, "Mhs" + j, 80);
            }

            // ukur tambah mahasiswa baru di akhir list (harus menyusuri seluruh list)
            long t0 = System.nanoTime();
            daftar.tambahMahasiswa("NIMBARU" + i, "MhsBaru", 90);
            long t1 = System.nanoTime();
            totalTambah += (t1 - t0);

            // ukur hapus mahasiswa di akhir list (harus menyusuri seluruh list)
            long t2 = System.nanoTime();
            daftar.hapusMahasiswaSenyap("NIMBARU" + i);
            long t3 = System.nanoTime();
            totalHapus += (t3 - t2);
        }

        double avgTambahMs = (totalTambah / (double) TRIAL) / 1_000_000.0;
        double avgHapusMs = (totalHapus / (double) TRIAL) / 1_000_000.0;
        System.out.printf("LinkedList (n=%d) -> rata-rata TAMBAH di akhir : %.6f ms%n", JUMLAH_DATA_AWAL, avgTambahMs);
        System.out.printf("LinkedList (n=%d) -> rata-rata HAPUS di akhir  : %.6f ms%n", JUMLAH_DATA_AWAL, avgHapusMs);
        System.out.println();
    }
}
