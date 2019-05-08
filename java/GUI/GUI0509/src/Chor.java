public class Chor{

    String repertuar;
    Thread[] spiewacy;

    Chor(String repertuar){
        this.repertuar = repertuar;

        this.spiewacy = new Thread[repertuar.length()];

        for(int i = 0; i < this.repertuar.length(); i++){
            String name = String.valueOf(repertuar.charAt(i));
            this.spiewacy[i] = new Spiewak("Spiewak " + name) {
                String spiewaj() {
                    return name;
                }
            };
        }
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < repertuar.length(); i++){
            s += this.spiewacy[i] + "\n";
        }

        return s;
    }

    public Thread[] getThreads(){
        return this.spiewacy;
    }

}
