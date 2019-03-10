public class GUI0203 {

    public static void main(String[] args) {

        Musician[] muzycy = {new Violinist("Aleks", 2),    // name, time wystapienia (w godz.)
                new Cellist("Bartek", 1),
                new Flutist("Czarek", 0.5)};
        for (Musician m : muzycy)
            System.out.println("Musician: " + m.name() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "time performing: " + m.time() + " h. " + '\n' +
                    "hour wage: " + m.wage() + '\n');

        System.out.println(Musician.maxFee(muzycy));
    }
}

abstract class Musician{
    public String name;
    public double time;
    public double wage;
    public String instrument;

    Musician(String name, double time, double wage, String instrument){
        this.name = name;
        this.time = time;
        this.wage = wage;
        this.instrument = instrument;
    }

    public String name(){
        return this.name;
    }

    public String instrument(){
        return this.instrument;
    }

    public double time(){
        return this.time;
    }

    public double wage(){
        return this.wage;
    }

    static String maxFee(Musician[] muzycy){
        double maxFee = 0;
        String currentName = "";
        double currentHours = 0;
        double currentPay = 0;
        for (Musician m : muzycy){
            if(m.wage() * m.time() > maxFee){
                maxFee = m.wage() * m.time();
                currentName = m.name();
                currentHours = m.time();
                currentPay = m.wage();
            }
        }
        return currentName + ", time = " + currentHours + " h. , wage = " + currentPay;
    }
}

class Violinist extends Musician{
    Violinist(String name, double time){
        super(name, time, 200, "violin");
    }
}

class Cellist extends Musician{
    Cellist(String name, double time){
        super(name, time, 250, "cell");
    }
}

class Flutist extends Musician{
    Flutist(String name, double time){
        super(name, time, 300, "flute");
    }
}