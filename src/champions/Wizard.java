package champions;

import angels.Angel;
import common.Constants;
import common.GameEngine;
import strategies.AttackStrategy;
import strategies.BasicStrategy;
import strategies.DefenceStrategy;
import terrains.Terrain;
import terrains.TerrainsType;

public class Wizard extends Champion {
    /**
     * damage-ul luat in duel.
     * fara race modifiers
      */
    private int damageTaken;

    /**
     * Constructor.
     * @param id .
     * @param location .
     */

    public Wizard(final int id, final Terrain location) {
        this.setId(id);
        this.setType('W');
        this.setCurrentHp(Constants.WHP);
        this.setMaxHp(Constants.WHP);
        this.setLevelUpHp(Constants.WUPHP);
        this.setLocation(location);
        this.initTerrainModifier(Constants.W_TERRAINMOD);
    }

    /**
     * Drain.
     * @param enemy inamicul atacat de drain
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Wizard enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DRAINPERCENTAGE
             + this.getLevel() * Constants.DRAINBONUS;
        damage =
                Math.round(Math.min(Constants.DRAINOFMAX
                   * enemy.getMaxHp(), enemy.getCurrentHp()));
        if (battleground.getType() == TerrainsType.Desert) {
            percentage *= this.getTerrainModifier();
        }
        enemy.setDamageTaken(Math.round(percentage * damage));
        float modifier = Constants.WIZARDTOWIZARDMOD1;
        modifier += this.getDamageModifier();
        percentage *= modifier;
        damage = Math.round(percentage * damage);

        return damage;
    }

    /**
     * Drain.
     * @param enemy inamicul atacat de drain
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Rogue enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DRAINPERCENTAGE
                + this.getLevel() * Constants.DRAINBONUS;
        damage =
                Math.round(Math.min(Constants.DRAINOFMAX
                        * enemy.getMaxHp(), enemy.getCurrentHp()));
        if (battleground.getType() == TerrainsType.Desert) {
            percentage *= this.getTerrainModifier();
        }
        float modifier = Constants.WIZARDTOROGUEMOD1;
        modifier += this.getDamageModifier();
        percentage *= modifier;
        damage = Math.round(percentage * damage);

        return damage;
    }

    /**
     * Drain.
     * @param enemy inamicul atacat de drain
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Pyromancer enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DRAINPERCENTAGE
                + this.getLevel() * Constants.DRAINBONUS;
        damage =
                Math.round(Math.min(Constants.DRAINOFMAX
                        * enemy.getMaxHp(), enemy.getCurrentHp()));
        if (battleground.getType() == TerrainsType.Desert) {
            percentage *= this.getTerrainModifier();
        }
        float modifier = Constants.WIZARDTOPYROMOD1;
        modifier += this.getDamageModifier();
        percentage *= modifier;
        damage = Math.round(percentage * damage);

        return damage;
    }

    /**
     * Drain.
     * @param enemy inamicul atacat de drain
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Knight enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DRAINPERCENTAGE
                + this.getLevel() * Constants.DRAINBONUS;
        damage =
                Math.round(Math.min(Constants.DRAINOFMAX
                        * enemy.getMaxHp(), enemy.getCurrentHp()));
        if (battleground.getType() == TerrainsType.Desert) {
            percentage *= this.getTerrainModifier();
        }
        float modifier = Constants.WIZARDTOKNIGHTMOD1;
        modifier += this.getDamageModifier();
        percentage *= modifier;
        damage = Math.round(percentage * damage);

        return damage;
    }


    /**
     * Deflect.
     * @param enemy inamicul atacat de deflect
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack2(final Wizard enemy, final Terrain battleground) {
        return 0;
    }

    /**
     * Deflect.
     * @param enemy inamicul atacat de deflect
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack2(final Rogue enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DEFLECTPERCENTAGE;
        int i = this.getLevel();
        while (i != 0
            && percentage + Constants.DEFLECTBONUS <= Constants.DEFLECTMAX) {
            percentage += Constants.DEFLECTBONUS;
            i--;
        }
        damage = Math.round(percentage * this.getDamageTaken());
        if (battleground.getType() == TerrainsType.Desert) {
            damage = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.WIZARDTOROGUEMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);


        return Math.round(damage);
    }

    /**
     * Deflect.
     * @param enemy inamicul atacat de deflect
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack2(final Pyromancer enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DEFLECTPERCENTAGE;
        int i = this.getLevel();
        while (i != 0
               && percentage + Constants.DEFLECTBONUS <= Constants.DEFLECTMAX) {
            percentage += Constants.DEFLECTBONUS;
            i--;
        }
        damage = Math.round(percentage * this.getDamageTaken());
        if (battleground.getType() == TerrainsType.Desert) {
            damage = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.WIZARDTOPYROMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);


        return Math.round(damage);
    }

    /**
     * Deflect.
     * @param enemy inamicul atacat de deflect
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack2(final Knight enemy, final Terrain battleground) {
        int damage;
        float percentage = Constants.DEFLECTPERCENTAGE;
        int i = this.getLevel();
        while (i != 0
               && percentage + Constants.DEFLECTBONUS <= Constants.DEFLECTMAX) {
            percentage += Constants.DEFLECTBONUS;
            i--;
        }
        damage = Math.round(percentage * this.getDamageTaken());
        if (battleground.getType() == TerrainsType.Desert) {
            damage = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.WIZARDTOKNIGHTMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);


        return Math.round(damage);
    }

    /**
     * incaseaza atacurile de la inamic.
     * @param enemy inamul ce ataca
     * @param battleground terenul de lupta/locatia
     */
    public void isAttacked(final Champion enemy, final Terrain battleground) {
        int totalDamage = enemy.attack1(this, battleground)
                + enemy.attack2(this, battleground);
        int myHp = this.getCurrentHp();
        this.setCurrentHp(myHp - totalDamage);
    }

    /**
     * aplica efectele ingerului.
     * @param angel ingerul spawnat pe
     * terenul pe care se afla eroul
     */
    public void isTouched(final Angel angel) {
        angel.touch(this);
    }

    /**
     * alegerea unei strategii.
     */
    public void chooseStrategy() {
        GameEngine engine = new GameEngine();
        if (!(this.getDead() || engine.isParalysed(this))) {
            if (this.getCurrentHp() < (float) 1 / Constants.WIZARDSTRMIN
                    * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof DefenceStrategy)) {
                    this.changeStrategy(new DefenceStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (this.getCurrentHp()
                    > (float) 1 / Constants.WIZARDSTRMIN * this.getMaxHp()
                    && this.getCurrentHp()
                    < (float) 1 / Constants.WIZARDSTRMAX * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof AttackStrategy)) {
                    this.changeStrategy(new AttackStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (!(this.getStrategy() instanceof BasicStrategy)) {
                this.changeStrategy(new BasicStrategy());
                this.getStrategy().apply(this);
            }
        }
    }
    /**
     * setter.
     * @param setDamageTaken .
     */
    public void setDamageTaken(final int setDamageTaken) {
        this.damageTaken = setDamageTaken;
    }

    /**
     * getter.
     * @return damageTaken
     */
    public int getDamageTaken() {
        return damageTaken;
    }

}




