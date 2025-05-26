package vista;
import java.util.Scanner;
import Controlador.*;


public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InversionController controller = new InversionController();
        GastoController gastoController = new GastoController();

        System.out.println("Seleccione un escenario (1-5):");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 2:              
                gastoController.ejecutarEscenario();
                break;
            case 4:
                  controller.ejecutarEscenario();
            default:
                break;
        }
      

    }
}
