public class Main{
    public static void main(String[] Args){
        Language language = new Language("javascript");
        Programmer programmer = new Programmer(language, 2);
        OS os = new OS("Windows", 10);
        Administrator administrator = new Administrator(os, false);
        Employee employee  = new Employee("Lukasz Skup", 0, programmer, administrator);

        System.out.print(employee.toString());
    }
}