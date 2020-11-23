public abstract class Student implements Comparable{
    int id;
    String nama;
    int nilai;
    
    public abstract void setId(int id);

    public abstract int getId();
    
    public abstract void setNama(String nama);
    
    public abstract String getNama();



    @Override
    public abstract int compareTo(Object o); 

}