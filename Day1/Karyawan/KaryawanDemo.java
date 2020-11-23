// Initialization Class KaryawanDemo
class KaryawanDemo {
    public static void main(String[] args) {

        // Assign objects
        Karyawan pekerja1 = new Karyawan("Joko Sujoko","Staff",5000000 );
        Karyawan pekerja2 = new Karyawan("Susanti","Supervisor",7000000);
        Karyawan pekerja3 = new Karyawan("Kartini","Manager",10000000);

        // Invoke Method printState to print Object
        pekerja1.printStates();
        pekerja2.printStates();
        pekerja3.printStates();
    }
}
