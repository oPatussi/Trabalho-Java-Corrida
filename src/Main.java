import java.util.*; // Importa todas as classes do pacote java.util, incluindo Scanner e ArrayList.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um Scanner para ler a entrada do usuário.
        UserInteract userInteract = new UserInteract(); // Instancia a classe para interagir com o usuário.
        VehicleService vehicleService = new VehicleService(); // Instancia a classe para gerenciar veículos.
        Track track = new Track(); // Instancia a classe para gerenciar a pista.

        List<Vehicle> vehicles = new ArrayList<>(); // Cria uma lista para armazenar veículos.

        while (true) { // Inicia um loop infinito para o menu.
            int option = userInteract.showMenu(scanner); // Exibe o menu e lê a opção do usuário.
            if (option == 0) break; // Se a opção for 0, sai do loop e encerra o programa.

            switch (option) { // Alterna entre as opções do menu.
                case 1 -> { // Caso 1: imprimir todos os veículos.
                    vehicleService.printAllVehicles(vehicles); // Chama o método para imprimir os veículos.
                }
                case 2 -> { // Caso 2: criar um novo carro.
                    String brand = userInteract.waitForVehicleBrand(scanner); // Lê a marca do veículo.
                    String model = userInteract.waitForVehicleModel(scanner); // Lê o modelo do veículo.
                    double weight = userInteract.waitForVehicleWeight(scanner); // Lê o peso do veículo.
                    int horsePower = userInteract.waitForVehicleHorsePower(scanner); // Lê a potência do veículo.
                    scanner.nextLine(); // Limpa o buffer do scanner.
                    vehicles.add(vehicleService.createNewCar(brand, model, weight, horsePower)); // Cria e adiciona um novo carro à lista de veículos.
                    userInteract.confirmationVehicleCreated(); // Confirma a criação do veículo.
                }
                case 3 -> { // Caso 3: criar uma nova moto.
                    String brand = userInteract.waitForVehicleBrand(scanner); // Lê a marca do veículo.
                    String model = userInteract.waitForVehicleModel(scanner); // Lê o modelo do veículo.
                    double weight = userInteract.waitForVehicleWeight(scanner); // Lê o peso do veículo.
                    int horsePower = userInteract.waitForVehicleHorsePower(scanner); // Lê a potência do veículo.
                    scanner.nextLine(); // Limpa o buffer do scanner.
                    vehicles.add(vehicleService.createNewMoto(brand, model, weight, horsePower)); // Cria e adiciona uma nova moto à lista de veículos.
                    userInteract.confirmationVehicleCreated(); // Confirma a criação do veículo.
                }
                case 4 -> { // Caso 4: remover um veículo.
                    vehicleService.printAllVehicles(vehicles); // Imprime todos os veículos.
                    int vehicleToRemove = userInteract.waitForVehicleToRemove(scanner); // Lê o índice do veículo a ser removido.
                    scanner.nextLine(); // Limpa o buffer do scanner.
                    vehicles.remove(vehicleToRemove - 1); // Remove o veículo da lista (ajusta o índice para começar em 0).
                    userInteract.confirmationVehicleRemoved(); // Confirma a remoção do veículo.
                }
                case 5 -> { // Caso 5: encontrar o veículo mais potente.
                    Vehicle mostPotentVehicle = vehicleService.findMostPotent(vehicles); // Encontra o veículo mais potente.

                    if (mostPotentVehicle != null) { // Verifica se encontrou um veículo.
                        System.out.println("Veículo: " + mostPotentVehicle.getModel() + " | Potência: " + mostPotentVehicle.getHorsePower() + " Hp"); // Exibe o veículo mais potente.
                    } else {
                        System.out.println("Nenhum veículo encontrado."); // Mensagem se nenhum veículo foi encontrado.
                    }
                }
                case 6 -> { // Caso 6: iniciar corrida.
                    track.startRace(vehicles, track.getTrackLength()); // Inicia a corrida com a lista de veículos e o comprimento da pista.
                }
                case 7 -> { // Caso 7: definir novo comprimento da pista.
                    int newTrackSize = userInteract.waitForNewTrackSize(scanner); // Lê o novo comprimento da pista.
                    scanner.nextLine(); // Limpa o buffer do scanner.
                    track.setTrackLength(newTrackSize); // Define o novo comprimento da pista.
                }
                default -> { // Opção padrão: se a entrada não corresponder a nenhuma opção.
                    System.out.println("Não é uma opção, tente novamente."); // Mensagem de erro.
                }
            }
        }

        scanner.close(); // Fecha o scanner para liberar recursos.
    }
}
