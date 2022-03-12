package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;


public class Spawner extends Angel {
    /**
     * hp-ul primit de wizard.
     */
    private static final int WIZARDBUFF = 120;
    /**
     * hp-ul primit de rogue.
     */
    private static final int ROGUEBUFF = 180;
    /**
     * hp-ul primit de pyromancer.
     */
    private static final int PYROBUFF = 150;
    /**
     * hp-ul primit de knight.
     */
    private static final int KNIGHTBUFF = 200;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public Spawner(final Terrain spawnLocation) {
        this.setType("Spawner");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru Spawner.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (wizard.getCurrentHp() <= 0) {
            wizard.setCurrentHp(WIZARDBUFF);
            wizard.setDead(false);
            String message = new String("Spawner helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Wizard ";
            message += wizard.getId();
            message += " was brought back to life by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);

        }
    }

    /**
     * implementarea efectiva e metodei pentru Spawner.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (rogue.getCurrentHp() <= 0) {
            rogue.setCurrentHp(ROGUEBUFF);
            rogue.setDead(false);
            String message = new String("Spawner helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Rogue ";
            message += rogue.getId();
            message += " was brought back to life by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Spawner.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (pyromancer.getCurrentHp() <= 0) {
            pyromancer.setCurrentHp(PYROBUFF);
            pyromancer.setDead(false);
            String message = new String("Spawner helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Pyromancer ";
            message += pyromancer.getId();
            message += " was brought back to life by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Spawner.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (knight.getCurrentHp() <= 0) {
            knight.setCurrentHp(KNIGHTBUFF);
            knight.setDead(false);
            String message = new String("Spawner helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Knight ";
            message += knight.getId();
            message += " was brought back to life by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

}
