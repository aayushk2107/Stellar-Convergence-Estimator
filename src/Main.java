import data.StarRepository;
import model.Star;

public class Main {

    public static void main(String[] args) {

        Star star =
                StarRepository.findByName("Betelgeuse");

        System.out.println(star);
    }
}