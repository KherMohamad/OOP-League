package observers;


import java.util.ArrayList;

public class GreatMagician {
    /**
     * instanta singleton.
     */
    private static GreatMagician instance  = null;
    /**
     * arhiva magicianului.
     */
    private ArrayList<String> magicOrb = new ArrayList<String>();

    /**
     * returneaza instanta.
     * @return instanta singleton
     */
    public static GreatMagician getInstance() {
        if (instance == null) {
            instance = new GreatMagician();
        }
        return instance;
    }

    /**
     * actualizeaza arhiva.
     * @param message mesajul nou
     */
    public void update(final String message) {
        magicOrb.add(message);
    }

    /**
     * getter.
     * @return magicOrb
     */
    public ArrayList<String> getMagicOrb() {
        return magicOrb;
    }
}
