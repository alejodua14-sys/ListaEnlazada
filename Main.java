public class Main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        // 🎵 Agregar canciones
        lista.insertarAlFinal("bella");
        lista.insertarAlFinal("la playa");
        lista.insertarAlFinal("Tusa");
        lista.insertarAlFinal("california");
        lista.insertarAlFinal("besos usados");

        System.out.println("Historial de canciones:");
        lista.mostrar();

        // 🔹 Eliminar primera
        System.out.println("\nEliminando primera canción...");
        lista.eliminarAlInicio();
        lista.mostrar();

        // 🔹 Buscar canción
        System.out.println("\n¿Está 'Tusa'?");
        System.out.println(lista.buscar("Tusa"));

        // 🔹 Tamaño
        System.out.println("\nTamaño de la lista: " + lista.tamanio());

        // 🔹 Obtener por índice
        System.out.println("Canción en posición 1: " + lista.obtenerPorIndice(1));

        // 🔹 Eliminar por valor
        System.out.println("\nEliminando 'Despacito'...");
        lista.eliminarPorValor("Despacito");
        lista.mostrar();

        // 🔹 Invertir lista
        System.out.println("\nLista invertida:");
        lista.invertir();
        lista.mostrar();

        // 🔹 Detectar ciclo
        System.out.println("\n¿Tiene ciclo?");
        System.out.println(lista.detectarCiclo());
    }
}