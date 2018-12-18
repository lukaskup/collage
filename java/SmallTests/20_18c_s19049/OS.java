public class OS{
    String name;
    int version;

    OS(String name, int version){
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString(){
        return "(name = " + this.name + ", version = " + this.version + ")";
    }
}