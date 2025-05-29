package vista;
import java.util.Scanner;
import Controlador.*;


public class menu {    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InversionController controller = new InversionController();
        GastoController gastoController = new GastoController();
         DeudaController deudaController= new DeudaController();
        IngresoController ingresoController = new IngresoController();
        AhorroController ahorroController = new AhorroController();
        FondoEmergenciaController fondoemerController =new FondoEmergenciaController();

        System.out.println("Seleccione un escenario (1-5):");
        int opcion = scanner.nextInt();
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

                 
            default:
                break;
        }

         scanner.close();

    }
}
