public class Vehicle {

    private final String model;
    private final String brand;
    private final double weight;
    private final int horsePower;

    public Vehicle(String model, String brand, double weight, int horsePower) {
        this.model = model;
        this.brand = brand;
        this.weight = weight;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getWeight() {
        return weight;
    }

    public int getHorsePower() {
        return horsePower;
    }

    //Faz a tentativa de andar, verificando se o Random caiu acima ou abaixo de 0.5
    public boolean TryBonusDistance(double horsePower){
        double chance = horsePower/1000;
        boolean retorno = false;
        double tentativa = Math.random();
        if(tentativa < chance){
            retorno = true;
        }
        return retorno;
    }

    public int CalculateBonusDistance(double peso){
        if (peso < 1000){
            return 3;
        }
        else if (peso >1000 && peso <2000){
            return 2;
        }
        else if (peso >2000 && peso <3000){
            return 1;
        }else return 0;
    }

    public int Drive(Vehicle vehicle) {
        int passo =1;
        if(TryBonusDistance(vehicle.horsePower)){
            passo += CalculateBonusDistance(vehicle.weight);
            if (vehicle instanceof Moto) {
                passo +=1;
            }
        }
        return passo;
    }




}