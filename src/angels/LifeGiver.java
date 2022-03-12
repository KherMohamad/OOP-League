package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;


public class LifeGiver extends Angel {
    /**
     * hp-ul primit de wizard.
     */
    private static final int WIZZARDBUFF = 120;
    /**
     * hp-ul primit de rogue.
     */
    private static final int ROGUEBUFF = 90;
    /**
     * hp-ul primit de pyromancer.
     */
    private static final int PYROBUFF = 80;
    /**
     * hp-ul primit de knight.
     */
    private static final int KNIGHTBUFF = 100;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public LifeGiver(final Terrain spawnLocation) {
        this.setType("LifeGiver");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru LifeGiver.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            int hp = wizard.getCurrentHp();
            int maxHp = wizard.getMaxHp();
            int lifeGiven = Math.min(WIZZARDBUFF, maxHp - hp);
            wizard.setCurrentHp(hp + lifeGiven);
            String message = new String("LifeGiver helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru LifeGiver.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            int hp = rogue.getCurrentHp();
            int maxHp = rogue.getMaxHp();
            int lifeGiven = Math.min(ROGUEBUFF, maxHp - hp);
            rogue.setCurrentHp(hp + lifeGiven);
            String message = new String("LifeGiver helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru LifeGiver.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            int hp = pyromancer.getCurrentHp();
            int maxHp = pyromancer.getMaxHp();
            int lifeGiven = Math.min(PYROBUFF, maxHp - hp);
            pyromancer.setCurrentHp(hp + lifeGiven);
            String message = new String("LifeGiver helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru LifeGiver.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            int hp = knight.getCurrentHp();
            int maxHp = knight.getMaxHp();
            int lifeGiven = Math.min(KNIGHTBUFF, maxHp - hp);
            knight.setCurrentHp(hp + lifeGiven);
            String message = new String("LifeGiver helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

}
