// FITUR UNDO/REDO EDITOR TEKS (STACK)
// Dua stack digunakan:
// undoStack : menyimpan histori teks sebelum perubahan terbaru (LIFO)
// redoStack : menyimpan teks yang baru saja di-undo, agar bisa dikembalikan (redo)

import java.util.Stack;

public class EditorUndoRedo {

    private String teksSaatIni;             // isi teks editor saat ini
    private Stack<String> undoStack;        // histori perubahan sebelumnya
    private Stack<String> redoStack;        // histori yang sudah di-undo

    public EditorUndoRedo() {
        this.teksSaatIni = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    // Operasi PUSH: menambahkan teks baru ke editor
    // Kondisi teks SEBELUM perubahan di-push ke undoStack
    // dan redoStack dikosongkan karena histori redo lama sudah tidak valid lagi
    public void tambahTeks(String teksBaru) {
        undoStack.push(teksSaatIni);
        teksSaatIni = teksBaru;
        redoStack.clear();
        System.out.println("Teks saat ini: \"" + teksSaatIni + "\"");
    }

    // Operasi UNDO: mengembalikan ke kondisi teks sebelum perubahan terakhir -> O(1)
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Undo: tidak ada perubahan untuk dibatalkan.");
            return;
        }
        redoStack.push(teksSaatIni);     // simpan kondisi sekarang agar bisa di-redo
        teksSaatIni = undoStack.pop();   // ambil kondisi sebelumnya dari undoStack
        System.out.println("Undo: \"" + teksSaatIni + "\"");
    }

    // Operasi REDO: mengembalikan perubahan yang telah di-undo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Redo: tidak ada perubahan untuk dikembalikan.");
            return;
        }
        undoStack.push(teksSaatIni);     // simpan kondisi sekarang kembali ke undoStack
        teksSaatIni = redoStack.pop();   // ambil kondisi yang sempat di-undo
        System.out.println("Redo: \"" + teksSaatIni + "\"");
    }

    public String getTeksSaatIni() {
        return teksSaatIni;
    }

    // ===== Versi "senyap" (tanpa System.out.println) untuk benchmark =====
    public void tambahTeksSenyap(String teksBaru) {
        undoStack.push(teksSaatIni);
        teksSaatIni = teksBaru;
        redoStack.clear();
    }

    public void undoSenyap() {
        if (undoStack.isEmpty()) {
            return;
        }
        redoStack.push(teksSaatIni);
        teksSaatIni = undoStack.pop();
    }
}
