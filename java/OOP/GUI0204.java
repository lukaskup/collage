public class GUI0204 {

    public static void main(String[] args) {

        Reversible[] revers = new Reversible[] {
                new ReversibleString("Kot2019"),
                new ReversibleInt(2),
                new ReversibleInt(3),
                new ReversibleString("Pies"),
                new ReversibleString("Ala ma kota i psa"),
                new ReversibleInt(10)
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        for (Reversible r : revers) {
            r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
            r.reverse();
            if(r.getClass().getName() == "ReversibleString"){
                System.out.println("Tekst " + r);
            }else{
                System.out.println(Integer.parseInt(r.toString()) + 10);
            }
        }
    }
}

interface Reversible<T>{
    public T reverse();
}

class ReversibleString implements Reversible{

    public String value;

    ReversibleString(String value){
        this.value = value;
    }

    @java.lang.Override
    public Reversible reverse() {
        char valueStr[] = this.value.toCharArray();
        String newValue = "";
        for(int i = 0; i < valueStr.length; i++){
            if(Character.isUpperCase(valueStr[i])){
                newValue += Character.toString(valueStr[i]).toLowerCase();
            }else{
                newValue += Character.toString(valueStr[i]).toUpperCase();
            }
        }
        this.value = newValue;
        return null;
    }

    public String toString() {
        return this.value;
    }
}

class ReversibleInt implements Reversible{

    public int value;

    ReversibleInt(int value){
        this.value = value;
    }

    @java.lang.Override
    public Reversible reverse() {
        this.value *= -1;
        return null;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}