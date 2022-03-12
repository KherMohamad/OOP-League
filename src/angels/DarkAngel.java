package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;

public class DarkAngel extends Angel {
    /**
     * hp-ul pierdut de wizard.
     */
    private static final int WIZZARDDEBUFF = 20;
    /**
     * hp-ul pierdut de rogue.
     */
    private static final int ROGUEDEBUFF = 10;
    /**
     * hp-ul pierdut de pyromancer.
     */
    private static final int PYRODEBUFF = 30;
    /**
     * hp-ul pierdut de knight.
     */
    private static final int KNIGHTDEBUFF = 40;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public DarkAngel(final Terrain spawnLocation) {
        this.setType("DarkAngel");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru DarkAngel.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            int hp = wizard.getCurrentHp();
            wizard.setCurrentHp(hp - WIZZARDDEBUFF);
            String message = new String("DarkAngel hit ");
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
     * implementarea efectiva e metodei pentru DarkAngel.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            int hp = rogue.getCurrentHp();
            rogue.setCurrentHp(hp - ROGUEDEBUFF);
            String message = new String("DarkAngel hit ");
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
     * implementarea efectiva e metodei pentru DarkAngel.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            int hp = pyromancer.getCurrentHp();
            pyromancer.setCurrentHp(hp - PYRODEBUFF);
            String message = new String("DarkAngel hit ");
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
     * implementarea efectiva e metodei pentru DarkAngel.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            int hp = knight.getCurrentHp();
            knight.setCurrentHp(hp - KNIGHTDEBUFF);
            String message = new String("DarkAngel hit ");
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
