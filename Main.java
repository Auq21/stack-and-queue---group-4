// TUGAS KELOMPOK - WEEK 7 PRACTICUM
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
        // FITUR UNDO/REDO EDITOR TEKS (STACK)
        // =========================================================
        System.out.println("\n======================================");
        System.out.println(" FITUR UNDO/REDO EDITOR TEKS (STACK)");
        System.out.println("======================================\n");

        EditorUndoRedo editor = new EditorUndoRedo();
        editor.tambahTeks("Tes Text Ke-1");
        editor.tambahTeks("Tes Text Ke-2");
        editor.undo();
        editor.redo();
    }
}
