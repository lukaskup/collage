public class ClassesTest {
    public static void main(String[] args){
        String name = "Tony";
        String familyName = "Stark";
        RegularPerson tony  = new RegularPerson(name, familyName);
        tony.showName();
        Billionaire tonyStark = new Billionaire(tony);
        System.out.println(tonyStark.money);
        tonyStark.setMoney(1000001);
        System.out.println(tonyStark.money);
    }
}

class RegularPerson{
    String name;
    String familyName;

    RegularPerson(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
    }

    void showName(){
        System.out.println(this.name + " " + this.familyName);
    } 
}

class Billionaire{
    RegularPerson person;
    int money;
    boolean inDanger;

    Billionaire(RegularPerson person){
        this.person = person;
        this.inDanger = false;
    }

    void setMoney(int money){
        this.money = money;
    }
}

class Enemy{
    Billionaire billionaire;
    String name;

    Enemy(String name){
        this.name = name;
    }

    void makeEvil(){
        System.out.ptinln("I'm " + this.name + " !!!");
    }

    void attack(){
        int isSuccessful = (int)(Math.random() + 0.5);
        if(isSuccessful == 1){
            billionaire.inDanger = true;
        }
    }
}