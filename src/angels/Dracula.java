package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;

public class Dracula extends Angel {
    /**
     * hp-ul pierdut de wizard.
     */
    private static final int WIZARDHPDEBUFF = 20;
    /**
     * hp-ul pierdut de rogue.
     */
    private static final int ROGUEHPDEBUFF = 35;
    /**
     * hp-ul pierdut de pyromancer.
     */
    private static final int PYROHPDEBUFF = 40;
    /**
     * hp-ul pierdut de knight.
     */
    private static final int KNIGHTHPDEBUFF = 60;

    /**
     * modificatorul pentru wizard.
     */
    private static final float WIZZARDMODIFIER = 0.4f;
    /**
     * modificatorul pentru rogue.
     */
    private static final float ROGUEMODIFIER = 0.1f;
    /**
     * modificatorul pentru pyromancer.
     */
    private static final float PYROMODIFIER = 0.2f;
    /**
     * modificatorul pentru knight.
     */
    private static final float KNIGHTMODIFIER = 0.3f;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public Dracula(final Terrain spawnLocation) {
        this.setType("Dracula");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru Dracula.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            int hp = wizard.getCurrentHp();
            wizard.setCurrentHp(hp - WIZARDHPDEBUFF);

            float oldModifier = wizard.getDamageModifier();
            wizard.setDamageModifier(oldModifier - WIZZARDMODIFIER);
            String message = new String("Dracula hit ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
        if (wizard.getCurrentHp() == 0) {
            String message = new String("Player Wizard ");
            message += wizard.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Dracula.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            int hp = rogue.getCurrentHp();
            rogue.setCurrentHp(hp - ROGUEHPDEBUFF);

            float oldModifier = rogue.getDamageModifier();
            rogue.setDamageModifier(oldModifier - ROGUEMODIFIER);
            String message = new String("Dracula hit ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
        if (rogue.getCurrentHp() == 0) {
            String message = new String("Player Rogue ");
            message += rogue.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Dracula.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            int hp = pyromancer.getCurrentHp();
            pyromancer.setCurrentHp(hp + PYROHPDEBUFF);

            float oldModifier = pyromancer.getDamageModifier();
            pyromancer.setDamageModifier(oldModifier - PYROMODIFIER);
            String message = new String("Dracula hit ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
        if (pyromancer.getCurrentHp() == 0) {
            String message = new String("Player Pyromancer ");
            message += pyromancer.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Dracula.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            int hp = knight.getCurrentHp();
            knight.setCurrentHp(hp - KNIGHTHPDEBUFF);

            float oldModifier = knight.getDamageModifier();
            knight.setDamageModifier(oldModifier - KNIGHTMODIFIER);
            String message = new String("Dracula hit ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
        if (knight.getCurrentHp() == 0) {
            String message = new String("Player Knight ");
            message += knight.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }
}
