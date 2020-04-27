package se.lexicon.michelle.data;

public class PersonSequencer {
    private static int personId = 0;

    public static int nextPersonID(){
        return personId++;
    }
    public static void reset(){
        personId = 0;
    }
}
