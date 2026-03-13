package Ejercicio5;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Ejercicio5 {

    private static final int MAIN_MIN = 1;
    private static final int MAIN_MAX = 50;
    private static final int STAR_MIN = 1;
    private static final int STAR_MAX = 12;
    private static final int MAIN_COUNT = 5;
    private static final int STAR_COUNT = 2;

    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        Bet5 bet = generateEuromillionsBet();
        System.out.println("Apuesta generada:");
        System.out.println("Números:  " + bet.getMainNumbers());
        System.out.println("Estrellas: " + bet.getStars());
    }

    /**
     * Genera una apuesta válida de Euromillones:
     * 5 números principales y 2 estrellas, todos únicos.
     */
    public static Bet5 generateEuromillionsBet() {
        List<Integer> mainNumbers = generateUniqueRandomNumbers(MAIN_COUNT, MAIN_MIN, MAIN_MAX);
        List<Integer> stars = generateUniqueRandomNumbers(STAR_COUNT, STAR_MIN, STAR_MAX);
        return new Bet5(mainNumbers, stars);
    }

    /**
     * Genera una lista de números aleatorios únicos dentro de un rango,
     * y los devuelve ordenados.
     */
    private static List<Integer> generateUniqueRandomNumbers(int quantity, int min, int max) {
    
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < quantity) {
            int number = RANDOM.nextInt(max - min + 1) + min;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        
        return numbers;
    }
}


