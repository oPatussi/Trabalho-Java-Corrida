import java.util.Scanner; // Importa a classe Scanner para ler entradas do usuário.

public class UserInteract {

    // Mensagens de solicitação e confirmação definidas como constantes.
    private static final String REQUEST_VEHICLE_BRAND = "Qual a marca do veículo?";
    private static final String REQUEST_VEHICLE_MODEL = "Qual o modelo do veículo?";
    private static final String REQUEST_VEHICLE_WEIGHT = "Qual o peso do veículo?";
    private static final String REQUEST_VEHICLE_REMOVE = "Qual veículo deseja remover da corrida?";
    private static final String REQUEST_VEHICLE_HORSE_POWER = "Quantos cavalos de potência têm o veículo?";
    private static final String CONFIRMATION_VEHICLE_ADD = "Veículo adicionado com sucesso.";
    private static final String CONFIRMATION_VEHICLE_REMOVE = "Veículo removido com sucesso.";
    private static final String REQUEST_NEW_TRACK_SIZE = "Qual o novo tamanho da pista que deseja criar?";

    // String que define o menu a ser exibido ao usuário.
    private static final String MENU = """
            ========== Menu ==========
            1 - Listar todos os veículos da Corrida
            2 - Adicionar um carro à corrida
            3 - Adicionar uma moto à corrida
            4 - Remover um veículo
            5 - Encontrar veículo mais potente
            6 - Iniciar corrida
            7 - Alterar tamanho da pista
            0 - Sair
            """;

    // Espaçador visual.
    private static final String SPACER = "==================";

    // Método para solicitar a marca do veículo.
    public String waitForVehicleBrand(Scanner scanner) {
        System.out.println(REQUEST_VEHICLE_BRAND);
        return scanner.nextLine();
    }

    // Método para solicitar o modelo do veículo.
    public String waitForVehicleModel(Scanner scanner) {
        System.out.println(REQUEST_VEHICLE_MODEL);
        return scanner.nextLine();
    }

    // Método para solicitar o peso do veículo.
    public double waitForVehicleWeight(Scanner scanner) {
        double weight = -1;
        while (weight < 0) { // Valida a entrada para garantir que seja um número positivo.
            try {
                System.out.println(REQUEST_VEHICLE_WEIGHT);
                weight = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) { // Trata exceções caso o usuário insira um valor inválido.
                System.out.println("Por favor, insira um número válido para o peso.");
            }
        }
        return weight;
    }

    // Método para solicitar a potência do veículo.
    public int waitForVehicleHorsePower(Scanner scanner) {
        int horsePower = -1;
        while (horsePower < 0) { // Valida a entrada para garantir que seja um número positivo.
            try {
                System.out.println(REQUEST_VEHICLE_HORSE_POWER);
                horsePower = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) { // Trata exceções caso o usuário insira um valor inválido.
                System.out.println("Por favor, insira um número inteiro válido para a potência.");
            }
        }
        return horsePower;
    }

    // Método para solicitar o índice do veículo a ser removido.
    public int waitForVehicleToRemove(Scanner scanner) {
        int vehicleToRemove = -1;
        while (vehicleToRemove < 0) { // Valida a entrada para garantir que seja um número positivo.
            try {
                System.out.println(REQUEST_VEHICLE_REMOVE);
                vehicleToRemove = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) { // Trata exceções caso o usuário insira um valor inválido.
                System.out.println("Por favor, insira um número inteiro válido para o veículo a ser removido.");
            }
        }
        return vehicleToRemove;
    }

    // Método para solicitar o novo tamanho da pista.
    public int waitForNewTrackSize(Scanner scanner) {
        int trackSize = -1;
        while (trackSize < 0) { // Valida a entrada para garantir que seja um número positivo.
            try {
                System.out.println(REQUEST_NEW_TRACK_SIZE);
                trackSize = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) { // Trata exceções caso o usuário insira um valor inválido.
                System.out.println("Por favor, insira um número inteiro válido para o tamanho da pista.");
            }
        }
        return trackSize;
    }

    // Método para confirmar que o veículo foi criado.
    public void confirmationVehicleCreated() {
        System.out.println(CONFIRMATION_VEHICLE_ADD);
    }

    // Método para confirmar que o veículo foi removido.
    public void confirmationVehicleRemoved() {
        System.out.println(CONFIRMATION_VEHICLE_REMOVE);
    }

    // Método para exibir o menu e capturar a opção do usuário.
    public int showMenu(Scanner scanner) {
        int escolha = -1;
        boolean entradaValida = false;

        while (!entradaValida) { // Loop até que o usuário insira uma opção válida.
            try {
                System.out.println(MENU);
                escolha = Integer.parseInt(scanner.nextLine()); // Lê a entrada do usuário e converte para int.
                entradaValida = true; // Se a conversão for bem-sucedida, a entrada é válida.
            } catch (NumberFormatException e) { // Trata exceções caso o usuário insira um valor inválido.
                System.out.println("Por favor, insira um número inteiro válido.");
            }
        }

        return escolha; // Retorna a escolha do usuário.
    }
}
