public class Administrator{
    OS favoriteOperationgSystem;
    boolean isWorkingNow;

    Administrator(OS os, boolean isWorkingNow){
        this.favoriteOperationgSystem = os;
        this.isWorkingNow = isWorkingNow;
    }

    @Override
    public String toString(){
        return "(favoriteOperationgSystem = " + this.favoriteOperationgSystem.toString() + ", isWorkingNow = " + this.isWorkingNow + ")";
    }
}