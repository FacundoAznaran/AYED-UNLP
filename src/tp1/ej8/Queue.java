package tp1.ej8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    
    // Atributo: usamos List como interfaz para ser flexibles
    protected List<T> data;

    // Constructor: inicializamos la lista
    public Queue() {
        this.data = new ArrayList<T>();
    }

    // Inserta el elemento al final de la cola (índice size-1)
    public void enqueue(T dato) {
        this.data.add(dato);
    }

    // Elimina el elemento del frente (índice 0) y lo retorna
    public T dequeue() {
        return this.data.remove(0);
    }

    // Retorna el elemento del frente sin eliminarlo
    public T head() {
        return this.data.get(0);
    }

    // Retorna verdadero si no tiene elementos
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    // Retorna la cantidad de elementos
    public int size() {
        return this.data.size();
    }

    // Retorna los elementos en un String (útil para debuguear)
    @Override
    public String toString() {
        String str = "[";
        for (T temp : data) {
            str += temp.toString() + ", ";
        }
        // Un retoque para que no quede la última coma
        if (!this.isEmpty()) {
            str = str.substring(0, str.length() - 2);
        }
        return str + "]";
    }
}