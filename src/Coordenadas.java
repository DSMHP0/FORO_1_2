import java.util.Scanner;

public class Coordenadas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y;
        int closestX = 0, closestY = 0, furthestX = 0, furthestY = 0;
        double closestDistance = Double.MAX_VALUE;
        double furthestDistance = 0;
        double totalDistance = 0;
        int count = 0;
        boolean pointsOnAxes = false;

        // Ingreso de múltiples coordenadas hasta leer 0 0
        while (true) {
            // Leer el siguiente par de coordenadas
            System.out.print("Ingresa las coordenadas (x y): ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            // Verificar si la entrada es 0 0, caso de salida
            if (x == 0 && y == 0) {
                break;
            }

            // Ignorar los puntos en el tercer cuadrante
            if (x < 0 && y < 0) {
                continue;
            }

            // Calcular la distancia al origen
            double distance = Math.sqrt(x * x + y * y);
            totalDistance += distance;
            count++;

            // Verificar si el punto está en algún eje
            if (x == 0 || y == 0) {
                pointsOnAxes = true;
            }

            // Actualizar el punto más cercano al origen
            if (distance < closestDistance) {
                closestDistance = distance;
                closestX = x;
                closestY = y;
            }

            // Actualizar el punto más lejano al origen
            if (distance > furthestDistance) {
                furthestDistance = distance;
                furthestX = x;
                furthestY = y;
            }
        }

        // Mostrar los resultados
        if (count > 0) {
            System.out.println("Closest to origin: " + closestX + " " + closestY);
            System.out.println("Furthest to origin: " + furthestX + " " + furthestY);
            System.out.println("Average distance to origin: " + (totalDistance / count));
        } else {
            System.out.println("No valid points were entered.");
        }

        // Mostrar si hubo puntos en los ejes
        if (pointsOnAxes) {
            System.out.println("There were points on the axes.");
        } else {
            System.out.println("There were no points on the axes.");
        }

        scanner.close();
    }
}
