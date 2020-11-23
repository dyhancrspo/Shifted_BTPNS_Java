class Car {
    String color;
    String brand;
    int speed = 0;
    int gear = 1;

    void changeColor(String newValue) {
         color = newValue;
    }

    void changeBrand(String newValue) {
         brand = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }
    void speedUp(int increment) {
         speed = speed + increment;   
    }
    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }
    void printStates() {
         System.out.println("Color:" + color + " Brand:" + brand + " Speed: " + speed );
    }
  
}
