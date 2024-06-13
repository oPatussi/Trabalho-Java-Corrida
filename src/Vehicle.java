public class Vehicle {

    // Campos finais para armazenar as propriedades do veículo.
    private final String model; // Modelo do veículo.
    private final String brand; // Marca do veículo.
    private final double weight; // Peso do veículo.
    private final int horsePower; // Potência do veículo.

    // Construtor para inicializar as propriedades do veículo.
    public Vehicle(String model, String brand, double weight, int horsePower) {
        this.model = model; // Inicializa o campo model com o valor passado.
        this.brand = brand; // Inicializa o campo brand com o valor passado.
        this.weight = weight; // Inicializa o campo weight com o valor passado.
        this.horsePower = horsePower; // Inicializa o campo horsePower com o valor passado.
    }

    // Métodos getter para acessar as propriedades do veículo.
    public String getModel() {
        return model; // Retorna o modelo do veículo.
    }

    public String getBrand() {
        return brand; // Retorna a marca do veículo.
    }

    public double getWeight() {
        return weight; // Retorna o peso do veículo.
    }

    public int getHorsePower() {
        return horsePower; // Retorna a potência do veículo.
    }

    // Método para tentar obter uma distância bônus com base na potência do veículo.
    public boolean TryBonusDistance(double horsePower) {
        double chance = horsePower / 1000; // Calcula a chance de obter o bônus com base na potência.
        boolean retorno = false; // Inicializa a variável de retorno como false.
        double tentativa = Math.random(); // Gera um número aleatório entre 0 e 1.
        if (tentativa < chance) { // Se o número gerado for menor que a chance, o bônus é obtido.
            retorno = true; // Define retorno como true.
        }
        return retorno; // Retorna se o bônus foi obtido ou não.
    }

    // Método para calcular a distância bônus com base no peso do veículo.
    public int CalculateBonusDistance(double peso) {
        if (peso < 1000) { // Se o peso for menor que 1000, o bônus é 3.
            return 3;
        } else if (peso > 1000 && peso < 2000) { // Se o peso estiver entre 1000 e 2000, o bônus é 2.
            return 2;
        } else if (peso > 2000 && peso < 3000) { // Se o peso estiver entre 2000 e 3000, o bônus é 1.
            return 1;
        } else {
            return 0; // Se o peso for 3000 ou mais, não há bônus.
        }
    }

    // Método para dirigir o veículo, calculando a distância percorrida.
    public int Drive(Vehicle vehicle) {
        int passo = 1; // Inicializa a distância padrão como 1.
        if (TryBonusDistance(vehicle.horsePower)) { // Se o bônus for obtido...
            passo += CalculateBonusDistance(vehicle.weight); // Adiciona a distância bônus com base no peso.
            if (vehicle instanceof Moto) { // Se o veículo for uma moto, adiciona mais 1 à distância.
                passo += 1;
            }
        }
        return passo; // Retorna a distância total percorrida.
    }
}
