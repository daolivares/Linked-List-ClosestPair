import java.io.IOException;

/**
 * Algoritmo y complejidad          20/11/22
 * @author Daniel
 *
 * En esta clase se crean los objetos de los algoritmos implementados para obtener las comprobaciones y
 * el tiempo de ejecucion en cada tamaño
 *
 */

public class Launcher {

    public static void main(String[] args) throws IOException {
        Closest_Pair in = new Closest_Pair();
        int n = (int) Math.pow(2, 4);
        int d = 5;
        Writer w = new Writer("comprobaciones.txt");
        while (n <= Math.pow(2, 17)) {
            double time = 0;
            int comprobaciones = 0;
            int i;
            for(i = 0; i < 150; i++) {
                ListaEnlazada coords = in.createCoordinates(n);
                coords.display();
                coords.sortList();
                coords.display();
                int start = (int) System.nanoTime();
                in.divideAndConquer(coords);
                int end = (int) System.nanoTime();
                time = time + (end - start);
            }
            time /= i;
            comprobaciones = n;
            w.write(n + " " + time + " " + comprobaciones);
            System.out.println(n + " " + time + " " + comprobaciones);
            d++;
            n = (int) Math.pow(2, d);
        }


    }

}
