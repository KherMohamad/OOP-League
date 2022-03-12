package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;


public class DamageAngel extends Angel {
    /**
     * modificatorul clasei wizard.
     */
    private static final float WIZZARDMODIFIER = 0.4f;
    /**
     * modificatorul clasei rogue.
     */
    private static final float ROGUEMODIFIER = 0.3f;
    /**
     * modificatorul clasei pyromancer.
     */
    private static final float PYROMODIFIER = 0.2f;
    /**
     * modificatorul clasei knight.
     */
    private static final float KNIGHTMODIFIER = 0.15f;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public DamageAngel(final Terrain spawnLocation) {
        this.setType("DamageAngel");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * suprascrierea metodei touch din clasa abstracta.
     * implementarea efectiva pentru DamageAngel
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            float oldModifier = wizard.getDamageModifier();
            wizard.setDamageModifier(oldModifier + WIZZARDMODIFIER);
            String message = new String("DamageAngel helped ");
            message +=  "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * suprascrierea metodei touch din clasa abstracta.
     * implementarea efectiva pentru DamageAngel
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            float oldModifier = rogue.getDamageModifier();
            rogue.setDamageModifier(oldModifier + ROGUEMODIFIER);
            String message = new String("DamageAngel helped ");
            message +=  "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * suprascrierea metodei touch din clasa abstracta.
     * implementarea efectiva pentru DamageAngel
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            float oldModifier = pyromancer.getDamageModifier();
            pyromancer.setDamageModifier(oldModifier + PYROMODIFIER);
            String message = new String("DamageAngel helped ");
            message +=  "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * suprascrierea metodei touch din clasa abstracta.
     * implementarea efectiva pentru DamageAngel
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            float oldModifier = knight.getDamageModifier();
            knight.setDamageModifier(oldModifier + KNIGHTMODIFIER);
            String message = new String("DamageAngel helped ");
            message +=  "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }
}
