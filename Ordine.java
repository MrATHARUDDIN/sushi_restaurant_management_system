package Resturante;

import java.util.ArrayList;

public class Menu {

    private static ArrayList<Piatto> menu = new ArrayList<>();

    static {
        menu.add(new Piatto("Nigiri Salmone", "Sushi", 5, "Nigiri con salmone fresco", "Nigiri.jpg"));
        menu.add(new Piatto("Nigiri Avocado", "Sushi", 6, "Nigiri con avocado", "Avocado.jpg"));
        menu.add(new Piatto("Ebi", "Sushi", 6, "Gambero", "Ebi.jpg"));
        menu.add(new Piatto("Unagi", "Sushi", 7, "Anguilla", "Unagi.jpg"));
        menu.add(new Piatto("Temaki", "Sushi", 5, "Cono di sushi", "Temaki.png"));
        menu.add(new Piatto("Uramaki", "Sushi", 6, "Rotolo invertito", "Uramaki.jpg"));
        menu.add(new Piatto("Oshizushi", "Sushi", 7, "Sushi pressato", "Oshizushi.png"));
        menu.add(new Piatto("Inari", "Sushi", 5, "Tofu fritto", "Inari.png"));
        menu.add(new Piatto("Chirashi", "Sushi", 8, "Ciotola mista", "Chirashi.png"));
    }

    public static ArrayList<Piatto> getMenu() {
        return menu;
    }

    public static void addPiatto(Piatto p) {
        menu.add(p);
    }

    public static void removePiatto(Piatto p) {
        menu.remove(p);
    }

    public static ArrayList<Piatto> filterByCategoria(String categoria) {
        ArrayList<Piatto> result = new ArrayList<>();

        for (Piatto p : menu) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                result.add(p);
            }
        }
        return result;
    }

    public static ArrayList<Piatto> getSushi() {
        return filterByCategoria("Sushi");
    }
}