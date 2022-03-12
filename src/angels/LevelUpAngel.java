package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import common.Constants;
import observers.GreatMagician;
import terrains.Terrain;

public class LevelUpAngel extends Angel {
    /**
     * modificatorul pentru wizard.
     */
    private static final float WIZZARDMODIFIER = 0.25f;
    /**
     * modificatorul pentru rogue.
     */
    private static final float ROGUEMODIFIER = 0.15f;
    /**
     * modificatorul pentru pyromancer.
     */
    private static final float PYROMODIFIER = 0.2f;
    /**
     * modificatorul pentru knight.
     */
    private static final float KNIGHTMODIFIER = 0.1f;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public LevelUpAngel(final Terrain spawnLocation) {
        this.setType("LevelUpAngel");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru LevelUpAngel.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            int xpFormula = wizard.getLevel() * Constants.UPCOEFF;
            wizard.setXp(Constants.LEVEL1XP + xpFormula);

            float oldModifier = wizard.getDamageModifier();
            wizard.setDamageModifier(oldModifier + WIZZARDMODIFIER);
            String message = new String("LevelUpAngel helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);

            wizard.levelUp();
        }
    }

    /**
     * implementarea efectiva e metodei pentru LevelUpAngel.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            int xpFormula = rogue.getLevel() * Constants.UPCOEFF;
            rogue.setXp(Constants.LEVEL1XP + xpFormula);

            float oldModifier = rogue.getDamageModifier();
            rogue.setDamageModifier(oldModifier + ROGUEMODIFIER);
            String message = new String("LevelUpAngel helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);

            rogue.levelUp();
        }
    }

    /**
     * implementarea efectiva e metodei pentru LevelUpAngel.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            int xpFormula = pyromancer.getLevel() * Constants.UPCOEFF;
            pyromancer.setXp(Constants.LEVEL1XP + xpFormula);

            float oldModifier = pyromancer.getDamageModifier();
            pyromancer.setDamageModifier(oldModifier + PYROMODIFIER);
            String message = new String("LevelUpAngel helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);

            pyromancer.levelUp();
        }
    }

    /**
     * implementarea efectiva e metodei pentru LevelUpAngel.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            int xpFormula = knight.getLevel() * Constants.UPCOEFF;
            knight.setXp(Constants.LEVEL1XP + xpFormula);

            float oldModifier = knight.getDamageModifier();
            knight.setDamageModifier(oldModifier + KNIGHTMODIFIER);
            String message = new String("LevelUpAngel helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);

            knight.levelUp();
        }
    }

}
