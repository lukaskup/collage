public class Programmer{
    Language favoriteLanguage;
    int yearsOfExperience;

    Programmer(Language language, int years){
        this.favoriteLanguage = language;
        this.yearsOfExperience = years;
    }

    @Override
    public String toString(){
        return "(favoriteLanguage = " + this.favoriteLanguage.toString() +
        ", yearsOfExperience = " + this.yearsOfExperience + ")";
    }
}