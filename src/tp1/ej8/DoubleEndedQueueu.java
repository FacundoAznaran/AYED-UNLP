package tp1.ej8;

public class DoubleEndedQueueu<T> extends Queue<T> {

    // Permite encolar al inicio (prioridad)
    public void enqueueFirst(T dato) {
        // Accedemos a 'data' porque en la clase padre lo pusimos como protected
        this.data.add(0, dato);
    }
}