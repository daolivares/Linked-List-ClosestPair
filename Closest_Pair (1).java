import java.util.*;

public class Closest_Pair {

    private ListaEnlazada closestCoord;
    private Coord firstCoord, secondCoord;


    public Closest_Pair(){
        closestCoord = new ListaEnlazada();
    }

    /* Funcion que crea las coordenadas */
    public ListaEnlazada createCoordinates(int tamaño){
        ListaEnlazada coords = new ListaEnlazada();
        Random rand = new Random();
        for(int i = 0; i < tamaño; i++){
            int y = rand.nextInt(20);
            if(i < tamaño/2){
                int x = rand.nextInt(25) / 2;
                coords.addNode(new Coord(x, y));
                continue;
            }
            int x = rand.nextInt(25) + 12;
            coords.addNode(new Coord(x,y));
        }
        return coords;
    }

    /* Funcion que implementa algoritmo fuerza bruta */
    public void brutalForce(ListaEnlazada coords){
        double d_min = 99999999;
        int n = coords.countNumNodes();
        double distance;

        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                distance = coords.get(i).data.getDistance(coords.get(j).data);
                if(distance < d_min){
                    firstCoord = coords.get(i).data;
                    secondCoord = coords.get(j).data;
                    d_min = distance;
                }
            }
        }
    }

    /* Funcion que implementa algoritmo divide y venceras */
    public void divideAndConquer(ListaEnlazada coords) {
        //creating Lx and Rx
        ListaEnlazada Lx;
        ListaEnlazada Rx;

        /**
            creating Px: sorting dataset primarily with x and secondarily with y (Px)
         */

        ListaEnlazada Px = coords;
        int size = Px.countNumNodes();

        Lx = Px.sublist(0, size / 2 - 1) ;
        Rx = Px.sublist(size / 2, size);

        //list created just to iterate between List
        size = Lx.countNumNodes();
        if(size <= 3){
            brutalForce(Lx);
            closestCoord.addNode(firstCoord);
            closestCoord.addNode(secondCoord);
        }else{
            divideAndConquer(Lx);
        }

        size = Rx.countNumNodes();
        if(size <= 3){
            brutalForce(Rx);
            closestCoord.addNode(firstCoord);
            closestCoord.addNode(secondCoord);
        }else{
            divideAndConquer(Rx);
        }
    }

}
