package vista;

import java.util.List;
import java.util.Scanner;
import Controlador.*;
import Modelo.TiposEstado;
import dao.TipoEstadoDAO;

/**
 * Clase menu que proporciona un menú interactivo para seleccionar diferentes
 * escenarios financieros.
 * Permite al usuario elegir entre escenarios de ingreso, gasto, deuda,
 * inversiones, ahorro y fondo de emergencia.
 */
public class menu {

    /**
     * Método principal que ejecuta el menú interactivo.
     * Permite al usuario seleccionar un escenario y ejecutar las acciones
     * correspondientes.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws Exception Si ocurre algún error durante la ejecución.
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        InversionController controller = new InversionController();
        GastoController gastoController = new GastoController();
        DeudaController deudaController = new DeudaController();
        IngresoController ingresoController = new IngresoController();
        AhorroController ahorroController = new AhorroController();
        FondoEmergenciaController fondoemerController = new FondoEmergenciaController();
        CargaCryptoController cargaCryptoController = new CargaCryptoController();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("---------------------------------------------------");
            System.out.println("Seleccione un escenario (1-6):");
            System.out.println("1. Escenario de Ingreso");
            System.out.println("2. Escenario de Gasto");
            System.out.println("3. Escenario de Deuda");
            System.out.println("4. Escenario de Inversiones");
            System.out.println("5. Escenario de Ahorro y Fondo de Emergencia");
            System.out.println("6. Carga de Datos de Criptomonedas");
            System.out.println("0. Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ingresoController.ejecutarEscenario();
                    break;
                case 2:
                    gastoController.ejecutarEscenario();
                    break;
                case 3:
                    deudaController.registrarDeudaConPagos();
                    break;
                case 4:
                    controller.escenario4();
                    break;
                case 5:
                    ahorroController.ejecutarEscenario();
                    fondoemerController.ejecutarEscenario();

                    break;
                case 6:
                    cargaCryptoController.cargarDatos("ethereum");

                    break;

                default:
                    break;
            }
        }

        scanner.close();

    }
}
