// Initialization Class Karyawan
class Karyawan {	
 	String name; // Declaring String name variable
	String position; // Declaring String position variable
	int salary;   // Declaring Interger  salary variable

    // Constructors
	Karyawan(String Name, String Position, int Salary){
         name = Name;
         position = Position;
         salary = Salary;
    }

    // changeName Method Declaration
	void changeName(String newValue) {
        // Set name based on object arguments
         name = newValue;
    }

    // getName Method Declaration
	String getName() {
		return name;
	}

    // changeSalary Method Declaration
    void changeSalary(int newValue) {
        // Set salary based on object arguments
         salary = newValue;
    }
   
    // getSalary Method Declaration
	int getSalary() {
		return salary;
	}

    // changePosition Method Declaration
    void changePosition(String newValue) {
        // Set position based on object arguments
         position = newValue;
    }
	// getPosition Method Declaration
    String getPosition() {
		return position;
	}

    //  printStates Method Declaration
    void printStates() {
        // Print output 
         System.out.println("Nama : " + getName() + ",  Jabatan : " + getPosition() + ",  Gaji : " + getSalary());
	}
}
