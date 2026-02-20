import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ServicioAPI servicio = new ServicioAPI();
        ModeloRespuesta datos = servicio.obtenerTasas();

        if (datos == null) {
            System.out.println("No se pudieron obtener las tasas.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== CONVERSOR DE MONEDAS ===");
            System.out.println("1. USD → COP");
            System.out.println("2. USD → EUR");
            System.out.println("3. USD → MXN");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 4) {
                System.out.println("Gracias por usar el conversor");
                break;
            }

            System.out.print("Ingrese la cantidad en USD: ");
            double cantidad = scanner.nextDouble();

            String monedaDestino = "";

            switch (opcion) {
                case 1:
                    monedaDestino = "COP";
                    break;
                case 2:
                    monedaDestino = "EUR";
                    break;
                case 3:
                    monedaDestino = "MXN";
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            double tasa = datos.getConversion_rates().get(monedaDestino);
            double resultado = convertir(cantidad, tasa);

            System.out.println("Resultado: " + resultado + " " + monedaDestino);

        } while (opcion != 4);

        scanner.close();
    }

    public static double convertir(double cantidad, double tasa) {
        return cantidad * tasa;
    }
}
