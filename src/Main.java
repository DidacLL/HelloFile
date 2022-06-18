
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var andy= new Person("   AndY ANderson   ", 28);
        var dwight= new Person("   AndY ANderson   ", 29);
        //Override equals()
        System.out.println(andy.equals(dwight)?"SAME!":"DIFFERENT!");
        //robotTalk();


    }

    private static void robotTalk() {
        System.out.println("Hello friend. \nWhat's your name?");
        //creamos un objeto scanner
        Scanner scanner = new Scanner(System.in);
        //usamos el objeto scanner y lo parse a input
        String input = scanner.nextLine();
        if (input.toLowerCase().equals(" ")){
            System.out.println("I don't like you "+ input);
        }else{
            System.out.println("Hello " + input);
        }
        int age;
        do{
            System.out.println("How old are you? ;) ");
            try{age = scanner.nextInt();}
            catch(Exception e){
                age=0;
                scanner=new Scanner(System.in);
            }
            if (age < 18) {
               // System.err.println("You are very young!"); //err. sirve para que salga en rojo y prevalece con out y sale primero
                System.err.println("Acces denied.");
            }else{
                System.out.println("You can join my friends club.");
            }
        }while(age<18);
        scanner = new Scanner(System.in);
        System.out.println("What's your favourite colour?");
        switch (scanner.nextLine().trim().toUpperCase()){
            case "RED" -> {
                System.out.println("Fire walks with me");
            }
            case "BLUE" -> {
                System.out.println("blue like a sea!");
            }
            case "GREEN" -> {
                System.out.println("Money man! ");
            }
            case "YELLOW" -> {
                System.out.println("Moliere hates you");
            }
            case "BLACK" -> {
                System.out.println("Why so serious?");
            }
            default -> System.out.println("Oh you are so original");
        }
    }
}