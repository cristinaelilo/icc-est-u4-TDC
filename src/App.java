import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] tamanos = {10, 100, 1000, 5000, 10000, 30000};
        int[][] arreglos = Ordenamiento.generarArreglos(tamanos);
        int[] valoresBusqueda = {9, 98, 957, 4000, 9876, 29475};

        // Insertar valores de búsqueda en los arreglos generados
        for (int i = 0; i < tamanos.length; i++) {
            if (valoresBusqueda[i] < arreglos[i].length) {
                arreglos[i][0] = valoresBusqueda[i];
            }
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 5 métodos");
            System.out.println("3. Buscar valores (búsqueda binaria normal y recursiva)");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    arreglos = Ordenamiento.generarArreglos(tamanos);
                    System.out.println("Arreglos generados exitosamente.");
                    break;
                case 2:
                    Ordenamiento.medirTiempos(arreglos);
                    break;
                case 3:
                    for (int i = 0; i < tamanos.length; i++) {
                        int[] arreglo = Arrays.copyOf(arreglos[i], arreglos[i].length);
                        Arrays.sort(arreglo); // Ordenar para aplicar búsqueda binaria
                        int valor = valoresBusqueda[i];

                        long inicioNormal = System.nanoTime();
                        int resultadoNormal = Ordenamiento.busquedaBinaria(arreglo, valor);
                        long finNormal = System.nanoTime();
                        System.out.printf("Arreglo %d, valor %d: Búsqueda binaria normal tiempo = %.9f seg.\n",
                                          tamanos[i], valor, (finNormal - inicioNormal) / 1e9);

                        long inicioRecursiva = System.nanoTime();
                        int resultadoRecursiva = Ordenamiento.busquedaBinariaRecursiva(arreglo, 0, arreglo.length - 1, valor);
                        long finRecursiva = System.nanoTime();
                        System.out.printf("Arreglo %d, valor %d: Búsqueda binaria recursiva tiempo = %.9f seg.\n",
                                          tamanos[i], valor, (finRecursiva - inicioRecursiva) / 1e9);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close(); 
    }
}

