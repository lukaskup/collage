import java.util.Scanner;

//i just could do it with regex smh
public class EmailValidator{

    public static boolean validateEmail(String email){
        String[] parts = email.split("@");
        if(parts.length != 2)
            return false;
        
        if(!parts[1].contains("."))
            return false;

        return true;
    }
    public static void main(String[] args){
        System.out.println("give me email to validate:");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        if(validateEmail(email))
            System.out.println("Email is valid, thank you :)");
        else
            System.out.println("Where in the hell did you get dat email from nigger");
    }
}