package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;

public class SmallAngel extends Angel {
    /**
     * hp-ul pierdut de wizard.
     */
    private static final int WIZARDHPBUFF = 25;
    /**
     * hp-ul pierdut de rogue.
     */
    private static final int ROGUEHPBUFF = 20;
    /**
     * hp-ul pierdut de pyromancer.
     */
    private static final int PYROHPBUFF = 15;
    /**
     * hp-ul pierdut de knight.
     */
    private static final int KNIGHTHPBUFF = 10;

    /**
     * modificatorul pentru wizard.
     */
    private static final float WIZZARDMODIFIER = 0.1f;
    /**
     * modificatorul pentru rogue.
     */
    private static final float ROGUEMODIFIER = 0.05f;
    /**
     * modificatorul pentru pyromancer.
     */
    private static final float PYROMODIFIER = 0.15f;
    /**
     * modificatorul pentru knight.
     */
    private static final float KNIGHTMODIFIER = 0.1f;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public SmallAngel(final Terrain spawnLocation) {
        this.setType("SmallAngel");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru SmallAngel.
     * suprascriere
     * @param wizard wizard-ul afectat
     */
    public void touch(final Wizard wizard) {
        if (!wizard.getDead()) {
            int hp = wizard.getCurrentHp();
            int maxHp = wizard.getMaxHp();
            int hpToGive = Math.min(WIZARDHPBUFF, maxHp - hp);
            wizard.setCurrentHp(hp + hpToGive);

            float oldModifier = wizard.getDamageModifier();
            wizard.setDamageModifier(oldModifier + WIZZARDMODIFIER);
            String message = new String("SmallAngel helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru SmallAngel.
     * suprascriere
     * @param rogue rogue-ul afectat
     */
    public void touch(final Rogue rogue) {
        if (!rogue.getDead()) {
            int hp = rogue.getCurrentHp();
            int maxHp = rogue.getMaxHp();
            int hpToGive = Math.min(ROGUEHPBUFF, maxHp - hp);
            rogue.setCurrentHp(hp + hpToGive);

            float oldModifier = rogue.getDamageModifier();
            rogue.setDamageModifier(oldModifier + ROGUEMODIFIER);
            String message = new String("SmallAngel helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru SmallAngel.
     * suprascriere
     * @param pyromancer pyromancer-ul afectat
     */
    public void touch(final Pyromancer pyromancer) {
        if (!pyromancer.getDead()) {
            int hp = pyromancer.getCurrentHp();
            int maxHp = pyromancer.getMaxHp();
            int hpToGive = Math.min(PYROHPBUFF, maxHp - hp);
            pyromancer.setCurrentHp(hp + hpToGive);

            float oldModifier = pyromancer.getDamageModifier();
            pyromancer.setDamageModifier(oldModifier + PYROMODIFIER);
            String message = new String("SmallAngel helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru SmallAngel.
     * suprascriere
     * @param knight knight-ul afectat
     */
    public void touch(final Knight knight) {
        if (!knight.getDead()) {
            int hp = knight.getCurrentHp();
            int maxHp = knight.getMaxHp();
            int hpToGive = Math.min(KNIGHTHPBUFF, maxHp - hp);
            knight.setCurrentHp(hp + hpToGive);

            float oldModifier = knight.getDamageModifier();
            knight.setDamageModifier(oldModifier + KNIGHTMODIFIER);
            String message = new String("SmallAngel helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

}
