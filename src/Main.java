import data.StarRepository;
import model.Star;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter star name: ");

        String starName = scanner.nextLine();

        Star star =
                StarRepository.findByName(starName);

        if (star == null) {
            System.out.println("Star not found.");
            return;
        }

        System.out.println(star);
    }
}