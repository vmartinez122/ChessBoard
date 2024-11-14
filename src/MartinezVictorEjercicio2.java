import java.util.Scanner;

public class MartinezVictorEjercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String ANSI_RED = "\u001B[31m"; // Color rojo
        final String ANSI_RESET = "\u001B[0m";// Devolver color predeterminado
        String pattern;
        boolean patternErr;
        int size;
        final int MIN_SIZE =1;
        final int MAX_SIZE = 15;

        //Solicitar al usuario el carácter que usar como patrón
        System.out.println("Introduce un patrón:");
        do{
            pattern = input.nextLine();
            patternErr=pattern.length()>1;
            if (patternErr){
                System.out.println(ANSI_RED+"Error. Introduce 1 único carácter."+ANSI_RESET); // Mensaje de error
            }
        }while (patternErr);

        //Solicitar al usuario el tamaño de la casilla (1<=size<=15)
        System.out.println("Tamaño de las casillas ("+MIN_SIZE+"-"+MAX_SIZE+"):");
        do {
            if (input.hasNextInt()) {
                size = input.nextInt();
                if (size >= MIN_SIZE&&size<=MAX_SIZE) {
                    input.nextLine(); //Limpiamos el búfer
                    break;
                }
            }
            System.out.println(ANSI_RED+"Error. Introduce un número entre "+MIN_SIZE+" y "+MAX_SIZE+ANSI_RESET); // Mensaje de error
            input.nextLine(); //Limpiamos el búfer
        } while (true);

        System.out.println(pattern+size);

    }
}