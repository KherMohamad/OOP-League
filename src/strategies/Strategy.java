package strategies;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public interface Strategy {
    /**
     * aplica strategia.
     * @param wizard eroul
     */
   void apply(Wizard wizard);
    /**
     * aplica strategia.
     * @param rogue eroul
     */
    void apply(Rogue rogue);
    /**
     * aplica strategia.
     * @param pyromancer eroul
     */
    void apply(Pyromancer pyromancer);
    /**
     * aplica strategia.
     * @param knight eroul
     */
    void apply(Knight knight);


}
