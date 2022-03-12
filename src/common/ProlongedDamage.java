package common;

public class ProlongedDamage {
    /**
     * damage-ul dat intr-o runda de efect.
     */
    private int damage;
    /**
     * numarul de runde.
     */
    private int turnsDamaged;
    /**
     * imobilizarea adversarului.
     */
    private boolean isParalysed;

    /**
     * construnctor.
     * @param initDamage la fel ca mai sus
     * @param initTurnsDamaged .
     * @param initParalysed .
     */
 public ProlongedDamage(final int initDamage,
                        final int initTurnsDamaged,
                        final boolean initParalysed) {
     this.damage = initDamage;
     this.turnsDamaged = initTurnsDamaged;
     this.isParalysed = initParalysed;


 }

    /**
     * setter.
     * @param setDamage .
     */
 public void setDamage(final int setDamage) {
     this.damage = setDamage;

 }

    /**
     * setter.
     * @param setTurnsDamaged .
     */
 public void setTurnsDamaged(final int setTurnsDamaged) {
     this.turnsDamaged = setTurnsDamaged;

 }

    /**
     * setter.
     * @param setParalysed SAA
     */
 public void setParalysed(final boolean setParalysed) {

     isParalysed = setParalysed;

 }

    /**
     * getter.
     * @return SAA
     */
    public int getDamage() {
     return this.damage;

 }
    /**
     * getter.
     * @return SAA
     */
 public int getTurnsDamaged() {
     return this.turnsDamaged;

 }
    /**
     * getter.
     * @return SAA
     */
 public boolean getParalysed() {
     return isParalysed;

 }
}
