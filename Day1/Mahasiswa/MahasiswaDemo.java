class MahasiswaDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa();

        // Invoke methods on 
        // those objects
        mhs1.changeName("Jono Sujono");
        mhs1.changeGender("Laki-Laki");
        mhs1.changeAge(25);
        mhs1.printStates();

        mhs2.changeName("Kartini");
        mhs2.changeGender("Perempuan");
        mhs2.changeAge(22);
        mhs2.printStates();
    }
}
