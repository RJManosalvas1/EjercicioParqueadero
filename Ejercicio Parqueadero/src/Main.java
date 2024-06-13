import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(); // Create a new parking lot instance

        while (true) {
            System.out.println("\nParqueadero Management System");
            System.out.println("1. Ingresar un carro");
            System.out.println("2. Sacar un carro");
            System.out.println("3. Ver ingresos totales");
            System.out.println("4. Ver puestos libres");
            System.out.println("5. Cambiar tarifa por hora");
            System.out.println("6. Avanzar una hora");
            System.out.println("7. Mostrar carros con placa 'PB'");
            System.out.println("8. Ver si hay carros por más de 24 horas");
            System.out.println("9. Vaciar Parqueadero");
            System.out.println("10. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = scanner.next();
                    int resultado = parqueadero.entrarCarro(placa);
                    if (resultado == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("El parqueadero está lleno.");
                    } else if (resultado == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else if (resultado == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya existe un carro con esa placa en el parqueadero.");
                    } else {
                        System.out.println("Carro ingresado en el puesto " + resultado);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la placa del carro a sacar: ");
                    placa = scanner.next();
                    int monto = parqueadero.sacarCarro(placa);
                    if (monto == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("El carro no se encuentra en el parqueadero.");
                    } else if (monto == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else {
                        System.out.println("Carro retirado. Monto a pagar: $" + monto);
                    }
                    break;
                case 3:
                    System.out.println("Ingresos totales del parqueadero: $" + parqueadero.darMontoCaja());
                    break;
                case 4:
                    System.out.println("Puestos libres: " + parqueadero.calcularPuestosLibres());
                    break;
                case 5:
                    System.out.print("Ingrese la nueva tarifa por hora: ");
                    int nuevaTarifa = scanner.nextInt();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    System.out.println("Nueva tarifa establecida: $" + nuevaTarifa);
                    break;
                case 6:
                    parqueadero.avanzarHora();
                    System.out.println("Hora actual del parqueadero: " + parqueadero.darHoraActual());
                    break;
                case 7:
                    System.out.println("Número de carros con placa que comienza con 'PB': " + parqueadero.contarCarrosQueComienzanConPlacaPB());
                    break;
                case 8:
                    if (parqueadero.hayCarroCon24Horas()) {
                        System.out.println("Hay al menos un carro que ha estado parqueado por más de 24 horas.");
                    } else {
                        System.out.println("No hay carros que hayan estado más de 24 horas.");
                    }
                    break;
                case 9:
                    int cantidadSacados = parqueadero.desocuparParqueadero();
                    System.out.println("Cantidad de carros sacados: " + cantidadSacados);
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
                    break;
            }
        }
    }
}
