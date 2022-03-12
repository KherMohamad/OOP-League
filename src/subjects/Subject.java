package subjects;

import observers.GreatMagician;

public class Subject {
    /**
     * notifica magicianul.
     * @param greatMagician marele magician
     * @param message mesajul trimis
     */
    public void notify(final GreatMagician greatMagician,
                       final String message) {
        greatMagician.update(message);
    }
}
