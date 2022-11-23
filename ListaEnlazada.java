/**
 * Codigo obtenido de la clase de Estructuras Discretas en el periodo 2021-30
 * Referencia en GitHub:
 * https://github.com/JoaoRacedo/Estructura_Datos_1/blob/main/Clase_5_1/src/SinglyLinkedList2.java
 * */

public class ListaEnlazada {
    Node head = null;
    Node tail = null;

    static class Node {
        //Attributes
        Coord data;
        Node next;

        //Constructor
        public Node(Coord d) {
            this.data = d;
            this.next = null;
        }
    }


    //addNode() will add a new node to the singly linked list
    public void addNode(Coord data){
        //reate a new node
        Node P = new Node(data);

        // to check if the list is empty
        if(head == null){
            // if the list is empty, the new node P will both head and tail
            head = P;
            tail = P;
        }else{
            // the new node P will be added after the tail such that tail's next will now point to P
            tail.next = P;
            // the new node P will become the tail of the list
            tail = P;
        }
    }


    public Node get(int index){
        Node result = null;
        Node current = this.head;
        int i = 0;
        while(current != null){
            if(i == index){
                return current;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    public void display() {
        Node P = this.head;

        if(P == null){
            System.out.println("The list is empty");
            return;
        }

        while (P != null) {
            System.out.print(P.data.toString() + " -> ");
            P = P.next;
        }
        System.out.print("null\n");
    }


    public ListaEnlazada sublist(int inicio, int fin){
        ListaEnlazada result = new ListaEnlazada();
        int i = 0;
        Node current = this.head;
        while(current != null){
            if(i >= inicio){
                result.addNode(current.data);
            }
            if(i == fin){
                break;
            }
            i++;
            current = current.next;
        }
        return result;
    }

    /*
        Funcion que usa el metgodo para organizar las coordenadas
        Referencias: https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/
     */

    // sortList() will sort nodes of the list in ascending order
    public void sortList(){
        // Node current will point to head
        Node current = head, index = null;
        Coord temp;
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the databetween them
                    if (current.data.getX() > index.data.getX()) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public int countNumNodes(){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

}