public class ListaEnlazada {

    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Insertar al inicio
    public void insertarAlInicio(String dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamanio++;
    }

    // Insertar al final
    public void insertarAlFinal(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            tamanio++;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null)
            actual = actual.siguiente;

        actual.siguiente = nuevo;
        tamanio++;
    }

    // Eliminar al inicio
    public String eliminarAlInicio() {
        if (cabeza == null) return null;

        String dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamanio--;
        return dato;
    }

    // Buscar
    public boolean buscar(String dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato))
                return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Mostrar
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // 🔹 E2.1 tamanio()
    public int tamanio() {
        return tamanio;
    }

    // 🔹 E2.2 obtenerPorIndice()
    public String obtenerPorIndice(int i) {
        if (i < 0 || i >= tamanio)
            throw new IndexOutOfBoundsException("Índice inválido");

        Nodo actual = cabeza;
        int contador = 0;

        while (contador < i) {
            actual = actual.siguiente;
            contador++;
        }

        return actual.dato;
    }

    // 🔹 E2.3 eliminarPorValor()
    public boolean eliminarPorValor(String dato) {
        if (cabeza == null) return false;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    // 🔹 E2.4 invertir()
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // 🔹 E2.6 detectarCiclo (Floyd)
    public boolean detectarCiclo() {
        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido)
                return true;
        }

        return false;
    }
}