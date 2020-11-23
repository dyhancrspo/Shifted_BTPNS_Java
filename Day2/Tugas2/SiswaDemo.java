 class SiswaDemo {
    public static void main(String[] args) {

        // Assign Objects
    
        Siswa obj1 = new Siswa("Joko Sujoko","Laki-Laki",66,3,10,2004);        
        Siswa obj2 = new Siswa("Susanti","Perempuan",74,20,5,2001);
        Siswa obj3 = new Siswa("Kartini","Perempuan",88,12,2,1990);
        Siswa obj4 = new Siswa("UpinIpin","Laki-Laki",45,12,2,2015);
        
        // Invoke methods on Object
        obj1.printStates();
        obj2.printStates();
        obj2.printStates();
        obj3.printStates();
        obj4.printStates();
    }
}
