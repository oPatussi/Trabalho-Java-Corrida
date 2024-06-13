import java.util.List;
import java.util.Random;

public class Track {

    // Constante usada como espaçador na impressão do status da corrida.
    final String SPACER = "==================";
    public int trackLength = 50; // Comprimento padrão da pista de corrida.

    // Método para iniciar a corrida.
    public void startRace(List<Vehicle> vehicles, int trackLength) {
        if (vehicles.size() < 1) { // Verifica se há veículos na corrida.
            System.out.println("Não há veículos na corrida ainda."); // Mensagem indicando que não há veículos.
            return; // Encerra o método se não houver veículos.
        }

        int[] positions = new int[vehicles.size()]; // Array para armazenar as posições dos veículos.
        boolean raceOver = false; // Flag para indicar se a corrida terminou.

        // Loop principal da corrida.
        while (!raceOver) {
            for (int i = 0; i < vehicles.size(); i++) {
                int move = vehicles.get(i).Drive(vehicles.get(i)); // Calcula a distância percorrida pelo veículo.
                positions[i] += move; // Atualiza a posição do veículo.
                try {
                    Thread.sleep(500); // Pausa a execução por 500 milissegundos para simular o tempo de corrida.
                } catch (InterruptedException ex) {
                    continue; // Continua a execução se houver uma interrupção.
                }
                if (positions[i] >= trackLength) { // Verifica se o veículo alcançou ou ultrapassou o comprimento da pista.
                    raceOver = true; // Define a flag indicando que a corrida terminou.
                    System.out.println("O vencedor é o -" + vehicles.get(i).getModel() + "- com potência de " + vehicles.get(i).getHorsePower() + " HP!"); // Imprime o vencedor da corrida.
                    break; // Sai do loop se a corrida terminou.
                }
            }
            printRaceStatus(vehicles, positions); // Imprime o status da corrida após cada rodada.
        }
    }

    // Método para imprimir o status da corrida.
    private void printRaceStatus(List<Vehicle> vehicles, int[] positions) {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getModel() + " está na posição " + positions[i]); // Imprime a posição atual de cada veículo.
        }
        System.out.println(SPACER); // Imprime o espaçador.
    }

    // Getter para obter o comprimento da pista.
    public int getTrackLength() {
        return trackLength;
    }

    // Setter para definir o comprimento da pista.
    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength; // Atualiza o comprimento da pista.
    }
}
