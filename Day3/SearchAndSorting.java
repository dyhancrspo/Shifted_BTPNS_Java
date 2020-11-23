public class SearchAndSorting {
    public static void main(String[] args) {
        int[] angka = {21,23,26,12,15}; // Array iNPUT
        System.out.print("Array Awal => ");
        for(int i = 0; i < angka.length; i++) { //Looping array Angka / array awal
            System.out.print(angka[i] + ", "); // Print hasil looping
        }
        System.out.println() ;
        SortWithBubble(angka); // Invoke Method SortWithBubble dengan parameter(Array Angka)
        System.out.print("Hasil Sorting: ") ;
        for(int i = 0; i < angka.length; i++) { // Looping Array hasil dari method SortWithBubble
            System.out.print(angka[i] + ", "); // Print hasil Looping array method SortWithBubble
        }

        System.out.println();
        // Invoke Method SearchBinary dengan parameter(Hasil Array dari Method SortWithBubble)
        SearchBinary(SortWithBubble(angka));
    }

    // Method SearchBinary
    static void SearchBinary(int[] angka) {
        int target = 23; // Element array (target) yang akan disearch.
        int left = 0; // Inisialisasi local variable left 
        int middle; // Local Variable middle
        int right = angka.length - 1; // Inisialisasi local variable right yg memiliki value dari hasil angka.length - 1
        while (left <= right) {
            middle = (left + right) / 2;
            if (angka[middle] == target) { // Check value array angka[middle] apakah sama dengan dari value variable target
                System.out.println( "Element " + target + " found at index " + middle); //Cetak hasil SearchBinary (index)
                break;
            } else if (angka[middle] < target) { // Check value array angka[middle]  lebih kecil dari value variable target
                left = middle + 1; //Set value variable left dengan munjumlahkan value dari vaiable middle + 1
            } else if (angka[middle] > target) { // Check value array angka[middle]  lebih besar dari value variable target
                right = middle - 1;  //Set value variable right dengan mengurangkan value dari vaiable middle - 1
            }
        }
    }
     
    // Method BubbleSort
    static int [] SortWithBubble(int [] angka) {
        for (int i = 0; i < angka.length - 1; i++) { //Looping berdasarkan panjang array dari parameter angka
            for (int j = 0; j < angka.length - 1 - i; j++) { //Looping array parameter - 1 - i
                if (angka[j] > angka[j + 1]) { 
                    int temp = angka[j]; // Inisialisasi Local Variable temp yang memupunyai value sesuai angka[j]
                    angka[j]  = angka[j + 1];  // Set angka[j] 
                    angka[j + 1] = temp; // Set angka[j+1]
                }
            }
        }
        return angka; // return angka
    }

}
