package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import subjects.Subject;
import terrains.Terrain;

public abstract class Angel {
    /**
     * locatia la care apare ingerul.
     */
    private Terrain spawnLocation;
    /**
     * tipul ingerului.
     */
    private String type;
    /**
     * notifica magicianul asupra ingerului.
     */
    private final Subject notifier = new Subject();

    /* metodele de aplicare a
    efectelor ingerilor.
    vor fi apelate de metodele isTouched din
    clasele de campioni.
     */

    /**
     * metoda pentru wizard.
     * @param wizard wizard-ul afectat
     */
    public abstract void touch(Wizard wizard);
    /**
     * metoda pentru rogue.
     * @param rogue rogue-ul afectat
     */
    public abstract void touch(Rogue rogue);
    /**
     * metoda pentru pyromancer.
     * @param pyromancer pyromancer-ul afectat
     */
    public abstract void touch(Pyromancer pyromancer);
    /**
     * metoda pentru knight.
     * @param knight knight-ul afectat
     */
    public abstract void touch(Knight knight);

    /**
     * setter.
     * @param setSpawnLocation .
     */
    public void setSpawnLocation(final Terrain setSpawnLocation) {
        this.spawnLocation = setSpawnLocation;
    }

    /**
     * setter.
     * @param setType .
     */
    public void setType(final String setType) {
        this.type = setType;
    }

    /**
     * getter.
     * @return spawnLocation
     */
    public Terrain getSpawnLocation() {
        return spawnLocation;
    }

    /**
     * getter.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * getter.
     * @return notifier
     */
    public Subject getNotifier() {
        return notifier;
    }
}
