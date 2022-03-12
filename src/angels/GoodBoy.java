package angels;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import observers.GreatMagician;
import terrains.Terrain;

public class GoodBoy extends Angel {
    /**
     * hp-ul pierdut de wizard.
     */
    private static final int WIZARDHPBUFF = 50;
    /**
     * hp-ul pierdut de rogue.
     */
    private static final int ROGUEHPBUFF = 40;
    /**
     * hp-ul pierdut de pyromancer.
     */
    private static final int PYROHPBUFF = 30;
    /**
     * hp-ul pierdut de knight.
     */
    private static final int KNIGHTHPBUFF = 20;

    /**
     * modificatorul pentru wizard.
     */
    private static final float WIZZARDMODIFIER = 0.3f;
    /**
     * modificatorul pentru rogue.
     */
    private static final float ROGUEMODIFIER = 0.4f;
    /**
     * modificatorul pentru pyromancer.
     */
    private static final float PYROMODIFIER = 0.5f;
    /**
     * modificatorul pentru knight.
     */
    private static final float KNIGHTMODIFIER = 0.4f;

    /**
     * constructor.
     * @param spawnLocation .
     */
    public GoodBoy(final Terrain spawnLocation) {
        this.setType("GoodBoy");
        this.setSpawnLocation(spawnLocation);
    }

    /**
     * implementarea efectiva e metodei pentru GoodBoy.
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
            String message = new String("GoodBoy helped ");
            message += "Wizard " + wizard.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru GoodBoy.
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
            String message = new String("GoodBoy helped ");
            message += "Rogue " + rogue.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru GoodBoy.
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
            String message = new String("GoodBoy helped ");
            message += "Pyromancer " + pyromancer.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }

    /**
     * implementarea efectiva e metodei pentru GoodBoy.
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
            String message = new String("GoodBoy helped ");
            message += "Knight " + knight.getId();
            this.getNotifier().notify(GreatMagician.getInstance(), message);
        }
    }
}
