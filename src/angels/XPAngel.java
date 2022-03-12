package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;


public class XPAngel extends Angel {
    /**
     * xp-ul primit de wizard.
     */
    private static final int WIZARDBUFF = 60;
    /**
     * xp-ul primit de rogue.
     */
    private static final int ROGUEBUFF = 40;
    /**
     * xp-ul primit de pyromancer.
     */
    private static final int PYROBUFF = 50;
    /**
     * xp-ul primit de knight.
     */
    private static final int KNIGHTBUFF = 45;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public XPAngel(final Terrain spawnLocation) {
        this.setType("XPAngel");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru XPAngel.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            wizard.setXp(wizard.getXp() + WIZARDBUFF);
            String message = new String("XPAngel helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru XPAngel.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            rogue.setXp(rogue.getXp() + ROGUEBUFF);
            String message = new String("XPAngel helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru XPAngel.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            pyromancer.setXp(pyromancer.getXp() + PYROBUFF);
            String message = new String("XPAngel helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru XPAngel.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            knight.setXp(knight.getXp() + KNIGHTBUFF);
            String message = new String("XPAngel helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

}
