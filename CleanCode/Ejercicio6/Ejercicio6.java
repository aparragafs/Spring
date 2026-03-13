package Ejercicio6;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {

    private static final int LONGITUD_SECUENCIA = 4;
    private static final int MAX_INTENTOS = 10;

    private static final String[] COLORES = {"AZUL", "ROJO", "VERDE", "AMARILLO"};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        List<String> secuenciaSecreta = generarSecuenciaSecreta();
        Scanner scanner = new Scanner(System.in);

        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {

            System.out.println("Intento " + intento);
            List<String> intentoJugador = leerIntento(scanner);

            Resultado6 resultado = evaluarIntento(secuenciaSecreta, intentoJugador);

            System.out.println("Blancas: " + resultado.blancas + " Negras: " + resultado.negras);

            if (resultado.blancas == LONGITUD_SECUENCIA) {
                System.out.println("¡Has ganado en el intento " + intento + "!");
                return;
            }
        }

        System.out.println("Has perdido. La secuencia era: " + secuenciaSecreta);
    }

    /**
     * Genera la secuencia secreta de colores.
     */
    private static List<String> generarSecuenciaSecreta() {

        List<String> secuencia = new ArrayList<>();

        for (int i = 0; i < LONGITUD_SECUENCIA; i++) {
            secuencia.add(COLORES[RANDOM.nextInt(COLORES.length)]);
        }

        return secuencia;
    }

    /**
     * Lee el intento del jugador.
     */
    private static List<String> leerIntento(Scanner scanner) {

        List<String> intento = new ArrayList<>();

        System.out.println("Introduce 4 colores (AZUL ROJO VERDE AMARILLO):");

        for (int i = 0; i < LONGITUD_SECUENCIA; i++) {
            intento.add(scanner.next().toUpperCase());
        }

        return intento;
    }

    /**
     * Evalúa el intento del jugador comparándolo con la secuencia secreta.
     */
    private static Resultado6 evaluarIntento(List<String> secuencia, List<String> intento) {

        int blancas = 0;
        int negras = 0;

        List<String> copiaSecuencia = new ArrayList<>(secuencia);
        List<String> copiaIntento = new ArrayList<>(intento);

        // Primero contar blancas (color correcto en posición correcta)
        for (int i = 0; i < LONGITUD_SECUENCIA; i++) {

            if (intento.get(i).equals(secuencia.get(i))) {
                blancas++;

                copiaSecuencia.set(i, null);
                copiaIntento.set(i, null);
            }
        }

        // Después contar negras (color correcto en posición incorrecta)
        for (int i = 0; i < LONGITUD_SECUENCIA; i++) {

            if (copiaIntento.get(i) != null && copiaSecuencia.contains(copiaIntento.get(i))) {
                negras++;

                copiaSecuencia.set(copiaSecuencia.indexOf(copiaIntento.get(i)), null);
            }
        }

        return new Resultado6(blancas, negras);
    }

    
}
