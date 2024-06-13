import java.util.Comparator;
import java.util.List;

public class VehicleService {

    // String constante usada como espaçador na impressão dos veículos.
    final String SPACER = "==================";

    // Método para imprimir todos os veículos da lista.
    public void printAllVehicles(List<Vehicle> vehicles) {
        if (vehicles.size() < 1) { // Verifica se a lista de veículos está vazia.
            System.out.println("Nenhum há veículo na corrida ainda."); // Mensagem indicando que não há veículos.
        } else {
            for (int i = 0; i < vehicles.size(); i++) { // Percorre todos os veículos na lista.
                System.out.println(SPACER); // Imprime o espaçador.
                System.out.println("Carro número " + (i + 1)); // Imprime o número do carro.
                System.out.println("-> Marca: " + vehicles.get(i).getBrand()); // Imprime a marca do veículo.
                System.out.println("-> Modelo: " + vehicles.get(i).getModel()); // Imprime o modelo do veículo.
                System.out.println("-> Peso: " + vehicles.get(i).getWeight()); // Imprime o peso do veículo.
                System.out.println("-> Potência: " + vehicles.get(i).getHorsePower()); // Imprime a potência do veículo.
            }
        }
    }

    // Método para criar um novo carro.
    public Car createNewCar(String brand, String model, double weight, int horsePower) {
        return new Car(model, brand, weight, horsePower); // Retorna uma nova instância de Car.
    }

    // Método para criar uma nova moto.
    public Moto createNewMoto(String brand, String model, double weight, int horsePower) {
        return new Moto(model, brand, weight, horsePower); // Retorna uma nova instância de Moto.
    }

    // Método para encontrar o veículo mais potente na lista.
    public Vehicle findMostPotent(List<Vehicle> vehicles) {
        // Utiliza stream para encontrar o veículo com a maior potência.
        return vehicles.stream().max(Comparator.comparingDouble(Vehicle::getHorsePower)).orElse(null);
        // Compara os veículos pela potência e retorna o mais potente, ou null se a lista estiver vazia.
    }

}
