class CarDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Car mobil1 = new Car();
        Car mobil2 = new Car();

        // Invoke methods on 
        // those objects
        mobil1.changeColor("Kuning");
        mobil1.changeBrand("BWM");
        mobil1.speedUp(100);
        mobil1.printStates();
        mobil1.applyBrakes(50);
        mobil1.printStates();

        mobil2.changeColor("Merah");
        mobil2.changeBrand("Feraru");
        mobil2.speedUp(200);
        mobil2.printStates();
        mobil2.applyBrakes(70);
        mobil2.printStates();
    }
}
