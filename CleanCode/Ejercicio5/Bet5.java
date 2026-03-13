package Ejercicio5;
import java.util.List;
/**
 * Clase que representa una apuesta de Euromillones.
 */
public class Bet5 {
    private final List<Integer> mainNumbers;
    private final List<Integer> stars;

    public Bet5(List<Integer> mainNumbers, List<Integer> stars) {
        this.mainNumbers = mainNumbers;
        this.stars = stars;
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public List<Integer> getStars() {
        return stars;
    }
}
