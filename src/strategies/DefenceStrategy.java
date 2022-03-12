package strategies;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public class DefenceStrategy implements Strategy {
 /*
      constantele de mai jos reprezinta
      inversele coeficientilor de hp.

      jucatorul primeste 1/*NAME*HPCOEFF din hp
     */

    /**
     * inversa coeficent wizard.
     */
    private static final int WIZARDHPCOEFF = 5;
    /**
     * inversa coeficient rogue.
     */
    private static final int ROGUEHPCOEFF = 2;
    /**
     * inversa coeficient pyromancer.
     */
    private static final int PYROHPCOEFF = 3;
    /**
     * inversa coeficient knight.
     */
    private static final int KNIGHTHPCOEFF = 4;

    /**
     * modificatorul de damage pt wizard.
     */
    private static final float WIZARDDMGMODIFIER = 0.2f;
    /**
     * modificatorul de damage pt rogue.
     */
    private static final float ROGUEDMGMODIFIER = 0.1f;
    /**
     * modificatorul de damage pt pyromancer.
     */
    private static final float PYRODMGMODIFIER = 0.3f;
    /**
     * modificatorul de damage pt knight.
     */
    private static final float KNIGHTDMGMODIFIER = 0.2f;

    /**
     * aplica strategia.
     * @param wizard eroul
     */
    public void apply(final Wizard wizard) {

        float damageModifier = wizard.getDamageModifier();
        wizard.setDamageModifier(damageModifier - WIZARDDMGMODIFIER);

        int hp = wizard.getCurrentHp();
        int maxHp = wizard.getMaxHp();
        int maxHpGain = Math.round((float) hp / WIZARDHPCOEFF);
        int hpGained = Math.min(maxHpGain, maxHp - hp);

        wizard.setCurrentHp(hp + hpGained);

    }

    /**
     * aplica strategia.
     * @param rogue eroul
     */
    public void apply(final Rogue rogue) {

        float damageModifier = rogue.getDamageModifier();
        rogue.setDamageModifier(damageModifier - ROGUEDMGMODIFIER);

        int hp = rogue.getCurrentHp();
        int maxHp = rogue.getMaxHp();
        int maxHpGain = Math.round((float) hp / ROGUEHPCOEFF);
        int hpGained = Math.min(maxHpGain, maxHp - hp);

        rogue.setCurrentHp(hp + hpGained);
    }

    /**
     * aplica strategia.
     * @param pyromancer eroul
     */
    public void apply(final Pyromancer pyromancer) {
        float damageModifier = pyromancer.getDamageModifier();
        pyromancer.setDamageModifier(damageModifier - PYRODMGMODIFIER);

        int hp = pyromancer.getCurrentHp();
        int maxHp = pyromancer.getMaxHp();
        int maxHpGain = Math.round((float) hp / PYROHPCOEFF);
        int hpGained = Math.min(maxHpGain, maxHp - hp);

        pyromancer.setCurrentHp(hp + hpGained);
    }

    /**
     * aplica strategia.
     * @param knight eroul
     */
    public void apply(final Knight knight) {
        System.out.println("Strategie aplicata");
        float damageModifier = knight.getDamageModifier();
        knight.setDamageModifier(damageModifier - KNIGHTDMGMODIFIER);

        int hp = knight.getCurrentHp();
        int maxHp = knight.getMaxHp();
        int maxHpGain = Math.round((float) hp / KNIGHTHPCOEFF);
        int hpGained = Math.min(maxHpGain, maxHp - hp);

        knight.setCurrentHp(hp + hpGained);

    }

}
