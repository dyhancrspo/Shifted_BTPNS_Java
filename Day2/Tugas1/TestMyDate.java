public class TestMyDate {
    public static void main(String[] args) {
		MyDate myBirth = new MyDate(22, 7, 1964);
		MyDate theNextDay = myBirth.addDays(7);
		MyDate theNextMonth = myBirth.addMonths(1);
		MyDate theNextYear = myBirth.addYears(2);
		MyDate theLastDay = myBirth.minDays(2);
		MyDate theLastMonth = myBirth.minMonths(1);
		MyDate theLastYeat = myBirth.minYears(2);
	
		
		System.out.println(myBirth);
		System.out.println("");
		System.out.println(theNextDay);
		System.out.println(theNextMonth);
		System.out.println(theNextYear);
		System.out.println("");
		System.out.println(theLastDay);
		System.out.println(theLastMonth);
		System.out.println(theLastYeat);
	}
}      
