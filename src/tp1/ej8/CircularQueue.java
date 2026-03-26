package tp1.ej8;

public class CircularQueue<T> extends Queue<T> {

    // El shift hace la magia de la rotación
    public T shift() {
        // 1. Sacamos el elemento del frente (usamos el dequeue de la clase padre)
        T dato = this.dequeue();
        
        // 2. Lo volvemos a meter al final (usamos el enqueue de la clase padre)
        this.enqueue(dato);
        
        // 3. Retornamos el elemento que movimos
        return dato;
    }
}