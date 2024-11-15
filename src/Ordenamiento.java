import java.util.Arrays;
import java.util.Random;

public class Ordenamiento {

    // Generar arreglos con tamaños específicos usando un solo arreglo base
    public static int[][] generarArreglos(int[] tamanos) {
        Random rand = new Random();
        int maxTamaño = tamanos[tamanos.length - 1];
        int[] base = rand.ints(maxTamaño, 1, 30001).toArray();

        int[][] arreglos = new int[tamanos.length][];
        for (int i = 0; i < tamanos.length; i++) {
            arreglos[i] = Arrays.copyOfRange(base, 0, tamanos[i]);
        }
        return arreglos;
    }

    // Método Burbuja con Ajuste
    public static void burbujaConAjuste(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Método de Selección
    public static void seleccion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Método de Inserción
    public static void insercion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Método Burbuja Normal
    public static void burbujaNormal(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método Burbuja Avanzada (Optimización extra con marca de posición)
    public static void burbujaAvanzada(int[] arr) {
        int n = arr.length;
        int posUltimoCambio = n - 1; // Última posición donde se realizó un cambio
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int limite = posUltimoCambio;
            posUltimoCambio = 0;

            for (int j = 0; j < limite; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    posUltimoCambio = j; // Actualizar la posición del último cambio
                }
            }

            if (!swapped) break; 
        }
    }

    // Búsqueda binaria normal
    public static int busquedaBinaria(int[] arr, int valor) {
        int izquierda = 0, derecha = arr.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arr[medio] == valor) return medio;
            if (arr[medio] < valor) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }

    // Búsqueda binaria recursiva
    public static int busquedaBinariaRecursiva(int[] arr, int izquierda, int derecha, int valor) {
        if (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arr[medio] == valor) return medio;
            if (arr[medio] < valor) return busquedaBinariaRecursiva(arr, medio + 1, derecha, valor);
            return busquedaBinariaRecursiva(arr, izquierda, medio - 1, valor);
        }
        return -1;
    }

    // Medición del tiempo de ejecución para cada método de ordenamiento
    public static void medirTiempos(int[][] arreglos) {
        String[] metodos = {"Burbuja con Ajuste", "Selección", "Inserción", "Burbuja Normal", "Burbuja Avanzada"};
        for (String metodo : metodos) {
            System.out.println("Método " + metodo);
            for (int[] arr : arreglos) {
                int[] copia = Arrays.copyOf(arr, arr.length);
                long inicio = System.nanoTime();

                switch (metodo) {
                    case "Burbuja con Ajuste": burbujaConAjuste(copia); break;
                    case "Selección": seleccion(copia); break;
                    case "Inserción": insercion(copia); break;
                    case "Burbuja Normal": burbujaNormal(copia); break;
                    case "Burbuja Avanzada": burbujaAvanzada(copia); break;
                }

                long fin = System.nanoTime();
                System.out.println("Con " + copia.length + " valores el tiempo es de " + (fin - inicio) / 1e9 + " seg.");
            }
            System.out.println();
        }
    }
}
