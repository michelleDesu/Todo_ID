package se.lexicon.michelle.model;

public class Sequencer {
    private static int counter = 0;

    public static int nextID(){

        return counter++;
    }
}
