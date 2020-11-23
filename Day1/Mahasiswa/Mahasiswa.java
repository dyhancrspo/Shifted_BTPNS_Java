class Mahasiswa {	 
 	String name;
	String gender;
	int age;
	
	void changeName(String newValue) {
         name = newValue;
    }
	String getName() {
		return name;
	}

    void changeAge(int newValue) {
         age = newValue;
    }
	int getAge() {
		return age;
	}

    void changeGender(String newValue) {
         gender = newValue;
    }
	String getGender() {
		return gender;
	}

    void printStates() {
         System.out.println("Nama : " + getName() + ",  Umur : " + getAge() + ",  Jenis : " + getGender() );
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
