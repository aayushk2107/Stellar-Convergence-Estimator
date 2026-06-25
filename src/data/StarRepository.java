/*
    Stores known stars and their
    observed properties.
*/

package data;

import model.Star;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StarRepository {

    private static final Map<String, Star> stars =
            new HashMap<>();

    static {

        stars.put(
                "sun",
                new Star(
                        "Sun",
                        1.0,
                        "White Dwarf"
                )
        );

        stars.put(
                "sirius",
                new Star(
                        "Sirius",
                        2.1,
                        "White Dwarf"
                )
        );

        stars.put(
                "betelgeuse",
                new Star(
                        "Betelgeuse",
                        15.0,
                        "Neutron Star"
                )
        );

        stars.put(
                "rigel",
                new Star(
                        "Rigel",
                        21.0,
                        "Neutron Star"
                )
        );

        stars.put(
                "aldebaran",
                new Star(
                        "Aldebaran",
                        1.7,
                        "White Dwarf"
                )
        );

        stars.put(
                "arcturus",
                new Star(
                        "Arcturus",
                        1.1,
                        "White Dwarf"
                )
        );

        stars.put(
                "spica",
                new Star(
                        "Spica",
                        11.0,
                        "Neutron Star"
                )
        );

        stars.put(
                "eta carinae",
                new Star(
                        "Eta Carinae",
                        100.0,
                        "Black Hole"
                )
        );
    }

    public static Star findByName(String name) {

        if (name == null) {
            return null;
        }

        return stars.get(
                name.toLowerCase()
        );
    }

    public static Collection<Star> getAllStars() {
        return stars.values();
    }
}