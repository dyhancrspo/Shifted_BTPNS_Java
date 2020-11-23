public class MyDate {
    private int day = 1;
    private int month = 1;
    private int year = 2000;
    	
 	public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public MyDate(MyDate date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public MyDate addDays(int moreDays) {
        MyDate newDate = new MyDate(this);
         	newDate.day = newDate.day + moreDays;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }
    
    public MyDate minDays(int lastDays) {
        MyDate newDate = new MyDate(this);
         	newDate.day = newDate.day - lastDays;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }
    public MyDate addMonths(int moreMonths) {
        MyDate newDate = new MyDate(this);
         	newDate.month = newDate.month + moreMonths;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }
    public MyDate minMonths(int lastMonth) {
        MyDate newDate = new MyDate(this);
         	newDate.month = newDate.month - lastMonth;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }
    public MyDate addYears(int moreYears) {
        MyDate newDate = new MyDate(this);
         	newDate.year = newDate.year + moreYears;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }
    public MyDate minYears(int lastYear) {
        MyDate newDate = new MyDate(this);
         	newDate.year = newDate.year - lastYear;
         	// Not Yet Implemented: wrap around code...
         	return newDate;
    }

    public void setDay(int day){
        this.day = day;
    }

    public String toString() {
        String retString = "" + day + "-" + month + "-" + year;
     		return retString;
     	}
}
