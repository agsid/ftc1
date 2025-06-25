public class car {
    String companyName;
    int milage;

    public car(String companyName, int milage){
        this.companyName = companyName;
        this.milage = milage;
    }
    public String oldOrNew(){
        if (this.milage >= 10000)  {
            return "Old";
        } 
        return "New";
    }
}
