public class l20_18c_s19049{
    public static void main(String[] args){
        
    }

    class Employee{
        String name;
        int savings;
        Programmer programmer;
        Administrator administrator;

        Employee(String name, int savings, Programmer programmer, Administrator administrator){
            this.name = name;
            this.savings = savings;
            this.programmer = programmer;
            this.administrator = administrator;
        }

        @Override
        public String toString(){
            return "(name = " + this.name + ", savings = " + this.savings +
            ", programmer = " + this.programmer.toString() +
            ", administrator = " + this.administrator.toString() + ")";
        }
    }
}