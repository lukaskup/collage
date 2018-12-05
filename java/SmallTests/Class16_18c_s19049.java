
/**
* @author s19049
* @group 18c
* @blockchainHash 42bc4fd79496183420262473712b1cde5dca7724b0f615e3ece77df23bf0a5a6
*/
public class Class16_18c_s19049 {
    public static void main(String[] args) {
        
        int amountOfHorcruxes = 8;
        Voldemort youKnowWho = new Voldemort(amountOfHorcruxes);

        String name = "Harry";
        String familyName = "Potter";
        RegularPerson harry = youKnowWho.killLily(name, familyName);

        Dumbledore albus = new Dumbledore();
        Wizard harryWizard = albus.youAreWizard(harry);

        while (youKnowWho.isAlive()) {
            harryWizard.destroyHorcruxOf(youKnowWho);
            harryWizard.tryToDefeat(youKnowWho); // Success, if Voldemort has no Horcruxes
        }

        System.out.println("Happy ending");

    }

}

// tip: start here
class Voldemort{
    int amountOfHorcruxes;

    Voldemort(int amountOfHorcruxes){
        this.amountOfHorcruxes = amountOfHorcruxes;
    }

    RegularPerson killLily(String name, String familyName){
        System.out.println("Roses are red, violets are blue, lily is dead, so my soul too :,C :,C :,C :,C");
        return new RegularPerson(name, familyName);
    }

    boolean isAlive(){
        if(amountOfHorcruxes != 0)
            return true;
        else
            return false;
    }
}

class RegularPerson{
    String name;
    String familyName;

    RegularPerson(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
    }
}

class Dumbledore{
    Wizard youAreWizard(RegularPerson person){
        return new Wizard(person);
    }
}

class Wizard{

    RegularPerson person;

    Wizard(RegularPerson person){
        this.person = person;
    }

    void destroyHorcruxOf(Voldemort enemy){
        enemy.amountOfHorcruxes -= 1;
    }

    void tryToDefeat(Voldemort enemy){
        if(enemy.amountOfHorcruxes == 0){
            System.out.println("Success");
        }else{
            System.out.println("Just destroyed one Horcruxes but he's still alive");
        }
    }
}