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
        boolean[][]chess; //Array2D que almacena la estructura del tablerp
        final int BOARDSIZE = 8;


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

        // Generamos el tablero: (false-->casilla blanca | true-->casilla negra)
        chess = new boolean[BOARDSIZE][BOARDSIZE]; //Formamos el Array2D
        boolean white=false; //La primera casilla, será blanca
        //Bucle que altera entre true y false en cada casilla del tablero:
        for (int row=0; row < chess.length;++row){
            for (int col=0; col<chess[0].length; ++col) {
                chess[row][col]=white;
                white=!white; //la siguente casilla será el inverso de esta
            }
        }

        //Imprime el tablero (provisional)
        for (boolean[] x:chess){
            for (boolean y: x){
                if (y){
                    System.out.print(pattern);
                }else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }

    }
}