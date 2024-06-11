import java.util.List;
import java.util.Scanner;

public class UserInteract {

    private final String REQUEST_VEHICLE_BRAND = "Qual a marca do veículo ?";
    private final String REQUEST_VEHICLE_MODEL = "Qual o modelo do veículo ?";
    private final String REQUEST_VEHICLE_WEIGHT = "Qual o peso do veículo ?";
    private final String REQUEST_VEHICLE_REMOVE = "Qual veículo deseja remover da corrida ?";
    private final String REQUEST_VEHICLE_HORSE_POWER = "Quantos cavalos de potência têm o veículo ?";
    private final String CONFIMATION_VEHICLE_ADD = "Veículo adicionado com sucesso.";
    private final String CONFIMATION_VEHICLE_REMOVE = "Veículo removido com sucesso.";
    private final String REQUEST_NEW_TRACK_SIZE = "Qual o novo tamanho da pista que deseja criar ?";

    final String MENU = """
            ========== Menu ==========
            1 - Listar todos os veículos da Corrida
            2 - Adicionar um carro a corrida
            3 - Adicinar uma moto a corrida
            4 - Remover um veículo
            5 - Encontrar carro mais potente
            6 - Iniciar corrida
            7 - Alterar tamanho da corrida
            0 - Sair
            """;

    final String SPACER = "==================";

    public String waitForVehicleBrand(Scanner scanner){
        System.out.println(REQUEST_VEHICLE_BRAND);
        return scanner.nextLine();
    }

    public String waitForVehicleModel(Scanner scanner){
        System.out.println(REQUEST_VEHICLE_MODEL);
        return scanner.nextLine();
    }

    public double waitForVehicleWeight(Scanner scanner){
        System.out.println(REQUEST_VEHICLE_WEIGHT);
        return scanner.nextDouble();
    }

    public int waitForVehicleHorsePower(Scanner scanner){
        System.out.println(REQUEST_VEHICLE_HORSE_POWER);
        return scanner.nextInt();
    }

    public int waitForVehicleToRemove(Scanner scanner){
        System.out.println(REQUEST_VEHICLE_REMOVE);
        return scanner.nextInt();
    }

    public int waitForNewTrackSize(Scanner scanner){
        System.out.println(REQUEST_NEW_TRACK_SIZE);
        return scanner.nextInt();
    }

    public void confimationVehicleCreated(){
        System.out.println(CONFIMATION_VEHICLE_ADD);
    }

    public void confimationVehicleRemoved(){
        System.out.println(CONFIMATION_VEHICLE_REMOVE);
    }


    public int showMenu(Scanner scanner){
        int escolha = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println(MENU);
                escolha = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
            }
        }

        return escolha;
    }
}