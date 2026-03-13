/**
 * Clase que resuelve una ecuación cuadrática de la forma:
 * ax² + bx + c = 0
 */
public class Ejercicio3 {

    /**
     * Método principal que calcula las soluciones de la ecuación cuadrática.
     * Recibe los coeficientes a, b y c.
     */
    public void calcQuadraticEq(double a, double b, double c) {

        // Calcula el discriminante de la ecuación: b² - 4ac
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            dosSoluciones(a, b, discriminante);
        } 
        else if (discriminante == 0) {
            unaSolucion(a, b);
        } 
        else {
            System.out.println("Equation has no real roots");
        }
    }

    /**
     * Calcula las dos soluciones reales de la ecuación cuadrática
     * cuando el discriminante es mayor que 0.
     */
    private void dosSoluciones(double a, double b, double discriminante) {

        
        double sqrt = Math.sqrt(discriminante);

        double x1 = (-b - sqrt) / (2 * a);
        double x2 = (-b + sqrt) / (2 * a);

        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }

    /**
     * Calcula la única solución real cuando el discriminante es 0.
     */
    private void unaSolucion(double a, double b) {

        double x = -b / (2 * a);

        System.out.println("x = " + x);
    }
}
