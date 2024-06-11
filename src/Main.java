import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInteract userInteract = new UserInteract();
        VehicleController vehicleController = new VehicleController();
        Track track = new Track();

        List<Vehicle> vehicles = new ArrayList<>();

        while (true){
            int option = userInteract.showMenu(scanner);
            if(option == 0) break;
            switch (option){
                case 1 ->{
                    vehicleController.printAllVehicles(vehicles);
                }
                case 2 ->{
                    String brand = userInteract.waitForVehicleBrand(scanner);
                    String model = userInteract.waitForVehicleModel(scanner);
                    double weight = userInteract.waitForVehicleWeight(scanner);
                    int horsePower = userInteract.waitForVehicleHorsePower(scanner);
                    vehicles.add(vehicleController.CreateNewCar(brand,model,weight,horsePower));
                    userInteract.confimationVehicleCreated();
                }case 3 ->{
                    String brand = userInteract.waitForVehicleBrand(scanner);
                    String model = userInteract.waitForVehicleModel(scanner);
                    double weight = userInteract.waitForVehicleWeight(scanner);
                    int horsePower = userInteract.waitForVehicleHorsePower(scanner);
                    vehicles.add(vehicleController.CreateNewMoto(brand,model,weight,horsePower));
                    userInteract.confimationVehicleCreated();
                }
                case 4 ->{
                    vehicleController.printAllVehicles(vehicles);
                    int vehicleToRemove = userInteract.waitForVehicleToRemove(scanner);
                    vehicles.remove(vehicleToRemove-1);
                    userInteract.confimationVehicleRemoved();

                }
                case 5 ->{
                    Vehicle mostPotentVehicle = vehicleController.FindMostPotent(vehicles);

                    if (mostPotentVehicle != null) {
                        System.out.println("Veículo: " + mostPotentVehicle.getModel() + " | Potência: " + mostPotentVehicle.getHorsePower()+" Hp");
                    } else {
                        System.out.println("Nenhum veículo encontrado.");
                    }
                }
                case 6->{
                    track.startRace(vehicles,track.trackLength);
                }
                case 7->{
                    int newTrackSice = userInteract.waitForNewTrackSize(scanner);
                    track.setTrackLength(newTrackSice);
                }
                default -> {
                    System.out.println("Não é uma opção, tente novamente.");
                }
            }
        }


    }


}
