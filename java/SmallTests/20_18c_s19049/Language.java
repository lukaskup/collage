public class Language{
    String name;

    Language(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "(name = " + this.name + ")";
    }
}