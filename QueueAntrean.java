// SISTEM MANAJEMEN ANTREAN (QUEUE)
// Queue disini dibangun secara manual menggunakan struktur Linked List
// (bukan java.util.Queue) agar konsep node-pointer FIFO (First In First Out)

// Node untuk menyimpan satu pelanggan dalam antrean
class NodePelanggan {
    String nama;
    NodePelanggan next;

    public NodePelanggan(String nama) {
        this.nama = nama;
        this.next = null;
    }
}

// Class QueueAntrean merepresentasikan antrean pelanggan customer service
// menggunakan Linked List dengan dua pointer: front (kepala antrean,
// pelanggan yang akan dilayani lebih dulu) dan rear (ekor antrean,
// tempat pelanggan baru ditambahkan).
public class QueueAntrean {

    private NodePelanggan front; // pelanggan paling depan (akan dilayani)
    private NodePelanggan rear;  // pelanggan paling belakang (baru masuk)
    private int jumlah;

    public QueueAntrean() {
        this.front = null;
        this.rear = null;
        this.jumlah = 0;
    }

    // Operasi ENQUEUE: tambah pelanggan baru ke akhir antrean -> O(1)
    public void tambahPelanggan(String nama) {
        NodePelanggan nodeBaru = new NodePelanggan(nama);
        if (rear == null) {
            // Antrean masih kosong, pelanggan baru jadi front dan rear sekaligus
            front = nodeBaru;
            rear = nodeBaru;
        } else {
            rear.next = nodeBaru;
            rear = nodeBaru;
        }
        jumlah++;
        System.out.println("[Antrean] " + nama + " berhasil masuk ke antrean.");
    }

    // Operasi DEQUEUE: melayani (menghapus) pelanggan paling depan -> O(1)
    public void layaniPelanggan() {
        if (front == null) {
            System.out.println("[Antrean] Tidak ada pelanggan untuk dilayani, antrean kosong.");
            return;
        }
        String namaDilayani = front.nama;
        front = front.next;
        if (front == null) {
            // Antrean menjadi kosong setelah dequeue
            rear = null;
        }
        jumlah--;
        System.out.println("Melayani pelanggan: " + namaDilayani);
    }

    // Menampilkan seluruh pelanggan yang masih berada dalam antrean -> O(n)
    public void tampilkanAntrean() {
        if (front == null) {
            System.out.println("Pelanggan dalam antrean: (kosong)");
            return;
        }
        System.out.println("Pelanggan dalam antrean:");
        NodePelanggan current = front;
        int nomor = 1;
        while (current != null) {
            System.out.println(nomor + ". " + current.nama);
            current = current.next;
            nomor++;
        }
    }

    public int getJumlah() {
        return jumlah;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // ===== Versi "senyap" (tanpa System.out.println) =====
    // Digunakan khusus pada PerbandinganPerforma agar waktu I/O console
    // tidak ikut terukur dan mengganggu akurasi benchmark System.nanoTime().
    public void tambahPelangganSenyap(String nama) {
        NodePelanggan nodeBaru = new NodePelanggan(nama);
        if (rear == null) {
            front = nodeBaru;
            rear = nodeBaru;
        } else {
            rear.next = nodeBaru;
            rear = nodeBaru;
        }
        jumlah++;
    }

    public void layaniPelangganSenyap() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
        jumlah--;
    }
}
