package Resturante;

import java.util.ArrayList;

public class FeedbackManager {

    private static ArrayList<Feedback> listaFeedback = new ArrayList<>();

    public static void addFeedback(Feedback f) {
        listaFeedback.add(f);
    }

    public static ArrayList<Feedback> getFeedbacks() {
        return listaFeedback;
    }
}