public abstract class Spiewak extends Thread{
    static int ids = 0;
    private int id;
    private String name;

    public Spiewak(String name) {
        this.id = ++ids;
        this.name = name;

        this.setName(name);
    }

    abstract String spiewaj();

    public void run(){
        try{
            while(true) {
                for (int i = 1; i <= this.id; i++) {
                    if (Math.random() < 0.5) {
                        System.out.print(this.spiewaj().toUpperCase());
                    } else {
                        System.out.print(this.spiewaj().toLowerCase());
                    }
                    this.sleep(2000);
                }
            }
        }catch(InterruptedException exeption){
            System.out.println(exeption.getLocalizedMessage());
        }

    }

    public String toString(){
        return "Spiewak " + this.name;
    }
}