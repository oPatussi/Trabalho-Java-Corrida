import java.util.Comparator;
import java.util.List;

public class VehicleController {

    final String SPACER = "==================";

    public void printAllVehicles(List<Vehicle> vehicles){
        if (vehicles.size() < 1){
            System.out.println("Nenhum há veículo na corrida ainda.");
        }
        else {
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println(SPACER);
                System.out.println("Carro número " + (i + 1));
                System.out.println("-> Marca: " + vehicles.get(i).getBrand());
                System.out.println("-> Modelo: " + vehicles.get(i).getModel());
                System.out.println("-> Peso: "+ vehicles.get(i).getWeight());
                System.out.println("-> Potência: " + vehicles.get(i).getHorsePower());
            }
        }
    }

    public Car CreateNewCar(String brand, String model, double weight, int horsePower){
        return new Car(model, brand, weight, horsePower);
    }

    public Moto CreateNewMoto(String brand, String model, double weight, int horsePower){
        return new Moto(model, brand, weight, horsePower);
    }

    public Vehicle FindMostPotent(List<Vehicle> vehicles){
        return vehicles.stream().max(Comparator.comparingDouble(Vehicle::getHorsePower)).orElse(null);
    }

}
