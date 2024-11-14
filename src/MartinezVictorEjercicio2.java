import java.util.Scanner;

public class MartinezVictorEjercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String ANSI_RED = "\u001B[31m"; // Color rojo
        final String ANSI_RESET = "\u001B[0m";// Devolver color predeterminado
        String patron;
        boolean pIncorrecto;

        //Solicitar al usuario el carácter que usar como patrón
        System.out.println("Introduce un patrón:");
        do{
            patron = input.nextLine();
            pIncorrecto=patron.length()>1;
            if (pIncorrecto){
                System.out.println(ANSI_RED+"Error. Introduce 1 único carácter."+ANSI_RESET);
            }
        }while (pIncorrecto);

        //Solicitar al usuario el tamaño de la casilla (1<=size<=15)
    }
}