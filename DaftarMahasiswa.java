// MANAJEMEN DATA MAHASISWA (LINKED LIST)
// getter/setter untuk mengakses data dalam Node Linked List

// Node yang menyimpan data satu mahasiswa + pointer ke node berikutnya
class NodeMahasiswa {
    private String nim;
    private String nama;
    private int nilai;
    NodeMahasiswa next;

    public NodeMahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
    }

    // ===== Getter & Setter (enkapsulasi data dalam Node) =====
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public int getNilai() { return nilai; }
    public void setNilai(int nilai) { this.nilai = nilai; }
}

// Class DaftarMahasiswa mengelola Single Linked List berisi data mahasiswa.
public class DaftarMahasiswa {

    private NodeMahasiswa head;
    private int jumlah;

    public DaftarMahasiswa() {
        this.head = null;
        this.jumlah = 0;
    }

    // Menambahkan mahasiswa baru di akhir list -> O(n) karena harus
    // menyusuri sampai node terakhir (tidak menyimpan pointer tail terpisah,
    // agar perbandingan dengan Queue yang punya tail pointer lebih jelas).
    public void tambahMahasiswa(String nim, String nama, int nilai) {
        NodeMahasiswa nodeBaru = new NodeMahasiswa(nim, nama, nilai);
        if (head == null) {
            head = nodeBaru;
        } else {
            NodeMahasiswa current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nodeBaru;
        }
        jumlah++;
    }

    // Menghapus mahasiswa berdasarkan NIM -> O(n), perlu menyusuri list
    // sambil menyimpan referensi node sebelumnya untuk melepas pointer.
    public boolean hapusMahasiswa(String nim) {
        NodeMahasiswa current = head;
        NodeMahasiswa sebelumnya = null;

        while (current != null) {
            if (current.getNim().equals(nim)) {
                if (sebelumnya == null) {
                    head = current.next; // yang dihapus adalah head
                } else {
                    sebelumnya.next = current.next;
                }
                jumlah--;
                System.out.println("Mahasiswa dengan NIM " + nim + " (" + current.getNama() + ") berhasil dihapus.");
                return true;
            }
            sebelumnya = current;
            current = current.next;
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        return false;
    }

    // Mengupdate nilai mahasiswa berdasarkan NIM -> O(n) pencarian linear
    public boolean updateNilai(String nim, int nilaiBaru) {
        NodeMahasiswa current = head;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNilai(nilaiBaru);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Mencari mahasiswa berdasarkan NIM, mengembalikan node-nya (atau null)
    public NodeMahasiswa cariMahasiswa(String nim) {
        NodeMahasiswa current = head;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Menampilkan seluruh daftar mahasiswa secara berurutan -> O(n)
    public void tampilkanDaftar() {
        if (head == null) {
            System.out.println("Daftar Mahasiswa: (kosong)");
            return;
        }
        System.out.println("Daftar Mahasiswa:");
        NodeMahasiswa current = head;
        int nomor = 1;
        while (current != null) {
            System.out.println(nomor + ". NIM: " + current.getNim() + ", Nama: " + current.getNama()
                    + ", Nilai: " + current.getNilai());
            current = current.next;
            nomor++;
        }
    }

    public int getJumlah() {
        return jumlah;
    }

    // ===== Versi "senyap" (tanpa System.out.println) untuk benchmark =====
    public boolean hapusMahasiswaSenyap(String nim) {
        NodeMahasiswa current = head;
        NodeMahasiswa sebelumnya = null;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                if (sebelumnya == null) {
                    head = current.next;
                } else {
                    sebelumnya.next = current.next;
                }
                jumlah--;
                return true;
            }
            sebelumnya = current;
            current = current.next;
        }
        return false;
    }
}
