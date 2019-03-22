public class GUI0205 {
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Carrey"){
            @Override
            String spiewaj(){
                return "oooooooo";
            }
        };

        Spiewak s2 = new Spiewak("Houston"){
            @Override
            String spiewaj(){
                return "a4iBBiii";
            }
        };

        Spiewak s3 = new Spiewak("Madonna"){
            @Override
            String spiewaj(){
                return "aAa";
            }
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}

abstract class Spiewak{
    static int ids = 0;
    private int id;
    private String name;

    public Spiewak(String name) {
        this.id = ++ids;
        this.name = name;
    }

    abstract String spiewaj();

    public static Spiewak najglosniej(Spiewak[] sp){
        Spiewak spiewak = new Spiewak("test"){
            @Override
            String spiewaj(){
                return "0";
            }
        };

        int highestValue = spiewak.spiewaj().length();

        for(Spiewak s : sp){
            char[] melody = s.spiewaj().toCharArray();
            char[] temp = new char[s.spiewaj().length()];

            int tempIndex = 0;
            for(int i = 0; i < s.spiewaj().length(); i++){
                if(!(new String(temp).contains(String.valueOf(melody[i])))){
                    temp[tempIndex] = melody[i];
                    tempIndex++;
                }
            }

            if(highestValue < new String(temp).trim().length()){
                highestValue = new String(temp).trim().length();
                spiewak = s;
            }
        }

        return spiewak;
    };

    public String toString(){
        return "(" + this.id + ")" + " " + this.name + ": " + this.spiewaj();
    }
}