package strategies;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;



public class AttackStrategy implements Strategy {
    /*
      constantele de mai jos reprezinta
      inversele coeficientilor de hp.

      jucatorul renunta la 1/*NAME*HPCOEFF din hp
     */

    /**
     * inversa coeficent wizard.
     */
    private static final int WIZARDHPCOEFF = 10;
    /**
     * inversa coeficient rogue.
     */
    private static final int ROGUEHPCOEFF = 7;
    /**
     * inversa coeficient pyromancer.
     */
    private static final int PYROHPCOEFF = 4;
    /**
     * inversa coeficient knight.
     */
    private static final int KNIGHTHPCOEFF = 5;

    /**
     * modificatorul de damage pt wizard.
     */
    private static final float WIZARDDMGMODIFIER = 0.6f;
    /**
     * modificatorul de damage pt rogue.
     */
    private static final float ROGUEDMGMODIFIER = 0.4f;
    /**
     * modificatorul de damage pt pyromancer.
     */
    private static final float PYRODMGMODIFIER = 0.7f;
    /**
     * modificatorul de damage pt knight.
     */
    private static final float KNIGHTDMGMODIFIER = 0.5f;

    /**
     * aplica strategia.
     * @param wizard eroul
     */
    public void apply(final Wizard wizard) {
        int hp = wizard.getCurrentHp();
        float hpLost = (float) hp / WIZARDHPCOEFF;
        wizard.setCurrentHp(hp - Math.round(hpLost));

        float damageModifier = wizard.getDamageModifier();
        wizard.setDamageModifier(damageModifier + WIZARDDMGMODIFIER);

    }

    /**
     * aplica strategia.
     * @param rogue eroul
     */
    public void apply(final Rogue rogue) {
        int hp = rogue.getCurrentHp();
        float hpLost = (float) hp / ROGUEHPCOEFF;
        rogue.setCurrentHp(hp - Math.round(hpLost));

        float damageModifier = rogue.getDamageModifier();
        rogue.setDamageModifier(damageModifier + ROGUEDMGMODIFIER);
    }

    /**
     * aplica strategia.
     * @param pyromancer eroul
     */
    public void apply(final Pyromancer pyromancer) {
        int hp = pyromancer.getCurrentHp();
        float hpLost = (float) hp / PYROHPCOEFF;
        pyromancer.setCurrentHp(hp - Math.round(hpLost));

        float damageModifier = pyromancer.getDamageModifier();
        pyromancer.setDamageModifier(damageModifier + PYRODMGMODIFIER);

    }

    /**
     * aplica strategia.
     * @param knight eroul
     */
    public void apply(final Knight knight) {
        System.out.println("Strategie aplicata");
        int hp = knight.getCurrentHp();
        float hpLost = (float) hp / KNIGHTHPCOEFF;
        knight.setCurrentHp(hp - Math.round(hpLost));

        float damageModifier = knight.getDamageModifier();
        knight.setDamageModifier(damageModifier + KNIGHTDMGMODIFIER);

    }

}
