package practice_5_personas;

public class fecha {
    private int day;
    private int mounth;
    private int year;

    //Construcutor 
    
    public fecha() {
    }

    public fecha(int day, int mounth, int year) {
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }

    
    //SETTERS AND GETTERS
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMounth() {
        return mounth;
    }

    public void setMounth(int mounth) {
        if(mounth >0 && mounth <13){
            this.mounth = mounth;
        }
        else{
            System.out.println("No valid data");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
