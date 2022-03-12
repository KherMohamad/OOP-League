package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;

public class OKDoomer extends Angel {
    /**
     * constructor.
     * @param spawnLocation .
     */
    OKDoomer(final Terrain spawnLocation) {
        this.setType("TheDoomer");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru Doomer.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            wizard.setCurrentHp(0);
            wizard.setDead(true);
            String message = new String("TheDoomer hit ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Wizard ";
            message += wizard.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }
    /**
     * implementarea efectiva e metodei pentru Doomer.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            rogue.setCurrentHp(0);
            rogue.setDead(true);
            String message = new String("TheDoomer hit ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Rogue ";
            message += rogue.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Doomer.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            pyromancer.setCurrentHp(0);
            pyromancer.setDead(true);
            String message = new String("TheDoomer hit ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Pyromancer ";
            message += pyromancer.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru Doomer.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            knight.setCurrentHp(0);
            knight.setDead(true);
            String message = new String("TheDoomer hit ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
            message = "Player Knight ";
            message += knight.getId() + " was killed by an Angel";
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }

    }

}
