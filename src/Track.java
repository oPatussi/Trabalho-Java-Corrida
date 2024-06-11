import java.util.List;
import java.util.Random;

public class Track {

    final String SPACER = "==================";
    public int trackLength = 50;

    public void startRace(List<Vehicle> vehicles, int trackLength) {
        if (vehicles.size() < 1) {
            System.out.println("Não há veículos na corrida ainda.");
            return;
        }


        int[] positions = new int[vehicles.size()];
        boolean raceOver = false;

        while (!raceOver) {
            for (int i = 0; i < vehicles.size(); i++) {
                int move = vehicles.get(i).Drive(vehicles.get(i));
                positions[i] += move;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    continue;
                }
                if (positions[i] >= trackLength) {
                    raceOver = true;
                    System.out.println("O vencedor é o -" + vehicles.get(i).getModel() + "- com potência de " + vehicles.get(i).getHorsePower() + " HP!");
                    break;
                }
            }
            printRaceStatus(vehicles, positions);
        }
    }

    private void printRaceStatus(List<Vehicle> vehicles, int[] positions) {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getModel() + " está na posição " + positions[i]);
        }
        System.out.println(SPACER);
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }
}
