import java.util.Scanner;

public class MartinezVictorEjercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String ANSI_RED = "\u001B[31m"; // Color rojo
        final String ANSI_RESET = "\u001B[0m";// Devolver color predeterminado
        String pattern; // Almacena el carácter que introduce el usuario.
        //He decidido almacenar el carácter en un tipo String en vez de tipo char,
        // debido a que el usuario puede introducir valores inválidos, que no pueden ser almacenados en tipo char
        boolean patternErr; // Variable que comprueba errores en el input del usuario
        int size; // Tamaño que tendrá cada casilla del tablero
        // Constantes delimitando el rango del tamaño del tablero
        final int MIN_SIZE =1;
        final int MAX_SIZE = 15;
        boolean[][]chess; // Array2D que almacena la estructura del tablerp
        boolean black; // Variable utilizada para crear el tablero
        final int BOARD_SIZE = 8; // Constante que determina el tamaño del tablero


        // Solicitar al usuario el carácter que utilizar como patrón:
        System.out.println("Introduce un patrón:");
        do{
            pattern = input.nextLine();
            patternErr=pattern.length()>1||pattern.isBlank(); // Boolean que comprueba si el input es válido (El input ha de ser 1 carácter)
            // Utilizamos esta boolean para imprimir el mensaje de error y repetir el bucle
            if (patternErr){
                System.out.println(ANSI_RED+"Error. Introduce 1 único carácter."+ANSI_RESET); // Mensaje de error
            }
        }while (patternErr);

        // Solicitar al usuario el tamaño de las casillas:
        System.out.println("Tamaño de las casillas ("+MIN_SIZE+"-"+MAX_SIZE+"):");
        do { // Bucle de validación de input del usuario
            if (input.hasNextInt()) { // Validamos si el input es un entero
                size = input.nextInt(); // Si és un entero, podemos almacenarlo en la variable size para continuar comprobándolo
                if (size >= MIN_SIZE&&size<=MAX_SIZE) { // El tamaño ha de estar dentro del rango
                    input.nextLine(); // Limpiamos el búfer
                    break; // Rompe el bucle
                }
            }
            System.out.println(ANSI_RED+"Error. Introduce un número entre "+MIN_SIZE+" y "+MAX_SIZE+ANSI_RESET); // Mensaje de error
            input.nextLine(); //Limpiamos el búfer
        } while (true);

        // Generamos el tablero:
        chess = new boolean[BOARD_SIZE][BOARD_SIZE]; // Utilizaremos un Array2D donde: (false-->casilla blanca | true-->casilla negra)
        black= false; // La primera casilla será blanca

        // Bucle que itera entre true y false en cada casilla del tablero:
        for (int row=0; row < chess.length;++row){//Bucle que itera entre las filas del Array 2D
            for (int col=0; col<chess[0].length; ++col) { //Bucle que itera entre los carácteres en cada fila, corresponde a las columnas de Array2D
                chess[row][col]=black;
                black=!black; // La siguente casilla será el inverso de esta
            }
            black=!black;// La siguiente fila, comienza por el color que finaliza la última casilla de la fila anterior, así que volveremos a invertir el valor
        }

        // Imprimir tablero por pantalla:
        for (boolean[] x:chess){ // El primer bucle foreach, accede a las filas del Array2D, que almacenará en x
            // Para separar cada fila, utilizamos una barra formada de guiones, con un guión '-' por carácter en la fila
            // Sabemos cuantos carácteres tiene la fila, multiplicando el tamaño de la tabla(BOARD_SIZE) por el tamaño del patrón
            // Además de los carácteres del patrón, tenemos 1 separador por tamaño de la tabla. Al valor total le agregamos 1, para el último separador
            for (int i=0;i<BOARD_SIZE*(size+1)+1;i++){
                System.out.print('-');
            }
            System.out.println(); // Salto de línea al finalizar la línea
            for(int k=0;k<size;k++){ // Bucle que repite una misma fila las veces especificadas por size
                for (boolean y:x) { // Creamos otro bucle foreach, que acceda a los carácteres dentro de los array x de las filas del primer Array2D
                    System.out.print('|'); //Separador de cada casilla, independiente del tamaño de las casillas
                    for (int j = 0; j < size; j++) { // Bucle que repite el carácter el número especificado por size
                        if (y) { // Si la casilla en el array es y=true, imprimiremos el carácter
                            System.out.print(pattern);
                        } else { // Sinó, imprimimos un espacio en blanco
                            System.out.print(' ');
                        }
                    }
                }
                System.out.print("|\n"); // Final de línea. Añadimos un separador adicional y hacemos un salto de línea con \n
            }
        }
        // Separador de guiones
        for (int i=0;i<BOARD_SIZE*(size+1)+1;i++) {
            System.out.print('-');
        }
    }
}
