package champions;

import angels.Angel;
import common.Constants;
import common.GameEngine;
import common.ProlongedDamage;
import strategies.AttackStrategy;
import strategies.BasicStrategy;
import strategies.DefenceStrategy;
import terrains.Terrain;
import terrains.TerrainsType;

public class Knight extends Champion {
    /**
     * constructor.
     * @param id .
     * @param location .
     */
    public Knight(final int id, final Terrain location) {
        this.setId(id);
        this.setType('K');
        this.setCurrentHp(Constants.KHP);
        this.setMaxHp(Constants.KHP);
        this.setLevelUpHp(Constants.KUPHP);
        this.setLocation(location);
        this.initTerrainModifier(Constants.K_TERRAINMOD);
    }

    /**
     * Execute.
     * @param enemy inamicul atacat cu execute.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack1(final Wizard enemy, final Terrain battleground) {
        int hpLimit = Math.round((Constants.POINTOFEXECUTION
              + this.getLevel() * Constants.EXECUTIONBONUS) * enemy.getMaxHp());
        int damage;
        if (enemy.getCurrentHp() < hpLimit) {
            damage = enemy.getMaxHp();
            return damage;
        } else {
            damage = Constants.EXECUTEDAMAGE
                    + this.getLevel() * Constants.EXECUTEDMGBONUS;
            if (battleground.getType() == TerrainsType.Land) {
                damage = Math.round(getTerrainModifier() * damage);
            }
          enemy.setDamageTaken(damage);
            float modifier = Constants.KNIGHTTOWIZZARDMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Execute.
     * @param enemy inamicul atacat cu execute.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack1(final Rogue enemy, final Terrain battleground) {
        int hpLimit = Math.round((Constants.POINTOFEXECUTION
              + this.getLevel() * Constants.EXECUTIONBONUS) * enemy.getMaxHp());
        int damage;
        if (enemy.getCurrentHp() < hpLimit) {
            damage = enemy.getMaxHp();
            return damage;
        } else {
            damage = Constants.EXECUTEDAMAGE
                    + this.getLevel() * Constants.EXECUTEDMGBONUS;
            if (battleground.getType() == TerrainsType.Land) {
                damage = Math.round(getTerrainModifier() * damage);
            }
            float modifier = Constants.KNIGHTTOROGUEMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Execute.
     * @param enemy inamicul atacat cu execute.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack1(final Pyromancer enemy, final Terrain battleground) {
        int hpLimit = Math.round((Constants.POINTOFEXECUTION
             + this.getLevel() * Constants.EXECUTIONBONUS) * enemy.getMaxHp());
        int damage;
        if (enemy.getCurrentHp() < hpLimit) {
            damage = enemy.getMaxHp();
            return damage;
        } else {
            damage = Constants.EXECUTEDAMAGE
                    + this.getLevel() * Constants.EXECUTEDMGBONUS;
            if (battleground.getType() == TerrainsType.Land) {
                damage = Math.round(getTerrainModifier() * damage);
            }
            float modifier = Constants.KNIGHTTOPYROMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Execute.
     * @param enemy inamicul atacat cu execute.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack1(final Knight enemy, final Terrain battleground) {
        int hpLimit = Math.round((Constants.POINTOFEXECUTION
            + this.getLevel() * Constants.EXECUTIONBONUS) * enemy.getMaxHp());
        int damage;
        if (enemy.getCurrentHp() < hpLimit) {
            damage = enemy.getMaxHp();

        } else {
            damage = Constants.EXECUTEDAMAGE
                    + this.getLevel() * Constants.EXECUTEDMGBONUS;

            if (battleground.getType() == TerrainsType.Land) {
                damage = Math.round(getTerrainModifier() * damage);
            }
            // Modificatorul nu se schimba deoarece este 1.
            damage = Math.round(Constants.KNIGHTTOKNIGHTMOD1 * damage);
        }

        return damage;
    }

    /**
     * Slam.
     * @param enemy inamicul lovit de slam.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack2(final Wizard enemy, final Terrain battleground) {
        int damage = Constants.SLAMDAMAGE
                + Constants.SLAMBONUS * this.getLevel();
        if (battleground.getType() == TerrainsType.Land) {
            damage = Math.round(getTerrainModifier() * damage);

        }
        enemy.setDamageTaken(enemy.getDamageTaken() + damage);
        float modifier = Constants.KNIGHTTOWIZZARDMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage stun
        = new ProlongedDamage(0, Constants.TURNSSLAMMED, true);
        enemy.setProlongedDamage(stun);

        return damage;
    }

    /**
     * Slam.
     * @param enemy inamicul lovit de slam.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack2(final Rogue enemy, final Terrain battleground) {
        int damage = Constants.SLAMDAMAGE
                + Constants.SLAMBONUS * this.getLevel();
        if (battleground.getType() == TerrainsType.Land) {
            damage = Math.round(getTerrainModifier() * damage);

        }
        float modifier = Constants.KNIGHTTOROGUEMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage stun
                = new ProlongedDamage(0, Constants.TURNSSLAMMED, true);
        enemy.setProlongedDamage(stun);

        return damage;
    }

    /**
     * Slam.
     * @param enemy inamicul lovit de slam.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack2(final Pyromancer enemy, final Terrain battleground) {
        int damage = Constants.SLAMDAMAGE
                + Constants.SLAMBONUS * this.getLevel();
        if (battleground.getType() == TerrainsType.Land) {
            damage = Math.round(getTerrainModifier() * damage);

        }
        float modifier = Constants.KNIGHTTOPYROMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage stun
                = new ProlongedDamage(0, Constants.TURNSSLAMMED, true);
        enemy.setProlongedDamage(stun);

        return damage;
    }

    /**
     * Slam.
     * @param enemy inamicul lovit de slam.
     * @param battleground campul de lupta.
     * @return damage-ul rotunjit
     */
    public int attack2(final Knight enemy, final Terrain battleground) {
        int damage = Constants.SLAMDAMAGE
                + Constants.SLAMBONUS * this.getLevel();
        if (battleground.getType() == TerrainsType.Land) {
            damage = Math.round(getTerrainModifier() * damage);

        }
        float modifier = Constants.KNIGHTTOKNIGHTMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage stun
                = new ProlongedDamage(0, Constants.TURNSSLAMMED, true);
        enemy.setProlongedDamage(stun);

        return damage;
    }

    /**
     * incaseaza atacurile de la inamic.
     * @param enemy inamicul ce ataca
     * @param battleground terenul de lupta/locatia
     */
    public void isAttacked(final Champion enemy, final Terrain battleground) {
        System.out.println("Damage dat de " + enemy.getType() + ":");
        int totalDamage = enemy.attack1(this, battleground)
                + enemy.attack2(this, battleground);
        int myHp = this.getCurrentHp();
        this.setCurrentHp(myHp - totalDamage);

    }

    /**
     * aplicarea efectelor ingerului.
     * @param angel ingerul care apare pe
     *terenul pe care se afla campionul
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
            if (this.getCurrentHp() < (float) 1 / Constants.KNIGHTSTRMIN
                    * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof DefenceStrategy)) {
                    this.changeStrategy(new DefenceStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (this.getCurrentHp()
                    > (float) 1 / Constants.KNIGHTSTRMIN * this.getMaxHp()
                    && this.getCurrentHp()
                    < (float) 1 / Constants.KNIGHTSTRMAX * this.getMaxHp()) {
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
}
