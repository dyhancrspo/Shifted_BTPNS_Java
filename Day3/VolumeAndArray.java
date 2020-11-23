public class VolumeAndArray {
    public static void main(String args[]){
          
    int x = Integer.parseInt(args[0]);
    switch(x){
        case 1: System.out.println("Volume Kubus   =  " + volumeBangun(Integer.parseInt(args[1])));
        break;
        case 2: System.out.println("Volume Bola    =  " + volumeBangun(Double.parseDouble(args[1])));
        break;
        case 3: printArray(Integer.parseInt(args[1]));
        break;
        default :System.out.println("Invalid Mas Bro!!!");
            }
        }
      
        // Voleume Kubus
        public static int volumeBangun(int n1) {
           return n1* n1 * n1;
        }
        // Volume Bola
        public static double volumeBangun(double n1) {
           return (4/3) * (3.14 * (n1 * n1 * n1));
        }
     
        // Array
        //Print Array
        public static void printArray(int z) {
           if (z == 2) {
               String[][] arr = {
                   {"satu", "dua", "tiga", "empat"},
                   {"lima", "enam"}
               };
               for (int i = 0; i < arr.length; i++) {
                   for (int j = 0; j < arr[i].length; j++) {
                       System.out.print(arr[i][j] + " ");
                   }
                   System.out.println();
               }
           } else if (z == 3) {
              String[][] arr = {
                 { "Juno", "Mail", "Budi" },
                 { "Romlah", "Jaenab", "Cuplis" },
                 {  "Mumun", "Jepri" }
              };
               for (int i = 0; i < arr.length; i++) {
                   for (int j = 0; j < arr[i].length; j++) {
                       System.out.print(arr[i][j] + " ");
                   }
                   System.out.println();
               }
           }
       }
     
     
     
       
}
